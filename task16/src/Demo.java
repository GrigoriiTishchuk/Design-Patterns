import devices.Device;
import devices.Radio;
import devices.SmartTv;
import devices.Tv;
import remotes.AdvancedRemote;
import remotes.BasicRemote;
import remotes.SmartRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
        testSmartFeatures();
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

    public static void testSmartFeatures() {
        System.out.println("Tests with SmartTV and SmartRemote.");
        SmartTv smartTV = new SmartTv();
        SmartRemote smartRemote = new SmartRemote(smartTV);

        smartRemote.voiceControl("Power on");
        smartRemote.voiceControl("Open https://refactoring.guru");
        smartTV.printStatus();

        System.out.println("Tests with SmartRemote on standard Radio.");
        Radio radio = new Radio();
        SmartRemote radioSmartRemote = new SmartRemote(radio);
        radioSmartRemote.voiceControl("Power toggle");
        radioSmartRemote.voiceControl("Open https://example.com");
        radio.printStatus();
    }
}