package stardom.extremeend.entity.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<RefineryBlockEntity> REFINERY_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(StardomsExtremeEnd.MOD_ID, "refinery_be"),
                    FabricBlockEntityTypeBuilder.create(RefineryBlockEntity::new, ModBlocks.REFINERY).build());

    public static void registerBlockEntities(){
        StardomsExtremeEnd.LOGGER.info("Block Entities Registered");
    }
}
