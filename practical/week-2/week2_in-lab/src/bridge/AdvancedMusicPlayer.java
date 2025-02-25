package bridge;

import interfaces.MusicSource;

public class AdvancedMusicPlayer extends MusicPlayer {
    public AdvancedMusicPlayer(MusicSource musicSource) {
        super(musicSource);
    }

    @Override
    public void playMusic() {
        System.out.println("🎧 Advanced music player:");
        musicSource.play();
    }
}
