
/**
 * This Exception is thrown when the user tries when the user
 * tries to add a member but enters a userID that is being used
 * by an existing member of MiniNet.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-19
 */
public class UserIDInUseException extends Exception {
	
	/**
	 * Constructor method for UserIDInUseException.
	 * @param errMsg Error message passed to the constructor
	 */
	public UserIDInUseException (String errMsg) {
		super(errMsg);
	}
	
}
