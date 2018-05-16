
public class NotToBeCoupledException extends Exception {
	
	public NotToBeCoupledException(String errMsg) {
		super(errMsg);
		System.out.println("Only adult members can be included in couple connections.");
	}
	
}
