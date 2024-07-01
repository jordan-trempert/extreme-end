package stardom.extremeend.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import stardom.extremeend.StardomsExtremeEnd;
import stardom.extremeend.particle.custom.ToxicBubbleParticle;

public class ModParticles {
    public static final SimpleParticleType TOXIC_BUBBLE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles(){
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(StardomsExtremeEnd.MOD_ID, "toxic_bubbles_particle"), TOXIC_BUBBLE_PARTICLE);
    }
}
