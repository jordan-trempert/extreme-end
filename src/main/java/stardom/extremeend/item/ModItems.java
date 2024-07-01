package stardom.extremeend.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import com.terraformersmc.terraform.boat.impl.item.TerraformBoatItem;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.jukebox.JukeboxSongs;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.trim.ArmorTrimPatterns;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.block.ModBlocks;
import stardom.extremeend.entity.ModBoats;
import stardom.extremeend.entity.ModEntities;
import stardom.extremeend.sound.ModSounds;

import java.util.List;

import static stardom.extremeend.block.ModFluids.STILL_VOID_ENERGY;


public class ModItems {

    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.of("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.of("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.of("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.of("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = Identifier.of("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = Identifier.of("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = Identifier.of("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.of("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.of("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.of("item/empty_slot_ingot");
    private static final Identifier EMPTY_SLOT_REDSTONE_DUST_TEXTURE = Identifier.of("item/empty_slot_redstone_dust");
    private static final Identifier EMPTY_SLOT_QUARTZ_TEXTURE = Identifier.of("item/empty_slot_quartz");
    private static final Identifier EMPTY_SLOT_EMERALD_TEXTURE = Identifier.of("item/empty_slot_emerald");
    private static final Identifier EMPTY_SLOT_DIAMOND_TEXTURE = Identifier.of("item/empty_slot_diamond");
    private static final Identifier EMPTY_SLOT_LAPIS_LAZULI_TEXTURE = Identifier.of("item/empty_slot_lapis_lazuli");
    private static final Identifier EMPTY_SLOT_AMETHYST_SHARD_TEXTURE = Identifier.of("item/empty_slot_amethyst_shard");





    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item ENDERWORK = registerItem("enderwork", new EnderworkItem(new Item.Settings().maxCount(1)));
    public static final Item DRACONIUM_INGOT = registerItem("draconium_ingot", new Item(new Item.Settings()));
    public static final Item ENDERITE_GEM = registerItem("enderite_gem", new Item(new Item.Settings()));
    public static final Item ENDERITE_GEM_FRAGMENT = registerItem("enderite_gem_fragment", new Item(new Item.Settings()));
    public static final Item DRACONIC_SOUL = registerItem("draconic_soul", new DraconicSoulItem(new Item.Settings()));
    public static final Item CHOCY_MILK = registerItem("chocy_milk", new ChocyMilkItem(new Item.Settings().maxCount(1)));
    public static final Item POCKET_DIMENSION = registerItem("pocket_dimension", new PocketDimensionItem(new Item.Settings().maxCount(1)));
    public static final Item NEBULOUS_VOID_MUSIC_DISC = registerItem("nebulous_void_music_disc", new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable((ModSounds.NEBULOUS_VOID_SONG))));
    public static final Item RUBY_UPGRADE_TEMPLATE = registerItem("ruby_upgrade_smithing_template", ModSmithingTemplateItem.createRubyUpgrade());
    public static final Item ENDERITE_UPGRADE_TEMPLATE = registerItem("enderite_upgrade_smithing_template", ModSmithingTemplateItem.createEnderiteUpgrade());
    public static final Item DRACONIC_UPGRADE_TEMPLATE = registerItem("draconic_upgrade_smithing_template", ModSmithingTemplateItem.createDraconicUpgrade());
    public static final Item PILLARS_TRIM_TEMPLATE = registerItem("pillars_armor_trim_smithing_template", ModSmithingTemplateItem.of(ModArmorTrimPatterns.PILLARS, new FeatureFlag[0]));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));
    public static final Item ENDER_GUARD_SPAWN_EGG = registerItem("ender_guard_spawn_egg", new SpawnEggItem(ModEntities.ENDER_GUARD, 0xb51919, 0x6a0e0e, new Item.Settings()));
    public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.RUBY, 4, -2f))));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterial.RUBY, 2.0f, -2.4f))));
    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.RUBY, 6.0f, -2.6f))));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterial.RUBY, 2.5f, -2.6f))));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterial.RUBY, -2.0f, 0.0f))));
    public static final Item RUBY_HELMET = registerItem("ruby_helmet", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(33))));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(33))));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(33))));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(33))));
    public static final Item ENDERITE_SWORD = registerItem("enderite_sword", new SwordItem(EnderiteToolMaterial.ENDERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(EnderiteToolMaterial.ENDERITE, 6, -2f)).fireproof()));
    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe", new PickaxeItem(EnderiteToolMaterial.ENDERITE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(EnderiteToolMaterial.ENDERITE, 4.0f, -2.4f)).fireproof()));
    public static final Item ENDERITE_AXE = registerItem("enderite_axe", new AxeItem(EnderiteToolMaterial.ENDERITE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(EnderiteToolMaterial.ENDERITE, 8.0f, -2.6f)).fireproof()));
    public static final Item ENDERITE_SHOVEL = registerItem("enderite_shovel", new ShovelItem(EnderiteToolMaterial.ENDERITE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(EnderiteToolMaterial.ENDERITE, 2.5f, -2.6f)).fireproof()));
    public static final Item ENDERITE_HOE = registerItem("enderite_hoe", new HoeItem(EnderiteToolMaterial.ENDERITE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(EnderiteToolMaterial.ENDERITE, 0.0f, 0.0f)).fireproof()));
    public static final Item DRACONIC_SWORD = registerItem("draconic_sword", new SwordItem(DraconicToolMaterial.DRACONIC, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(DraconicToolMaterial.DRACONIC, 8, -2f)).fireproof()));
    public static final Item DRACONIC_PICKAXE = registerItem("draconic_pickaxe", new PickaxeItem(DraconicToolMaterial.DRACONIC, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(DraconicToolMaterial.DRACONIC, 6.0f, -2.4f)).fireproof()));
    public static final Item DRACONIC_AXE = registerItem("draconic_axe", new AxeItem(DraconicToolMaterial.DRACONIC, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(DraconicToolMaterial.DRACONIC, 10.0f, -2.6f)).fireproof()));
    public static final Item DRACONIC_SHOVEL = registerItem("draconic_shovel", new ShovelItem(DraconicToolMaterial.DRACONIC, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(DraconicToolMaterial.DRACONIC, 4.5f, -2.6f)).fireproof()));
    public static final Item DRACONIC_HOE = registerItem("draconic_hoe", new HoeItem(DraconicToolMaterial.DRACONIC, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(DraconicToolMaterial.DRACONIC, 2.0f, 0.0f)).fireproof()));

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet", new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40)).fireproof()));
    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40)).fireproof()));
    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings", new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40)).fireproof()));
    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots", new ArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40)).fireproof()));
    public static final Item DRACONIC_HELMET = registerItem("draconic_helmet", new DraconicArmorItem(ModArmorMaterials.DRACONIC, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(45)).fireproof()));
    public static final Item DRACONIC_CHESTPLATE = registerItem("draconic_chestplate", new DraconicChestplateItem(ModArmorMaterials.DRACONIC, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(45)).fireproof()));
    public static final Item DRACONIC_LEGGINGS = registerItem("draconic_leggings", new DraconicArmorItem(ModArmorMaterials.DRACONIC, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(45)).fireproof()));
    public static final Item DRACONIC_BOOTS = registerItem("draconic_boots", new DraconicArmorItem(ModArmorMaterials.DRACONIC, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(45)).fireproof()));

    public static final Item CHORUS_SIGN = registerItem("chorus_sign", new SignItem(new Item.Settings().maxCount(16), ModBlocks.STANDING_CHORUS_SIGN, ModBlocks.WALL_CHORUS_SIGN));
    public static final Item HANGING_CHORUS_SIGN = registerItem("chorus_hanging_sign", new HangingSignItem(ModBlocks.HANGING_CHORUS_SIGN, ModBlocks.WALL_HANGING_CHORUS_SIGN, new Item.Settings().maxCount(16)));
    public static final Item GLITCHED_SIGN = registerItem("glitched_sign", new SignItem(new Item.Settings().maxCount(16), ModBlocks.STANDING_GLITCHED_SIGN, ModBlocks.WALL_GLITCHED_SIGN));
    public static final Item HANGING_GLITCHED_SIGN = registerItem("glitched_hanging_sign", new HangingSignItem(ModBlocks.HANGING_GLITCHED_SIGN, ModBlocks.WALL_HANGING_GLITCHED_SIGN, new Item.Settings().maxCount(16)));
    public static final Item CHORUS_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.CHORUS_BOAT_ID, ModBoats.CHORUS_BOAT_KEY, false);
    public static final Item CHORUS_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.CHORUS_CHEST_BOAT_ID, ModBoats.CHORUS_BOAT_KEY, true);
    public static final Item GLITCHED_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.GLITCHED_BOAT_ID, ModBoats.GLITCHED_BOAT_KEY, false);
    public static final Item GLITCHED_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.GLITCHED_CHEST_BOAT_ID, ModBoats.GLITCHED_BOAT_KEY, true);


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(RAW_RUBY);

    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(StardomsExtremeEnd.MOD_ID, name), item);
    }


    public static void registerModItems(){
        StardomsExtremeEnd.LOGGER.info("Registering mod items for: " + StardomsExtremeEnd.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }


}
