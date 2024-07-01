/*
 * Decompiled with CFR 0.2.2 (FabricMC 7c48b8c4).
 */
package stardom.extremeend.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.joml.Matrix4f;

@Environment(value=EnvType.CLIENT)
public class VoidEnergyRenderer<T extends BlockEntity> implements BlockEntityRenderer<T> {
    public static final Identifier FLUID_TEXTURE = Identifier.ofVanilla("textures/block/end_portal.png");

    public VoidEnergyRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(T blockEntity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, int overlay) {
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        this.renderFluid(blockEntity, matrix4f, vertexConsumerProvider.getBuffer(this.getLayer()));
    }

    private void renderFluid(T entity, Matrix4f matrix, VertexConsumer vertexConsumer) {
        float bottomY = this.getBottomYOffset();
        float topY = this.getTopYOffset();
        this.renderSide(entity, matrix, vertexConsumer, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, Direction.SOUTH);
        this.renderSide(entity, matrix, vertexConsumer, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, Direction.NORTH);
        this.renderSide(entity, matrix, vertexConsumer, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, Direction.EAST);
        this.renderSide(entity, matrix, vertexConsumer, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, Direction.WEST);
        this.renderSide(entity, matrix, vertexConsumer, 0.0f, 1.0f, bottomY, bottomY, 0.0f, 0.0f, 1.0f, 1.0f, Direction.DOWN);
        this.renderSide(entity, matrix, vertexConsumer, 0.0f, 1.0f, topY, topY, 1.0f, 1.0f, 0.0f, 0.0f, Direction.UP);
    }

    private void renderSide(T entity, Matrix4f model, VertexConsumer vertices, float x1, float x2, float y1, float y2, float z1, float z2, float z3, float z4, Direction side) {
        // Check if we should render this side (logic depends on fluid or block type)
        if (shouldRenderSide(entity, side)) {
            vertices.vertex(model, x1, y1, z1).color(255, 255, 255, 255);
            vertices.vertex(model, x2, y1, z2).color(255, 255, 255, 255);
            vertices.vertex(model, x2, y2, z3).color(255, 255, 255, 255);
            vertices.vertex(model, x1, y2, z4).color(255, 255, 255, 255);
        }
    }

    protected boolean shouldRenderSide(T entity, Direction side) {
        // Custom logic to determine if the side should be rendered
        return true; // Example: always render for simplicity
    }

    protected float getTopYOffset() {
        return 0.875f; // Example value for fluid height
    }

    protected float getBottomYOffset() {
        return 0.125f; // Example value for fluid height
    }

    protected RenderLayer getLayer() {
        return RenderLayer.getTranslucent();
    }
}
