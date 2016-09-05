package observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
	private float temperature;
	private float humidity;
	private float pressure;
	
	@Override
	public void register(Subject subject) {
		subject.registerObserver(this);
	}
	
	@Override
	public void unregister(Subject subject) {
		subject.removeObserver(this);
	}

	@Override
	public void display() {
		System.out.println("temperature: " + temperature  + "\nhumidity: "+ humidity + "\npressure: " + pressure);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		
		display();
	}

}
