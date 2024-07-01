package stardom.extremeend.client.render;

import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

public class VoidEnergyRenderHandler implements FluidRenderHandler {

    public VoidEnergyRenderHandler(Identifier stillTexture, Identifier flowingTexture, int tintColor) {
    }


    @Override
    public Sprite[] getFluidSprites(@Nullable BlockRenderView view, @Nullable BlockPos pos, FluidState state) {
        return new Sprite[0];
    }
}
