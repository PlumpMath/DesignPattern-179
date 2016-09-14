package factory;

public class MailFactory implements AbstractFactory {

	@Override
	public Sender createSender() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

	@Override
	public Receiver createReceiver() {
		// TODO Auto-generated method stub
		return new MailReceiver();
	}

}
