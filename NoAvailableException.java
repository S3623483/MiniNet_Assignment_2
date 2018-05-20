
/**
 * This Exception is thrown when the user tries to connect to adults
 * as a couple and at least one of them is already connected with another
 * adult as a couple.
 * @author Benjamin R Donnelly
 * @version 1.0
 * @since 2018-05-16
 */
public class NoAvailableException extends Exception {
	
	/**
	 * Constructor method for NoAvailableException.
	 * @param errMsg Error message passed to the constructor.
	 */
	public NoAvailableException(String errMsg) {
		super(errMsg);
	}
	
}
