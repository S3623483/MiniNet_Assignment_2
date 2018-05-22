
/**
 * Class that can instantiate an object of type Connection.
 * Also, provides all of the appropriate methods.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.1
 * @since 2018-03-18
 */
public class Connection {
	
	private Person person1;	// first person to be included in the connection.
	private Person person2;	// second person to be included in the connection.
	private String type;		// type of connection (Friend, Parent, Couple, Classmate, Colleague).
	
	/**
	 * This method is the class constructor.
	 * @param person1 First person to be included in the connection.
	 * @param person2 Second person to be included in the connection.
	 * @param type Type of connection.
	 */
	public Connection(Person person1, Person person2, String type) {
		this.person1 = person1;
		this.person2 = person2;
		this.type = type;
	}
	
	/**
	 * This method returns the person1 of the connection.
	 * @return Person The first person involved with the connection.
	 */
	public Person getPerson1() {
		return person1;
	}
	
	/**
	 * This method returns the person2 of the connection.
	 * @return Person The second person involved with the connection.
	 */
	public Person getPerson2() {
		return person2;
	}
	
	/**
	 * This method returns the type of the connection.
	 * @return String The type of connection.
	 */
	public String getType() {
		return type;
	}
	
}
