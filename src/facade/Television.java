package facade;

public class Television {
	public void on(){
		System.out.println(getClass().getSimpleName() + " " + getClass().getMethods()[0].getName());
	};
	public void off(){
		System.out.println(getClass().getSimpleName() + " " + getClass().getMethods()[1].getName());
	};
}
