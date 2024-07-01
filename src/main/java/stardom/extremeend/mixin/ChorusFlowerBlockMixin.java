package stardom.extremeend.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChorusFlowerBlock;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import stardom.extremeend.block.ModBlocks;

@Debug(export = true)
@Mixin(ChorusFlowerBlock.class)
public class ChorusFlowerBlockMixin {

    @WrapOperation(
            method = "canPlaceAt",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
            ordinal = 1 )
    )
    private boolean EndStoneBlocks(BlockState instance, Block block, Operation<Boolean> original) {
        if (instance.isOf(ModBlocks.MOSSY_END_STONE)) {
            return true;
        }
        else if(instance.isOf(ModBlocks.MISSING)){
            return true;
        }
        else{
            return original.call(instance, block);
        }
    }

    @WrapOperation(
            method = "randomTick",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
                    ordinal = 0
            )
    )
    private boolean EndStoneBlocksTick(BlockState instance, Block block, Operation<Boolean> original) {
        if (instance.isOf(ModBlocks.MOSSY_END_STONE)) {
            return true;
        }
        else if(instance.isOf(ModBlocks.MISSING)){
            return true;
        }
        else{
            return original.call(instance, block);
        }
    }

    @WrapOperation(
            method = "randomTick",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
                    ordinal = 3
            )
    )
    private boolean EndStoneBlocksTick2(BlockState instance, Block block, Operation<Boolean> original) {
        if (instance.isOf(ModBlocks.MOSSY_END_STONE)) {
            return true;
        }
        else if(instance.isOf(ModBlocks.MISSING)){
            return true;
        }
        else{
            return original.call(instance, block);
        }
    }


}
