package stardom.extremeend.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.recipebook.FurnaceRecipeBookScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import stardom.extremeend.StardomsExtremeEnd;

@Environment(value = EnvType.CLIENT)
public class RefineryScreen extends AbstractFurnaceScreen<RefineryScreenHandler> {
    private static final Identifier LIT_PROGRESS_TEXTURE = Identifier.of("container/refinery/lit_progress");
    private static final Identifier BURN_PROGRESS_TEXTURE = Identifier.of("container/refinery/burn_progress");
    private static final Identifier TEXTURE = Identifier.of(StardomsExtremeEnd.MOD_ID, "textures/gui/refinery.png");

    public RefineryScreen(RefineryScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, new FurnaceRecipeBookScreen(), inventory, title, TEXTURE, LIT_PROGRESS_TEXTURE, BURN_PROGRESS_TEXTURE);
    }

    @Override
    public void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;

    }



    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int l;
        int k;
        int i = this.x;
        int j = this.y;
        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        if ((this.handler).isBurning()) {
            k = 14;
            l = MathHelper.ceil(this.handler.getFuelProgress() * 13.0f) + 1;
            context.drawGuiTexture(LIT_PROGRESS_TEXTURE, 14, 14, 0, 14 - l, i + 56, j + 36 + 14 - l, 14, l);
        }
        k = 24;
        l = MathHelper.ceil(this.handler.getCookProgress() * 24.0);
        context.drawGuiTexture(BURN_PROGRESS_TEXTURE, 24, 16, 0, 0, i + 79, j + 34, l, 16);
    }






}
