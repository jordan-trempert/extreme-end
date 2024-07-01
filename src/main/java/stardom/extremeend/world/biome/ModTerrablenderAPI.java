package stardom.extremeend.world.biome;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.world.biome.surface.ModMaterialRules;
import terrablender.api.*;

public class ModTerrablenderAPI implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        StardomsExtremeEnd.LOGGER.info("Starting terrablender initializing for mod " + StardomsExtremeEnd.MOD_ID);

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, StardomsExtremeEnd.MOD_ID, ModMaterialRules.makeRules());

        EndBiomeRegistry.registerHighlandsBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "lush_end")), 6);
        EndBiomeRegistry.registerHighlandsBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "glitched_jungle")), 6);
        EndBiomeRegistry.registerMidlandsBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "end_dunes")), 6);
        EndBiomeRegistry.registerHighlandsBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "bright_chorus")), 6);
        EndBiomeRegistry.registerHighlandsBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "shattered_void")), 4);
        EndBiomeRegistry.registerHighlandsBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "aurora_glade")), 2);
        EndBiomeRegistry.registerHighlandsBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "wild_reeds")), 5);
        EndBiomeRegistry.registerHighlandsBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "toxic_wastes")), 4);
        EndBiomeRegistry.registerHighlandsBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "twisting_chorus")), 7);
        EndBiomeRegistry.registerHighlandsBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "phosphorus_fields")), 3);
        //EndBiomeRegistry.registerEdgeBiome(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("extremeend", "end_dunes")), 4);




        StardomsExtremeEnd.LOGGER.info("Mod biomes finished initializing with terrablender for mod. " + StardomsExtremeEnd.MOD_ID);

    }

}