package stardom.extremeend.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.entity.custom.EnderGuardEntity;

public class EnderGuardRenderer extends MobEntityRenderer<EnderGuardEntity, EnderGuardModel<EnderGuardEntity>> {
    public static final Identifier TEXTURE = Identifier.of(StardomsExtremeEnd.MOD_ID, "textures/entity/ender_guard.png");
    public EnderGuardRenderer(EntityRendererFactory.Context context) {
        super(context, new EnderGuardModel<>(context.getPart(ModModelLayers.ENDER_GUARD)), 0.6f);
    }

    @Override
    public Identifier getTexture(EnderGuardEntity entity) {
        return TEXTURE;
    }
}
