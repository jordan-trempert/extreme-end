package stardom.extremeend.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.impl.item.TerraformBoatItem;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.block.ModBlocks;
import stardom.extremeend.item.ModItems;

public class ModBoats {
    public static final Identifier CHORUS_BOAT_ID = Identifier.of(StardomsExtremeEnd.MOD_ID, "chorus_boat");
    public static final Identifier CHORUS_CHEST_BOAT_ID = Identifier.of(StardomsExtremeEnd.MOD_ID, "chorus_chest_boat");

    public  static final  RegistryKey<TerraformBoatType> CHORUS_BOAT_KEY = TerraformBoatTypeRegistry.createKey(CHORUS_BOAT_ID);

    public static final Identifier GLITCHED_BOAT_ID = Identifier.of(StardomsExtremeEnd.MOD_ID, "glitched_boat");
    public static final Identifier GLITCHED_CHEST_BOAT_ID = Identifier.of(StardomsExtremeEnd.MOD_ID, "glitched_chest_boat");

    public  static final  RegistryKey<TerraformBoatType> GLITCHED_BOAT_KEY = TerraformBoatTypeRegistry.createKey(GLITCHED_BOAT_ID);

    public static void registerBoats(){
        TerraformBoatType chorusBoat = new TerraformBoatType.Builder()
                .item(ModItems.CHORUS_BOAT)
                .chestItem(ModItems.CHORUS_CHEST_BOAT)
                .planks(ModBlocks.CHORUS_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, CHORUS_BOAT_KEY, chorusBoat);

        TerraformBoatType glitchedBoat = new TerraformBoatType.Builder()
                .item(ModItems.GLITCHED_BOAT)
                .chestItem(ModItems.GLITCHED_CHEST_BOAT)
                .planks(ModBlocks.GLITCHED_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, GLITCHED_BOAT_KEY, glitchedBoat);
    }

}
