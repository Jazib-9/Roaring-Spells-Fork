package net.acetheeldritchking.roaring_knight_iss.entity.bosses.black_executioner;

import net.acetheeldritchking.roaring_knight_iss.TheRoaringSpellbooks;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

public class BlackExecutionerModel extends GeoModel<BlackExecutionerBoss> {
    @Override
    public ResourceLocation getModelResource(BlackExecutionerBoss animatable) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "geo/black_executioner_shade.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlackExecutionerBoss animatable) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "textures/entity/black_executioner_shade.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlackExecutionerBoss animatable) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "animations/black_executioner_shade.animation.json");
    }

    @Override
    public void setCustomAnimations(BlackExecutionerBoss animatable, long instanceId, AnimationState<BlackExecutionerBoss> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
