package stardom.extremeend.mixin;

import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import stardom.extremeend.block.ModFluids;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity
        implements Attackable {

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Shadow public abstract boolean removeStatusEffect(RegistryEntry<StatusEffect> effect);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "baseTick", at = @At("HEAD"))
    public void baseTick(CallbackInfo info) {


        World world = this.getWorld();
        BlockPos entityPos = this.getBlockPos();
        Fluid fluid = world.getFluidState(entityPos).getFluid();
        if (fluid == ModFluids.STILL_TOXINS || fluid == ModFluids.FLOWING_TOXINS) {
            this.removeStatusEffect(StatusEffects.POISON);
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100));
        }
    }

}
