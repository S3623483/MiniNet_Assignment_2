
public class AlreadyConnectedException extends Exception {
	
	public AlreadyConnectedException (String errMsg) {
		super(errMsg);
		System.out.println("These people are already connected.");
	}
	
}
