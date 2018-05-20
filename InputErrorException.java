
/**
 * This Exception is thrown when the user incorrectly completes some of
 * the GUI scenes. For example, this Exception will be thrown if the user
 * tries to add a new member without entering a userID and/or fullName.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-19
 */
public class InputErrorException extends Exception {
	
	/**
	 * Constructor method for InputErrorException.
	 * @param errMsg Error message passed to constructor.
	 */
	public InputErrorException (String errMsg) {
		super(errMsg);
	}
	
}
