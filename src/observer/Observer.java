package observer;

public interface Observer {
	public void register(Subject subject);
	public void unregister(Subject subject);
	public void update(float temperature, float humidity, float pressure);
}
