import java.util.ArrayList;

public class Baby extends Person {
	
	private ArrayList<Person> parents = new ArrayList<>(); // ArrayList holding baby's parents
	
	/**
	 * This method is the class constructor inherited from the Person superclass
	 */
	public Baby(String userID, String fullName, int age, String gender, String photo, String status) {
		super(userID, fullName, age, gender, photo, status);
	}
	
	/**
	 * This method adds the callers parents to the parents ArrayList
	 * @param person1 First parent
	 * @param person2 Second parent
	 */
	public void setParents(Person person1, Person person2) {
		parents.add(person1);
		parents.add(person2);
	}
	
	/**
	 * This method prints out the full names of the callers parents. As parents are
	 * added when the member is added, an if-statement is not necessary here as no child /
	 * baby will ever have any empty parents ArrayList.
	 */
	public void printParents() {
		System.out.println();
		System.out.println("Parents: ");
		for (int i = 0; i < parents.size(); i++) {
			System.out.println(parents.get(i).getFullName());
		}
	}
	
}
