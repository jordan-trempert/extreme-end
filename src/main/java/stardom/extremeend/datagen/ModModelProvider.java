package stardom.extremeend.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import stardom.extremeend.block.ModBlocks;
import stardom.extremeend.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {



        BlockStateModelGenerator.BlockTexturePool chorus_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHORUS_PLANKS);
        chorus_pool.family(ModBlocks.CHORUS_FAMILY);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.HANGING_CHORUS_SIGN, Models.GENERATED);


    }
}