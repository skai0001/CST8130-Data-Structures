
import java.util.*;
import java.io.*;
import java.util.Scanner;



public class Planner {


	private Event[] activities = new Event[1000];
	private int numEvents = 0;


	public Planner() {
	}


	public void menuInput(){

		Planner planner = new Planner();
		Scanner keyboard = new Scanner(System.in);
		OurDate date;
		int x = 1;

		while (x != 0) {

			if (keyboard.hasNextInt()) {
				x = keyboard.nextInt();
				if (x < 0 || x > 5) {
					System.out.println("Invalid ..Please re-enter!");
				}
			} else {
				keyboard.next();
				System.out.println("Invalid ..Please re-enter!");
				x -= 1;
			} 
			while(x < 0 || x > 5);

			if (x == 1) {
				planner.inputEvent(keyboard, "yes");

			} else if (x == 2) {

				date = new OurDate();
				System.out.println("\nEnter date to display.");
				date.inputDate(keyboard, "yes");
				planner.displayOneDay(date);

			}else if (x == 3) {
			
				date = new OurDate();
				System.out.println("\nEnter date to display.");
				date.inputDate(keyboard, "yes");
				System.out.println("\nYour events for the week " + "starting on "+date+" are: ");

				for (int i = 1; i <= 7; i++) {
					planner.displaySevenDays(date);
					date.addOne();
				}

			} else if (x == 4) {
				planner.deleteEvent(keyboard);

			} else if (x == 5) {
				try {
					System.out.println("Enter name of file to process: ");
					File file = new File(keyboard.next());

					if (file.exists()) {
						Scanner keyboard1 = new Scanner(file);
						planner.inputEvent(keyboard, "no");
					} else if (!file.exists()) {
						throw new FileNotFoundException();
					}
				} catch (FileNotFoundException ex) {
					System.out.println("File does not exist.");
				}
			} else if (x == 0){
				break;
			}
		} 



	}
	public boolean inputEvent(Scanner scanner, String prompt) {

		boolean eCreated = false; 
		boolean eSucces = false;
		if (prompt == "yes") {

			if (numEvents == 1000) {
				System.out.println("Planner is full ..event cannot be added ");
				return false;
			}

			Scanner keyboard = scanner;

			while (!eCreated) {
				try {

					System.out.println("\nEnter event type to add:\n"
							+ "1 for a meeting event\n"
							+ "2 for a school event\n"
							+ "3 for a work event\n"
							+ "4 for a social\n"
							+ "0 to go back\n");
					int x = 0;
					x = keyboard.nextInt();
					Event temp = null;
					if (x == 1) {	
						temp = new Meeting(keyboard, "yes");
					} else if (x == 2){
						temp = new School(keyboard, "yes");
					} else if (x == 3) {
						temp = new Work(keyboard, "yes");
					} else if (x == 4) {
						temp = new Social(keyboard, "yes");
					} else if (x == 0) {
						break; 
					} else {
						throw new InputMismatchException();
					}


					for (int i = 0; i < numEvents; i++) {
						if (activities[i].isEqual(temp)) {
							System.out.println("Event already exists ");			
							eSucces = true;
							continue; 
						}
					}


					if (!eSucces) {
						activities[numEvents] = temp;
						numEvents++;
						eCreated = true;
						System.out.println("\nEvent added.");
						break; 
					}
					break; 
				} catch (InputMismatchException ex) {
					System.out.println("Invalid .Please re-enter");
					keyboard.nextLine();
					continue;
				} 
			} 

		} else if (prompt == "no") {
			Scanner keboard = scanner;

			while (keboard.hasNext()) {

				try {

					if (numEvents == 1000) {
						System.out.println("File is full");
						return false;
					}

					int j = keboard.nextInt();

					Event temp = null  ;


					if (j == 1) {
						temp = new Meeting(keboard, "no");
					} else if (j == 2) {
						temp = new School(keboard, "no");
					} else if (j == 3) {
						temp = new Work(keboard, "no");
					} else if (j == 4) {
						temp = new Social(keboard, "no");
					}


					for (int k = 0; k < numEvents; k++) {
						if (activities[k].isEqual(temp)) {
							System.out.println("You already have an activity for that date and time ...cannot be enetered");
							eSucces = true;
							break;
						}
					}

					if (!eSucces) {
						activities[numEvents] = temp;
						numEvents++;
					}
				} catch (InputMismatchException ex) {
					System.out.println("Cannot be added .");
					break;
				}
			} 
		}
		return true;
	}
	public String toString(){
		return null;

	}
	public void displayOneDay(OurDate date) {

		boolean eventFound = false;
		System.out.println("Your activities for "+date+" are: ");

		for (int i = 0; i < numEvents; i++) {
			if (date.isEqual(activities[i].getDate())) {
				System.out.println(activities[i]);
				eventFound = true;
			}
		}

		if (!eventFound) {
			System.out.println("There are no events on that day.");
		}
	}

	public void displaySevenDays(OurDate date) {
		displayOneDay(date);
	}

	public boolean deleteEvent(Scanner userInput) {

		if (activities[0] == null) {
			System.out.println("Planner is empty ");
			return true;
		}

		System.out.println("Enter date and time of event to be deleted: ");
		OurDate date = new OurDate();
		OurTime time = new OurTime();

		date.inputDate(userInput, "yes");
		time.inputTime(userInput, "yes");

		for (int i = 0; i < numEvents; i++) {
			if (date.isEqual(activities[i].getDate()) &&
					time.isEqual(activities[i].getTime())) {
				activities[i] = activities[numEvents - 1];
				activities[numEvents - 1] = null;
				numEvents--;
				System.out.println("Event deleted.");
				break;
			} else {
				System.out.println("Event does not exist");
				break;
			}
		}
		return true;
	}

}