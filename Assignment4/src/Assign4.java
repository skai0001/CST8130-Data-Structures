/**   This class models a main .
 *    	Author:  Hasan		
 *		Date : April 05 2017
 *		Course: CST8130_300 Data Structure
 *    
 *    	Assignment 4 -contains a menu of 6 options ( clears dictionary , adds text from keyboard
 *    												add txt from file , search for word count ,
 *    												display number of nodes , quits)
 *     
 *				
 *    Methods:  main
 *				openFile
 *                  
 */



import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assign4 {


	public static void main(String[] args) {
		int display = 0 ; 
		int option;
		Dictionary treeMap = new Dictionary() ;
		Scanner in = new Scanner (System.in);
		Scanner inFile = null;


		while (display >= 0){

			try {


				System.out.print( "\nEnter 1 to clear dictionary,  ");
				System.out.print( "\n2 to add text from keyboard,  ");
				System.out.print( "\n3 to add text from a file,  ");
				System.out.print( "\n4 to search for a word count, ");
				System.out.print( "\n5 to display number of nodes,  ");
				System.out.print( "\n6 to quit\n");

				option = in.nextInt();

				switch (option){

				case 1:

					treeMap.reset();
					continue;

				case 2:

					treeMap.inputWord(in,"yes");
					continue;

				case 3 :

					inFile = openFile(in);
					if (inFile != null) {
						while (inFile.hasNext())
							treeMap.inputWord(inFile,"no");
					} // end of if 

					continue;

				case 4 :

					treeMap.search(in);
					continue;

				case 5 :

					treeMap.display();
					continue;

				case 6:

					break;

				default:

					System.out.println("Invalid option.");
					break;
				} // end of switch 
			}  catch (InputMismatchException e){
				System.out.print("Invalid option");


			} // end of catch 
			break;
		} // end of while loop
	} // end of main() 

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

} // end of class Assign4
