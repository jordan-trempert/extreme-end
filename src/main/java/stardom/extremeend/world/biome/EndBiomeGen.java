package stardom.extremeend.world.biome;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.block.ModBlocks;

import java.util.Random;

import static net.minecraft.util.math.VerticalSurfaceType.CEILING;
import static net.minecraft.util.math.VerticalSurfaceType.FLOOR;
import static net.minecraft.world.gen.surfacebuilder.MaterialRules.*;

public class EndBiomeGen {



    public static void genEndBiomes() {



        BiomePlacement.addEnd(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "lush_end")),
                new MultiNoiseUtil.NoiseHypercube(
                        MultiNoiseUtil.ParameterRange.of(-1.0f, -0.15f),
                        MultiNoiseUtil.ParameterRange.of(-1.0f, -0.35f),
                        MultiNoiseUtil.ParameterRange.of(0.3f, 1.0f),
                        MultiNoiseUtil.ParameterRange.of(-0.375f, 0.05f),
                        MultiNoiseUtil.ParameterRange.of(0.0f),
                        MultiNoiseUtil.ParameterRange.of(0.0f, 1.0f),
                        0L));

        BiomePlacement.addEnd(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "end_dunes")),
                new MultiNoiseUtil.NoiseHypercube(
                        MultiNoiseUtil.ParameterRange.of(1.0f, 2f), //Temp
                        MultiNoiseUtil.ParameterRange.of(-1.0f, -0.35f), //Humid
                        MultiNoiseUtil.ParameterRange.of(0.6f, 1.3f), //Continentalness
                        MultiNoiseUtil.ParameterRange.of(-0.375f, 0.075f), //Erosion
                        MultiNoiseUtil.ParameterRange.of(0.5f), //Depth
                        MultiNoiseUtil.ParameterRange.of(0.4f, 1.0f), //Weirdness
                        1L));//Offset
    }



    public static void replaceGround(){
        MaterialRules.MaterialRule lushEnd = condition(MaterialRules.biome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "lush_end"))), condition(STONE_DEPTH_FLOOR, MaterialRules.block(ModBlocks.MOSSY_END_STONE.getDefaultState())));
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("extremeend", "surface_rules"), lushEnd);

        MaterialRules.MaterialRule endDunes = condition(MaterialRules.biome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "end_dunes"))), condition(STONE_DEPTH_FLOOR, MaterialRules.block(ModBlocks.END_SAND.getDefaultState())));
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("extremeend", "surface_rules"), endDunes);

        MaterialRules.MaterialRule glitchedJungle = condition(MaterialRules.biome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "glitched_jungle"))), condition(STONE_DEPTH_FLOOR, MaterialRules.block(ModBlocks.MISSING.getDefaultState())));
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("extremeend", "surface_rules"), glitchedJungle);

        MaterialRules.MaterialRule brightChorus = condition(MaterialRules.biome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "bright_chorus"))), condition(STONE_DEPTH_FLOOR, MaterialRules.block(ModBlocks.MOSSY_END_STONE.getDefaultState())));
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("extremeend", "surface_rules"), brightChorus);

        MaterialRules.MaterialRule shatteredVoid = condition(MaterialRules.biome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "shattered_void"))), condition(STONE_DEPTH_FLOOR, MaterialRules.block(ModBlocks.VOIDSTONE.getDefaultState())));
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("extremeend", "surface_rules"), shatteredVoid);

        MaterialRules.MaterialRule auroraGlade = condition(MaterialRules.biome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "aurora_glade"))), condition(MaterialRules.stoneDepth(0, true, 95, FLOOR), MaterialRules.block(ModBlocks.LUMINA_STONE.getDefaultState())));
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("extremeend", "surface_rules"), auroraGlade);

        MaterialRules.MaterialRule wildReeds = condition(MaterialRules.biome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "wild_reeds"))), condition(STONE_DEPTH_FLOOR, MaterialRules.block(ModBlocks.SADDENED_END_STONE.getDefaultState())));
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("extremeend", "surface_rules"), wildReeds);

        MaterialRules.MaterialRule toxicWastes = condition(MaterialRules.biome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "toxic_wastes"))), condition(STONE_DEPTH_FLOOR, MaterialRules.block(ModBlocks.MOSSY_END_STONE.getDefaultState())));
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("extremeend", "surface_rules"), toxicWastes);

        MaterialRules.MaterialRule twistingChorus = condition(MaterialRules.biome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "twisting_chorus"))), condition(STONE_DEPTH_FLOOR, MaterialRules.block(ModBlocks.MOSSY_END_STONE.getDefaultState())));
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("extremeend", "surface_rules"), twistingChorus);


        MaterialRules.MaterialRule phosphorusFields = condition(MaterialRules.biome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "phosphorus_fields"))), condition(MaterialRules.stoneDepth(0, true, 95, FLOOR), MaterialRules.block(ModBlocks.PHOSPHORUS.getDefaultState())));
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("extremeend", "surface_rules"), phosphorusFields);

    }




}

