package adapters;

import interfaces.MusicSource;

public class LocalFileAdapter implements MusicSource {
    private String fileName;

    public LocalFileAdapter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void play() {
        System.out.println("🎵 Playing local file: " + fileName);
    }
}
