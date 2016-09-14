package factory;

public class StaticFactory {
	public static Sender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		} else if ("sms".equals(type)) {
			return new SmsSender();
		} else {
			return null;
		}
	}
}
