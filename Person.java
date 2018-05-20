
/**
 * Abstract class from which Adult, Child & Baby extend. This class provides methods that can be used by allof its subclasses.
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.1
 * @since 2018-03-18
 */
public abstract class Person {
	
	private String userID;		// Person's userID which is their unique identifier.
	private String fullName;	// Person's full name.
	private int age;		// Person's age.
	private String gender;		// Person's gender.
	private String photo;		// Person's photo. Optional field. Set to "No Photo" if the user decides not to include a photo.
	private String status;		// Person's status. Optional field. Set to "No Status if the user decides not to include a photo.
	
	/**
	 * This method is the class constructor. This constructor was not overloaded as the optional nature of
	 * the photo and status instance variables is factored in within the following methods:
	 * <ul>
	 * 	<li> <code>setPhoto()</code> Will set photo to "No Photo" if nothing is entered (empty string) by the user </li>
	 *  	<li> <code>setStatus()</code> Will set status to "No Status" if nothing is entered (empty string) by the user </li>
	 *  	<li><code>addPhoto()</code> Will set photo to "No Photo" if the user decides not to include a photo when adding a member</li>
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
	
}
