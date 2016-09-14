package factory;

public class SenderFactory implements Factory {

	@Override
	public Sender createSender() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

}
