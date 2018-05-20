
/**
 * This Exception is thrown when the user tries to duplicate a connection
 * in MiniNet. For example, this Exception will be thrown when the user tries
 * to connection two people as friends who are already friends on MiniNet.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.0
 * @since 2018-05-16
 */
public class AlreadyConnectedException extends Exception {
	
	/**
	 * Constructor method for AlreadyConnectedException.
	 * @param errMsg Error message passed to the constructor.
	 */
	public AlreadyConnectedException (String errMsg) {
		super(errMsg);
	}
	
}
