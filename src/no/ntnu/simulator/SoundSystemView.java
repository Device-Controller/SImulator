package no.ntnu.simulator;

public class SoundSystemView extends AbstractSimulatorView{
    private SoundSystem soundSystem;
    public SoundSystemView() {
        soundSystem = new SoundSystem();
        setServer(new Server(23, soundSystem, this::handleDummy, this::updateFields));
    }

    @Override
    protected void updateFields() {
    }
}
