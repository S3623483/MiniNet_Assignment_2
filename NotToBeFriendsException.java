
/**
 * This Exception is thrown when the user tries to create a Friend
 * connection in violation of MiniNet's rules. Friend connections not
 * allowed by MiniNet are as follows:
 * A friend connection between an Adult and a Child
 * A friend connection between an Adult and a Baby
 * A friend connection between a Child and a Baby
 * A friend connection between two Child with age gap greater than 3 years
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-16
 */
public class NotToBeFriendsException extends Exception {
	
	/**
	 * Constructor method for NotToBeFriendsException.
	 * @param errMsg Error message passed to the constructor.
	 */
	public NotToBeFriendsException (String errMsg) {
		super(errMsg);
	}
	
}
