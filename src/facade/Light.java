package facade;

public class Light {
	public void on(){
		System.out.println(getClass().getSimpleName() + " " + getClass().getMethods()[0].getName());
	};
	public void off(){
		System.out.println(getClass().getSimpleName() + " " + getClass().getMethods()[1].getName());
	};
}
