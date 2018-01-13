/**   This class models an event and notes .
 *	  Author:  Linda Crane
 *    Revisded by: Hasan Skaiky
 *    Assignment 3 update - added addNote,deleteNote,displayNote methods
 *    
 *	  Data fields:   list - linkedlist of notes 
 *                   date:  OurDate - the day/month/year of the event
 *                   time: Time - the hour/minute that event starts at
 *					 description: String - a description of event
 *                                
 *				
 *    Methods:  default constructor
 *				initial constructors
 *              getDate: OurDate - returns date of event
 *				getTime: Time - returns time of event
 *			
 *              toString: String - displays event to a String
 *              inputEvent (Scanner, String) - prompts (if String parameter starts with 'y') input 
 *                                             from Scanner parameter  for all data fields
 *              isEqual (Event): boolean - compares date and time in two objects and returns true/false if they are equal 
 *              isGreater (Event): boolean - compares date and time in two objects and returns true if object in class (this)
 *                                           is greater than parameter object; else returns false    
 *             **addNote : to add notes to existing events in Planner
 *             **deleteNotes: deletes notes from an existing events in Planner 
 *             **displayNotes : displays the notes that has been added to the event from keyboard to file .                          
 */
import java.util.*;
public class Event {
	private OurDate date = new OurDate();
	private OurTime time = new OurTime();
	private String description = new String();
	private LinkedList <String> list= new LinkedList<String>();


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

		String str=new String ();
		str="[ ";
		for ( int c = 0 ; c < list.size();c++){
			str += list.get(c);

			if(c != list.size()-1){
				str += ", ";
			}
		}
		str+=" ]";
		return new String("     " + date + " " + time + " " + description + "\n\t" + str );
	}

	public boolean inputEvent(Scanner in, String prompt) {

		if (!date.inputDate(in, prompt)) {
			return false;
		}
		if (!time.inputTime(in,prompt)) {
			return false;
		}
		if(prompt.charAt(0) == 'y'){
			System.out.print ("Enter event description: ");
		}
		this.description = in.next();

		if (prompt.charAt(0) == 'y'){

			System.out.print("Enter how many notes you would like to add:");
		}
		int numNotes = -1;

		do {if (in. hasNextInt())
			numNotes = in.nextInt();
		else {
			in.next();
			System.out.println("Invalid entry...Please enter an integer");
			numNotes = -1;
		}
		} while(numNotes == -1);

		if (numNotes > 0){
			for (int c = 0 ; c < numNotes; c++){
				if (prompt.charAt(0) == 'y'){
					System.out.println("Enter Note:");
				}
				String str=in.next();
				list.add(str);
			}
		}

		return true;
	}

	public boolean isEqual (Event rhs) {
		return (this.date.isEqual(rhs.date) && this.time.isEqual(rhs.time));
	}

	public boolean isGreater (Event rhs) {
		if (this.date.isGreater (rhs.date))
			return true;
		else if (this.date.isEqual(rhs.date) && this.time.isGreater (rhs.time))
			return true;
		return false;

	}
	public void addNote(String note){
		list.add(note);

	}

	public void deleteNote ( Scanner in){
		System.out.println("Current note for this event are: ");
		this.displayNotes();
		System.out.println("Enter note to delete ");

		int noteToDelete = -1;

		do {if (in. hasNextInt())
			noteToDelete = in.nextInt();
		else {
			in.next();
			System.out.println("Invalid entry...Please enter an integer");
			noteToDelete = -1;
		}
		} while(noteToDelete == -1);

		if ( noteToDelete > 0 || noteToDelete >= list.size()){
			System.out.println("Invalid");
		} else
			list.remove(noteToDelete);
	}
	public void  displayNotes(){

		for (int i = 0;  i < list.size(); i++){
			System.out.println(i +": " +list.get(i));
		}


	}
}
