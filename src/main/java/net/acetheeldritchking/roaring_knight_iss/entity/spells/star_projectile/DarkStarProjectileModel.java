package net.acetheeldritchking.roaring_knight_iss.entity.spells.star_projectile;

import net.acetheeldritchking.roaring_knight_iss.TheRoaringSpellbooks;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DarkStarProjectileModel extends GeoModel<DarkStarProjectileEntity> {
    @Override
    public ResourceLocation getModelResource(DarkStarProjectileEntity darkStarProjectileEntity) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "geo/star_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DarkStarProjectileEntity darkStarProjectileEntity) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "textures/entity/star_projectile.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DarkStarProjectileEntity darkStarProjectileEntity) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "animations/dark_sabre_projectile.animation.json");
    }
}
