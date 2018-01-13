

public class Main {

	public static void main(String[] args) {
		Planner planner = new Planner();
		System.out.println("Enter 1 to add an event to planner from the keyboard;)\n"
				+ "2 to display events for a day; \n"
				+ "3 to display events for a week; \n"
				+ "4 to delete an event; \n"
				+ "5 to add events to planner from a file; \n"
				+ "0 to quit; \n");
		planner.menuInput();
	} 

}