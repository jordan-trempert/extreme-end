package stardom.extremeend;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.boat.impl.item.TerraformBoatItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.EndPortalBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import stardom.extremeend.block.ModBlocks;
import stardom.extremeend.client.render.VoidEnergyRenderHandler;
import stardom.extremeend.entity.ModBoats;
import stardom.extremeend.entity.ModEntities;
import stardom.extremeend.entity.block.RefineryBlockEntity;
import stardom.extremeend.entity.client.EnderGuardModel;
import stardom.extremeend.entity.client.EnderGuardRenderer;
import stardom.extremeend.entity.client.ModModelLayers;
import stardom.extremeend.entity.custom.EnderGuardEntity;
import stardom.extremeend.item.DraconicArmorItem;
import stardom.extremeend.particle.ModParticles;
import stardom.extremeend.particle.custom.ToxicBubbleParticle;
import stardom.extremeend.screen.ModScreenHandlers;
import stardom.extremeend.screen.RefineryScreen;

import static stardom.extremeend.block.ModBlocks.REFINERY;
import static stardom.extremeend.block.ModFluids.*;

public class StardomsExtremeEndClient implements ClientModInitializer{
    @Override
    public void onInitializeClient(){

        final ParticleManager particleManager;
        TerraformBoatClientHelper.registerModelLayers(ModBoats.CHORUS_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.GLITCHED_BOAT_ID, false);
        DraconicArmorItem.registerElytra();



        // Register your custom fluid renderer
        FluidRenderHandlerRegistry.INSTANCE.register(STILL_VOID_ENERGY, FLOWING_VOID_ENERGY,
                new SimpleFluidRenderHandler(
                        Identifier.of("extremeend:block/end_portal"),
                        Identifier.of("extremeend:block/end_portal"),
                        0xA1E038D0
                ));

        // Map your fluids to a render layer
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                STILL_VOID_ENERGY, FLOWING_VOID_ENERGY);



        FluidRenderHandlerRegistry.INSTANCE.register(STILL_TOXINS, FLOWING_TOXINS,
                new SimpleFluidRenderHandler(
                        Identifier.of("extremeend:block/toxins"),
                        Identifier.of("extremeend:block/toxins"),
                        0xA100ff00
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                STILL_TOXINS, FLOWING_TOXINS);


        EntityRendererRegistry.register(ModEntities.ENDER_GUARD, EnderGuardRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ENDER_GUARD, EnderGuardModel::getTexturedModelData);

        ParticleFactoryRegistry.getInstance().register(ModParticles.TOXIC_BUBBLE_PARTICLE, ToxicBubbleParticle.Factory::new);
        HandledScreens.register(ModScreenHandlers.REFINERY_SCREEN_HANDLER,
                RefineryScreen::new);







    }
}
