package stardom.extremeend.screen;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record RefineryData(BlockPos pos) { public static final PacketCodec<RegistryByteBuf, RefineryData> PACKET_CODEC = PacketCodec.tuple(BlockPos.PACKET_CODEC, RefineryData::pos, RefineryData::new); }