/**   This class models an event.
 *	  Author:  Hasan Skaiky
 *	  Data fields:   date:  OurDate - the day/month/year of the event
 *                   time: Time - the hour/minute that event starts at
 *					 description: String - a description of event                             
 */
import java.util.*;
public class Event {
	private OurDate date = new OurDate();
	private OurTime time = new OurTime();
	private String description = new String();

	public Event() {
	}
	public Event (OurDate date, OurTime time, String description){
		this.date = new OurDate(date);
		this.time = new OurTime (time);
		this.description = new String (description);
	}
	public Event (int day, int month, int year, int hour, int minute, String description){
		this.date = new OurDate (day, month, year);
		this.time = new OurTime (hour, minute);
		this.description = new String (description);
	}

	// get methods
	public OurDate getDate() { return date;}
	public OurTime getTime() { return time; }



	// accessor methods and mutators
	public String toString() {
		return new String("     " + date + " " + time + " " + description);
	}

	public boolean inputEvent(Scanner in, String prompt) {

		if (!date.inputDate(in, prompt)) {
			return false;
		}
		if (!time.inputTime(in,prompt)) {
			return false;
		}
		if (prompt.charAt(0) == 'y')
			System.out.print ("Enter event description: ");
		this.description = in.next();
		return true;
	}

	public boolean isEqual (Event rhs) {
		return (this.date.isEqual(rhs.date) && this.time.isEqual(rhs.time));
	}

	public boolean greaterEvents(Event e){
		if (this.date.isGreater(e.date)){
			return true;
		}else if (this.time.isGreater(e.time)){
			return true; 
		}
		return false;

	}

	public boolean lessEvents( Event e){

		if (this.date.isLess(e.date)){
			return true;
		} else  if (this.time.isLess(e.time)){
			return true;
		}
		return false;

	}



}
