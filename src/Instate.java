/**
 * InState is a child of the student class and is designed to accommodate InState students specific 
 * requirements for grants and scholarships. Provides a toString and tuition due method which 
 * calculates the correct tuition due for this case. 
 * 
 * @author Harishkarthik Kumaran Pillai
 */
public class Instate extends Student
{
	private int funds;
	
	/**
	 * Constructs the InState student object while also incorporating the object requirements of the Superclass (student).
	 * @param fname is the first name of the student
	 * @param lname is the last name of the student
	 * @param credit is the number of credits the student is attempting
	 * @param newFunds is the amount of aid the student is receiving
	 */
	public Instate(String fname, String lname, int credit, int newFunds) 
	{
		super(fname, lname, credit);
		funds = newFunds;
	}
	
	/**
	 *  Calculates the appropriate amount the student owes to the institution by taking into consideration 
	 *  the student's part time status and any addition grants or funds they have.
	 */
	public int tuitionDue() 
	{	
		boolean partTime = false;
		boolean aboveFifteen = false;
		int universityFee = Price.UNIVERSITY_FEE;
		int tuitionDue = 0;
		
		if(credit < Price.PART_TIME_CREDITS)
		{
			partTime = true;
		}
		else if(credit > Price.FULL_TIME_CREDITS)
		{
			aboveFifteen = true;
		}
		
		if(partTime)
		{
			universityFee = Price.UNIVERSITY_FEE_PART_TIME;
			tuitionDue = (Price.PER_CREDIT_INSTATE * credit) + universityFee;
		}
		else if(aboveFifteen)
		{
			tuitionDue = (Price.PER_CREDIT_INSTATE * Price.FULL_TIME_CREDITS) + universityFee - funds;
		}
		else
		{
			tuitionDue = (Price.PER_CREDIT_INSTATE * credit) + universityFee - funds;
		}
		return tuitionDue;
	}

	@Override
	public String toString() 
	{
		String superToString = super.toString();
		//System.out.println("error TEst:" + superToString);
		return "I " + superToString + " " + funds;
	}
	
	//testbed
	public void testbedInState()
	{
			   
	   	Instate test1  = new Instate("harry","pillai",18,1000);
	   	Instate test2  = new Instate("harry","pillai",8,100);	   

	   	System.out.println(test1.toString());
	   	System.out.println(test1.tuitionDue());
	   	
	   	System.out.println(test2.toString());
	   	System.out.println(test2.tuitionDue());
	 }
//}
}