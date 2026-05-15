package net.acetheeldritchking.roaring_knight_iss.entity.bosses.black_executioner.goals;

import io.redspace.ironsspellbooks.entity.mobs.wizards.GenericAnimatedWarlockAttackGoal;
import net.minecraft.world.entity.PathfinderMob;

public class BlackExecutionerAttackGoal extends GenericAnimatedWarlockAttackGoal {
    public BlackExecutionerAttackGoal(PathfinderMob abstractSpellCastingMob, double pSpeedModifier, int minAttackInterval, int maxAttackInterval) {
        super(abstractSpellCastingMob, pSpeedModifier, minAttackInterval, maxAttackInterval);
    }
}
