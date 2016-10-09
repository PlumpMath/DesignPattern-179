package facade;

public class RemoteController {
	Television television;
	Light light;
	
	public RemoteController() {
		television = new Television();
		light = new Light();
	}
	
	public void watchTV() {
		light.off();
		television.on();
	}
	
	public void closeTV() {
		light.on();
		television.off();
	}
}
