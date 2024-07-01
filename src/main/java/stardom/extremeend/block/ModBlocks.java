package stardom.extremeend.block;

import com.mojang.serialization.MapCodec;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Instrument;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureKeys;
import net.minecraft.world.gen.structure.Structures;
import org.jetbrains.annotations.Nullable;
import stardom.extremeend.StardomsExtremeEnd;
import net.minecraft.block.FallingBlock;

import java.util.Optional;

import static stardom.extremeend.block.ModFluids.STILL_VOID_ENERGY;
import static stardom.extremeend.block.ModFluids.STILL_TOXINS;

public class ModBlocks {

    // Sapling Generators
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHORUS_BIG = ConFeatureOf(StardomsExtremeEnd.MOD_ID, "chorus_forest_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHORUS_SMALL = ConFeatureOf(StardomsExtremeEnd.MOD_ID, "chorus_smaller_tree");
    public static final SaplingGenerator CHORUS = new SaplingGenerator("chorus", Optional.of(CHORUS_BIG), Optional.of(CHORUS_SMALL), Optional.empty());


    public static final RegistryKey<ConfiguredFeature<?, ?>> GLITCHED_TREE = ConFeatureOf(StardomsExtremeEnd.MOD_ID, "glitched_jungle_tree");
    public static final SaplingGenerator GLITCHED = new SaplingGenerator("glitched", Optional.empty(), Optional.of(GLITCHED_TREE), Optional.empty());

    public static final Block CHORUS_SAPLING = registerBlock("chorus_sapling", new SaplingBlock(CHORUS, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GLITCHED_SAPLING = registerBlock("glitched_sapling", new SaplingBlock(GLITCHED, AbstractBlock.Settings.create().mapColor(MapColor.BLUE).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block CHORUS_LEAVES = registerBlock("chorus_leaves", new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque()));
    public static final Block GLOWING_LEAVES = registerBlock("glowing_leaves", new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque().luminance((state) -> {return 15;})));
    public static final Block GLITCHED_LEAVES = registerBlock("glitched_leaves", new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque()));
    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(Block.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block REFINERY = registerBlock("refinery", new RefineryBlock(Block.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block", new Block(Block.Settings.copy(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block DRACONIUM_BLOCK = registerBlock("draconium_block", new Block(Block.Settings.copy(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block", new Block(Block.Settings.copy(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque()));
    public static final Block RUBY_ORE = registerBlock("ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2,5), Block.Settings.copy(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2,5), Block.Settings.copy(Blocks.DEEPSLATE).strength(4f)));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2,5), Block.Settings.copy(Blocks.NETHERRACK).strength(1f)));
    public static final Block END_RUBY_ORE = registerBlock("end_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2,5), Block.Settings.copy(Blocks.END_STONE).strength(3f)));
    public static final Block ENDERITE_ORE = registerBlock("enderite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(8,15), Block.Settings.copy(Blocks.END_STONE).strength(6f)));
    public static final Block PHOSPHORUS_ENDERITE_ORE = registerBlock("phosphorus_enderite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(8,15), Block.Settings.copy(Blocks.END_STONE).strength(6f)));
    public static final Block MOSSY_END_STONE = registerBlock("mossy_end_stone", new Block(Block.Settings.copy(Blocks.END_STONE).sounds(BlockSoundGroup.STONE)));
    public static final Block SADDENED_END_STONE = registerBlock("saddened_end_stone", new Block(Block.Settings.copy(Blocks.END_STONE).sounds(BlockSoundGroup.STONE)));
    public static final Block MISSING = registerBlock("missing", new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE)));
    public static final Block VOIDSTONE = registerBlock("voidstone", new Block(Block.Settings.copy(Blocks.BLACKSTONE).sounds(BlockSoundGroup.STONE)));
    public static final Block LUMINA_STONE = registerBlock("lumina_stone", new TranslucentBlock(Block.Settings.copy(Blocks.BLACKSTONE).sounds(BlockSoundGroup.GLASS).nonOpaque().luminance((state) -> {return 10;})));
    public static final Block ENDER_GLOW = registerBlock("ender_glow", new TranslucentBlock(Block.Settings.copy(Blocks.OCHRE_FROGLIGHT).sounds(BlockSoundGroup.FROGLIGHT).luminance((state) -> {return 15;})));
    public static final Block POLISHED_VOIDSTONE = registerBlock("polished_voidstone", new Block(Block.Settings.copy(Blocks.POLISHED_BLACKSTONE).sounds(BlockSoundGroup.STONE)));
    public static final Block POLISHED_VOIDSTONE_BRICKS = registerBlock("polished_voidstone_bricks", new Block(Block.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS).sounds(BlockSoundGroup.STONE)));
    public static final Block POLISHED_VOIDSTONE_BRICK_STAIRS = registerBlock("polished_voidstone_brick_stairs", new StairsBlock(POLISHED_VOIDSTONE_BRICKS.getDefaultState(), Block.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS).sounds(BlockSoundGroup.STONE)));
    public static final Block POLISHED_VOIDSTONE_BRICK_WALL = registerBlock("polished_voidstone_brick_wall", new WallBlock(Block.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICK_WALL).sounds(BlockSoundGroup.STONE)));
    public static final Block POLISHED_VOIDSTONE_BRICK_SLAB = registerBlock("polished_voidstone_brick_slab", new SlabBlock(Block.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB).sounds(BlockSoundGroup.STONE)));
    public static final Block END_SANDSTONE = registerBlock("end_sandstone", new Block(Block.Settings.copy(Blocks.SMOOTH_SANDSTONE).sounds(BlockSoundGroup.STONE)));
    public static final Block PHOSPHORUS = registerBlock("phosphorus", new PhosphorusBlock(Block.Settings.copy(Blocks.NETHERRACK).sounds(BlockSoundGroup.STONE)));
    public static final Block ENDER_FLAME = registerBlock("ender_flame", new EnderFlameBlock(Block.Settings.copy(Blocks.SOUL_FIRE)));
    public static final Block TOXIC_SLUDGE = registerBlock("toxic_sludge", new SludgeBlock(Block.Settings.copy(Blocks.MUD).sounds(BlockSoundGroup.MUD)));
    public static final Block CHORUS_GROWTH = registerBlock("chorus_growth", new FlowerBlock(SuspiciousStewEffectsComponent.DEFAULT,Block.Settings.copy(Blocks.ORANGE_TULIP).nonOpaque().noCollision().luminance((state) -> {return 10;})));
    public static final Block TOXIC_BUBBLER = registerBlock("toxic_bubbler", new BubblerBlock(Block.Settings.copy(Blocks.ORANGE_TULIP).nonOpaque().noCollision().luminance((state) -> {return 3;})));
    public static final Block END_REEDS = registerReeds("end_reeds", new ReedsBlock(Block.Settings.copy(Blocks.SUGAR_CANE).nonOpaque().noCollision().luminance((state) -> {return 7;})));

        // Chorus wood family
        public static final Identifier CHORUS_SIGN_TEXTURE = Identifier.of(StardomsExtremeEnd.MOD_ID, "entity/signs/chorus");
        public static final Identifier CHORUS_HANGING_SIGN_TEXTURE = Identifier.of(StardomsExtremeEnd.MOD_ID, "entity/signs/hanging/chorus");
        public static final Identifier CHORUS_HANGING_GUI_SIGN_TEXTURE = Identifier.of(StardomsExtremeEnd.MOD_ID, "textures/gui/hanging_signs/chorus");


        public static final Block CHORUS_STEM = registerBlock("chorus_stem", new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.NETHER_STEM)));
        public static final Block CHORUS_WOOD = registerBlock("chorus_wood", new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD).sounds(BlockSoundGroup.NETHER_STEM)));
        public static final Block STANDING_CHORUS_SIGN = registerSign("chorus_standing_sign", new TerraformSignBlock(CHORUS_SIGN_TEXTURE, Block.Settings.copy(Blocks.OAK_SIGN).sounds(BlockSoundGroup.NETHER_STEM)));
        public static final Block HANGING_CHORUS_SIGN = registerSign("chorus_hanging_sign", new TerraformHangingSignBlock(CHORUS_HANGING_SIGN_TEXTURE, CHORUS_HANGING_GUI_SIGN_TEXTURE, Block.Settings.copy(Blocks.OAK_HANGING_SIGN).sounds(BlockSoundGroup.NETHER_STEM)));
        public static final Block WALL_CHORUS_SIGN = registerSign("chorus_wall_sign", new TerraformWallSignBlock(CHORUS_SIGN_TEXTURE, Block.Settings.copy(Blocks.OAK_WALL_SIGN).sounds(BlockSoundGroup.NETHER_STEM).dropsLike(STANDING_CHORUS_SIGN)));
        public static final Block WALL_HANGING_CHORUS_SIGN = registerSign("chorus_wall_hanging_sign", new TerraformWallHangingSignBlock(CHORUS_HANGING_SIGN_TEXTURE, CHORUS_HANGING_GUI_SIGN_TEXTURE, Block.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).sounds(BlockSoundGroup.NETHER_STEM).dropsLike(HANGING_CHORUS_SIGN)));
        public static final Block STRIPPED_CHORUS_STEM = registerBlock("stripped_chorus_stem", new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.NETHER_STEM)));
        public static final Block STRIPPED_CHORUS_WOOD = registerBlock("stripped_chorus_wood", new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD).sounds(BlockSoundGroup.NETHER_STEM)));
        public static final Block CHORUS_PLANKS = registerBlock("chorus_planks", new Block(Block.Settings.copy(Blocks.WARPED_PLANKS).sounds(BlockSoundGroup.NETHER_WOOD)));
        public static final Block CHORUS_TRAPDOOR = registerBlock("chorus_trapdoor", new TrapdoorBlock(BlockSetType.OAK, Block.Settings.copy(Blocks.OAK_TRAPDOOR).sounds(BlockSoundGroup.NETHER_WOOD)));
        public static final Block CHORUS_PRESSURE_PLATE = registerBlock("chorus_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE).sounds(BlockSoundGroup.NETHER_WOOD)));
        public static final Block CHORUS_BUTTON = registerBlock("chorus_button", new ButtonBlock(BlockSetType.OAK, 30, Block.Settings.copy(Blocks.OAK_BUTTON).sounds(BlockSoundGroup.NETHER_WOOD)));
        public static final Block CHORUS_SLAB = registerBlock("chorus_slab", new SlabBlock(Block.Settings.copy(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD)));
        public static final Block CHORUS_STAIRS = registerBlock("chorus_stairs", new StairsBlock(CHORUS_PLANKS.getDefaultState(), Block.Settings.copy(Blocks.OAK_STAIRS).sounds(BlockSoundGroup.NETHER_WOOD)));
        public static final Block CHORUS_FENCE_GATE = registerBlock("chorus_fence_gate", new FenceGateBlock(ModWoodTypes.CHORUS, AbstractBlock.Settings.create().mapColor(CHORUS_PLANKS.getDefaultMapColor()).solid().strength(2.0F, 3.0F).burnable()));
        public static final Block CHORUS_FENCE = registerBlock("chorus_fence", new FenceBlock(AbstractBlock.Settings.create().mapColor(CHORUS_PLANKS.getDefaultMapColor()).sounds(BlockSoundGroup.NETHER_WOOD)));
        public static final Block CHORUS_DOOR = registerBlock("chorus_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().mapColor(CHORUS_PLANKS.getDefaultMapColor()).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY)));

        // Glitched Wood Family

        public static final Identifier GLITCHED_SIGN_TEXTURE = Identifier.of(StardomsExtremeEnd.MOD_ID, "entity/signs/glitched");
        public static final Identifier GLITCHED_HANGING_SIGN_TEXTURE = Identifier.of(StardomsExtremeEnd.MOD_ID, "entity/signs/hanging/glitched");
        public static final Identifier GLITCHED_HANGING_GUI_SIGN_TEXTURE = Identifier.of(StardomsExtremeEnd.MOD_ID, "textures/gui/hanging_signs/glitched");

        public static final Block GLITCHED_LOG = registerBlock("glitched_log", new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.WOOD)));
        public static final Block GLITCHED_WOOD = registerBlock("glitched_wood", new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD)));
        public static final Block STANDING_GLITCHED_SIGN = registerSign("glitched_standing_sign", new TerraformSignBlock(GLITCHED_SIGN_TEXTURE, Block.Settings.copy(Blocks.OAK_SIGN).sounds(BlockSoundGroup.WOOD)));
        public static final Block HANGING_GLITCHED_SIGN = registerSign("glitched_hanging_sign", new TerraformHangingSignBlock(GLITCHED_HANGING_SIGN_TEXTURE, GLITCHED_HANGING_GUI_SIGN_TEXTURE, Block.Settings.copy(Blocks.OAK_HANGING_SIGN).sounds(BlockSoundGroup.WOOD)));
        public static final Block WALL_GLITCHED_SIGN = registerSign("glitched_wall_sign", new TerraformWallSignBlock(GLITCHED_SIGN_TEXTURE, Block.Settings.copy(Blocks.OAK_WALL_SIGN).sounds(BlockSoundGroup.WOOD).dropsLike(STANDING_GLITCHED_SIGN)));
        public static final Block WALL_HANGING_GLITCHED_SIGN = registerSign("glitched_wall_hanging_sign", new TerraformWallHangingSignBlock(GLITCHED_HANGING_SIGN_TEXTURE, GLITCHED_HANGING_GUI_SIGN_TEXTURE, Block.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).sounds(BlockSoundGroup.WOOD).dropsLike(HANGING_GLITCHED_SIGN)));
        public static final Block STRIPPED_GLITCHED_LOG = registerBlock("stripped_glitched_log", new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.WOOD)));
        public static final Block STRIPPED_GLITCHED_WOOD = registerBlock("stripped_glitched_wood", new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD).sounds(BlockSoundGroup.WOOD)));
        public static final Block GLITCHED_PLANKS = registerBlock("glitched_planks", new Block(Block.Settings.copy(Blocks.WARPED_PLANKS).sounds(BlockSoundGroup.WOOD)));
        public static final Block GLITCHED_TRAPDOOR = registerBlock("glitched_trapdoor", new TrapdoorBlock(BlockSetType.OAK, Block.Settings.copy(Blocks.OAK_TRAPDOOR).sounds(BlockSoundGroup.WOOD)));
        public static final Block GLITCHED_PRESSURE_PLATE = registerBlock("glitched_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE).sounds(BlockSoundGroup.WOOD)));
        public static final Block GLITCHED_BUTTON = registerBlock("glitched_button", new ButtonBlock(BlockSetType.OAK, 30, Block.Settings.copy(Blocks.OAK_BUTTON).sounds(BlockSoundGroup.WOOD)));
        public static final Block GLITCHED_SLAB = registerBlock("glitched_slab", new SlabBlock(Block.Settings.copy(Blocks.OAK_SLAB).sounds(BlockSoundGroup.WOOD)));
        public static final Block GLITCHED_STAIRS = registerBlock("glitched_stairs", new StairsBlock(GLITCHED_PLANKS.getDefaultState(), Block.Settings.copy(Blocks.OAK_STAIRS).sounds(BlockSoundGroup.WOOD)));
        public static final Block GLITCHED_FENCE_GATE = registerBlock("glitched_fence_gate", new FenceGateBlock(ModWoodTypes.CHORUS, AbstractBlock.Settings.create().mapColor(GLITCHED_PLANKS.getDefaultMapColor()).solid().strength(2.0F, 3.0F).burnable()));
        public static final Block GLITCHED_FENCE = registerBlock("glitched_fence", new FenceBlock(AbstractBlock.Settings.create().mapColor(GLITCHED_PLANKS.getDefaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
        public static final Block GLITCHED_DOOR = registerBlock("glitched_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().mapColor(GLITCHED_PLANKS.getDefaultMapColor()).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY)));

        // Saplings
        //public static final Block CHORUS_SAPLING = registerBlock("chorus_sapling", new SaplingBlock(CHORUS, Block.Settings.copy(Blocks.OAK_SAPLING)));
        //public static final Block GLITCHED_SAPLING = registerBlock("glitched_sapling", new SaplingBlock(GLITCHED, Block.Settings.copy(Blocks.OAK_SAPLING)));


    public static final BlockFamily CHORUS_FAMILY = BlockFamilies.register(ModBlocks.CHORUS_PLANKS)
                .sign(ModBlocks.STANDING_CHORUS_SIGN, ModBlocks.WALL_CHORUS_SIGN)
                .group("wooden").unlockCriterionName("has_planks").build();

    public static final BlockFamily GLITCHED_FAMILY = BlockFamilies.register(ModBlocks.GLITCHED_PLANKS)
            .sign(ModBlocks.STANDING_GLITCHED_SIGN, ModBlocks.WALL_GLITCHED_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();


    public static final Block END_SAND = registerBlock("end_sand", new FallingBlock(Block.Settings.copy(Blocks.SAND).sounds(BlockSoundGroup.SAND)) {
        @Override
        public boolean isEnabled(FeatureSet enabledFeatures) {
            return super.isEnabled(enabledFeatures);
        }

        @Override
        public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
            super.onLanding(world, pos, fallingBlockState, currentStateInPos, fallingBlockEntity);
        }

        @Override
        public void onDestroyedOnLanding(World world, BlockPos pos, FallingBlockEntity fallingBlockEntity) {
            super.onDestroyedOnLanding(world, pos, fallingBlockEntity);
        }

        @Override
        public DamageSource getDamageSource(Entity attacker) {
            return super.getDamageSource(attacker);
        }

        @Override
        public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
            return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
        }

        @Override
        protected MapCodec<? extends FallingBlock> getCodec() {
            return null;
        }
    });


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, Identifier.of(StardomsExtremeEnd.MOD_ID, name), block);

    }

    private static Block registerReeds (String name, Block block){
        registerReedsItem(name, block);

        return Registry.register(Registries.BLOCK, Identifier.of(StardomsExtremeEnd.MOD_ID, name), block);

    }

    private static Block registerSign(String name, Block block){

        return Registry.register(Registries.BLOCK, Identifier.of(StardomsExtremeEnd.MOD_ID, name), block);

    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, Identifier.of(StardomsExtremeEnd.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    private static Item registerReedsItem(String name, Block block){
        return Registry.register(Registries.ITEM, Identifier.of(StardomsExtremeEnd.MOD_ID, "end_berry"), new BlockItem(block, new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.5f).build())));
    }

    public static void registerModBlocks(){
        StardomsExtremeEnd.LOGGER.info("Registering blocks for: " + StardomsExtremeEnd.MOD_ID);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> ConFeatureOf(String id, String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(id, name));
    }
}
