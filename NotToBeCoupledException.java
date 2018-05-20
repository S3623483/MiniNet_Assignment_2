
/**
 * This Exception is thrown when the user tries to include either
 * a Child and/or a Baby in a Couple connection.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-16
 */
public class NotToBeCoupledException extends Exception {
	
	/**
	 * Constructor method for NotToBeCoupledException.
	 * @param errMsg Error message passed to the constructor.
	 */
	public NotToBeCoupledException(String errMsg) {
		super(errMsg);
	}
	
}
