import java.util.ArrayList;

public abstract class Person {
	
	private String userID;
	private String fullName;
	private int age;
	private String gender;
	private String photo;
	private String status;
	public ArrayList<Connection> friends = new ArrayList<>(); // ArrayList to store a persons friends
	
	/**
	 * This method is the class constructor. This constructor was not overloaded as the optional nature of
	 * the photo and status instance variables is factored in within the following methods:
	 * <ul>
	 * 	<li> <code>setPhoto()</code> Will set photo to "No Photo" if nothing is entered (empty string) by the user </li>
	 *  <li> <code>setStatus()</code> Will set status to "No Status" if nothing is entered (empty string) by the user </li>
	 *  <li><code>addPhoto()</code> Will set photo to "No Photo" if the user decides not to include a photo when adding a member</li>
	 *  	<li><code>addStatus()</code> Will set status to "No Status" if the user decides not to include a status when adding a member</li>
	 * </ul>
	 * @param userID Persons userID (must be unique).
	 * @param fullName Persons full name.
	 * @param age Persons age.
	 * @param gender Persons gender (M / F).
	 * @param photo Optional ("No Photo" appears on profile if nothing entered).
	 * @param status optional ("No Status" appears on profile if nothing entered).
	 */
	public Person(String userID, String fullName, int age, String gender, String photo, String status) {
		this.userID = userID;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.photo = photo;
		this.status = status;
	}
		
	/**
	 * This method returns a persons MiniNet userID.
	 * @return Persons userID.
	 */
	public String getUserID() {
		return userID;
	}	
	
	/**
	 * This method allows a person to update their userID on MiniNet.
	 * @param ID Persons userID.
	 */
	public void setUserID(String ID) {
		userID = ID;
	}
	
	/**
	 * This method returns a person full name as listed on MiniNet.
	 * @return Persons full name.
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * This method allows a person to update the name on MiniNet.
	 * @param fname Persons full name.
	 */
	public void setFullName(String fname) {
		fullName = fname;
	}
	
	/**
	 * This method returns a person age as listed on MiniNet.
	 * @return Persons age.
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * This method allows a person to update their age on MiniNet.
	 * @param age Persons age.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * This method returns a persons MiniNet gender.
	 * @return Persons gender.
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * This method allows a person to update their MiniNet gender.
	 * @param gender Person gender.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * This method returns a persons MiniNet photo.
	 * @return Persons current photo.
	 */
	public String getPhoto() {
		return photo;
	}
	
	/**
	 * This method allows a person to update their MiniNet photo. If the user enters
	 * an empty string then the photo is set to "No Photo".
	 * @param photo Persons new photo.
	 */
	public void setPhoto(String p) {
		if (p.isEmpty()) {
			photo = "No Photo";
		}
		else {
			photo = p;
		}
	}
	
	/**
	 * This method returns a persons MiniNet status.
	 * @return Persons current status.
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * This method allows a person to update their MiniNet status. If the user enters
	 * an empty string then the status is set to "No Status".
	 * @param status Persons new status.
	 */
	public void setStatus(String s) {
		if (s.isEmpty()) {
			status = "No Status";
		}
		else {
			status = s;
		}
	}
	
	/**
	 * This method adds someone to this persons friends ListArray.
	 * @param person Person being added to this persons the friends ListArray.
	 */
	public void addFriend(Person person) {
		friends.add(new Connection(person));
	}
	
	/**
	 * This method is declared as abstract as it will need to be implemented differently for
	 * each subclass of Person. For example, for Child references, there will be no need to
	 * print dependents because, for the purposes of this project, they can't have any dependents.
	 */
	public void displayFriends() {
		if (friends.size() > 0) {
			System.out.println();
			System.out.println("Friends: ");
			for (int i = 0; i < friends.size(); i++) {
				System.out.println(friends.get(i).getPerson().getFullName());
			}			
		}
	}
	
	/**
	 * @return The number of friends in a persons friends ListArray.
	 */
	public int numberOfFriends() {
		return friends.size();
	}
	
	/**
	 * This method determines whether one person if friends with another on MiniNet.
	 * @param userID The MiniNet ID of person who may be friends with this person.
	 * @return boolean Depending on whether userID is in persons friends ListArray.
	 */
	public boolean isFriend(String userID) {
		boolean isAFriend = false;
		
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getPerson().getUserID().equals(userID)) {
				isAFriend = true;
			}
		}
		return isAFriend;
	}
	
	 /**
	  * This method returns a copy of the callers friends ArrayList.
	  * @return ArrayList<Connection> Returns the callers friends ArrayList.
	  */
	public ArrayList<Connection> getFriends() {
		return friends;
	}
	
	/**
	 * This method removes the i-th person in the callers friends ArrayList. 
	 * @param i Integer index of the friend.
	 */
	public void removeFriend(int i) {
		friends.remove(i);
	}
	
}
