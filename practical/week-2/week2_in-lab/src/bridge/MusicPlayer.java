package bridge;

import interfaces.MusicSource;

public abstract class MusicPlayer {
    public MusicSource musicSource;

    public MusicPlayer(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    public abstract void playMusic();
}
