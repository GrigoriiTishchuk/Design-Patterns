public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create a weather station and observers
        WeatherStation weatherStation = new WeatherStation(-20, 40);
        WeatherObserver observer1 = new ConcreteObserver("Observer 1", "Temperature changed!");
        WeatherObserver observer2 = new ConcreteObserver("Observer 2", "Temperature updated!");
        WeatherObserver observer3 = new ConcreteObserver("Observer 3", "Temperature changed!");

        // Register observers
        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);
        weatherStation.addObserver(observer3);

        Thread stationThread = new Thread(weatherStation::start);
        System.out.println("Weather station started.");
        stationThread.start();

        Thread.sleep(10000); // Let the weather station run for 10 seconds

        System.out.println("Weather observer 3 is removed.");
        weatherStation.removeObserver(observer3);

        Thread.sleep(5000);
        System.out.println("Weather station stopped.");
        weatherStation.stop();
        stationThread.interrupt();
    }

}
