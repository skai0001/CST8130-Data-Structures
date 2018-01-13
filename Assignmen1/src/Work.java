import java.util.*;
import java.util.Scanner;

public class Work extends Event {

	private int length;

	public Work(Scanner sc, String prompt) {
		super(sc, prompt);
	}

	public boolean inputEvent(Scanner scanner, String prompt) {
		boolean eCreated = false;
		super.inputEvent(scanner, prompt);

		while (!eCreated) {
			try {
				if (prompt == "yes") {
			
					System.out.println("Enter duration of the shift: ");
					length = scanner.nextInt();
					eCreated = true;
				} else if (prompt == "no") {
					length = scanner.nextInt();
					eCreated = true;
				}
			} catch (InputMismatchException ex) {
				System.out.println("Doesnot exist!");
				scanner.nextLine();
				eCreated = false;
				break;
			} catch (NoSuchElementException ex) {
				System.out.println("Doesnot exist!");
				eCreated = true;
				break;
			}
		}

		return true;
	}

	public String toString() {
		return super.toString()+" "+length;
	}

}