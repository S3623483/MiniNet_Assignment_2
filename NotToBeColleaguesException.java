
public class NotToBeColleaguesException extends Exception {
	
	public NotToBeColleaguesException (String errMsg) {
		super(errMsg);
		System.out.println("A Baby can not be included in a colleague connection.");
	}
	
}
