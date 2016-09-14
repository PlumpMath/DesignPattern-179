package factory;

public class MailReceiver implements Receiver {

	@Override
	public void receive() {
		System.out.println(getClass().getSimpleName());	
	}

}
