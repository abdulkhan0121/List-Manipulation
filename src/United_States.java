//Abdul Khan
//C Block
//3/9/19

package United_States;
import java.io.File;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class United_States {

	public static void main(String[] args) {
		
		ArrayList<String> states = new ArrayList<String>(50);

		String pathname = "States";
	    File file = new File(pathname);
	    Scanner input = null;
	    try
	    {
	        input = new Scanner(file);
	        int i = 0;
	        while(input.hasNextLine()) {
	        	String word = input.nextLine();
	        	states.add(i, word);
	        	i++;
	        	Collections.sort(states);
	        }
	    }
	    catch (FileNotFoundException ex)
	    {
	        System.out.println("*** Cannot open " + pathname
	                                                                             + " ***");
	        System.exit(1);  // quit the program
	    } 
	    
	   boolean quit = false;
	    
	   while( quit == false) {
	    
	    System.out.println("***Select a function:***\nDisplay list(1)\nInsert item(2)\nRemove item(3)\nSave list(4)\nQuit(5)");
	    Scanner choice = new Scanner(System.in);
	    int menu = choice.nextInt();
	    if(menu == 1)
	    	displayList(states);
	    if(menu == 2)
	    	insertItem(states);
	    if(menu == 3)
	    	removeItem(states);
	    if(menu == 4)
	    	saveList(states);
	    if(menu == 5)
	    	quit();
	    
	    }
	    
	}

	public static void displayList(ArrayList<String> states) {
	
		System.out.println("\n***LIST***");
		for(String word : states) {
			
			System.out.println(word);
			
		}
		System.out.println();
		
	}
	
	public static ArrayList<String> insertItem(ArrayList<String> states) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a state you wish to add:");
		String addState = input.nextLine();
		if(states.contains(addState)) {
			System.out.println("Error: that item already exists\n");
		}
		else {
			states.add(addState);
			Collections.sort(states);
		}
		
		
		return states;
		
	}
	
	public static void removeItem(ArrayList<String> states) {
		
		boolean found = false;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a state you wish to remove:");
		String removeState = input.nextLine();
		if(states.contains(removeState)) {
			
			for(int i = 0; i < 50; i++) {
					if(removeState.equals(states.get(i))) {
					found = true;
					states.remove(i);
					Collections.sort(states);
					if(found == true)
						i = 51;

				}
			}
			
		}
		else
			System.out.println("Item is not present in the list");
			
		
	}
	
	public static void saveList(ArrayList<String> states) {		
		
		String pathname = "States";
	    File file = new File(pathname);
	    PrintWriter output = null;
	    try
	    {
	       output = new PrintWriter(file);
	    }
	    catch (FileNotFoundException ex)
	    {
	       System.out.println("Cannot create " + pathname);
	       System.exit(1);  // quit the program
	    }
	    for(String word : states) {
		    output.println(word);
		}
	    output.close();

		
	}
	
	public static void quit() {
		
		System.out.println("program terminated");
		System.exit(0);
		
	}
	
}
