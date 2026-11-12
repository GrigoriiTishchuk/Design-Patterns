package devices;

public class SmartTv extends Tv {
    private String currentUrl = "None";

    public void browseInternet(String url) {
        if (isEnabled()) {
            this.currentUrl = url;
            System.out.println("SmartTV: Navigating to " + url);
        } else {
            System.out.println("SmartTV: Cannot browse internet while TV is turned off.");
        }
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm Smart TV.");
        System.out.println("| I'm " + (isEnabled() ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + getVolume() + "%");
        System.out.println("| Current channel is " + getChannel());
        System.out.println("| Current browser URL: " + currentUrl);
        System.out.println("------------------------------------\n");
    }
}