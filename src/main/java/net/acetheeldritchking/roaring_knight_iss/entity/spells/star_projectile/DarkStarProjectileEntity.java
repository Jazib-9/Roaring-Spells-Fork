package net.acetheeldritchking.roaring_knight_iss.entity.spells.star_projectile;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.acetheeldritchking.roaring_knight_iss.entity.spells.star_shrapnel.DarkStarShrapnelProjectileEntity;
import net.acetheeldritchking.roaring_knight_iss.registries.RKEntityRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class DarkStarProjectileEntity extends AbstractMagicProjectile implements GeoAnimatable {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public DarkStarProjectileEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DarkStarProjectileEntity(Level pLevel, double initialAngle) {
        this(RKEntityRegistry.DARK_STAR_PROJECTILE.get(), pLevel);
        this.setNoGravity(true);
        this.noPhysics = true;
        this.initialAngle = initialAngle;
        this.fallbackOrigin = this.getOwner().position();
    }

    // Stuff for the actual movement and explarding
    private final static int startTicks = 20*20;
    private final static int pullTicks = 5*20;
    private final static double maxRadius = 12.0;
    private final static double pullInTargetRadius = 3.0;
    private final static double angularSpeed = Math.toRadians(6.0);
    private final static double outwardSpeed = 0.18;
    private final static int fragCount = 5;

    private double initialAngle;
    private Vec3 fallbackOrigin = Vec3.ZERO;

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
        return 0.1F;
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.empty();
    }

    @Override
    public void tick() {
        super.tick();

        int age = this.tickCount;
        double angle = this.initialAngle + age * angularSpeed;
        double radius;

        if (age <= startTicks)
        {
            radius = Math.min(age * outwardSpeed, maxRadius);
        } else if (age <= startTicks + pullTicks)
        {
            double t = (double) (age - startTicks) / pullTicks;
            radius = Mth.lerp(t, maxRadius, pullInTargetRadius);
        } else
        {
            // Explard
            explodeStar();
            return;
        }

        // Movin and groovin
        Vec3 origin = getOrigin();
        double x = origin.x + Math.cos(angle) * radius;
        double y = origin.y + 1.2;
        double z = origin.z + Math.sin(angle) * radius;
        this.setPos(x, y, z);
    }

    private Vec3 getOrigin()
    {
        if (this.getOwner() != null && this.getOwner().isAlive())
        {
            this.fallbackOrigin = this.getOwner().position();
        }
        return this.fallbackOrigin;
    }

    // EXPLARD MY STAR!!! - December Holiday
    private void explodeStar()
    {
        if (this.level() instanceof ServerLevel serverLevel)
        {
            serverLevel.sendParticles(ParticleTypes.EXPLOSION,
                    this.getX(), this.getY(), this.getZ(), 1, 0.0, 0.0, 0.0, 0.0);
        }
        this.level().playSound(null, this.blockPosition(), SoundRegistry.ARCANE_IMPACT.get(), SoundSource.HOSTILE, 1F, 1F);

        double baseAngle = this.random.nextDouble() * Math.PI * 2;
        for (int i = 0; i < fragCount; i++)
        {
            double angle = baseAngle + i * (2 * Math.PI / fragCount);

            DarkStarShrapnelProjectileEntity shrapnel = new DarkStarShrapnelProjectileEntity(this.level());
            shrapnel.setOwner(this);
            shrapnel.setPos(this.getX(), this.getY(), this.getZ());

            double speed = 0.5;
            shrapnel.setDeltaMovement(Math.cos(angle) * speed, 0.05, Math.sin(angle) * speed);
            this.level().addFreshEntity(shrapnel);
        }

        this.discard();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        // Nothing here
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
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        // If I touch this, the Roaring starts
        super.defineSynchedData(pBuilder);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putDouble("InitialAngle", this.initialAngle);
        tag.putDouble("OriginX", this.fallbackOrigin.x);
        tag.putDouble("OriginY", this.fallbackOrigin.y);
        tag.putDouble("OriginZ", this.fallbackOrigin.z);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.initialAngle = tag.getDouble("InitialAngle");
        this.fallbackOrigin = new Vec3(tag.getDouble("OriginX"), tag.getDouble("OriginY"), tag.getDouble("OriginZ"));
    }
}
