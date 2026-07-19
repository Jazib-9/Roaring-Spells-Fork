package net.acetheeldritchking.roaring_knight_iss.entity.spells.star_shrapnel;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.acetheeldritchking.roaring_knight_iss.registries.RKEntityRegistry;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class DarkStarShrapnelProjectileEntity extends AbstractMagicProjectile implements GeoAnimatable {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public DarkStarShrapnelProjectileEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DarkStarShrapnelProjectileEntity(Level pLevel) {
        this(RKEntityRegistry.DARK_STAR_SHRAPNEL.get(), pLevel);
        this.setNoGravity(true);
    }

    @Override
    public void trailParticles() {
        var vec = getDeltaMovement();
        var length = vec.length();
        int count = (int) Math.min(20, Math.round(length) * 3) + 1;
        float f = (float) length / count;
        for (int i = 0; i < count; i++) {
            Vec3 random = Utils.getRandomVec3(0.02);
            Vec3 p = vec.scale(f * i);
            level().addParticle(ParticleHelper.CLEANSE_PARTICLE, this.getX() + random.x + p.x, this.getY() + random.y + p.y, this.getZ() + random.z + p.z, random.x, random.y, random.z);
        }
    }

    @Override
    public void impactParticles(double x, double y, double z) {

    }

    @Override
    public float getSpeed() {
        return 0.95F;
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.empty();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        // You couldn't learn anything from this
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object o) {
        return tickCount;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }
}
