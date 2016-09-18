package singleton;

/**
 * �ڲ��൥��
 */
public class InnerClassSingleTon {
	private InnerClassSingleTon() {}
	
	public static InnerClassSingleTon getIntance() {
		return SingleTonHolder.INTANCE;
	}
	
	private static class SingleTonHolder {
		private static final InnerClassSingleTon INTANCE = new InnerClassSingleTon();
	}
}
