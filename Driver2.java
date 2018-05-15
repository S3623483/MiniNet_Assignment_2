import java.util.*;

public class Driver2 {
	
	private ArrayList<Person> members = new ArrayList<>();			// ArrayList holding all members of MiniNet
	private ArrayList<Connection> connections = new ArrayList<>();		// ArrayList holding all connections of MiniNet
	private int choiceMain;							// User input in the mainMenu() method
	private int updateMenu;							// User input in selectPerson() method
	
	/**
	 * This method populates MiniNet with members and establishes
	 * connections between some of the members.
	 */
	private void populate() {
		/*
		 * Add initial members of MiniNet.
		 */
		members.add(new Adult("BEN1984", "Benjamin Donnelly", 33, "M", "bend.photo", "I'm programming"));
		members.add(new Adult("BELINDA1985", "Belinda Donnelly", 32, "F", "belinda.photo", "I'm teaching"));
		members.add(new Adult("KENTUCKYKAT", "Karl Anthony-Towns", 22, "M", "KAT.photo", "No Status"));
		members.add(new Adult("THEPROCESS", "Joel Embiid", 24, "M", "joel.photo", "No Status"));
		members.add(new Adult("THEBROW", "Anthony Davis", 25, "M", "ad23.photo", "No Status"));
		members.add(new Adult("GREEKFREAK", "Giannis Antetokounmpo", 23, "M", "bucks.photo", "No Status"));
		members.add(new Adult("BECMARIE", "Rebecca Donnelly", 30, "F", "bec.photo", "No Status"));
		members.add(new Adult("KLSAMUELSON", "Katie Lou Samuelson", 20, "F", "kls.photo", "I'm playing in the NCAA Tournament"));
		members.add(new Adult("KATEBOSWORTH", "Kate Bosworth", 35, "F", "katebos.photo", "I'm on set at the moment"));
		members.add(new Adult("THESIMONA", "Simona Halep", 26, "F", "WTASimona.photo", "No Status"));
		members.add(new Child("LDONNELLY", "Louis Donnelly", 10, "M", "louis.photo", "No Status"));
		members.add(new Baby("LITTLEONE", "Lucy Donnelly", 1, "F", "No Photo", "No Status"));
		
		/*
		 * Add initial connections between members of MiniNet
		 */
		connections.add(new Connection(members.get(0), members.get(1), "Friend"));
		connections.add(new Connection(members.get(1), members.get(2), "Friend"));
		connections.add(new Connection(members.get(2), members.get(3), "Friend"));
		connections.add(new Connection(members.get(3), members.get(4), "Friend"));
		connections.add(new Connection(members.get(4), members.get(5), "Friend"));
		connections.add(new Connection(members.get(5), members.get(6), "Friend"));
		connections.add(new Connection(members.get(6), members.get(7), "Friend"));
		connections.add(new Connection(members.get(7), members.get(8), "Friend"));
		connections.add(new Connection(members.get(8), members.get(0), "Friend"));
		connections.add(new Connection(members.get(1), members.get(6), "Friend"));
		connections.add(new Connection(members.get(2), members.get(7), "Friend"));
		connections.add(new Connection(members.get(0), members.get(4), "Friend"));
		connections.add(new Connection(members.get(0), members.get(1), "Partner"));		
		/*
		 * Add parent / child connections for the Child & Baby members of MiniNet
		 */
		connections.add(new Connection(members.get(0), members.get(10), "Parent"));
		connections.add(new Connection(members.get(0), members.get(11), "Parent"));
		connections.add(new Connection(members.get(1), members.get(10), "Parent"));
		connections.add(new Connection(members.get(1), members.get(11), "Parent"));
		connections.add(new Connection(members.get(10), members.get(0), "Child"));
		connections.add(new Connection(members.get(10), members.get(1), "Child"));
		connections.add(new Connection(members.get(11), members.get(0), "Child"));
		connections.add(new Connection(members.get(11), members.get(1), "Child"));
	}
	
	/**
	 * This method displays to the console the userID and fullName of every member
	 * of MiniNet. Each member is displayed on a separate line.
	 */
	private void showAllMembers() {
		for(int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).getUserID() + "\t\t\t" + members.get(i).getFullName());
		}
	}
	
	/**
	 * This method displays to the console the details of each connection in
	 * MiniNet. The fullName of both members in the connection and the type of connection
	 * are printed on a separate for each connection and are separated three tabs ("\t").
	 */
	private void showAllConnections() {
		for(int i = 0; i < connections.size(); i++) {
			System.out.println(connections.get(i).getPerson1().getFullName() + "\t\t\t" + connections.get(i).getPerson2().getFullName() + "\t\t\t" + connections.get(i).getType());
		}
	}
	
	/**
	 * This method prints to the console the fullName and type of connections for
	 * the Person listed as the methods argument.
	 * @param person The Person whose connections we wish to view.
	 */
	private void showMemberConnections(Person person) {
		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getPerson1().equals(person)) {
				System.out.println(connections.get(i).getPerson2().getFullName() + "\t\t\t" + connections.get(i).getType());
			}
			
			if (connections.get(i).getPerson2().equals(person)) {
				System.out.println(connections.get(i).getPerson1().getFullName() + "\t\t\t" + connections.get(i).getType());
			}
		}
	}
	
	/**
	 * This method determines whether or not someone is a member of
	 * MiniNet based on userID.
	 * @param testUserID to determine if member of MiniNet.
	 * @return boolean true if userID is member of MiniNet and false otherwise.
	 */
	private boolean isMember(String testUserID) {
		boolean found = false;
		
		for(int i = 0; i < members.size(); i++) {
			if(testUserID.toUpperCase().equals(members.get(i).getUserID())) {
				found = true;
			}
		}		
		return found;	
	}
	
	/**
	 * This method determines and returns the index position of the
	 * member with a userID equal to testUserID.
	 * @param testUserID userID of member whose index position we wish to find.
	 * @return int Index position of testUserID.
	 */
	private int memberIndex(String testUserID) {
		int index = 0;
		
		if (isMember(testUserID) == false) {
			index = -1;
		}
		else {
			for (int i = 0; i < members.size(); i++) {
				if (testUserID.toUpperCase().equals(members.get(i).getUserID())) {
					index = i;
				}
			}			
		}
		return index;
	}
	
	/**
	 * This method adds a member to MiniNet. This method factors is whether the new member
	 * is an Adult, Child or Baby and requires the declaration of parents if the new
	 * member is either a Child or Baby.
	 */
	private void addMember() {
		Scanner input = new Scanner(System.in);
		
		String newUserID = addUserID();
		String newFullName = addName();
		
		boolean validAge = false;
		int newAge = 0;
		do {
			try {
				newAge = addAge();
				validAge = true;
			}
			catch (NoSuchAgeException nsae) {
				System.out.println();
			}
			catch (NumberFormatException nfe) {
				System.out.println("Age must be an integer between 0 and 150 (inclusive)");
				System.out.println();
			}
		} while (!validAge);
		
		String newGender = addGender();
		String newStatus = addStatus();
		String newPhoto = addPhoto();
		
		if (newAge >= 16) {
			members.add(new Adult(newUserID, newFullName, newAge, newGender, newStatus, newPhoto));			
		}
		else if (newAge < 16 && newAge > 2) {
			members.add(new Child(newUserID, newFullName, newAge, newGender, newStatus, newPhoto));
			addParents(newUserID);
		}
		else {
			members.add(new Baby(newUserID, newFullName, newAge, newGender, newStatus, newPhoto));
			addParents(newUserID);
		}
	}
	
	/**
	 * This method prompts the user for the userID of the member whose
	 * profile they wish to view. If the userID is for a current member,
	 * the profile will be displayed. If not, the user is advised and
	 * returned to the main menu
	 */
	private void displayProfile() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the userID of the member whose profile you wish to view: ");
		String userID = input.nextLine().toUpperCase().trim();
		
		if (isMember(userID) == true) {
			int index = memberIndex(userID);
			Person personProfile = members.get(index);
			System.out.println("UserID: \t\t" + members.get(index).getUserID());
			System.out.println();
			System.out.println("Name: \t\t" + members.get(index).getFullName());
			System.out.println("Age: \t\t" + members.get(index).getAge());
			System.out.println("Gender: \t\t" + members.get(index).getGender());
			System.out.println("Status: \t\t" + members.get(index).getStatus());
			System.out.println("Photo: \t\t" + members.get(index).getPhoto());
			System.out.println();
			System.out.println("Connections:");
			showMemberConnections(personProfile);
		}	
	}
	
	/**
	 * This method determines whether or not two people are friends on MiniNet.
	 * @return boolean Value depends on whether the two people are friends on MiniNet.
	 */
	private boolean areFriends() {
		Scanner input = new Scanner(System.in);
		boolean areFriends = false;
		boolean correctUserIDs = true;
		
		System.out.print("Enter the userID of the first person: ");
		String userID1 = input.nextLine().toUpperCase().trim();
		
		System.out.print("Enter the userID of the second person: ");
		String userID2 = input.nextLine().toUpperCase().trim();
		
		int index1 = memberIndex(userID1);
		int index2 = memberIndex(userID2);
		
		/*
		 * First we make the userID's inputted by the user represent members of MiniNet.
		 * Also, we confirm that user has provided two different userID's.
		 * We see correctUserIDs to false if userID's provided by the user fail either
		 * of these tests.
		 */
		if (index1 < 0 || index2 < 0) {
			System.out.println("Sorry, either one or both of " + userID1 + " & " + userID2 + " are not members of MiniNet.");
			correctUserIDs = false;
		}
		else if (index1 == index2) {
			System.out.println("You have entered the same userID [" + userID1 +"] twice.");
			correctUserIDs = false;
		}
		
		if (correctUserIDs == true) {
			Person person1 = members.get(index1);
			Person person2 = members.get(index2);
			
			for (int i = 0; i < connections.size(); i++) {
				if (connections.get(i).getPerson1().equals(person1) && connections.get(i).getPerson2().equals(person2)) {
					System.out.println("Yes, " + userID1 + " & " + userID2 + " are connected on MiniNet.");
					areFriends = true;
				}
				else if (connections.get(i).getPerson2().equals(person1) && connections.get(i).getPerson1().equals(person2)) {
					System.out.println("Yes, " + userID1 + " & " + userID2 + " are connected on MiniNet.");
					areFriends = true;
				}
			}
			
			if (areFriends == false) {
				System.out.println("No, " + userID1 + " & " + userID2 + " are not friends on MiniNet.");
			}
		}
		return areFriends;
	}
	
	/**
	 * This method adds the necessary connections between a Child or Baby with their
	 * parents. This method calls the validParents() method to ensure the proposed
	 * parents comply with the MiniNet rules.
	 * @param userID String userID of the Child or Baby whose parents are being disclosed.
	 */
	private void addParents(String userID) {
		Scanner input = new Scanner(System.in);
		boolean validParents = false;
		boolean sameString = false;
		boolean isMember1 = false;
		boolean isMember2 = false;
		int index1;
		int index2;
		int newMemberIndex = memberIndex(userID);
		String stringParent1;
		String stringParent2;
		Person newMember = members.get(newMemberIndex);
		Person parent1;
		Person parent2;
		
		do {
			try {
				System.out.print("Enter userID of first parent: ");
				stringParent1 = input.nextLine().toUpperCase().trim();
				System.out.print("Enter userID of second parent: ");
				stringParent2 = input.nextLine().toUpperCase().trim();
				
				sameString = stringParent1.equals(stringParent2);
				isMember1 = isMember(stringParent1); // determine if first parent is member of MiniNet
				isMember2 = isMember(stringParent2); // determine if second parent is member of MiniNet
				
				index1 = memberIndex(stringParent1); // get index of first parent
				index2 = memberIndex(stringParent2); // get index of second parent
				
				parent1 = members.get(index1); // get object reference for first parent
				parent2 = members.get(index2); // get object reference for second parent
				
				validParents = validParents(parent1, parent2);
				/*
				 * Advise user if one or both of the userID's are not for a member of MiniNet.
				 * The user can not exit this process without entering a compliant parent
				 * combination.
				 */
				if (!(isMember1 && isMember2) || stringParent1.equals(stringParent2) || !(validParents)) {
					System.out.println("The userID's entered are invalid.");
					System.out.println("Please re-enter parent userID's.");
					System.out.println();
				}
				else {
					connections.add(new Connection(parent1, newMember, "Parent"));	// note parent1 as parent of newMember
					connections.add(new Connection(parent2, newMember, "Parent"));	// note parent2 as parent of newMember
					connections.add(new Connection(newMember, parent1, "Parent"));	// note newMember as child of parent1
					connections.add(new Connection(newMember, parent2, "Parent"));	// note newMember as child of parent2
				}
			}
			/*
			 * This catches the exception thrown if the user enters a userID(s) that do
			 * not belong to any current members of the members ArrayList.
			 */
			catch (Exception e)
			{
				System.out.println("The userID's entered are invalid.");
				System.out.println("Please re-enter parent userID's.");
				System.out.println();
			}
		}
		while((!(isMember1 && isMember2)) || sameString || !(validParents));	
	}
	
	/**
	 * This method verifies that the two proposed parents comply with the MiniNet rules
	 * with respect to being a parent.
	 * @param person1 Person First proposed parent.
	 * @param person2 Person Second proposed parent.
	 * @return boolean Value depending on whether person1 and person2 are a valid parent combination.
	 */
	private boolean validParents(Person person1, Person person2) {
		boolean valid = false;
		boolean bothAdults = false;
		boolean samePartner = false;
		boolean noPartner1 = false;
		boolean noPartner2 = false;
		
		/*
		 * This if-statement makes sure both proposed parents are adults.
		 */
		if (person1 instanceof Adult && person2 instanceof Adult) {
			bothAdults = true;
		}
		/*
		 * These logic statements makes sure both proposed parents are each others partner and switches
		 * samePartner to true is this condition is met. We need to ensure this as all couples / parents
		 * in MiniNet are mutually exclusive. We note that if both person1 and person2 have null partners,
		 * they are valid parents and the else-if statement will switch noPartner to true. samePartner and
		 * noPartner will remain false only if one or both of the proposed parents have a different partner.
		 */
		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getPerson1() == person1 && connections.get(i).getPerson2() == person2 && connections.get(i).getType().equals("Partner")) {
				samePartner = true;
			}
			else if (connections.get(i).getPerson2() == person2 && connections.get(i).getPerson2() == person1 && connections.get(i).getType().equals("Partner")) {
				samePartner = true;
			}
		}
		/*
		 * These logic statements determine whether or not parent2 is in a connection with type partner.
		 * If no such connection is found for parent2, noPartner1
		 */
		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getPerson1() == person1 && connections.get(i).getType().equals("Partner")) {
				noPartner1 = false;
			}
			else if (connections.get(i).getPerson2() == person1 && connections.get(i).getType().equals("Partner")) {
				noPartner1 = false;
			}
		}
		/*
		 * These logic statements determine whether or not parent2 is in a connection with type partner.
		 * If no such connection is found for parent2, noPartner1
		 */
		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getPerson1() == person2 && connections.get(i).getType().equals("Partner")) {
				noPartner2 = false;
			}
			else if (connections.get(i).getPerson2() == person2 && connections.get(i).getType().equals("Partner")) {
				noPartner2 = false;
			}
		}
		/*
		 * This if-statement checks the results of bothAdults, samePartner and noPartner and switches
		 * valid to true if the two people form a valid parent combination. 
		 */
		if (bothAdults && samePartner) {
			valid = true;
		}
		else if (bothAdults && noPartner1 && noPartner2) {
			valid = true;
		}
		return valid;
	}
	
	/**
	 * This method obtains and returns the userID for a new member.
	 * @return String The userID for a new member.
	 */
	private String addUserID() {
		Scanner input = new Scanner(System.in);
		boolean validUserID = false;
		String newUserID;
		
		do {
			System.out.print("Enter your unique userID: ");
			newUserID = input.nextLine().toUpperCase().trim();
			if (newUserID.isEmpty()) {
				System.out.println("UserID cannot be an empty string. Try again.");
			}
			else if (isMember(newUserID) == false) {
				System.out.println("Congratulations! " + newUserID + " is available!");
				validUserID = true;
			}
			else {
				System.out.println("Sorry, " + newUserID + " is already taken! Try again!");
			}
		}
		while(!validUserID);	
		return newUserID;
	}
	
	/**
	 * This method obtains and returns the full name for a new member.
	 * @return String The full name of a new member.
	 */
	private String addName() {
		Scanner input = new Scanner(System.in);
		boolean validName = false;
		String newName;
		
		do {
			System.out.print("Enter your full name: ");
			newName = input.nextLine().trim();
			if (newName.isEmpty()) {
				System.out.println("Name cannot be an empty string.");
				System.out.println("Please try again.");
			}
			else {
				validName = true;
			}
		} while (!validName);		
		return newName;
	}
	
	/**
	 * This method obtains and returns the age of a new member. As per the requirements
	 * of the assignment, this method throws two Exceptions (NoSuchAgeException &
	 * NumberFormatException). NoSuchAgeException ensures the age inputted by the user
	 * is between 0 and 150 (inclusive).
	 * @return int The age of the new member.
	 */
	private int addAge() throws NoSuchAgeException, NumberFormatException {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		
		System.out.print("Enter your age: ");
		String newAgeString = input.nextLine();
		int newAge = Integer.parseInt(newAgeString);
				
		if (newAge < 0 || newAge > 150) {
			throw new NoSuchAgeException("Invalid age has been entered", newAge);
		}
		return newAge;
	}
	
	/**
	 * This method obtains and returns the gender of a new member.
	 * @return String The gender of the new member.
	 */
	private String addGender() {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		String response;
		String gender = "";
		
		do {
			System.out.print("Enter your gender: ");
			response = input.nextLine().toUpperCase().trim();
			if (response.equals("M")) {
				gender = "M";
				valid = true;
			}
			else if (response.equals("F")) {
				gender = "F";
				valid = true;
			}
			else {
				System.out.println("Please enter either \"M\" or \"F\".");
			}
		} while(!valid);
		return gender;
	}
	
	/**
	 * This method obtains and returns the status for a new member.
	 * @return String The new members status.
	 */
	private String addStatus() {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		String response;
		String newStatus = "";
		
		do {
			System.out.print("Do you want to include a status? (Y / N): ");
			response = input.nextLine().toUpperCase().trim();
			if (response.equals("Y")) {
				System.out.print("Please enter your status: ");
				newStatus = input.nextLine().trim();
				if (newStatus.isEmpty()) {
					newStatus = "No Status";
					valid = true;
				}
				else {
					valid = true;
				}
			}
			else if (response.equals("N")) {
				newStatus = "No Status";
				valid = true;
			}
			else {
				System.out.println("Please enter either \"Y\" or \"N\".");
			}
		} while(!valid);
		return newStatus;
	}
	
	/**
	 * This method obtains and returns the photo file for a new member.
	 * @return String The new members photo file.
	 */
	private String addPhoto() {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		String response;
		String newPhoto = "";
		
		do {
			System.out.print("Do you want to include a photo? (Y / N): ");
			response = input.nextLine().toUpperCase().trim();
			if (response.equals("Y")) {
				System.out.print("Please enter file name: ");
				newPhoto = input.nextLine().trim();
				if (newPhoto.isEmpty()) {
					newPhoto = "No Photo";
					valid = true;
				}
				else {
					valid = true;					
				}
			}
			else if (response.equals("N")) {
				newPhoto = "No Photo";
				valid = true;
			}
			else {
				System.out.println("Please enter either \"Y\" or \"N\".");
			}
		} while(!valid);
		return newPhoto;
	}
	
	public void run() {
		
		System.out.println("Welcome to MiniNet!");
		
		populate();
		
		// showAllMembers();
		
		System.out.println();
		
		// showAllConnections();
		
		// Person tester = members.get(1);
		
		System.out.println();
		
		// showMemberConnections(tester);
				
		addMember();
		
	}	
	
}
