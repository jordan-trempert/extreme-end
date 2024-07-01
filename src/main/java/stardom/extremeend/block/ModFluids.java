package stardom.extremeend.block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.item.ModItemGroups;

public class ModFluids {
    public static FlowableFluid STILL_VOID_ENERGY;
    public static FlowableFluid STILL_TOXINS;
    public static FlowableFluid FLOWING_VOID_ENERGY;
    public static FlowableFluid FLOWING_TOXINS;
    public static Block VOID_ENERGY_BLOCK;
    public static Block TOXINS_BLOCK;
    public static Item VOID_ENERGY_BUCKET;
    public static Item TOXINS_BUCKET;

    public static void register() {
        STILL_VOID_ENERGY = Registry.register(Registries.FLUID,
                Identifier.of(StardomsExtremeEnd.MOD_ID, "void_energy"), new VoidEnergy.Still());
        FLOWING_VOID_ENERGY = Registry.register(Registries.FLUID,
                Identifier.of(StardomsExtremeEnd.MOD_ID, "flowing_void_energy"), new VoidEnergy.Flowing());
        STILL_TOXINS = Registry.register(Registries.FLUID,
                Identifier.of(StardomsExtremeEnd.MOD_ID, "toxins"), new Toxins.Still());
        FLOWING_TOXINS = Registry.register(Registries.FLUID,
                Identifier.of(StardomsExtremeEnd.MOD_ID, "flowing_toxins"), new Toxins.Flowing());

        VOID_ENERGY_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(StardomsExtremeEnd.MOD_ID,"void_energy_block"),
                new FluidBlock(ModFluids.STILL_VOID_ENERGY, Block.Settings.copy(Blocks.WATER)){ });
        TOXINS_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(StardomsExtremeEnd.MOD_ID,"toxins_block"),
                new FluidBlock(ModFluids.STILL_TOXINS, Block.Settings.copy(Blocks.WATER)){ });

        VOID_ENERGY_BUCKET = Registry.register(Registries.ITEM, Identifier.of(StardomsExtremeEnd.MOD_ID, "void_energy_bucket"),
                new BucketItem(ModFluids.STILL_VOID_ENERGY, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
        TOXINS_BUCKET = Registry.register(Registries.ITEM, Identifier.of(StardomsExtremeEnd.MOD_ID, "toxins_bucket"),
                new BucketItem(ModFluids.STILL_TOXINS, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

    }
}
