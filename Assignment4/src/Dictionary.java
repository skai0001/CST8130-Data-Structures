/**   This class models a Dictionary treeMap  
 *		Author:   Hasan		
 *		Date :    April 05 2017
 *		Course:   CST8130_300 Data Structure
 *		purpose : Dictionay of type TreeMap that structured to hold the key value pairs for each word in the dictionary 
 *		Data members: TreeMap<String, Integer> - structure for holding the key-value pairs
 *					  for each word in the dictionary	
 *		Methods:  default constructor
 *                inputWord (Scanner , String ) :void- adds text from keyboard or file to the dictionary
 *                checkFormat (String): String -checks the words for capitalization and special symbols 
 *				  search(Scanner):void- searches for the string in the dictionary and displays how many it exists
 *				  reset():resets the dictionary to null 
 *				  display(): displays the number of nodes in the treeMap                                
 */

import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {

	public TreeMap <String,Integer > dictionary = new TreeMap <String,Integer>();

	public Dictionary(){ // default constructor


	} // end of constructor

	public void inputWord (Scanner in, String prompt){  // add text from keyboard or file 

		if(prompt == "yes"){
			System.out.println("Enter word to add:");
		} // end of if statement 
		String str = in.next();
		str = checkFormat(str);

		if (dictionary.containsKey(str)){
			int value = dictionary.get(str);
			value ++;
			dictionary.replace(str, value);
		} else {
			dictionary.put(str,1); 
		} // end of else statement
	} // end of inputWord()

	public String checkFormat( String key){ // check words for capitals and  remove symbols

		key = key.toLowerCase().replaceAll("[^a-zA-Z]", ""); 
		return key;
	} // end of check()

	public void search (Scanner in){ // searches for a word an outputs the count 

		String key = "";
		System.out.println("Enter word to search for\n");
		key =in.next();
		key = checkFormat(key); 

		if (dictionary.containsKey(key)){

			System.out.println( key + " occurs " + dictionary.get(key) +" time(s)");
		} else {
			System.out.println(" It does not exist ");
		} // end of else statement
	} // end of search()


	public void reset(){ // resets the tree 
		dictionary.clear();
	}// end of reset()


	public void display(){ // display number of nodes 
		System.out.println("There are " + dictionary.size()+ " node(s)\n");
	} // end of display()

} // end of class Dictionay
