package stardom.extremeend.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import java.util.List;

public class DraconicChestplateItem extends DraconicArmorItem {
    public DraconicChestplateItem(RegistryEntry<ArmorMaterial> material, ArmorItem. Type type, Item. Settings settings) {
        super(material, type, settings);

    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.extremeend.draconic_chestplate"));
    }
}