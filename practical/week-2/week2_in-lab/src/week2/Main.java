package main;

import adapters.LocalFileAdapter;
import adapters.OnlineStreamAdapter;
import adapters.RadioStationAdapter;
import bridge.AdvancedMusicPlayer;
import bridge.MusicPlayer;
import decorators.EqualizerDecorator;
import decorators.VolumeControlDecorator;
import interfaces.MusicSource;

public class Prog {
    public static void main(String[] args) {
        // 🎵 Adapting different music sources
        MusicSource localFile = new LocalFileAdapter("favorite_song.mp3");
        MusicSource onlineStream = new OnlineStreamAdapter("http://streamingservice.com/track");
        MusicSource radioStation = new RadioStationAdapter("Classic FM");

        // 🎧 Creating basic music players
        MusicPlayer localPlayer = new AdvancedMusicPlayer(localFile);
        MusicPlayer onlinePlayer = new AdvancedMusicPlayer(onlineStream);
        MusicPlayer radioPlayer = new AdvancedMusicPlayer(radioStation);

        // 🌟 Adding decorators for additional features
        MusicPlayer localWithEqualizer = new EqualizerDecorator(localPlayer);
        MusicPlayer onlineWithVolume = new VolumeControlDecorator(onlinePlayer);
        MusicPlayer radioWithAllFeatures = new VolumeControlDecorator(new EqualizerDecorator(radioPlayer));

        // 🎶 Playing music with different features
        System.out.println("\n=== 🎵 Playing Local File with Equalizer ===");
        localWithEqualizer.playMusic();

        System.out.println("\n=== 🌐 Playing Online Stream with Volume Control ===");
        onlineWithVolume.playMusic();

        System.out.println("\n=== 📻 Playing Radio Station with All Features ===");
        radioWithAllFeatures.playMusic();
    }
}
