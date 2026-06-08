package net.acetheeldritchking.roaring_knight_iss.entity.spells.dark_sabre_projectile;

import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import net.acetheeldritchking.roaring_knight_iss.registries.RKEntityRegistry;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;
import org.checkerframework.checker.units.qual.N;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class DarkSabreProjectile extends AbstractMagicProjectile implements IEntityWithComplexSpawn, GeoAnimatable {
    public DarkSabreProjectile(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        setNoGravity(true);
    }

    public DarkSabreProjectile(Level pLevel) {
        this(RKEntityRegistry.DARK_SABRE_PROJECTILE.get(), pLevel);
    }

    public int delay;
    public @Nullable Vec3 ownerTracking = null;
    public @Nullable UUID targetEntity = null;
    public @Nullable Entity cachedTarget = null;
    int age;

    public void setTarget(Entity target)
    {
        this.cachedTarget = target;
        this.targetEntity = target.getUUID();
    }

    @Override
    public void trailParticles() {

    }

    @Override
    public void impactParticles(double x, double y, double z) {

    }

    @Override
    public float getSpeed() {
        return 0;
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.empty();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }

    @Override
    public double getTick(Object o) {
        return 0;
    }
}
