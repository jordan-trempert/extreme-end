package stardom.extremeend.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DraconicSoulItem extends Item{
    public DraconicSoulItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        return ModItems.DRACONIC_SOUL.getDefaultStack();
    }
}
