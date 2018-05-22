import java.util.*;
import java.io.*;

/**
 * 
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.1
 * @since 2018-03-18
 */
public class Driver2 {
	
	private ArrayList<Person> members = new ArrayList<>();			// ArrayList holding all members of MiniNet
	private ArrayList<Connection> connections = new ArrayList<>();	// ArrayList holding all connections of MiniNet
	
	/**
	 * This method populates MiniNet with members and establishes connections between some of the members.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InvalidParentException
	 */
	public void populate() throws FileNotFoundException, IOException, InvalidParentException {
		String membersFile = "people.txt";
		String relationsFile = "relations.txt";
		String line1;
		/*
		 * Add members from people.txt.
		 */
        File membersFileReader = new File("people.txt");
        BufferedReader membersFileBufferedReader = new BufferedReader(new FileReader(membersFileReader));
        
        while((line1 = membersFileBufferedReader.readLine()) != null) {
        		String[] parts = line1.split("\\s*,\\s*");
        		int age = Integer.parseInt(parts[2]);
        		/*
        		 * Add members of different type (Adult, Child, Baby) based on their age.
        		 */
        		if (age >= 16) {
        			members.add(new Adult(parts[0].toUpperCase(), parts[1], age, parts[3], parts[4], parts[5]));
        		}
        		else if (age < 16 && age > 2) {
        			members.add(new Child(parts[0].toUpperCase(), parts[1], age, parts[3], parts[4], parts[5]));
        		}
        		else {
        			members.add(new Baby(parts[0].toUpperCase(), parts[1], age, parts[3], parts[4], parts[5]));
        		}
        }
        membersFileBufferedReader.close();
        /*
         * Add connections from relations.txt.
         */
        File connectionsFileReader = new File("relations.txt");
        BufferedReader connectionsFileBufferedReader = new BufferedReader(new FileReader(connectionsFileReader));
        String line2;
        while((line2 = connectionsFileBufferedReader.readLine()) != null) {
    		String[] parts = line2.split(", ");
    		/*
    		 * Add connections
    		 */
    		connections.add(new Connection(getPerson(parts[0]), getPerson(parts[1]), parts[2]));
        }
        connectionsFileBufferedReader.close();
	}
	
	/**
	 * This method is called if the populate() method throws an exception and is unable to provide an initial population to
	 * MiniNet. This method will populate MiniNet with hard-coded members and connections.
	 */
	public void populate2() {
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
		members.add(new Child("NDONNELLY", "Nate Donnelly", 5, "M", "louis.photo", "No Status"));
		members.add(new Baby("LITTLEONE", "Lucy Donnelly", 1, "F", "No Photo", "No Status"));
		/*
		 * Add initial connections between members of MiniNet.
		 */
		connections.add(new Connection(members.get(0), members.get(1), "Friend"));
		connections.add(new Connection(members.get(1), members.get(2), "Friend"));
		connections.add(new Connection(members.get(2), members.get(4), "Friend"));
		connections.add(new Connection(members.get(3), members.get(4), "Friend"));
		connections.add(new Connection(members.get(4), members.get(5), "Friend"));
		connections.add(new Connection(members.get(5), members.get(6), "Friend"));
		connections.add(new Connection(members.get(6), members.get(7), "Friend"));
		connections.add(new Connection(members.get(7), members.get(8), "Friend"));
		connections.add(new Connection(members.get(8), members.get(0), "Friend"));
		connections.add(new Connection(members.get(1), members.get(6), "Friend"));
		connections.add(new Connection(members.get(2), members.get(7), "Classmate"));
		connections.add(new Connection(members.get(0), members.get(4), "Colleague"));
		connections.add(new Connection(members.get(0), members.get(1), "Couple"));		
		connections.add(new Connection(members.get(0), members.get(10), "Parent"));
		connections.add(new Connection(members.get(0), members.get(11), "Parent"));
		connections.add(new Connection(members.get(0), members.get(12), "Parent"));
		connections.add(new Connection(members.get(1), members.get(10), "Parent"));
		connections.add(new Connection(members.get(1), members.get(11), "Parent"));
		connections.add(new Connection(members.get(1), members.get(12), "Parent"));
	}
	
	/**
	 * This method checks the connections of an ArrayList<Connection> to make sure there are
	 * exactly two "Parent" connections. As per the code, this check is carried out for Child
	 * and Baby members only.
	 * @param connections An ArrayList<Connection> of connections.
	 * @return An ArrayList<Person> containing all members that violate MiniNet's parent requirements.
	 */
	private ArrayList<Person> checkConnections(ArrayList<Connection> connections) {
		ArrayList<Person> invalidMembers = new ArrayList<>();
		int noOfParents = 0;
		
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i) instanceof Child || members.get(i) instanceof Baby) {
				for (int j = 0; j < connections.size(); j++) {
					if ((connections.get(j).getPerson1() == members.get(i) && connections.get(j).getType().equals("Parent")) || (connections.get(j).getPerson2() == members.get(i) && connections.get(j).getType().equals("Parent"))) {
						noOfParents += 1;
					}
				}
				if (noOfParents != 2) {
					invalidMembers.add(members.get(i));
					System.out.println(members.get(i).getFullName() + " does not have both parents listed.");
					System.out.println("This violates MiniNet rules.");
					System.out.println("As such, " + members.get(i).getFullName() + " has been removed from MiniNet.");
					noOfParents = 0; // reset noOfParent for the next iteration.
				}
				else {
					noOfParents = 0; // reset noOfParent for the next iteration.
				}				
			}
		}
		return invalidMembers;
	}
	
	/**
	 * This method gets the userID for all existing members of MiniNet and returns this in an ArrayList<String>.
	 * @return An ArrayList<String> holding the userID's for all current members of MiniNet.
	 */
	public ArrayList<String> getUserIDs() {
		ArrayList<String> userIDs = new ArrayList<>();
		
		for (int i = 0; i < members.size(); i++) {
			userIDs.add(members.get(i).getUserID());
		}
		return userIDs;
	}
	
	/**
	 * This method returns the members ArrayList<Person> instance variable.
	 * @return An ArrayList<Person> holding the Person objects for all current members of MiniNet.
	 */
	public ArrayList<Person> getMembers() {
		return members;
	}
	
	/**
	 * This method gets and returns an ArrayList<Connection> holding all of the current connections in
	 * MiniNet.
	 * @return An ArrayList<Connection> holding the Connection objects for all current connection in MiniNet.
	 */
	public ArrayList<Connection> getConnections() {
		ArrayList<Connection> allConnections = new ArrayList<>();
		for(int i = 0; i < connections.size(); i++) {
			allConnections.add(connections.get(i));
		}
		return allConnections;
	}
	
	/**
	 * This method returns an ArrayList<Connection> which contains all connections involving the person
	 * inputted as the method argument. 
	 * @param person The person whose connection listing we wish to examine.
	 * @return An ArrayList<Connection> containing all connections involving person.
	 */
	public ArrayList<Connection> showMemberConnections(Person person) {
		ArrayList<Connection> memberConnections = new ArrayList<>();
		
		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getPerson1().equals(person)) {
				memberConnections.add(connections.get(i));
				//System.out.println(connections.get(i).getPerson2().getFullName() + "\t\t\t" + connections.get(i).getType());
			}
			
			if (connections.get(i).getPerson2().equals(person)) {
				memberConnections.add(connections.get(i));
				//System.out.println(connections.get(i).getPerson1().getFullName() + "\t\t\t" + connections.get(i).getType());
			}
		}
		return memberConnections;
	}
	
	/**
	 * This method returns an ArrayList<String> containing the userID's of the connections associated
	 * with the unique identifier passed as the methods argument.
	 * @param userID The unique identifier of the member whose connection userID's we wish to collect.
	 * @return An ArrayList<String> containing the userID's of a selected members connections.
	 */
	private ArrayList<String> getConnectionUserIDs(String userID) {
		ArrayList<String> connectionUserIDs = new ArrayList<>();
		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getPerson1().getUserID().equals(userID)) {
				connectionUserIDs.add(connections.get(i).getPerson2().getUserID());
			}
			else if (connections.get(i).getPerson2().getUserID().equals(userID)) {
				connectionUserIDs.add(connections.get(i).getPerson1().getUserID());
			}
		}
		return connectionUserIDs;
	}
	
	/**
	 * This method removes the person associated with the userID inputted as the method argument from MiniNet.
	 * @param userID The unique identifier of the members we wish to remove from MiniNet.
	 * @throws NotToBeDeletedException If the person object associated with userID is part of a connection of type "Parent".
	 */
	public void remove(String userID) throws NotToBeDeletedException {
		int removeIndex = memberIndex(userID);
		Person removePerson = members.get(removeIndex);
		
		System.out.println(removePerson.getFullName());
		
		for (int i = 0; i < connections.size(); i++) {
			if ((connections.get(i).getPerson1() == removePerson && connections.get(i).getType().equals("Parent")) || (connections.get(i).getPerson2() == removePerson && connections.get(i).getType().equals("Parent"))) {
				throw new NotToBeDeletedException(userID + " can not be deleted as they are a parent on MiniNet.");
			}
		}
		
		for (int i = 0; i < connections.size(); i++) {
			if ((connections.get(i).getPerson1() == removePerson) || (connections.get(i).getPerson2() == removePerson)) {
				connections.remove(i);
			}
		}
		
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i) == removePerson) {
				members.remove(i);
			}
		}
	}
	
	/**
	 * This method removes the connection at the given index from the connections ArrayList.
	 * @param i Index of the connection we wish to remove from the connections ArrayList.
	 */
	public void removeConnection(int i) {
		connections.remove(i);
	}
	
	/**
	 * This method determines whether there is an existing connection based on the arguments passed to the method.
	 * @param userID1 The unique identifier associated with the first person.
	 * @param userID2 The unique identifier associated with the second person.
	 * @param type The type of connection.
	 * @return boolean true if the arguments passed represent an existing connection and false otherwise.
	 */
	public boolean validConnection(String userID1, String userID2, String type) {
		Person person1 = getPerson(userID1);
		Person person2 = getPerson(userID2);
		boolean validConnection = false;
		
		for (int i = 0; i < connections.size(); i++) {
			if ((connections.get(i).getPerson1() == person1 && connections.get(i).getPerson2() == person2 && connections.get(i).getType().equals(type)) || (connections.get(i).getPerson1() == person2 && connections.get(i).getPerson2() == person1 && connections.get(i).getType().equals(type))) {
				validConnection = true;
			}
		}
		return validConnection;
	}
	
	/**
	 * This method adds a connection in MiniNet between the members associated userID1 and userID2.
	 * The connection is added only when valid arguments are passed to the method.
	 * If the user attempts to create an invalid connection, an exception is thrown and the user is notified.
	 * @param userID1 The unique identifier of the first person in the proposed new connection.
	 * @param userID2 The unique identifier of the second person in the proposed new connection.
	 * @param type The type of connection.
	 * @throws NotToBeFriendsException If userID1 and/or userID2 are already in a "Couple" conection.
	 * @throws SamePersonException If the user tries to connect the same person in some way (userID1 = userID2).
	 * @throws AlreadyConnectedException If the proposed new connections already exists.
	 * @throws NotToBeClassmatesException If userID1 and/or userID2 is for a Baby member. 
	 * @throws NoAvailableException If person1 and/or person2 are already in a "Couple" connection.
	 * @throws NotToBeCoupledException If userID1 and/or userID2 is for a Baby and/or Child member. Only adults can be in a "Couple" connection.
	 * @throws NotToBeColleaguesException If userID1 and/or userID2 is for a Baby member.
	 */
	public void addConnection(String userID1, String userID2, String type) throws NotToBeFriendsException, SamePersonException, AlreadyConnectedException, NotToBeClassmatesException, NoAvailableException, NotToBeCoupledException, NotToBeColleaguesException {
		int index1 = memberIndex(userID1);		// get index position for userID1
		int index2 = memberIndex(userID2);		// get index position for userID2
		Person person1 = members.get(index1);	// get Person reference for userID1
		Person person2 = members.get(index2);	// get Person reference for userID2
		boolean alreadyConnected = connectionExists(person1, person2, type);
		/*
		 * Make sure the user is not trying to connect the same person.
		 */
		if (index1 == index2) {
			throw new SamePersonException("You are trying to connect the same person.");
		}
		// types include friend, couple, classmate, colleague
		if (type.equals("Friend")) {
			if (alreadyConnected == true) {
				throw new AlreadyConnectedException("The two members are already friends.");
			}
			else {
				addFriend(person1, person2);
			}
		}
		else if (type.equals("Classmate")) {
			if (alreadyConnected == true) {
				throw new AlreadyConnectedException("The two members are already friends.");
			}
			else {
				addClassmate(person1, person2);
			}
		}
		else if (type.equals("Couple")) {
				addCouple(person1, person2);				
			}
		else if (type.equals("Colleague")) {
			if (alreadyConnected == true) {
				throw new AlreadyConnectedException("The two members are already friends.");
			}
			else {
				addColleague(person1, person2);				
			}
		}
	}
	
	/**
	 * This method adds a "Friend" connection in MiniNet between person1 and person2.
	 * The connection is added only when valid arguments are passed to the method.
	 * If the user attempts to create an invalid "Friend" connection, an exception is thrown and the user is notified.
	 * @param person1 The first person in the proposed new "Friend" connection.
	 * @param person2 The second person in the proposed new "Friend" connection.
	 * @throws NotToBeFriendsException If a "Friend" connection between person1 and person2 violates MiniNet rules.
	 */
	private void addFriend(Person person1, Person person2) throws NotToBeFriendsException {
		int person1Age = person1.getAge();
		int person2Age = person2.getAge();
		int ageGap = Math.abs(person1Age - person2Age);
				
		if (person1 instanceof Adult && person2 instanceof Adult) {
			connections.add(new Connection(person1, person2, "Friend"));
		}
		else if (person1 instanceof Baby || person2 instanceof Baby) {
			throw new NotToBeFriendsException("A baby can not have any friends connections.");
		}
		else if ((person1 instanceof Adult && person2 instanceof Child) || (person1 instanceof Child && person2 instanceof Adult)) {
			throw new NotToBeFriendsException("An adult and a child can not have a friendship connection.");
		}
		else if (person1 instanceof Child && person2 instanceof Child && ageGap > 3) {
			throw new NotToBeFriendsException("Two children with an age gap greater than 3 can not have a friendship connection.");
		}
		else if (person1 instanceof Child && person2 instanceof Child && ageGap <= 3) {
			connections.add(new Connection(person1, person2, "Friend"));
		}
	}
	
	/**
	 * This method adds a "Classmate" connection in MiniNet between person1 and person2.
	 * The connection is added only when valid arguments are passed to the method.
	 * If the user attempts to create an invalid "Classmate" connection, an exception is thrown and the user is notified.
	 * @param person1 The first person in the proposed new "Classmate" connection.
	 * @param person2 The second person in the proposed new "Classmate" connection.
	 * @throws NotToBeClassmatesException If person1 and/or person2 is a Baby member.
	 */
	private void addClassmate(Person person1, Person person2) throws NotToBeClassmatesException {
		if (person1 instanceof Baby || person2 instanceof Baby) {
			throw new NotToBeClassmatesException("A baby can not have any classmate connections.");
		}
		else {
			connections.add(new Connection(person1, person2, "Classmate"));
		}
	}
	
	/**
	 * This method adds a "Couple" connection in MiniNet between person1 and person2.
	 * The connection is added only when valid arguments are passed to the method.
	 * If the user attempts to create an invalid "Couple" connection, an exception is thrown and the user is notified.
	 * @param person1 The second person in the proposed new "Couple" connection.
	 * @param person2 The second person in the proposed new "Couple" connection.
	 * @throws NoAvailableException If person1 and/or person2 are already in a "Couple" connection.
	 * @throws NotToBeCoupledException If person1 and/or person2 is a Baby and/or Child member. Only adults can be in a "Couple" connection.
	 */
	private void addCouple(Person person1, Person person2) throws NoAvailableException, NotToBeCoupledException {
		boolean alreadyCoupled = alreadyCoupled(person1, person2);
		
		if (alreadyCoupled == true) {
			throw new NoAvailableException("Already Coupled.");
		}
		else if (person1 instanceof Baby || person2 instanceof Baby) {
			throw new NotToBeCoupledException("A baby can not be part of a couple.");
		}
		else if (person1 instanceof Child || person2 instanceof Child) {
			throw new NotToBeCoupledException("A child can not be part of a couple.");
		}
		else {
			connections.add(new Connection(person1, person2, "Couple"));
		}
	}
	
	/**
	 * This method adds a "Colleague" connection in MiniNet between person1 and person2.
	 * The connection is added only when valid arguments are passed to the method.
	 * If the user attempts to create an invalid "Colleague" connection, an exception is thrown and the user is notified.
	 * @param person1 The first person in the proposed new "Colleague" connection.
	 * @param person2 The second person in the proposed new "Colleague" connection.
	 * @throws NotToBeColleaguesException If person1 and/or person2 is a Baby member.
	 */
	private void addColleague(Person person1, Person person2) throws NotToBeColleaguesException {
		if (person1 instanceof Baby || person2 instanceof Baby) {
			throw new NotToBeColleaguesException("A baby can not have any colleague connections.");
		}
		else {
			connections.add(new Connection(person1, person2, "Colleague"));
		}
	}
	
	
	/**
	 * This method determines whether there is an existing connection based on the arguments passed to the method.
	 * @param person1 The first person.
	 * @param person2 The second person.
	 * @param type The type of connection.
	 * @return boolean true if the arguments passed represent an existing connection and false otherwise.
	 */
	private boolean connectionExists(Person person1, Person person2, String type) {
		boolean connectionExists = false;
		
		for (int i = 0; i < connections.size(); i++) {
			if ((connections.get(i).getPerson1() == person1 && connections.get(i).getPerson2() == person2 && connections.get(i).getType().equals(type)) || (connections.get(i).getPerson1() == person2 && connections.get(i).getPerson2() == person1 && connections.get(i).getType().equals(type))) {
				connectionExists = true;
			}
		}
		return connectionExists;
	}
	
	/**
	 * This method determines whether one or both of the members passed are in a "Couple" connection.
	 * @param person1 The object for the first person.
	 * @param person2 The object for the second person.
	 * @return boolean true if peron1 and/or person2 are already in a "Couple" connection and false otherwise.
	 */
	private boolean alreadyCoupled(Person person1, Person person2) {
		boolean alreadyCoupled = false;
		
		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getPerson1() == person1 && connections.get(i).getPerson2() == person2 && connections.get(i).getType().equals("Couple")) {
				alreadyCoupled = true;
			}
			else if (connections.get(i).getPerson1() == person1 && connections.get(i).getPerson2() != person2 && connections.get(i).getType().equals("Couple")) {
				alreadyCoupled = true;
			}
			else if (connections.get(i).getPerson1() != person1 && connections.get(i).getPerson2() == person2 && connections.get(i).getType().equals("Couple")) {
				alreadyCoupled = true;
			}
			else if (connections.get(i).getPerson1() == person2 && connections.get(i).getPerson2() != person1 && connections.get(i).getType().equals("Couple")) {
				alreadyCoupled = true;
			}
			else if (connections.get(i).getPerson1() != person2 && connections.get(i).getPerson2() == person1 && connections.get(i).getType().equals("Couple")) {
				alreadyCoupled = true;
			}
		}
		return alreadyCoupled;
	}
	
	/**
	 * This method determines whether or not someone is a member of MiniNet based on userID.
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
	 * This method determines and returns the index position of the member with a userID equal to testUserID.
	 * @param testUserID userID of member whose index position we wish to find.
	 * @return int Index position of testUserID.
	 */
	public int memberIndex(String testUserID) {
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
	 * This method adds a member to MiniNet. The member is added only when valid arguments are passed to the method.
	 * If the user attempts to create an invalid member, an exception is thrown and the user is notified.
	 * @param userID The new members unique identifier (compulsory).
	 * @param fullName The new members full name (compulsory).
	 * @param age The new members age (compulsory).
	 * @param gender The new members gender (compulsory).
	 * @param photo The photo file (optional) for the new member.
	 * @param status The status (optional) for the new member.
	 * @param parent1 The unique identifier for the new members first listed parent.
	 * @param parent2 The unique identifier for the new members second listed parent.
	 * @throws InputErrorException If userID and/or fullName are empty Strings.
	 * @throws ParentsRequiredException If parent1 and/or parent2 are empty Strings and the age of the proposed new member is less than 16.
	 * @throws UserIDInUseException If userID is being used by an existing member of MiniNet.
	 * @throws InvalidParentException If parent1 and parent2 represent an invalid parent combination.
	 */
	public void addMember(String userID, String fullName, int age, String gender, String photo, String status, String parent1, String parent2) throws InputErrorException, ParentsRequiredException, UserIDInUseException, InvalidParentException {
		boolean validParents = false;
		/*
		 * Make sure that neither userID or fullName are empty Strings.
		 */
		if (userID.equals("") || fullName.equals("")) {
			throw new InputErrorException("userID can not be an empty String.");
		}
		/*
		 * Make sure the user enters non-empty Strings for parent1 & parent2 to when
		 * age is less than 16.
		 */
		if ((age < 16 && parent1.equals("")) || (age < 16 && parent2.equals(""))) {
			throw new ParentsRequiredException("Both parents must be entered when age is less than 16.");
		}
		/*
		 * Make sure the userID entered by the user is not already in use.
		 */
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getUserID().equals(userID)) {
				throw new UserIDInUseException("This userID is already in use.");
			}
		}
		/*
		 * Run the validParents method to ensure the parent combination entered by the user
		 * is valid. This will only run when age is less than 16.
		 */
		if (age < 16) {
			validParents = validParents(parent1, parent2);
		}
		
		if (age >= 16) {
			members.add(new Adult(userID, fullName, age, gender, photo, status));
		}
		else if (age < 16 && age > 2 && validParents == true) {
			members.add(new Child(userID, fullName, age, gender, photo, status));
			connections.add(new Connection(getPerson(userID), getPerson(parent1), "Parent"));
			connections.add(new Connection(getPerson(userID), getPerson(parent2), "Parent"));
			connections.add(new Connection(getPerson(parent1), getPerson(parent2), "Couple"));
		}
		else if (age <= 2 && validParents == true) {
			members.add(new Baby(userID, fullName, age, gender, photo, status));
			connections.add(new Connection(getPerson(userID), getPerson(parent1), "Parent"));
			connections.add(new Connection(getPerson(userID), getPerson(parent2), "Parent"));
			connections.add(new Connection(getPerson(parent1), getPerson(parent2), "Couple"));
		}
	}
	
	/**
	 * This determines whether or not two members of MiniNet represent a valid parent combination.
	 * @param parent1 The unique identifier for the first proposed parent.
	 * @param parent2 The unique identifier for the second proposed parent.
	 * @return boolean true if parent1 and parent2 represent a valid parent combination and false otherwise.
	 * @throws InvalidParentException If the combination of parent1 and parent2 represents an invalid parent combination as per MiniNet's rules.
	 */
	public boolean validParents(String parent1, String parent2) throws InvalidParentException {
		boolean parent1Member = isMember(parent1);
		boolean parent2Member = isMember(parent2);
		boolean validParents = false;
		
		if (parent1Member == false || parent2Member == false) {
			throw new InvalidParentException("One (or both) of the parent userID's are invalid");
		}
		
		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getPerson1().getUserID().equals(parent1) && !(connections.get(i).getPerson2().getUserID().equals(parent2)) && connections.get(i).getType().equals("Couple")) {
				throw new InvalidParentException("One (or both) of the parent userID's are in a relationship with someone else");
			}
			else if (connections.get(i).getPerson2().getUserID().equals(parent1) && !(connections.get(i).getPerson1().getUserID().equals(parent2)) && connections.get(i).getType().equals("Couple")) {
				throw new InvalidParentException("One (or both) of the parent userID's are in a relationship with someone else");
			}
			else if (connections.get(i).getPerson1().getUserID().equals(parent2) && !(connections.get(i).getPerson2().getUserID().equals(parent1)) && connections.get(i).getType().equals("Couple")) {
				throw new InvalidParentException("One (or both) of the parent userID's are in a relationship with someone else");
			}
			else if (connections.get(i).getPerson2().getUserID().equals(parent2) && !(connections.get(i).getPerson1().getUserID().equals(parent1)) && connections.get(i).getType().equals("Couple")) {
				throw new InvalidParentException("One (or both) of the parent userID's are in a relationship with someone else");
			}
		}
		validParents = true;
		return validParents;
	}
	
	/**
	 * This method return the Person object associated with the unique identifier passed to the method.
	 * @param userID The unique identifier of the member who Person object we wish to return.
	 * @return Person object associated with the userID.
	 */
	public Person getPerson(String userID) {
		int index = memberIndex(userID);
		return members.get(index);
	}
	
	/**
	 * This method determines whether or not the member associated with the unique identifier passed as the
	 * argument is in a "Parent" connection.
	 * @param userID The unique identifier of the member.
	 * @return boolean true is the member is in a "Parent" connection and false otherwise.
	 */
	public boolean isParent(String userID) {
		boolean isParent = false;
		Person person = getPerson(userID);
		
		for (int i = 0; i < connections.size(); i++) {
			if ((connections.get(i).getPerson1() == person && connections.get(i).getType().equals("Parent")) || (connections.get(i).getPerson2() == person && connections.get(i).getType().equals("Parent"))) {
				isParent = true;
			}
		}
		return isParent;
	}
	
}
