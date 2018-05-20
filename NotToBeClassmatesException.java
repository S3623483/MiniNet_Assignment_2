
/**
 * This Exception is thrown when the user tries to include a Baby
 * in a Classmate connection.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-16
 */
public class NotToBeClassmatesException extends Exception {
	
	/**
	 * Constructor method for NoSuchAgeException.
	 * @param errMsg Error message passed to the constructor.
	 */
	public NotToBeClassmatesException(String errMsg) {
		super(errMsg);
	}
	
}
