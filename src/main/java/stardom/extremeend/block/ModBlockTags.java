package stardom.extremeend.block;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;

public class ModBlockTags {
    public static final TagKey<Block> ENDER_BASE_BLOCKS = register("ender_base_blocks");


    private static TagKey<Block> register(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(StardomsExtremeEnd.MOD_ID,id));
    }

}
