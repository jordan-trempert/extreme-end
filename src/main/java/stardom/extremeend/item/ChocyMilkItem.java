package stardom.extremeend.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class ChocyMilkItem extends MilkBucketItem {


    public ChocyMilkItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user)
    {
        // Apply the effect to the player

        // Call the super method to ensure the milk bucket is replaced with an empty bucket
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        stack.decrementUnlessCreative(1, user);
        if (!world.isClient) {
            user.clearStatusEffects();
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 1, 2));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 1, 4));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 1, 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 1, 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20 * 1, 2));
        }

        return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }
}
