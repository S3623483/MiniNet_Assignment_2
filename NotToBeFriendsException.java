
public class NotToBeFriendsException extends Exception {
	
	public NotToBeFriendsException (String errMsg) {
		super(errMsg);
		System.out.println("Invalid Friendship");
	}
	
}
