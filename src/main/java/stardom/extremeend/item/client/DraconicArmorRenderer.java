package stardom.extremeend.item.client;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.item.DraconicArmorItem;

public final class DraconicArmorRenderer extends GeoArmorRenderer<DraconicArmorItem> {
    public DraconicArmorRenderer() {
        super(new DefaultedItemGeoModel<>(Identifier.of(StardomsExtremeEnd.MOD_ID, "armor/draconic_armor"))); // Using DefaultedItemGeoModel like this puts our 'location' as item/armor/example armor in the assets folders.
    }
}