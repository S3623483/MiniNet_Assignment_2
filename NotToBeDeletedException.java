
/**
 * This Exception is thrown when the user tries to delete any member
 * that is involved in a Parent connection. This means that once a
 * person is included in a Parent connection, they can never be deleted
 * from MiniNet.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-19
 */
public class NotToBeDeletedException extends Exception {
	
	/**
	 * Constructor method for NotToBeDeletedException.
	 * @param errMsg Error message passed to the constructor
	 */
	public NotToBeDeletedException(String errMsg) {
		super(errMsg);
	}
	
}
