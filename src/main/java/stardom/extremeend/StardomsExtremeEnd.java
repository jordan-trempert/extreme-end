package stardom.extremeend;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.biome.FoliageColors;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stardom.extremeend.block.ModBlocks;
import stardom.extremeend.block.ModFluids;
import stardom.extremeend.entity.ModBoats;
import stardom.extremeend.entity.ModEntities;
import stardom.extremeend.entity.block.ModBlockEntities;
import stardom.extremeend.entity.custom.EnderGuardEntity;
import stardom.extremeend.item.ModItemGroups;
import stardom.extremeend.item.ModItems;
import stardom.extremeend.particle.ModParticles;
import stardom.extremeend.potions.ModPotions;
import stardom.extremeend.sound.ModSounds;
import stardom.extremeend.world.biome.EndBiomeGen;

public class StardomsExtremeEnd implements ModInitializer {
	public static final String MOD_ID = "extremeend";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final RegistryKey<PlacedFeature> OVERWORLD_RUBY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(StardomsExtremeEnd.MOD_ID,"overworld_ruby"));
	public static final RegistryKey<PlacedFeature> NETHER_RUBY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(StardomsExtremeEnd.MOD_ID,"nether_ruby"));
	public static final RegistryKey<PlacedFeature> END_RUBY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(StardomsExtremeEnd.MOD_ID,"end_ruby"));
	public static final RegistryKey<PlacedFeature> ENDERITE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(StardomsExtremeEnd.MOD_ID,"enderite"));
	public static final RegistryKey<PlacedFeature> PHOSPHORUS_ENDERITE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(StardomsExtremeEnd.MOD_ID,"phosphorus_enderite"));
	public static final ParticleType<SimpleParticleType> POISON_BUBBLE = FabricParticleTypes.simple();


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModBoats.registerBoats();
		ModFluids.register();
		ModSounds.registerSounds();
		ModPotions.registerPotions();
		ModParticles.registerParticles();
		FabricDefaultAttributeRegistry.register(ModEntities.ENDER_GUARD, EnderGuardEntity.createEnderGuardAttributes());
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(StardomsExtremeEnd.MOD_ID, "poison_bubble"), POISON_BUBBLE);



		//EndBiomeGen.genEndBiomes();
		EndBiomeGen.replaceGround();
		EndBiomeGen.genEndBiomes();


		// Ores
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, OVERWORLD_RUBY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, NETHER_RUBY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, END_RUBY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, ENDERITE);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, PHOSPHORUS_ENDERITE);





		// Strippables
		StrippableBlockRegistry.register(ModBlocks.CHORUS_STEM, ModBlocks.STRIPPED_CHORUS_STEM);
		StrippableBlockRegistry.register(ModBlocks.CHORUS_WOOD, ModBlocks.STRIPPED_CHORUS_WOOD);
		StrippableBlockRegistry.register(ModBlocks.GLITCHED_LOG, ModBlocks.STRIPPED_GLITCHED_LOG);
		StrippableBlockRegistry.register(ModBlocks.GLITCHED_WOOD, ModBlocks.STRIPPED_GLITCHED_WOOD);

		//Flammables
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_STEM, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHORUS_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHORUS_STEM, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_DOOR , 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_TRAPDOOR, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_FENCE_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.GLOWING_LEAVES, 30, 60);


		//SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CHORUS_SIGN_TEXTURE));
		// Apply Cutouts
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_GROWTH, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.END_REEDS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOXIC_BUBBLER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLITCHED_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUMINA_STONE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SADDENED_END_STONE, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDER_FLAME, RenderLayer.getCutoutMipped());


		// Coloring
		colorizeBlock(ModBlocks.MOSSY_END_STONE);
		colorizeBlock(ModBlocks.END_SAND);
		colorizeBlock(ModBlocks.CHORUS_LEAVES);
		colorizeBlock(ModBlocks.GLITCHED_LEAVES);
		colorizeBlock(ModBlocks.GLOWING_LEAVES);
		colorizeItem(ModBlocks.MOSSY_END_STONE);
		colorizeItem(ModBlocks.END_SAND);
		colorizeItem(ModBlocks.CHORUS_LEAVES);
		colorizeItem(ModBlocks.GLITCHED_LEAVES);
		colorizeItem(Blocks.GRASS_BLOCK);
		colorizeItem(Blocks.FERN);
		colorizeItem(Blocks.LARGE_FERN);
		colorizeItem(Blocks.SHORT_GRASS);
		colorizeItem(Blocks.TALL_GRASS);
		colorizeItem(Blocks.OAK_LEAVES);
		colorizeItem(Blocks.MANGROVE_LEAVES);
		colorizeItem(Blocks.SPRUCE_LEAVES);
		colorizeItem(Blocks.DARK_OAK_LEAVES);
		colorizeItem(Blocks.ACACIA_LEAVES);
		colorizeItem(Blocks.JUNGLE_LEAVES);




		ColorProviderRegistry.BLOCK.register((BlockState state, BlockRenderView world, BlockPos pos, int tintIndex) -> {
			// Replace with your own logic to calculate color based on y-value
			int y = pos.getY();
			int color = calculateColorBasedOnY(y, 45, 95, 0x0000FF, 0xFF0000);
			return color;
		}, ModBlocks.END_SANDSTONE);

		UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof EndermanEntity && player.getStackInHand(hand).getItem() == Items.BUCKET) {
				// Replace the bucket with a diamond
				player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
				player.giveItemStack(new ItemStack(ModItems.CHOCY_MILK));
				return ActionResult.SUCCESS;
			}
			return ActionResult.PASS;
		});


	}

	private int calculateColorBasedOnY(int y, int startY, int endY, int startColor, int endColor) {
		// Calculate the proportion of the way y is between startY and endY
		float proportion = (float)(y - startY) / (endY - startY);

		// Calculate the new RGB values based on the proportion
		int red = (int)((1 - proportion) * ((startColor >> 16) & 0xFF) + proportion * ((endColor >> 16) & 0xFF));
		int green = (int)((1 - proportion) * ((startColor >> 8) & 0xFF) + proportion * ((endColor >> 8) & 0xFF));
		int blue = (int)((1 - proportion) * (startColor & 0xFF) + proportion * (endColor & 0xFF));

		// Return the new color
		if (y > endY) {
			return endColor;
		}
		else if (y < startY) {
			return startColor;
		}
		else {
			return (red << 16) | (green << 8) | blue;
		}
	}



	public void colorizeBlock(Block block){
		BlockRenderLayerMapImpl.INSTANCE.putBlock(block, RenderLayer.getCutoutMipped());
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
			if (world == null || pos == null) {
				return FoliageColors.getDefaultColor();
			}
			return BiomeColors.getGrassColor(world, pos);
		}, block);

		ColorProviderRegistry.ITEM.register((stack, layer) -> {
			return FoliageColors.getDefaultColor();
		}, block);
	}

	public void colorizeBlockYValue(Block block, int y, int startY, int endY, int startColor, int endColor){
		BlockRenderLayerMapImpl.INSTANCE.putBlock(block, RenderLayer.getCutoutMipped());
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
			if (world == null || pos == null) {
				return FoliageColors.getDefaultColor();
			}
			return calculateColorBasedOnY(y, startY, endY, startColor, endColor);
		}, block);

		ColorProviderRegistry.ITEM.register((stack, layer) -> {
			return FoliageColors.getDefaultColor();
		}, block);
	}

	public void colorizeItem(Block block){
		ColorProviderRegistry.ITEM.register((itemStack, i) ->
		{
			BlockState blockstate = ((BlockItem) itemStack.getItem()).getBlock().getDefaultState();
			if (MinecraftClient.getInstance().player != null)
			{
				return MinecraftClient.getInstance().getBlockColors().getColor(blockstate, MinecraftClient.getInstance().world, MinecraftClient.getInstance().player.getBlockPos(), i);
			}
			else
			{
				return MinecraftClient.getInstance().getBlockColors().getColor(blockstate, null, null, i);
			}
		}, block);
	}


}