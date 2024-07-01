package stardom.extremeend.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fabricmc.fabric.api.screenhandler.v1.FabricScreenHandlerFactory;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;

public class ModScreenHandlers {
    public static final ScreenHandlerType<RefineryScreenHandler> REFINERY_SCREEN_HANDLER = register(Identifier.of(StardomsExtremeEnd.MOD_ID, "refinery"),
            (ScreenHandlerType.Factory<RefineryScreenHandler>) RefineryScreenHandler::new,
            RefineryData.PACKET_CODEC);

    private static ScreenHandlerType<RefineryScreenHandler> register(Identifier refinery, ScreenHandlerType.Factory<RefineryScreenHandler> aNew, PacketCodec<RegistryByteBuf, RefineryData> packetCodec) {
        return Registry.register(Registries.SCREEN_HANDLER, refinery, new ScreenHandlerType<RefineryScreenHandler>(aNew, FeatureFlags.VANILLA_FEATURES));
    }


    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType<T>(factory, FeatureFlags.VANILLA_FEATURES));
    }

    public static void registerScreenHandlers() {
        StardomsExtremeEnd.LOGGER.info("Registering Screen Handlers for " + StardomsExtremeEnd.MOD_ID);
    }
}