
/**
 * This Exception is thrown when the user tries to add a new member and
 * inputs an age outside of the allowable bounds of 0 to 150 (inclusive).
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-15
 */
public class NoSuchAgeException extends Exception {
	
	/**
	 * Constructor method for NoSuchAgeException.
	 * @param errMsg Error message passed to the constructor.
	 */
	public NoSuchAgeException (String errMsg) {
		super(errMsg);
	
	}
	
}
