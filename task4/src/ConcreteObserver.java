public class ConcreteObserver implements WeatherObserver {
    private final String name;
    private final String message;


    public ConcreteObserver(String name, String message) {
        this.name = name;
        this.message = message;
    }

    @Override
    public void update(int temperature) {
        System.out.println("Observer " + name + " received update: " + message + " Current temperature: " + temperature);
    }
}
