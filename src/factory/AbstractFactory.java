package factory;

public interface AbstractFactory {
	public Sender createSender();
	public Receiver createReceiver();
}
