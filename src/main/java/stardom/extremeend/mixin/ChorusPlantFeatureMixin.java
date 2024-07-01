package stardom.extremeend.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChorusFlowerBlock;
import net.minecraft.world.gen.feature.ChorusPlantFeature;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import stardom.extremeend.block.ModBlocks;

@Debug(export = true)
@Mixin(ChorusPlantFeature.class)
public class ChorusPlantFeatureMixin {

    @WrapOperation(
            method = "generate",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z")
    )
    private boolean Generation(BlockState instance, Block block, Operation<Boolean> original) {
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