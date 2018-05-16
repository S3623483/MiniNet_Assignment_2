
public class SamePersonException extends Exception {
	
	public SamePersonException (String errMsg) {
		super(errMsg);
		System.out.println("You are trying to connect the same person");
	}
	
}
