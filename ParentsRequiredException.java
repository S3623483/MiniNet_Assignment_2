
/**
 * This Exception is thrown when the user tries to add a new Child
 * or Baby member but leaves parent1 and/or parent2 empty.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-19
 */
public class ParentsRequiredException extends Exception {
	
	/**
	 * Constructor method for ParentsRequiredException.
	 * @param errMsg Error message passed to the constructor.
	 */
	public ParentsRequiredException (String errMsg) {
		super(errMsg);
	}
	
}
