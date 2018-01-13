import java.io.File;
import java.io.IOException;
import java.util.*;
/**   This class models a main .
 *	  Author:  Linda Crane
 *    Revisded by: Hasan Skaiky
 *    Assignment 3 update - added two extra options to add notes and delete notes
 *     
 *				
 *    Methods:  main
 *				openFile
 *                  
 */
public class Assign3 {
	public static void main(String[] args) {
		

		Scanner in = new Scanner (System.in);
		Scanner inFile = null;
		Planner planner = new Planner();
		OurDate displayDate = new OurDate();
		Event event = new Event();
		int menuChoice = 1;
		
		
		while (menuChoice !=0 ) {
			// loop to enter valid MenuChoice...
			do {

				System.out.print( "\nEnter 1 to add an event to planner from keyboard;  ");
				System.out.print( "\n2 to display events for a day;  ");
				System.out.print( "\n3 to display events for a week;  ");
				System.out.print("\n4 to delete an event; ");
				System.out.print( "\n5 to add events to planner from a file;  ");
				System.out.print("\n6 to add a note to an event");
				System.out.print("\n7 to to delete a note from an event");
				System.out.print( "\n0 to quit: ");
				if (in. hasNextInt())
					menuChoice = in.nextInt();
				else {
				    in.next();
					System.out.println("Invalid menu choice....reenter: ");
					menuChoice = -1;
				}
			} while (menuChoice < 0 || menuChoice > 7);
		

			if (menuChoice == 1) {
				planner.inputEvent(in, "yes");
				System.out.println (planner);
			} else if (menuChoice == 2) {
				System.out.println ("Enter a date to display: ");
				if (displayDate.inputDate(in, "yes")) 
					planner.displayOneDay(displayDate);
			} else if (menuChoice == 3) {
				System.out.println ("Enter a date to display: ");
				if (displayDate.inputDate(in, "yes"))
					planner.displaySevenDays(displayDate);
			} else if (menuChoice == 4) {
				planner.deleteEvent(in, "yes");
			} else if (menuChoice == 5) {
				inFile = openFile(in);
			}else if (menuChoice ==6){
				planner.addNote(in, "yes");
		
			}else if (menuChoice == 7){
				System.out.println ("Enter to delete a note from an event");
				planner.deleteNoteForEvent(in, "yes");
			} 
				if (inFile != null) {
					while (inFile.hasNext())
						planner.inputEvent(inFile, "no");
					System.out.println (planner);
				}
			}

		

	}
	
	//********************openFile*********************************
		public static Scanner openFile(Scanner in) {
			String fileName = new String();
			Scanner inFile = null;

			System.out.print("\n\nEnter name of file to process: ");
			fileName = in.next();

			File file = new File(fileName);
			try {
				if (file.exists()) {
					inFile = new Scanner(file);
				}
				else System.out.println ("File does not exist.....");
				return inFile;
			} catch (IOException e) {
				System.out.println("Could not open file...." + fileName + "exiting");
				return null;
			}
		}// end openFile method

}
