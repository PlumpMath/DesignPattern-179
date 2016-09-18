package singleton;

/**
 * ��������
 */
public class EagerlySingleTon {
	private static EagerlySingleTon intance = new EagerlySingleTon();
	
	private EagerlySingleTon() {}
	
	public static EagerlySingleTon getIntance() {
		return intance;
	}
}
