package stardom.extremeend.screen;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.data.DataGenerator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import stardom.extremeend.block.ModBlocks;
import stardom.extremeend.entity.block.AbstractRefineryBlockEntity;
import stardom.extremeend.entity.block.RefineryBlockEntity;

import java.sql.Ref;

public class RefineryScreenHandler extends AbstractFurnaceScreenHandler {


    protected RefineryScreenHandler(ScreenHandlerType<?> type, RecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookCategory category, int syncId, PlayerInventory playerInventory) {
        super(type, recipeType, category, syncId, playerInventory);
    }

    public RefineryScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlers.REFINERY_SCREEN_HANDLER, RecipeType.SMELTING, RecipeBookCategory.FURNACE, syncId, playerInventory);
    }


    public RefineryScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.REFINERY_SCREEN_HANDLER, RecipeType.SMELTING, RecipeBookCategory.FURNACE, syncId, playerInventory, inventory, propertyDelegate);
    }


    @Override
    protected boolean isFuel(ItemStack itemStack) {
        return AbstractRefineryBlockEntity.canUseAsFuel(itemStack);
    }

    @Override
    protected boolean isSmeltable(ItemStack itemStack) {
        return itemStack.getItem() == ModBlocks.RUBY_BLOCK.asItem();
    }

    @Override
    public RecipeBookCategory getCategory() {
        return RecipeBookCategory.CRAFTING;
    }

    @Override
    public void populateRecipeFinder(RecipeMatcher finder) {
        return;
    }
}

