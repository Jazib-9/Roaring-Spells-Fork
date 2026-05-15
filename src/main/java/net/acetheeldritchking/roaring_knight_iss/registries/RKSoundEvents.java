package net.acetheeldritchking.roaring_knight_iss.registries;

import net.acetheeldritchking.roaring_knight_iss.TheRoaringSpellbooks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RKSoundEvents {
    private static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(Registries.SOUND_EVENT, TheRoaringSpellbooks.MOD_ID);

    // Black Executioner Theme
    public static DeferredHolder<SoundEvent, SoundEvent> BLACK_EXECUTIONER_THEME = registerSoundEvent("black_executioner_theme");

    // Back Executioner Hurt

    // Black Executioner Death

    // Black Executioner Idle

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name)
    {
        return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent
                (ResourceLocation.fromNamespaceAndPath(TheRoaringSpellbooks.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENT.register(eventBus);
    }
}
