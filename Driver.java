import java.util.*;

public class Driver {
	
	private ArrayList<Person> members = new ArrayList<>();	// ArrayList holding all members of MiniNet
	private int choiceMain;									// User input in the mainMenu() method
	private int updateMenu;									// User input in selectPerson() method
	
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
		 * Add connections between initial members of MiniNet.
		 */
		for (int i = 0; i <= 7; i++) {
			members.get(i).addFriend(members.get(i+1));
			members.get(i+1).addFriend(members.get(i));
		}
		for (int i = 0; i <= 6; i++) {
			members.get(i).addFriend(members.get(i+2));
			members.get(i+2).addFriend(members.get(i));
		}
		/*
		 * Add partner connections.
		 */
		((Adult) members.get(0)).setPartner(members.get(1));
		((Adult) members.get(1)).setPartner(members.get(0));
		/*
		 * Add parent and dependent connections.
		 */
		((Adult) members.get(0)).addChild(members.get(10));
		((Adult) members.get(1)).addChild(members.get(10));
		((Child) members.get(10)).setParents(members.get(0), members.get(1));
		((Adult) members.get(0)).addChild(members.get(11));
		((Adult) members.get(1)).addChild(members.get(11));
		((Baby) members.get(11)).setParents(members.get(0), members.get(1));
		/*
		 * Note that one member [userID = THESIMONA] has been left isolated with
		 * no connections in the initial populating of MiniNet.
		 */
	}
	
	/**
	 * This method presents the user with the MiniNet menu and prompts
	 * the user for their selection. The menu and prompt is in a try
	 * block and a catch block is used to ensure a valid input is provided
	 * by the user. If invalid input is entered the user is advised, the
	 * menu is re-displayed and the user is again prompted for their
	 * selection.
	 */
	private void mainMenu() {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		String string1;
		
		do
		{
			try
			{
				System.out.println("============= MiniNet Menu =============");
				System.out.println("1. List the names of all members");
				System.out.println("2. Update a members information");
				System.out.println("3. Display a members profile");
				System.out.println("4. Add a member");
				System.out.println("5. Remove a member");
				System.out.println("6. Connect two members as friends");
				System.out.println("7. Remove friend");
				System.out.println("8. Find out if two members are friends");
				System.out.println("9. Find the names of a members parents");
				System.out.println("10. Find the names of a members children");
				System.out.println("11. Exit");
				System.out.print("Enter your selection: ");
				
				string1 = input.nextLine();
				choiceMain = Integer.parseInt(string1);
				
				if (choiceMain < 1 || choiceMain > 11)
				{
					throw new Exception();
				}
				validInput = true;	
			}
			catch (NumberFormatException nfe)
			{
				System.out.println();
				System.out.println("Please enter a valid option.");
				System.out.println();
			}
			catch (Exception e)
			{
				System.out.println();
				System.out.println("Please enter a valid option.");
				System.out.println();
			}
		}
		while (!validInput);
	}
	
	/**
	 * This method allows the user the update a members personal information (userID,
	 * full name, age, gender, photo or status). If the userID provided by the user is
	 * not for a current member of MiniNet, the user is notified and returned to the main
	 * menu.
	 */
	private void updateMember() {
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		boolean userIDMember;
		int index = 0;
		String userID;
		String string1;
		
		System.out.print("Enter the userID for the person whose information you wish to update: ");
		userID = input.nextLine().toUpperCase().trim();
		
		userIDMember = isMember(userID);
		index = memberIndex(userID);
		
		if (userIDMember == true) {
			do
			{
				try
				{
					System.out.println("1. Update userID?");
					System.out.println("2. Update full name?");
					System.out.println("3. Update age?");
					System.out.println("4. Change gender?");
					System.out.println("5. Update photo?");
					System.out.println("6. Update status?");
					System.out.println("7. Exit");
					System.out.print("Enter your selection: ");
					
					string1 = input.nextLine().trim();
					updateMenu = Integer.parseInt(string1);
					
					if (updateMenu < 1 || updateMenu > 8)
					{
						throw new Exception();
					}
					validInput = true;
					
					switch (updateMenu) {
						/*
						 * Update user's userID.
						 */
						case 1:	System.out.print("Enter your updated userID: ");
								String newUserID = input.nextLine().toUpperCase().trim();
								if (newUserID.isEmpty()) {
									System.out.println("A userID can not be an empty string.");
									System.out.println("You are now being returned to the main menu.");
								}
								else if (isMember(newUserID) == false) {
									members.get(index).setUserID(newUserID);
									System.out.println("Congratualutions, userID of " + userID + " has been changed to " + newUserID);
								}
								else {
									System.out.println("Sorry, " + newUserID + " is already taken.");
									System.out.println("You are now being returned to the main menu.");
								}
								break;
						/*
						 * Update user's full name.
						 */
						case 2:	System.out.print("Enter your updated name: ");
								String newFullName = input.nextLine().trim();
								if (newFullName.isEmpty()) {
									System.out.println("Full name can not be an empty string.");
									System.out.println("You are now being returned to the main menu.");
								}
								else {
									members.get(index).setFullName(newFullName);									
								}
								break;
						/*
						 * Update user's age. The user is returned to main menu if invalid input is entered
						 * by the user.
						 */
						case 3:	try {
									System.out.print("Enter your updated age: ");
									String newAgeString = input.nextLine();
									int newAge = Integer.parseInt(newAgeString);
									int age = members.get(index).getAge();
									/*
									 * This if statement throws an exception if the user enters
									 * a negative number for the members up-dated age.
									 */
									if (newAge < 0) {
										throw new Exception();
									}
									/*
									 * We now use an if-else statement to ensure the change in age does not
									 * change the type of member (Adult, Child or Baby). Allowing an adults
									 * age to change from 33 to 1 here would result in ClassCastExceptions being
									 * thrown elsewhere in the application.
									 */
									if (age >= 16 && newAge < 16) {
										System.out.println("This change can not be made.");
										System.out.println("A member can not go from an adult to child / baby.");
										System.out.println("You are now being returned to the main menu.");
									}
									else if (age < 16 && age > 2 && newAge >= 16) {
										System.out.println("This change can not be made.");
										System.out.println("A member can not go from a child to an adult.");
										System.out.println("You are now being returned to the main menu.");
									}
									else if (age < 16 && age > 2 && newAge <= 2) {
										System.out.println("This change can not be made.");
										System.out.println("A member can not go from a child to a baby.");
										System.out.println("You are now being returned to the main menu.");
									}
									else if (age <= 2 && newAge > 2) {
										System.out.println("This change can not be made.");
										System.out.println("A member can not go from a baby to a child / adult.");
										System.out.println("You are now being returned to the main menu.");								
									}
									else {
										members.get(index).setAge(newAge);	
									}
								}
								catch (NumberFormatException nfe)
								{
									System.out.println("Age must be a positive integer.");
									System.out.println("You are now being returned to the main menu.");
								}
								catch (Exception e)
								{
									System.out.println("Age must be a positive integer.");
									System.out.println("You are now being returned to the main menu.");
								}
								break;	
						/*
						 * Change user's gender without obtaining any input. If this option is selected, the
						 * user's gender is automatically changed from "M" to "F" or vice versa.
						 */
						case 4:	if (members.get(index).getGender().equals("M")) {
									members.get(index).setGender("F");
									System.out.println(userID + "'s gender has been changed to F (female).");
								}
								else {
									members.get(index).setGender("M");
									System.out.println(userID + "'s gender has been changes to M (male).");
								}
								break;
						/*
						 * Update user's photo.
						 */
						case 5: System.out.print("Enter updated photo file: ");
								String newPhoto = input.nextLine().trim();
								members.get(index).setPhoto(newPhoto);
								break;
						/*
						 * Update user's status.
						 */
						case 6: System.out.print("Enter update status: ");
								String newStatus = input.nextLine().trim();
								members.get(index).setStatus(newStatus);
								break;
						/*
						 * Exit updateMenu.
						 */
						case 7:	return;
					}
				}
				catch (NumberFormatException nfe)
				{
					System.out.println();
					System.out.println("Please enter a valid option.");
				}
				catch (Exception e)
				{
					System.out.println();
					System.out.println("Please enter a valid option.");
				}
			}
			while (!validInput);
		}
		else {
			System.out.println(userID + " is not a member of MiniNet.");
			System.out.println("You are now being returned to the main menu.");
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
	 * This method displays to the console the userID and fullName of every member
	 * of MiniNet. Each member is displayed on a separate line.
	 */
	private void showAll() {
		for(int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).getUserID() + "\t\t\t" + members.get(i).getFullName());
		}
	}
	
	/**
	 * This method removes a member from the social network. It prompts the user to enter
	 * the userID of the member they wish to remove. It uses the isMember() method to
	 * make sure the provided userID is for a member of MiniNet. If it is, the member is
	 * removed from the members ArrayList and any friends and/or children ArrayLists in which
	 * they appear. If not, the user is notified their request failed because the provided
	 * userID is not associated with a member of MiniNet.
	 */
	private void remove() {
		Scanner input = new Scanner(System.in);
		String toRemove;
		int k;
		ArrayList<Person> tempChildren = new ArrayList<>();
		
		System.out.print("Enter the userID of the member you wish to delete: ");
		toRemove = input.nextLine().toUpperCase().trim();
		
		if (isMember(toRemove) == true) {
			int toRemoveIndex = memberIndex(toRemove);
			if (members.get(toRemoveIndex) instanceof Adult && ((Adult) members.get(toRemoveIndex)).howManyChildren() > 0) {
				System.out.println(toRemove + " has chldren on MiniNet.");
				System.out.println("Due to MiniNet rules, " + toRemove + " cannot be removed.");
				System.out.println("You are now being returned to the main menu.");
			}
			else {
				/*
				 * This first for loop removes toRemove from the members ArrayList.
				 */
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getUserID().equals(toRemove)) {
						members.remove(i);
					}
				}
				/*
				 * This second for loop remove toRemove from all friends ArrayLists in which they appear.
				 */
				for (int j = 0; j < members.size(); j++) {
					for (k = 0; k < members.get(j).friends.size(); k++) {
						if (members.get(j).friends.get(k).getPerson().getUserID().equals(toRemove)) {
							members.get(j).friends.remove(k);
						}
					}
				}
				/*
				 * This third for loop removes toRemove from all children ArrayLists in which they appear.
				 */
				for (int x = 0; x < members.size(); x++) {
					if (members.get(x) instanceof Adult && ((Adult) members.get(x)).howManyChildren() > 0) {
						tempChildren = ((Adult) members.get(x)).getChildren();
						for (int y = 0; y < tempChildren.size(); y++) {
							if (tempChildren.get(y).getUserID().equals(toRemove)) {
								((Adult) members.get(x)).removeChild(y);
							}
						}
					}
				}
			}
		}
		else {
			System.out.println("Sorry, " + toRemove + " could not be removed as they are not a member of MiniNet");
		}				
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
		int newAge = addAge();
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
	 * This method determines whether or not two people are friends on MiniNet.
	 * @return boolean Value depends on whether the two people are friends on MiniNet.
	 */
	private boolean areFriends() {
		Scanner input = new Scanner(System.in);
		boolean areFriends = false;
		
		System.out.print("Enter the userID of the first person: ");
		String userID1 = input.nextLine().toUpperCase().trim();
		
		System.out.print("Enter the userID of the second person: ");
		String userID2 = input.nextLine().toUpperCase().trim();
		
		int index1 = memberIndex(userID1);
		int index2 = memberIndex(userID2);
		
		if (index1 < 0 || index2 < 0) {
			System.out.println("Sorry, either one of both of " + userID1 + " & " + userID2 + " are not members of MiniNet.");
		}
		else if (index1 == index2) {
			System.out.println("You have entered the same userID [" + userID1 +"] twice.");
		}
		else if (members.get(index1).isFriend(userID2) == true && members.get(index2).isFriend(userID1) == true) {
			System.out.println("Yes, " + userID1 + " & " + userID2 + " are friends on MiniNet.");
			areFriends = true;
		}
		else {
			System.out.println("No, " + userID1 + " & " + userID2 + " are not friends on MiniNet.");
		}
		return areFriends;
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
			System.out.println("UserID: \t\t" + members.get(index).getUserID());
			System.out.println();
			System.out.println("Name: \t\t" + members.get(index).getFullName());
			System.out.println("Age: \t\t" + members.get(index).getAge());
			System.out.println("Gender: \t\t" + members.get(index).getGender());
			System.out.println("Status: \t\t" + members.get(index).getStatus());
			System.out.println("Photo: \t\t" + members.get(index).getPhoto());
			if (members.get(index).getAge() >= 16) {
				members.get(index).displayFriends();
				((Adult) members.get(index)).printChildren();
				((Adult) members.get(index)).printPartner();
			}
			else if (members.get(index).getAge() < 16 && members.get(index).getAge() > 2) {
				members.get(index).displayFriends();
				((Child) members.get(index)).printParents();
			}
			else {
				((Baby) members.get(index)).printParents();
			}
		}
		else {
			System.out.println("Sorry, " + userID + " is not a member of MiniNet.");
			System.out.println("You will now be returned to the main menu.");
		}
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
	 * This method obtains and returns the age of a new member.
	 * @return int The age of the new member.
	 */
	private int addAge() {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		int newAge = 0;
		
		do {
			try {
				System.out.print("Enter your age: ");
				String newAgeString = input.nextLine();
				newAge = Integer.parseInt(newAgeString);
				
				if (newAge <= 0) {
					throw new Exception();
				}
				valid = true;
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("Age must be a positive integer.");
			}
			catch (Exception e)
			{
				System.out.println("Age must be a positive integer.");
			}
		}
		while (!valid);
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
	
	/**
	 * This method connects two members of MiniNet as friends provided the connection
	 * request complies with MiniNet rules.
	 */
	private void addFriend() {
		Scanner input = new Scanner(System.in);
		boolean isMember1;
		boolean isMember2;
		boolean sameString;
		String stringFriend1;
		String stringFriend2;
		
		do {
			System.out.print("Enter userID of first person: ");
			stringFriend1 = input.nextLine().toUpperCase().trim();
			System.out.print("Enter userID of second person: ");
			stringFriend2 = input.nextLine().toUpperCase().trim();
			
			sameString = stringFriend1.equals(stringFriend2);
			isMember1 = isMember(stringFriend1); // determine if first parent is member of MiniNet
			isMember2 = isMember(stringFriend2); // determine if second parent is member of MiniNet
			
			/*
			 * Advise user if one or both of the userID's are not for a member of MiniNet
			 */
			if (!(isMember1 && isMember2) || stringFriend1.equals(stringFriend2)) {
				System.out.println("The userID's entered are invalid.");
				System.out.println("Please re-enter the userID's.");
				System.out.println();
			}
		} while((!(isMember1 && isMember2)) || sameString);
		
		int index1 = memberIndex(stringFriend1);
		int index2 = memberIndex(stringFriend2);
		
		Person friend1 = members.get(index1);
		Person friend2 = members.get(index2);
		
		int ageGap = Math.abs(friend1.getAge() - friend2.getAge()); // age difference between the two members asking to be friends
		
		boolean alreadyFriends = false;
		for (int i = 0; i < friend1.friends.size(); i++) {
			if (friend2.getUserID().equals(friend1.friends.get(i).getPerson().getUserID())) {
				alreadyFriends = true;
			}
		}
		
		if (alreadyFriends == true) {
			System.out.println("The two people entered are already friends on MiniNet");
			System.out.println("You are now being returned to the main menu.");
		}
		else if (friend1 instanceof Adult && friend2 instanceof Adult) {
			friend1.addFriend(friend2);
			friend2.addFriend(friend1);
			System.out.println(friend1.getUserID() + " & " + friend2.getUserID() + " are now friends on MiniNet.");
		}
		else if (friend1 instanceof Child && friend2 instanceof Child && ageGap <= 3) {
			friend1.addFriend(friend2);
			friend2.addFriend(friend1);
			System.out.println(friend1.getUserID() + " & " + friend2.getUserID() + " are now friends on MiniNet.");
		}
		else {
			System.out.println("The people entered can not be friends on MiniNet");
			System.out.println("You are now being returned to the main menu.");
		}
		
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
					((Adult) parent1).setPartner(parent2);
					((Adult) parent2).setPartner(parent1);
					((Adult) parent1).addChild(newMember);;
					((Adult) parent2).addChild(newMember);
					((Child) newMember).setParents(parent1, parent2);
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
		boolean noPartner = false;
		
		/*
		 * This if-statement makes sure both proposed parents are adults.
		 */
		if (person1 instanceof Adult && person2 instanceof Adult) {
			bothAdults = true;
		}
		/*
		 * This if-statement makes sure both proposed parents are each others partner and switches
		 * samePartner to true is this condition is met. We need to ensure this as all couples / parents
		 * in MiniNet are mutually exclusive. We note that if both person1 and person2 have null partners,
		 * they are valid parents and the else-if statement will switch noPartner to true. samePartner and
		 * noPartner will remain false only if one or both of the proposed parents have a different partner.
		 */
		if ((((Adult) person1).getPartner() == person2) && (((Adult) person2).getPartner() == person1)) {
			samePartner = true;
		}
		else if (((Adult) person1).getPartner() == ((Adult) person2).getPartner()) {
			noPartner = true;
		}
		/*
		 * This if-statement checks the results of bothAdults, samePartner and noPartner and switches
		 * valid to true if the two people form a valid parent combination. 
		 */
		if (bothAdults && samePartner) {
			valid = true;
		}
		else if (bothAdults && noPartner) {
			valid = true;
		}
		return valid;
	}
	
	/**
	 * This method prints to the console the number of children has person has, and,
	 * if this number is greater than zero, prints out the children's names as well.
	 */
	private void showChildren() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the members userID: ");
		String userID = input.nextLine().toUpperCase().trim();
		int userIDIndex = 0;
		
		boolean userIDMember = isMember(userID);
		
		if (userIDMember == true) {
			userIDIndex = memberIndex(userID);
			if (members.get(userIDIndex) instanceof Adult) {
				if (((Adult) members.get(userIDIndex)).hasChildren() == true) {
					System.out.println(userID + " has " + ((Adult) members.get(userIDIndex)).howManyChildren() + " children.");
					((Adult) members.get(userIDIndex)).printChildren();
				}
				else {
					System.out.println(userID + " does not have any children.");
				}
			}
			else {
				System.out.println(userID + " does not have any children.");
			}
		}
		else {
			System.out.println(userID + " is not a member of MiniNet.");
		}
	}
	
	/**
	 * This method prints to the console the parents of a child or baby that is a member
	 * of MiniNet. If an adults userID is entered, a message is written to the screen advising
	 * the user that the parents of an adult are not recorded in MiniNet.
	 */
	private void showParents() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the members userID: ");
		String userID = input.nextLine().toUpperCase().trim();
		int userIDIndex = 0;
		
		boolean userIDMember = isMember(userID);
		
		if (userIDMember == true) {
			userIDIndex = memberIndex(userID);
			if (members.get(userIDIndex) instanceof Child) {
				System.out.println("The parents of " + userID + " are:");
				((Child) members.get(userIDIndex)).printParents();
			}
			else if (members.get(userIDIndex) instanceof Baby) {
				System.out.println("The parents of " + userID + " are:");
				((Baby) members.get(userIDIndex)).printParents();
			}
			else {
				System.out.println(userID + " is an adult and their parents are not recorded in MiniNet.");
			}
		}
		else {
			System.out.println(userID + " is not a member of MiniNet.");
		}
	}
	
	private void removeFriend() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the userID of the member wanting to remove a friend: ");
		String userID1 = input.nextLine().toUpperCase().trim();
		boolean userID1Member = isMember(userID1);
		String userID2;
		boolean userID2Member = false;
		boolean areFriends = false;
		int index1;
		int index2;
		ArrayList<Connection> tempFriends1 = new ArrayList<>();
		ArrayList<Connection> tempFriends2 = new ArrayList<>();
		
		if (userID1Member == true) {
			index1 = memberIndex(userID1);
			tempFriends1 = members.get(index1).getFriends();
			System.out.print("Which of " + userID1 + "'s friends do you wish to remove? ");
			userID2 = input.nextLine().toUpperCase().trim();
			userID2Member = isMember(userID2);
			if (userID2Member == true) {
				index2 = memberIndex(userID2);
				tempFriends2 = members.get(index2).getFriends();
				for (int i = 0; i < members.get(index1).numberOfFriends(); i++) {
					if (tempFriends1.get(i).getPerson().getUserID().equals(userID2)) {
						members.get(index1).removeFriend(i);
						areFriends = true;
					}
				}
				for (int j = 0; j < members.get(index2).numberOfFriends(); j++) {
					if (tempFriends2.get(j).getPerson().getUserID().equals(userID1)) {
						members.get(index2).removeFriend(j);
					}
				}
				if (areFriends == false) {
					System.out.println(userID1 + " & " + userID2 + " are not friends on MiniNet.");					
				}
				else {
					System.out.println(userID1 + " & " + userID2 + " are no longer friends on MiniNet.");
				}
			}
			else {
				System.out.println(userID2 + " is not a member of MiniNet.");
				System.out.println("You are now being returned to the main menu.");				
			}
		}
		else {
			System.out.println(userID1 + " is not a member of MiniNet.");
			System.out.println("You are now being returned to the main menu.");
		}
	}
	
	/**
	 * This method is responsible for running the application and will be called by the
	 * main() method in MiniNet.java.
	 */
	public void run() {
		
		System.out.println("Welcome To MiniNet!");
		
		System.out.println();
		
		populate(); // tested; none of the main menu options throw an exception if the members ArrayList is empty
		
		mainMenu();
		
		do {
			switch (choiceMain) {
				case 1:		showAll();
							break;
				case 2:		updateMember();
							break;
				case 3:		displayProfile();
							break;
				case 4:		addMember();
							break;
				case 5:		remove();
							break;
				case 6:		addFriend();
							break;
				case 7:		removeFriend();
							break;
				case 8:		areFriends();
							break;
				case 9:		showParents();
							break;
				case 10:		showChildren();
							break;
				case 11:		return;
			}
			System.out.println();
			mainMenu();
		} while (choiceMain > 0 && choiceMain < 12);
	}
	
}
