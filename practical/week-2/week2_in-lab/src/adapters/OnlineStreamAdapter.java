package adapters;

import interfaces.MusicSource;

public class OnlineStreamAdapter implements MusicSource {
    private String url;

    public OnlineStreamAdapter(String url) {
        this.url = url;
    }

    @Override
    public void play() {
        System.out.println("🌐 Streaming online from: " + url);
    }
}
