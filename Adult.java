import java.util.ArrayList;

public class Adult extends Person {
	
	private Person partner;                                 // A persons partner
	private ArrayList<Person> children = new ArrayList<>(); // ArrayList holding all of the persons children
	
	/**
	 * This method is the class constructor inherited from the Person superclass.
	 */
	public Adult(String userID, String fullName, int age, String gender, String photo, String status) {
		super(userID, fullName, age, gender, photo, status);
	}
	
	/**
	 * This method returns the callers partner.
	 * @return The persons partner.
	 */
	public Person getPartner() {
		return partner;
	}
	
	/**
	 * The method sets the callers partner.
	 * @param partner The callers partner.
	 */
	public void setPartner(Person partner) {
		this.partner = partner;
	}
	
	 /**
	  * This method returns a copy of the callers children ArrayList.
	  * @return ArrayList<Person> Returns the callers children ArrayList.
	  */
	public ArrayList<Person> getChildren() {
		return children;
	}
	
	/**
	 * This method determines (true or false) whether an Adult has any children.
	 * @return boolean Value depends on whether the Adult has any children.
	 */
	public boolean hasChildren() {
		boolean hasChildren = false;
		if (children.size() > 0) {
			hasChildren = true;
		}
		return hasChildren;
	}
	
	/**
	 * This method returns the number of children an adult has.
	 * @return int How many children the call has.
	 */
	public int howManyChildren() {
		int number = 0;
		
		if (children.size() > 0) {
			number = children.size();
		}
		return number;
	}
	
	/**
	 * This method adds a child / baby to the callers children ArrayList.
	 * @param person The person being added to the callers children ArrayList.
	 */
	public void addChild(Person person) {
		children.add(person);
	}
	
	/**
	 * This method prints out the full name of all of the callers children only if they
	 * have children. If the caller does not have any children, nothing is printed.
	 * The if-statement is necessary to avoid null pointer exceptions.
	 */
	public void printChildren() {
		if (children.size() > 0) {
			System.out.println();
			System.out.println("Children");
			for (int i = 0; i < children.size(); i++) {
				System.out.println(children.get(i).getFullName());
			}			
		}
	}
	
	/**
	 * This method prints out the full name of the callers partner only if they have one.
	 * If the caller does not have a partner, nothing is printed.
	 * The if-statement is necessary to avoid null pointer exceptions.
	 */
	public void printPartner() {
		if (partner != null) {
			System.out.println();
			System.out.println("Partner");
			System.out.println(partner.getFullName());			
		}
	}
	
	/**
	 * This method removes the i-th child in the callers children ArrayList. 
	 * @param i Integer index of the child.
	 */
	public void removeChild(int i) {
		children.remove(i);
	}
				
}
