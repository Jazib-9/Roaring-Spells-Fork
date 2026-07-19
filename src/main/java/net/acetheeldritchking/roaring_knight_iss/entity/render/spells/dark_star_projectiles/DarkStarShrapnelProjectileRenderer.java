package net.acetheeldritchking.roaring_knight_iss.entity.render.spells.dark_star_projectiles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.acetheeldritchking.roaring_knight_iss.entity.spells.star_shrapnel.DarkStarShrapnelProjectileEntity;
import net.acetheeldritchking.roaring_knight_iss.entity.spells.star_shrapnel.DarkStarShrapnelProjectileModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DarkStarShrapnelProjectileRenderer extends GeoEntityRenderer<DarkStarShrapnelProjectileEntity> {
    public DarkStarShrapnelProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DarkStarShrapnelProjectileModel());
    }

    @Override
    public void preRender(PoseStack poseStack, DarkStarShrapnelProjectileEntity animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, animatable.yRotO, animatable.getYRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(-Mth.lerp(partialTick, animatable.xRotO, animatable.getXRot())));

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    @Override
    public @Nullable RenderType getRenderType(DarkStarShrapnelProjectileEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.breezeEyes(texture);
    }
}
