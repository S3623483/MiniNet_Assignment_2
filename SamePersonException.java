
/**
 * This Exception is thrown when the user tries to involve the
 * same member within a connection transaction.  For example, this
 * Exception will be thrown if the user tries to connect a member
 * with themself.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-16
 */
public class SamePersonException extends Exception {
	
	/**
	 * Constructor method for SamePersonException.
	 * @param errMsg Error message passed to the constructor
	 */
	public SamePersonException (String errMsg) {
		super(errMsg);
	}
	
}
