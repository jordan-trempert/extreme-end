package stardom.extremeend.item;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import stardom.extremeend.StardomsExtremeEnd;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> RUBY = ModArmorMaterials.register(StardomsExtremeEnd.MOD_ID + ":ruby", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.25f, 0.05f, () -> Ingredient.ofItems(ModItems.RUBY), List.of(new ArmorMaterial.Layer(Identifier.of(StardomsExtremeEnd.MOD_ID + ":ruby"), "", true)));

    public static final RegistryEntry<ArmorMaterial> ENDERITE = ModArmorMaterials.register(StardomsExtremeEnd.MOD_ID + ":enderite", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 5);
        map.put(ArmorItem.Type.LEGGINGS, 8);
        map.put(ArmorItem.Type.CHESTPLATE, 10);
        map.put(ArmorItem.Type.HELMET, 5);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3f, 0.2f, () -> Ingredient.ofItems(ModItems.ENDERITE_GEM), List.of(new ArmorMaterial.Layer(Identifier.of(StardomsExtremeEnd.MOD_ID + ":enderite"), "", true)));


    public static final RegistryEntry<ArmorMaterial> DRACONIC = ModArmorMaterials.register(StardomsExtremeEnd.MOD_ID + ":draconic", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 7);
        map.put(ArmorItem.Type.LEGGINGS, 10);
        map.put(ArmorItem.Type.CHESTPLATE, 12);
        map.put(ArmorItem.Type.HELMET, 7);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4f, 0.25f, () -> Ingredient.ofItems(ModItems.DRACONIUM_INGOT), List.of(new ArmorMaterial.Layer(Identifier.of(StardomsExtremeEnd.MOD_ID + ":draconic"), "", true)));


    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, defense.get(type));
        }
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }
}
