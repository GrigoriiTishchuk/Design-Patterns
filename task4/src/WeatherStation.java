import java.util.Random;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class WeatherStation {
    // something must be done with observers list to be sure it is okay in a thread.
    // typical list + snapshot = garbage collector is not happy OR
    // Syncronized list and deal with bs of syncronization OR
    // CopyOnWriteArrayList is thread-safe and read happens constantly and with update/delete copy of list is made OR
    // use a ReadWritelock to make sure that the list is not modified while iterating over it
    private final List<WeatherObserver> observers = new CopyOnWriteArrayList<>();
    private final Random random = new Random();
    private int temperature;
    private final int minTemperature;
    private final int maxTemperature;
    private volatile boolean running = true;

    public WeatherStation(int minTemperature, int maxTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.temperature = random.nextInt(maxTemperature - minTemperature + 1) + minTemperature;
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    public void stop() {
        this.running = false;
    }

    public void start() {
        while (running) {
            try {
                int sleepTime = random.nextInt(2000) + 1000; // Random sleep between 1 and 3 seconds
                Thread.sleep(sleepTime);
                // Randomly change the temperature by -2 to +2 degrees
                int newTemperature = temperature + random.nextInt(-2, 3);
                if (newTemperature >= minTemperature && newTemperature <= maxTemperature) {
                    temperature = newTemperature;
                    System.out.println("-<Weather Station> New temperature: " + newTemperature + " Celcius-");
                    notifyObservers();
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
