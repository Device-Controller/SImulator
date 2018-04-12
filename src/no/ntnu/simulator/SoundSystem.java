package no.ntnu.simulator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoundSystem extends SimulatedDevice{
    private int power;
    private int masterVolume;
    private int mute;
    private int inputSource;

    private Map<Integer, String> inputMap;

    private static final String STATUS_REQUEST = "?";
    private static final String POWER = "PW";
    private static final String MASTER_VOLUME = "MV";
    private static final String MUTE = "MU";
    private static final String INPUT_SOURCE = "SI";

    public SoundSystem() {
        power = 0;
        masterVolume = 56;
        mute = 0;
        inputSource = 5;

        inputMap = new HashMap<>();
        inputMap.put(0, "CD");
        inputMap.put(1, "DVD");
        inputMap.put(2, "BD");
        inputMap.put(3, "TV");
        inputMap.put(4, "SAT/CBL");
        inputMap.put(5, "GAME");
        inputMap.put(6, "GAME2");
        inputMap.put(7, "DOCK");
        inputMap.put(8, "V.AUX");
        inputMap.put(9, "IPOD");
        inputMap.put(10, "NET/USB");
        inputMap.put(11, "SERVER");
        inputMap.put(12, "FAVORITES");
        inputMap.put(13, "USB/IPOD");
        inputMap.put(14, "USB");
        inputMap.put(15, "IPD");
    }

    @Override
    public String generateResponse(String string) {
        return string;
    }
}
