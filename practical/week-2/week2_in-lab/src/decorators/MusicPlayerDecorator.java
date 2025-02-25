package decorators;

import bridge.MusicPlayer;

public abstract class MusicPlayerDecorator extends MusicPlayer {
    protected MusicPlayer musicPlayer;

    public MusicPlayerDecorator(MusicPlayer musicPlayer) {
        super(null); // No direct music source needed here
        this.musicPlayer = musicPlayer;
    }

    @Override
    public abstract void playMusic();
}
