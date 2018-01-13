import java.util.Scanner;

public class Meeting extends Event {
      private String location = new String();
      
      public Meeting() {
      }
      public Meeting  (OurDate date, OurTime time, String description, String location){
		super (date, time, description);
		this.location = new String (location);
	}
	public Meeting (int day, int month, int year, int hour, int minute, String description){
		super (day, month, year, hour, minute, description);
		this.location = new String (location);
	}
	
	
	//accessors and mutators
	public String toString() {
		return super.toString() + " at " + location;
	}
	public boolean inputEvent(Scanner in, String prompt) {
		if (!super.inputEvent(in, prompt))
				return false;
		if (prompt.charAt(0) == 'y')
			System.out.print ("Enter location :");
		location = in.next();
		return true;
	}
      

}
