package stardom.extremeend.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EnderworkItem extends FireworkRocketItem {
    public EnderworkItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isFallFlying()) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (!world.isClient) {
                FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(world, itemStack, user);
                world.spawnEntity(fireworkRocketEntity);
                user.incrementStat(Stats.USED.getOrCreateStat(this));
            }
            user.getItemCooldownManager().set(this, 25);
            return TypedActionResult.success(user.getStackInHand(hand), world.isClient());

        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient) {
            ItemStack itemStack = context.getStack();
            Vec3d vec3d = context.getHitPos();
            Direction direction = context.getSide();
            FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(world, context.getPlayer(), vec3d.x + (double)direction.getOffsetX() * 0.15, vec3d.y + (double)direction.getOffsetY() * 0.15, vec3d.z + (double)direction.getOffsetZ() * 0.15, itemStack);
            world.spawnEntity(fireworkRocketEntity);
        }
        return ActionResult.success(world.isClient);
    }
}
