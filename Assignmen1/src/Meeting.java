import java.util.Scanner;

public class Meeting extends Event {
	
	
	
	private String location;
	
	public Meeting(Scanner sc, String prompt) {
		super(sc, prompt);
	}
	
	public boolean inputEvent(Scanner scanner, String prompt) {
		
		if (prompt == "yes") {
			System.out.println("Enter event location: ");
			location = scanner.next();
		} else if (prompt == "no") {
			location = scanner.next();
		}
		return true;
	}
	
	public String toString() {
		return super.toString()+" "+location;
	}

}