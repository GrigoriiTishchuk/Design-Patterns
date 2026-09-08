import java.util.Random;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class WeatherStation {
    // something must be done with observers list to be sure it is okay in a thread.
    // typical list + snapshot = garbage collector is not happy OR
    // Syncronized list and deal with bs of syncronization OR
    // CopyOnWriteArrayList is thread-safe and read happens constantly and with update/delete copy of list is made OR
    // use a ReadWritelock to make sure that the list is not modified while iterating over it
    private List<WeatherObserver> observers = new CopyOnWriteArrayList<>();
}
