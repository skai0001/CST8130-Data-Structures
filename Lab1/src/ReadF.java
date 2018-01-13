
import java.io.*;
import java.util.Scanner;

public class ReadF {
	public static void main (String [] args){

		String fileName = "Events.txt";  
		Scanner fileInput ;
		File file = new File (fileName);
		Scanner scanWord ;

		String [] category = {" type: ", " month: ", " day: ", " year: ", " hour: ", " minute: ", " description: ", " extra:"};


		try{

			if (file.exists()){
				fileInput = new Scanner (file);

				while (fileInput.hasNextLine()){
					scanWord = new Scanner (fileInput.nextLine());

					for (int i =0; i<category.length; i++){
						System.out.print(category[i]);
						if (scanWord.hasNext()){
							System.out.print(scanWord.next());

						}else {
							System.out.print("");
						}


					}

					System.out.println("\n");
				}
				fileInput.close();

			}

		} catch (IOException e){
			System.err.println("Could not read file..." + fileName + "exiting");

		}

	}


}

