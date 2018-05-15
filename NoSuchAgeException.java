
public class NoSuchAgeException extends Exception {
	
	public NoSuchAgeException (String errMsg, int age) {
		super(errMsg);
		System.out.println("You have entered age as " + age);
		System.out.println("Age can not be negative or greater than 150");
	}
	
}
