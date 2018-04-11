package no.ntnu.simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SoundSystemCommunicator extends Communicator {
    private SoundSystem soundSystem;
    public SoundSystemCommunicator(Socket host, SoundSystem device, OnLog callback) {
        super(host,callback);
        setName("SS-" + getId());
        this.soundSystem = device;
    }

    @Override
    public void run(){
        try{
            br = new BufferedReader(new InputStreamReader(getHost().getInputStream()));
            pw = new PrintWriter(getHost().getOutputStream(), true);
            print(Log.CONNECTION, getHost().getRemoteSocketAddress() + " CONNECTED");
            while(isRunning()){
                if(isDataAvailable(br)){
                    String line = br.readLine();
                    print(Log.RECEIVED, line);
                    String response = soundSystem.generateResponse(line);
                    print(Log.GENERATED, response);
                    send(response);
                }
            }
        } catch (IOException e) {
            finish();
        }
    }

    private void send(String response) {
        pw.println(response);
        pw.flush();
        print(Log.SENT, response);
    }

    private boolean isDataAvailable(BufferedReader br) throws IOException {
        br.mark(100);
        boolean returnValue = br.read() != -1;
        br.reset();
        return returnValue;
    }
}
