package net.acetheeldritchking.roaring_knight_iss.registries;

import net.acetheeldritchking.roaring_knight_iss.TheRoaringSpellbooks;
import net.acetheeldritchking.roaring_knight_iss.items.weapons.DarkSabreItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;

public class RKItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheRoaringSpellbooks.MOD_ID);

    /***
     * Weapons
     */
    // Dark Sabre
    public static final DeferredHolder<Item, Item> DARK_SABRE = ITEMS.register("dark_sabre", DarkSabreItem::new);

    /***
     * Spawn Eggs
     */
    // Apothic Acolyte
    public static final DeferredItem<Item> BLACK_EXECUTIONER_SPAWN_EGG = ITEMS.register("black_executioner_spawn_egg",
            () -> new DeferredSpawnEggItem(RKEntityRegistry.BLACK_EXECUTIONER_BOSS, 1973277, 5147788,
                    new Item.Properties()));

    public static Collection<DeferredHolder<Item, ? extends Item>> getRKItems()
    {
        return ITEMS.getEntries();
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
