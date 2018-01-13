import java.util.Scanner;
/**   This class models a work event - it's superclass is Event.
 *	  Author:  Hasan Skaiky
 *	  Data fields:   shiftLength:int - length of work shift
 */
public class Work extends Event {
      private int shiftLength;
      
      public Work() {
      }
      public Work  (OurDate date, OurTime time, String description, int shiftLength){
		super (date, time, description);
		this.shiftLength = shiftLength;
	}
	public Work (int day, int month, int year, int hour, int minute, String description, int shiftLength){
		super (day, month, year, hour, minute, description);
		this.shiftLength = shiftLength;
	}
	
	
	//accessors and mutators
	public String toString() {
		return super.toString() + " for " + shiftLength;
	}
	public boolean inputEvent(Scanner in, String prompt) {
		if (!super.inputEvent(in, prompt))
			return false;
		
		do {
			if (prompt.charAt(0) == 'y')
				System.out.print ("Enter shiftLength - greater than 0 :");
			if (in.hasNextInt())
				shiftLength = in.nextInt();
			else {
				System.out.println ("Invalid value for shift length");
				in.next();
				if (prompt.charAt(0) != 'y')
					return false;
			}
		}while (shiftLength <=0);
		
		return true;
	}
      

}
