package stardom.extremeend.block;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;

public class ModWoodTypes {
    public static WoodTypeBuilder builder = new WoodTypeBuilder();
    public static WoodType CHORUS = builder.register( Identifier.of(StardomsExtremeEnd.MOD_ID, "chorus"), BlockSetType.OAK);
}
