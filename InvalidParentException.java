
/**
 * This Exception is thrown when incorrect parent information is entered
 * for a Child or Baby member of MiniNet. For example, this Exception will
 * be thrown if the user leaves the parent1 and/or parent2 TextField's
 * empty when trying to add a new member who is under sixteen years of age.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-19
 */
public class InvalidParentException extends Exception {
	
	/**
	 * Constructor method for InvalidParentException.
	 * @param errMsg Error message passed to the constructor.
	 */
	public InvalidParentException (String errMsg) {
		super(errMsg);
	}
	
}
