
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Lab1 {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int display = 0 ; 
		int option;
		Scanner keyboard = new Scanner(System.in);
		Numbers num = new Numbers();

		while (display >= 0){

			try {


				System.out.println("Enter 1 to create aray of new size ,\n"
						+ "2 to generate random numbers into array ,\n"
						+ "3 to count a value ,\n"
						+ "4 to display array ,\n"
						+ "0 to quit:");

				option = keyboard.nextInt();

				switch (option){

				case 0:

					break;

				case 1:

					System.out.print("Enter new size:");
					num =new Numbers(keyboard.nextInt());
					System.out.println("Array has been generated\n");
					continue;

				case 2:

					num.generateNumbers();
					System.out.println("Numbers have been generated\n");

					continue;

				case 3 :

					System.out.print("Enter number to search for:\n");
					int x = keyboard.nextInt();
					System.out.println("There are" + " " + num.count(x) + ""+ " of the number" + " " + x  );
					continue;

				case 4:

					System.out.println("The numbers are:\n" + num.toString());
					continue;

				default:

					System.out.println("Invalid option.");
					break;
				}
			}  catch (InputMismatchException e){
				System.out.print("Invalid option");


			}
			break;
		}
	}



}




