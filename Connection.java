
public class Connection {
	
	private Person person1;
	private Person person2;
	private String type;
	
	/**
	 * This method is the class constructor.
	 * @param person The person being connected with.
	 */
	public Connection(Person person1, Person person2, String type) {
		this.person1 = person1;
		this.person2 = person2;
		this.type = type;
	}
	
	/**
	 * This method returns the person1 of the connection.
	 * @return Person The person involved with the connection.
	 */
	public Person getPerson1() {
		return person1;
	}
	
	/**
	 * This method returns the person2 of the connection.
	 * @return Person The person involved with the connection.
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
