package net.acetheeldritchking.roaring_knight_iss.entity.spells.star_shrapnel;

import net.acetheeldritchking.roaring_knight_iss.TheRoaringSpellbooks;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DarkStarShrapnelProjectileModel extends GeoModel<DarkStarShrapnelProjectileEntity> {
    @Override
    public ResourceLocation getModelResource(DarkStarShrapnelProjectileEntity darkStarShrapnelProjectileEntity) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "geo/star_shrapnel_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DarkStarShrapnelProjectileEntity darkStarShrapnelProjectileEntity) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "textures/entity/star_shrapnel.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DarkStarShrapnelProjectileEntity darkStarShrapnelProjectileEntity) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "animations/dark_sabre_projectile.animation.json");
    }
}
