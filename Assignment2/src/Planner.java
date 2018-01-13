import java.util.ArrayList;
import java.util.Scanner;
/**   This class models an planner that will keep track of events in an ArrayList.
 *	  Author:  Hasan Skaiky 
 *	  Data fields:   events - ArrayList of Events
 *                   numEvents - int - how many events are stored in the activities array
 *    Methods:  default constructor
 *				inputEvent(Scanner, String)- addsk an Event to the activities array if there is room and if there is no other activity for that date and time
 *						String parameter indicates whether prompts will be displayed for input (string of "yes) or not (anthing else)      
 *				displayOneDay(Date) - looks through array and displays all events for the parameter date
 *				displaySevenDays (Date) - displays events for the seven days starting at parameter date
 *				deleteEvent (Date, Time) - looks through array for an event at parameter date and time, and deletes it (if found)
 */
public class Planner {

	final private int MAXEVENTS = 1000;
	final private int MEETING = 1;
	final private int SCHOOL = 2;
	final private int WORK = 3;
	final private int SOCIAL = 4;
	OurDate date = new OurDate();
	OurTime time = new OurTime();
	private ArrayList<Event> events = new ArrayList<Event>();
	private int numEvents = 0;
	Event event = new Event();
	public Planner () {
	}

	public boolean inputEvent(Scanner in, String prompt) {
		if (numEvents >= MAXEVENTS) {
			System.out.println ("Invalid...planner is full");
			return false;
		} else {

			int eventType = 0;

			while (eventType < MEETING || eventType > SOCIAL ) {
				if (prompt.charAt(0) == 'y') {
					System.out.print ("Enter the event type to add:  ");
					System.out.print ("\n 1 for a meeting event");
					System.out.print ("\n 2 for a school event");
					System.out.print ("\n 3 for a work event");
					System.out.println ("\n 4 for a social event");

				}
				if (in.hasNextInt())
					eventType = in.nextInt();
				else {
					System.out.println ("Invalid event type....reenter");
					in.next();
					if (prompt.charAt(0) != 'y') { // means we are reading from file...so we can't recover
						System.out.println ("Invalid type data...not entering event in array");
						return false;
					}
				}  
			}

			//allocate correct object type to next array entry
			switch (eventType) {
			case MEETING: event =  new Meeting() ; break;
			case SCHOOL: event =  new School() ; break;
			case WORK: event =  new Work() ;; break;
			case SOCIAL: event =  new Social() ;
			default: event = new Event() ;
			}
			// add data to the object
			if (!event.inputEvent(in,prompt)){
				return false;
			}
		}	//check if there is already an activity at that date and time


		if (binarySearch(event) == true) {
			System.out.println ("You already have an activity for that date and time...cannot be entered");
		}else  
		{

			events.add(0, event);
			insertionSort(events);
			numEvents++;  // move numEvents so that this element remains in array, otherwise next addition will add on top of this data
		}// end else
		return true;
	}



	public String toString() {
		String out = new String();
		for (int i=0; i < numEvents; i++) {
			out += events.get(i).toString() + "\n";
		}
		return out;
	}

	public void displayOneDay (OurDate displayDate) {
		System.out.println ("Your activities for " + displayDate + " are: ");
		for (int i = 0; i < numEvents; i++)
			if (events.get(i).getDate().isEqual(displayDate))
				System.out.println (events.get(i));
	}

	public void displaySevenDays(OurDate displayDate) {
		System.out.println ("Your activities for the week starting " + displayDate + " are: ");
		OurDate currentDate = displayDate;
		for (int j = 0; j < 7; j++) {
			displayOneDay (currentDate);
			currentDate.addOne();
			System.out.println();
		}
	}
	public boolean binarySearch(Event key) 
	{
		int first = 0;
		int last = numEvents - 1;

		while(last >= first) {
			int middle = (first + last) / 2;
			if((events.get(middle).isEqual(key))) {
				return true;
			}
			if(events.get(middle).lessEvents(key)) {
				first = middle + 1;
			}else if(events.get(middle).greaterEvents(key)) {
				last = middle - 1;
			}
		}
		return false;
	}
	public void insertionSort(ArrayList <Event> events){

		for(int i = 1 ; i < events.size(); i++){
			Event insert = events.get(i);
			int moveItem = i;
			while(moveItem > 0 && events.get(moveItem -1 ).lessEvents(insert)){
				events.set(moveItem, events.get(moveItem -1 ));
				moveItem--;
			}
			events.set(moveItem, insert);
		}

	}

	public void deleteEvent(Scanner in) {
		OurDate date = new OurDate();
		OurTime time = new OurTime();
		boolean isOk = false;

		// read in which date/time event to delete
		System.out.println ("Enter date and time of event to delete:");	
		do {
			isOk = date.inputDate(in, "yes");	
		} while (!isOk);
		isOk = false;
		do {
			isOk = time.inputTime(in, "yes");
		} while (!isOk);

		boolean found = false;
		int i = 1;

		for (i = 0; i < numEvents; i++) {
			if (events.get(i).getDate().isEqual(date) && events.get(i).getTime().isEqual(time)){
				found = true;
				break;
			}


		}

		if (found){
			events.set(i, events.get(numEvents-1));
			numEvents--;
			System.out.println ("Event deleted");
		}
		else System.out.println("There is no activity for that date and time...cannot be deleted");
	}


}
