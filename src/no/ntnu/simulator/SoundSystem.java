package no.ntnu.simulator;

import java.util.HashMap;
import java.util.Map;

public class SoundSystem extends SimulatedDevice{
    private String power;
    private String masterVolume;
    private String mute;
    private String inputSource;

    private Map<Integer, String> inputMap;
    private Map<String, Integer> inputMapFlipped;

    private static final String STATUS_REQUEST = "?";
    private static final String POWER = "PW";
    private static final String MASTER_VOLUME = "MV";
    private static final String MUTE = "MU";
    private static final String INPUT_SOURCE = "SI";

    public SoundSystem() {
        power = "OFF";
        masterVolume = "56";
        mute = "OFF";
        inputSource = "BD";

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

        inputMapFlipped = new HashMap<>();
        inputMapFlipped.put("CD", 0);
        inputMapFlipped.put("DVD", 1);
        inputMapFlipped.put("BD", 2);
        inputMapFlipped.put("TV", 3);
        inputMapFlipped.put("SAT/CBL", 4);
        inputMapFlipped.put("GAME", 5);
        inputMapFlipped.put("GAME2", 6);
        inputMapFlipped.put("DOCK", 7);
        inputMapFlipped.put("V.AUX", 8);
        inputMapFlipped.put("IPOD", 9);
        inputMapFlipped.put("NET/USB", 10);
        inputMapFlipped.put("SERVER", 11);
        inputMapFlipped.put("FAVORITES", 12);
        inputMapFlipped.put("USB/IPOD", 13);
        inputMapFlipped.put("USB", 14);
        inputMapFlipped.put("IPD", 15);
    }

    private String getPower() {
        return power;
    }

    private void setPower(String power) {
        this.power = power;
    }

    private String getMasterVolume() {
        return masterVolume;
    }

    private void setMasterVolume(String masterVolume) {
        this.masterVolume = masterVolume;
    }

    private String getMute() {
        return mute;
    }

    private void setMute(String mute) {
        this.mute = mute;
    }

    private String getInputSource() {
        return inputSource;
    }

    private void setInputSource(String inputSource) {
        this.inputSource = inputSource;
    }

    @Override
    public String generateResponse(String string) {
        if(string.length() <= 27) {
            String command = string.substring(0, 2);
            String parameter = string.substring(2);
            boolean statusCheck = parameter.equals(STATUS_REQUEST);
            if(statusCheck) {
                switch (command) {
                    case POWER:
                        return getPower();

                    case MASTER_VOLUME:
                        return getMasterVolume();

                    case MUTE:
                        return getMute();

                    case INPUT_SOURCE:
                        return getInputSource();
                }
            } else {
                int value = 0;
                if(command.equals(MASTER_VOLUME)){
                    try {
                        value = Integer.parseInt(parameter);

                    } catch (NumberFormatException nFE) {
                    }
                }
                switch (command) {
                    case POWER:
                        setPower(parameter);
                        return getPower();

                    case MASTER_VOLUME:
                        setMasterVolume(parameter);
                        return getMasterVolume();

                    case MUTE:
                        setMute(parameter);
                        return getMute();

                    case INPUT_SOURCE:
                        setInputSource(parameter);
                        return getInputSource();
                }
            }
            return "ERROR";
        } else {
            return "ERROR";
        }
    }
}
