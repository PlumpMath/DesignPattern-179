package command;

public class TableLight implements Light {

	@Override
	public void on() {
		System.out.println("TableLight on!");
	}

	@Override
	public void off() {
		System.out.println("TableLight off!");		
	}

}
