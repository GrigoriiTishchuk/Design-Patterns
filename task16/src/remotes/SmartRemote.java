package remotes;

import devices.Device;
import devices.SmartTv;

public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("SmartRemote: Processing voice command -> \"" + command + "\"");
        String normalized = command.toLowerCase();

        if (normalized.contains("power") || normalized.contains("toggle")) {
            power();
        } else if (normalized.contains("mute")) {
            mute();
        } else if (normalized.startsWith("open ")) {
            String url = command.substring(5).trim();
            if (device instanceof SmartTv) {
                ((SmartTv) device).browseInternet(url);
            } else {
                System.out.println("SmartRemote: Connected device does not support internet browsing.");
            }
        } else {
            System.out.println("SmartRemote: Unknown voice command.");
        }
    }
}