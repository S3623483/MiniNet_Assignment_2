
public class Connection {
	
	private Person person;
	
	/**
	 * This method is the class constructor.
	 * @param person The person being connected with.
	 */
	public Connection(Person person) {
		this.person = person;
	}
	
	/**
	 * This method returns the person involved with a particular connection.
	 * @return Person The person involved with the connection.
	 */
	public Person getPerson() {
		return person;
	}
	
}
