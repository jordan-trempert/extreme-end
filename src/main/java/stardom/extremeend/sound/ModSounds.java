package stardom.extremeend.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.block.jukebox.JukeboxSongs;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import stardom.extremeend.StardomsExtremeEnd;

public class ModSounds {


    public static final RegistryEntry.Reference<SoundEvent> NEBULOUS_VOID = registerReference("nebulus_void");
    public static final RegistryKey<JukeboxSong> NEBULOUS_VOID_SONG = ModSounds.of("nebulus_void");



    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(StardomsExtremeEnd.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        StardomsExtremeEnd.LOGGER.info("Registering Sounds for " + StardomsExtremeEnd.MOD_ID);

    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(String id) {
        return registerReference(Identifier.ofVanilla(id));
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id) {
        return registerReference(id, id);
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id, Identifier soundId) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }


    private static RegistryKey<JukeboxSong> of(String id) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(StardomsExtremeEnd.MOD_ID, id));
    }

    public static void bootstrap(Registerable<JukeboxSong> registry) {
        ModSounds.register(registry, NEBULOUS_VOID_SONG, ModSounds.NEBULOUS_VOID, 45, 1);
    }

    private static void register(Registerable<JukeboxSong> registry, RegistryKey<JukeboxSong> key, RegistryEntry.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        registry.register(key, new JukeboxSong(soundEvent, Text.translatable(Util.createTranslationKey("jukebox_song", key.getValue())), lengthInSeconds, comparatorOutput));
    }
}