package stardom.extremeend.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.EndPlatformFeature;

public class PocketDimensionItem extends Item {

    public PocketDimensionItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient && player instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
            ServerWorld targetWorld = null;
            Vec3d targetPos = null;

            if (world.getRegistryKey() == World.OVERWORLD || world.getRegistryKey() == World.NETHER) {
                // Teleport to the End
                targetWorld = serverPlayer.getServer().getWorld(World.END);
                targetPos = new Vec3d(100, 50, 0); // End platform coordinates
            } else if (world.getRegistryKey() == World.END) {
                // Teleport to the Overworld
                targetWorld = serverPlayer.getServer().getWorld(World.OVERWORLD);
                BlockPos worldSpawnPos = world.getSpawnPos();
                BlockPos spawnPos = serverPlayer.getSpawnPointPosition();

                if(serverPlayer.getSpawnPointPosition() != null) {
                    targetPos = new Vec3d(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5); // Overworld spawn coordinates
                }
                else{
                    targetPos = new Vec3d(worldSpawnPos.getX() + 0.5, worldSpawnPos.getY(), worldSpawnPos.getZ() + 0.5); // Overworld spawn coordinates
                }
            }

            if (targetWorld != null && targetPos != null) {
                // Detach the player for dimension change
                serverPlayer.detach();

                // Teleport to the new world at the safe coordinates
                serverPlayer.teleport(targetWorld, targetPos.x, targetPos.y, targetPos.z, serverPlayer.getYaw(), serverPlayer.getPitch());

                serverPlayer.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
                serverPlayer.getItemCooldownManager().set(this, 100);
            }
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }


    }
