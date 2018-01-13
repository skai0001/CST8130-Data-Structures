import java.io.File;

import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		

		Scanner in = new Scanner (System.in);
		Scanner inFile = null;
		Planner planner = new Planner();
		OurDate displayDate = new OurDate();
	
		int menuChoice = 1;
		
		
		while (menuChoice !=0 ) {
			// loop to enter valid MenuChoice...
			do {

				System.out.print( "\nEnter 1 to add an event to planner from keyboard;  ");
				System.out.print( "\n2 to display events for a day;  ");
				System.out.print( "\n3 to display events for a week;  ");
				System.out.print("\n4 to delete an event; ");
				System.out.print( "\n5 to add events to planner from a file;  ");
				System.out.print( "\n0 to quit: ");
				if (in. hasNextInt())
					menuChoice = in.nextInt();
		
				else {
				    in.next();
					System.out.println("Invalid menu choice....reenter: ");
					menuChoice = -1;
				}
			} while (menuChoice < 0 || menuChoice > 5);
		

			if (menuChoice == 1) {
				planner.inputEvent(in, "yes");
				//System.out.println (planner);  // used for debugging as I wrote the program
			} else if (menuChoice == 2) {
				System.out.println ("Enter a date to display: ");
				if (displayDate.inputDate(in, "yes")) 
					planner.displayOneDay(displayDate);
			} else if (menuChoice == 3) {
				System.out.println ("Enter a date to display: ");
				if (displayDate.inputDate(in, "yes"))
					planner.displaySevenDays(displayDate);
			} else if (menuChoice == 4) {
				planner.deleteEvent(in);
			} else if (menuChoice == 5) {
				inFile = openFile(in);
				if (inFile != null) {
					while (inFile.hasNext()) {
						if (!planner.inputEvent(inFile, "no"))
							break;
					}
				}
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
