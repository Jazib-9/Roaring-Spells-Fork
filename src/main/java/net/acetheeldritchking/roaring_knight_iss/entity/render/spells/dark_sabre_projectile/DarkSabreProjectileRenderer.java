package net.acetheeldritchking.roaring_knight_iss.entity.render.spells.dark_sabre_projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.acetheeldritchking.roaring_knight_iss.entity.spells.dark_sabre_projectile.DarkSabreProjectile;
import net.acetheeldritchking.roaring_knight_iss.entity.spells.dark_sabre_projectile.DarkSabreProjectileModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DarkSabreProjectileRenderer extends GeoEntityRenderer<DarkSabreProjectile> {
    public DarkSabreProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DarkSabreProjectileModel());
    }

    @Override
    public void preRender(PoseStack poseStack, DarkSabreProjectile animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);

        float xRot;
        float yRot;

        //the issue before was that when the swords were in the "wait" period
        // before being shot at the target they aren't moving, the original code would try to
        // face the swords in the direction they are moving, if not moving then they face up,
        // probably because in blockbench they were modeled facing up to begin with, the fix
        // was to just point it directly at its target instead of letting the entities velocity do it

        var target = animatable.getTargetEntity();
        boolean waitingForStrike = animatable.getAge() < animatable.delay
                && (animatable.mode == DarkSabreProjectile.AttackMode.SURROUND || animatable.mode == DarkSabreProjectile.AttackMode.SPREAD)
                && target != null;

        if (waitingForStrike) {
            // face straight at the target's center instead of getting facing angle
            // via motion, since motion is intentionally zero during this phase
            Vec3 toTarget = target.getBoundingBox().getCenter().subtract(animatable.position());
            xRot = ((float) (Mth.atan2(toTarget.horizontalDistance(), toTarget.y) * (double) (180F / (float) Math.PI)) - 90.0F);
            yRot = -((float) (Mth.atan2(toTarget.z, toTarget.x) * (double) (180F / (float) Math.PI)) - 90.0F);
        } else {
            //original behavior: facing angle dictated by motion
            Vec3 motion = animatable.deltaMovementOld.add(animatable.getDeltaMovement().subtract(animatable.deltaMovementOld).scale(partialTick));
            xRot = ((float) (Mth.atan2(motion.horizontalDistance(), motion.y) * (double) (180F / (float) Math.PI)) - 90.0F);
            yRot = -((float) (Mth.atan2(motion.z, motion.x) * (double) (180F / (float) Math.PI)) - 90.0F);
        }

        poseStack.translate(0, animatable.getBbHeight() * .5f, 0);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(xRot));
    }
}
