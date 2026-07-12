package net.acetheeldritchking.roaring_knight_iss.items.weapons;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.items.weapons.ActiveAndPassiveAbilityMagicSwordItem;
import net.acetheeldritchking.aces_spell_utils.utils.ASRarities;
import net.acetheeldritchking.roaring_knight_iss.registries.RKSpellRegistries;
import net.acetheeldritchking.roaring_knight_iss.utils.RKRarities;

public class DarkSabreItem extends ActiveAndPassiveAbilityMagicSwordItem {
    public DarkSabreItem() {
        super(
                RKWeaponTier.DARK_SABRE,
                ItemPropertiesHelper.equipment(1).fireResistant().rarity(RKRarities.SHADED_RARITY_PROXY.getValue()).attributes(ExtendedSwordItem.createAttributes(RKWeaponTier.DARK_SABRE)),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(RKSpellRegistries.KNIGHTS_EDGE, 1))
        );
    }

    @Override
    protected int getActiveCooldownTicks() {
        return 20 * 20;
    }

    @Override
    protected int getPassiveCooldownTicks() {
        return 5 * 20;
    }
}
