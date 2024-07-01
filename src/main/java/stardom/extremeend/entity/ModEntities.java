package stardom.extremeend.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.entity.custom.EnderGuardEntity;

public class ModEntities {
    public static final EntityType<EnderGuardEntity> ENDER_GUARD = Registry.register(Registries.ENTITY_TYPE, Identifier.of(StardomsExtremeEnd.MOD_ID, "ender_guard"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EnderGuardEntity::new).dimensions(EntityDimensions.fixed(1,3)).build());
}
