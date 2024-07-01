package stardom.extremeend.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.item.trim.ArmorTrimPatterns;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import stardom.extremeend.StardomsExtremeEnd;

public class ModArmorTrimPatterns extends ArmorTrimPatterns {

    public static final RegistryKey<ArmorTrimPattern> PILLARS = of(StardomsExtremeEnd.MOD_ID + ":pillars");

    public static void bootstrap(Registerable<ArmorTrimPattern> registry) {
        register(registry, ModItems.PILLARS_TRIM_TEMPLATE, PILLARS);
    }

    private static RegistryKey<ArmorTrimPattern> of(String id) {
        return RegistryKey.of(RegistryKeys.TRIM_PATTERN, Identifier.of(id));
    }

    public static void register(Registerable<ArmorTrimPattern> registry, Item template, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern armorTrimPattern = new ArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(template), Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);
        registry.register(key, armorTrimPattern);
    }
}
