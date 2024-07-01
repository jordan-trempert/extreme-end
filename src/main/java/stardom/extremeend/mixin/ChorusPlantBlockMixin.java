package stardom.extremeend.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChorusFlowerBlock;
import net.minecraft.block.ChorusPlantBlock;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import stardom.extremeend.block.ModBlocks;

@Debug(export = true)
@Mixin(ChorusPlantBlock.class)
public class ChorusPlantBlockMixin {

    @WrapOperation(
            method = "withConnectionProperties",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
            ordinal = 2 )
    )
    private static boolean EndStoneBlocks(BlockState instance, Block block, Operation<Boolean> original) {
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
            method = "getStateForNeighborUpdate",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
                    ordinal = 2 )
    )
    private boolean EndStoneBlocks2(BlockState instance, Block block, Operation<Boolean> original) {
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
            method = "canPlaceAt",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
                    ordinal = 1 )
    )
    private boolean EndStoneBlocks3(BlockState instance, Block block, Operation<Boolean> original) {
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
            method = "canPlaceAt",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
                    ordinal = 4 )
    )
    private boolean EndStoneBlocks4(BlockState instance, Block block, Operation<Boolean> original) {
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
