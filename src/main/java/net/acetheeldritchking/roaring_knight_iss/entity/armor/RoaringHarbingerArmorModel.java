package net.acetheeldritchking.roaring_knight_iss.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.acetheeldritchking.roaring_knight_iss.TheRoaringSpellbooks;
import net.acetheeldritchking.roaring_knight_iss.items.armor.RoaringHarbingerArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class RoaringHarbingerArmorModel extends DefaultedItemGeoModel<RoaringHarbingerArmorItem> {
    public RoaringHarbingerArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(RoaringHarbingerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "geo/roaring_harbinger_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RoaringHarbingerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, "textures/models/armor/roaring_harbinger_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RoaringHarbingerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
