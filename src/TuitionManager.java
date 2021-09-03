import java.util.*;
/**
 *  Manages all other classes in this project, essentially reads in user input and decides
 *  what method to use. Fine tunes the output and prints. 
 * @author Brain Moran
 *
 */
public class TuitionManager {
	Scanner input = new Scanner(System.in);
	
	String fname,lname,command,S_data, indicator;
	int credit, I_data;
	Student inputStudent;
	boolean triState, exchange;
	StudentList root = new StudentList();
	
	/**
	 * Provides the user instructions on input and figures out what function they want to use and calls the appropriate method. 
	 */
	public void run() {
		System.out.println("Instructions: Press enter key once and follow the key below");
		System.out.println("<(A)dd> <(R)emove> <(P)rint>");
		System.out.println("ADD- <cmd(I,O,N)> <first> <last> <#credits> <|(I) #Funds| |(O)(N) \"T\" or \"F\"|>");
		System.out.println("");
		System.out.println("REMOVE- <first> <last>");
		System.out.println("");
		System.out.println("PRINT- |prints the list|");
		System.out.println("");
		System.out.println("ex) A I Joe Bag 17 1200		A N Jill Collin 12 T");
		
		boolean notEnoughCredits = false;
		while(true) {
			String arg = input.next();
	        char switchArg = arg.charAt(0);
	        
	        switch (switchArg)  
	         {   
	            case 'I': 
	            	//add	            	
	            	fname = input.next();
	                lname = input.next();
	                credit = Integer.valueOf(input.next());
	                
	                if(credit <= 0)
                	{
                		System.out.println("Sorry that is an Invalid amount of credits");
                		notEnoughCredits = true;
                		break;
                	}
	                
	               
		                I_data = Integer.valueOf(input.next());
		                
	                	inputStudent = new Instate(fname,lname,credit,I_data);
	                	if(root.contains(inputStudent))
	                	{
	                		System.out.println("This is not possible, this student is already in the list!");
	                		System.out.println("Press Enter to continue...");
	                		break;
	                	}
	                	root.add(inputStudent);
	                break;
	            case 'O':
	            	fname = input.next();
	                lname = input.next();
	                credit = Integer.valueOf(input.next());
	                
	                if(credit <= 0)
                	{
                		System.out.println("Sorry that is an Invalid amount of credits");
                		notEnoughCredits = true;
                		break;
                	}
	                
	               
		                
	                	indicator = input.next();
	                	
	                	if(indicator.charAt(0) == 'T') {
	                		triState = true;
	                	} else if(indicator.charAt(0) == 'F') {
	                		triState = false;
	                	}else {
	                		//error
	                	}
	                	
	                	inputStudent = new Outstate(fname,lname,credit,triState);
	                	if(root.contains(inputStudent))
	                	{
	                		System.out.println("This is not possible, this student is already in the list!");
	                		System.out.println("Press Enter to continue...");
	                		break;
	                	}
	                	root.add(inputStudent);
	                
	        break;
	        case 'N': 
	                
	                	if(credit < 9)
	                	{
	                		System.out.println("Sorry International students cannot enroll for less than 9 credits!!!");
	                		notEnoughCredits = true;
	                		break;
	                	}
	                	indicator = input.next();
	                	
	                	if(indicator.charAt(0) == 'T') {
	                		exchange = true;
	                	} else if(indicator.charAt(0) == 'F') {
	                		exchange = false;
	                	}else {
	                		//error
	                	}
	                	
	                	inputStudent = new International(fname,lname,credit,exchange);
	                	if(root.contains(inputStudent))
	                	{
	                		System.out.println("This is not possible, this student is already in the list!");
	                		System.out.println("Press Enter to continue...");
	                		break;
	                	}
	                	root.add(inputStudent);
	                
	                
	            	break;
	            case 'R':
	            	//remove
	            	
	            	fname = input.next();
	            	lname = input.next();
	            	inputStudent = new Outstate(fname,lname,0,true);
	            	if(root.remove(inputStudent)) {
	            		break;
	            	} else {
	            		System.out.println("Student Not in List");
	            	}
	            	break;
	            case 'P':
	            	//print
	            	//System.out.println("printed List");
	            	System.out.println();
	            	root.print();
	            	break;
	            case 'Q':
	            	//termminate
	            	System.out.println("Program terminated");
	            	System.exit(0);
	            default:
	            	if(notEnoughCredits)
	            	{
	            		System.out.println("Press Enter to continue...");
	            		break;
	            	}
	            	System.out.println("Incorrect format: Command requires (A)dd (R)emove (P)rint (Q)uit");
	            	input.hasNextLine();
	            	break;
	            //	arg = input.next();
	            //  switchArg = arg.charAt(0);
	            	//print error
	            	
	         }
		}
	}
}
