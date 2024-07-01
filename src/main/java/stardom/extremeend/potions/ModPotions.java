package stardom.extremeend.potions;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.stat.Stat;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.block.ModBlocks;
import stardom.extremeend.item.ModItems;

public class ModPotions {

    public static RegistryEntry<Potion> RESISTANCE;
    public BrewingRecipeRegistry.Builder builder;

    public static final StatusEffectInstance RESISTANCE_POTION = new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 2);

    public static RegistryEntry<Potion> registerPotion(String name, StatusEffectInstance statusEffectInstance) {
        return Registry.registerReference(Registries.POTION, Identifier.of(StardomsExtremeEnd.MOD_ID, name), new Potion(statusEffectInstance));
    }

    public static void registerPotions(){
        RESISTANCE = registerPotion("resistance_potion", ModPotions.RESISTANCE_POTION);
        registerPotionRecipes();
    }


    private static void registerPotionRecipes() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, ModBlocks.END_REEDS.asItem(), ModPotions.RESISTANCE);
        });
    }

}
