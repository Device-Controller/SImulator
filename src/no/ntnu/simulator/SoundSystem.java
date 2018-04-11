package no.ntnu.simulator;

public class SoundSystem extends SimulatedDevice{
    private int power = 0;
    private int volume = 0;
    private int mute = 0;
    private int source = 0;
    @Override
    public String generateResponse(String string) {
        return string;
    }
}
