package net.acetheeldritchking.roaring_knight_iss.entity.render.entity.bosses.black_executioner;

import com.mojang.blaze3d.vertex.PoseStack;
import net.acetheeldritchking.roaring_knight_iss.TheRoaringSpellbooks;
import net.acetheeldritchking.roaring_knight_iss.entity.bosses.black_executioner.BlackExecutionerBoss;
import net.acetheeldritchking.roaring_knight_iss.entity.bosses.black_executioner.BlackExecutionerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BlackExecutionerRenderer extends GeoEntityRenderer<BlackExecutionerBoss> {
    public BlackExecutionerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BlackExecutionerModel());
    }

    @Override
    public ResourceLocation getTextureLocation(BlackExecutionerBoss animatable) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "textures/entity/black_executioner_shade.png");
    }

    @Override
    public void render(BlackExecutionerBoss entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
