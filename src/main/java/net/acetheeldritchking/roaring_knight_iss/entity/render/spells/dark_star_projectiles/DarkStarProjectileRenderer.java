package net.acetheeldritchking.roaring_knight_iss.entity.render.spells.dark_star_projectiles;

import net.acetheeldritchking.roaring_knight_iss.entity.spells.star_projectile.DarkStarProjectileEntity;
import net.acetheeldritchking.roaring_knight_iss.entity.spells.star_projectile.DarkStarProjectileModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DarkStarProjectileRenderer extends GeoEntityRenderer<DarkStarProjectileEntity> {
    public DarkStarProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DarkStarProjectileModel());
    }

    @Override
    public @Nullable RenderType getRenderType(DarkStarProjectileEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.breezeEyes(texture);
    }
}
