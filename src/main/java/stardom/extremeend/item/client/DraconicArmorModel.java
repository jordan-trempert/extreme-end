package stardom.extremeend.item.client;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.item.DraconicArmorItem;

public class DraconicArmorModel extends GeoModel<DraconicArmorItem> {
    @Override
    public Identifier getModelResource(DraconicArmorItem animatable) {
        return Identifier.of(StardomsExtremeEnd.MOD_ID, "geo/armor/draconic_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(DraconicArmorItem animatable) {
        return Identifier.of(StardomsExtremeEnd.MOD_ID, "textures/armor/draconic_armor.png");

    }

    @Override
    public Identifier getAnimationResource(DraconicArmorItem animatable) {
        return Identifier.of(StardomsExtremeEnd.MOD_ID, "animations/armor/draconic_armor.animation.json");

    }

}
