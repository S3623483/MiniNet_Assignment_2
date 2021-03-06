
/**
 * This Exception is thrown when the user tries to include a Baby
 * in a Colleague connection.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-16
 */
public class NotToBeColleaguesException extends Exception {
	
	/**
	 * Constructor method for NotToBeColleaguesException.
	 * @param errMsg Error message passed to the constructor.
	 */
	public NotToBeColleaguesException (String errMsg) {
		super(errMsg);
	}
	
}
