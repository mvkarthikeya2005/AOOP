package decorators;

import bridge.MusicPlayer;

public class VolumeControlDecorator extends MusicPlayerDecorator {
    public VolumeControlDecorator(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    @Override
    public void playMusic() {
        musicPlayer.playMusic();
        System.out.println("🔊 Volume control enabled.");
    }
}
