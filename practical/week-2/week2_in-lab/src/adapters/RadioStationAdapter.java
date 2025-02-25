package adapters;

import interfaces.MusicSource;

public class RadioStationAdapter implements MusicSource {
    private String station;

    public RadioStationAdapter(String station) {
        this.station = station;
    }

    @Override
    public void play() {
        System.out.println("📻 Playing radio station: " + station);
    }
}
