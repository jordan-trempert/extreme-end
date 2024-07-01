package stardom.extremeend.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.block.ModBlocks;
import stardom.extremeend.block.ModFluids;

public class ModItemGroups
{
    public static final ItemGroup END_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(StardomsExtremeEnd.MOD_ID, "end"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.end"))
                    .icon(() -> new ItemStack(ModItems.DRACONIUM_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.ENDERITE_GEM_FRAGMENT);
                        entries.add(ModItems.ENDERITE_GEM);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModBlocks.ENDERITE_BLOCK);
                        entries.add(ModBlocks.DRACONIUM_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_RUBY_ORE);
                        entries.add(ModBlocks.ENDERITE_ORE);
                        entries.add(ModBlocks.PHOSPHORUS_ENDERITE_ORE);
                        entries.add(ModBlocks.MOSSY_END_STONE);
                        entries.add(ModBlocks.SADDENED_END_STONE);
                        entries.add(ModBlocks.MISSING);
                        entries.add(ModBlocks.LUMINA_STONE);
                        entries.add(ModBlocks.VOIDSTONE);
                        entries.add(ModBlocks.POLISHED_VOIDSTONE);
                        entries.add(ModBlocks.POLISHED_VOIDSTONE_BRICKS);
                        entries.add(ModBlocks.POLISHED_VOIDSTONE_BRICK_STAIRS);
                        entries.add(ModBlocks.POLISHED_VOIDSTONE_BRICK_SLAB);
                        entries.add(ModBlocks.POLISHED_VOIDSTONE_BRICK_WALL);
                        entries.add(ModBlocks.PHOSPHORUS);
                        entries.add(ModBlocks.CHORUS_SAPLING);
                        entries.add(ModBlocks.CHORUS_PLANKS);
                        entries.add(ModBlocks.CHORUS_STAIRS);
                        entries.add(ModBlocks.CHORUS_SLAB);
                        entries.add(ModBlocks.CHORUS_BUTTON);
                        entries.add(ModBlocks.CHORUS_PRESSURE_PLATE);
                        entries.add(ModBlocks.CHORUS_FENCE_GATE);
                        entries.add(ModBlocks.CHORUS_FENCE);
                        entries.add(ModBlocks.CHORUS_DOOR);
                        entries.add(ModBlocks.CHORUS_TRAPDOOR);
                        entries.add(ModBlocks.CHORUS_STEM);
                        entries.add(ModBlocks.STRIPPED_CHORUS_STEM);
                        entries.add(ModBlocks.CHORUS_WOOD);
                        entries.add(ModBlocks.STRIPPED_CHORUS_WOOD);
                        entries.add(ModBlocks.ENDER_GLOW);
                        entries.add(ModBlocks.GLITCHED_LOG);
                        entries.add(ModBlocks.STRIPPED_GLITCHED_LOG);
                        entries.add(ModBlocks.GLITCHED_WOOD);
                        entries.add(ModBlocks.STRIPPED_GLITCHED_WOOD);
                        entries.add(ModBlocks.GLITCHED_SAPLING);
                        entries.add(ModBlocks.GLITCHED_PLANKS);
                        entries.add(ModBlocks.GLITCHED_STAIRS);
                        entries.add(ModBlocks.GLITCHED_SLAB);
                        entries.add(ModBlocks.GLITCHED_BUTTON);
                        entries.add(ModBlocks.GLITCHED_PRESSURE_PLATE);
                        entries.add(ModBlocks.GLITCHED_FENCE_GATE);
                        entries.add(ModBlocks.GLITCHED_FENCE);
                        entries.add(ModBlocks.GLITCHED_DOOR);
                        entries.add(ModBlocks.GLITCHED_TRAPDOOR);
                        entries.add(ModBlocks.CHORUS_LEAVES);
                        entries.add(ModBlocks.GLITCHED_LEAVES);
                        entries.add(ModBlocks.GLOWING_LEAVES);
                        entries.add(ModItems.CHORUS_BOAT);
                        entries.add(ModItems.CHORUS_CHEST_BOAT);
                        entries.add(ModItems.GLITCHED_BOAT);
                        entries.add(ModItems.GLITCHED_CHEST_BOAT);
                        entries.add(ModItems.CHORUS_SIGN);
                        entries.add(ModItems.HANGING_CHORUS_SIGN);
                        entries.add(ModItems.GLITCHED_SIGN);
                        entries.add(ModItems.HANGING_GLITCHED_SIGN);
                        entries.add(ModBlocks.END_SAND);
                        entries.add(ModBlocks.END_SANDSTONE);
                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_HOE);
                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);
                        entries.add(ModItems.ENDERITE_SWORD);
                        entries.add(ModItems.ENDERITE_PICKAXE);
                        entries.add(ModItems.ENDERITE_AXE);
                        entries.add(ModItems.ENDERITE_SHOVEL);
                        entries.add(ModItems.ENDERITE_HOE);
                        entries.add(ModItems.ENDERITE_HELMET);
                        entries.add(ModItems.ENDERITE_CHESTPLATE);
                        entries.add(ModItems.ENDERITE_LEGGINGS);
                        entries.add(ModItems.ENDERITE_BOOTS);
                        entries.add(ModItems.DRACONIC_SWORD);
                        entries.add(ModItems.DRACONIC_PICKAXE);
                        entries.add(ModItems.DRACONIC_AXE);
                        entries.add(ModItems.DRACONIC_SHOVEL);
                        entries.add(ModItems.DRACONIC_HOE);
                        entries.add(ModItems.DRACONIC_HELMET);
                        entries.add(ModItems.DRACONIC_CHESTPLATE);
                        entries.add(ModItems.DRACONIC_LEGGINGS);
                        entries.add(ModItems.DRACONIC_BOOTS);
                        entries.add(ModItems.RUBY_UPGRADE_TEMPLATE);
                        entries.add(ModItems.ENDERITE_UPGRADE_TEMPLATE);
                        entries.add(ModItems.DRACONIC_UPGRADE_TEMPLATE);
                        entries.add(ModItems.PILLARS_TRIM_TEMPLATE);
                        entries.add(ModItems.DRACONIC_SOUL);
                        entries.add(ModItems.DRACONIUM_INGOT);
                        entries.add(ModBlocks.CHORUS_GROWTH);
                        entries.add(ModBlocks.TOXIC_BUBBLER);
                        entries.add(ModBlocks.TOXIC_SLUDGE);
                        entries.add(ModBlocks.END_REEDS);
                        entries.add(ModItems.CHOCY_MILK);
                        entries.add(ModFluids.VOID_ENERGY_BUCKET);
                        entries.add(ModFluids.TOXINS_BUCKET);
                        entries.add(ModItems.ENDER_GUARD_SPAWN_EGG);
                        entries.add(ModItems.NEBULOUS_VOID_MUSIC_DISC);
                        entries.add(ModItems.POCKET_DIMENSION);
                        entries.add(ModItems.ENDERWORK);
                        entries.add(ModBlocks.REFINERY);




                    }).build());
    public static void registerItemGroups(){
        StardomsExtremeEnd.LOGGER.info("Registering item groups for: " + StardomsExtremeEnd.MOD_ID);
    }
}
