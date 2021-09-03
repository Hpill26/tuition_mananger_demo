/**
 * OutState is a child of the student class and is designed to accommodate Out of state
 * students who are either from the TriState are or from other parts of the US. 
 * Provides a toString and tuition due method which calculates the correct tuition due for this case. 
 * 
 * @author Harishkarthik Kumaran Pillai
 */
public class Outstate extends Student {
	
	private boolean tristate;
	
	/**
	 * Constructs the Outstate student object while also incorporating the object requirements of the Superclass (student).
	 * @param fname is the first name of the student
	 * @param lname is the last name of the student
	 * @param credit is the number of credits the student is attempting
	 * @param newTristate indicates whether or not the student is from the TriState area; true if from TriState, false otherwise
	 */
	public Outstate(String fname, String lname, int credit, boolean newTristate)
	{
		super(fname, lname, credit);

		tristate = newTristate;
	}
	
	/**
	 *  Calculates the appropriate tuition amount by accounting for a student's part time status and
	 *  their special discount for being from the TriState area. 
	 */
	public int tuitionDue() 
	{	
		boolean partTime = false;
		boolean aboveFifteen = false;
		int universityFee = Price.UNIVERSITY_FEE;
		int perCredit = Price.PER_CREDIT_OUTSTATE;
		int tuitionDue = 0;
		
		
		if(credit < Price.PART_TIME_CREDITS)
		{
			partTime = true;
		}
		else if(credit > Price.FULL_TIME_CREDITS)
		{
			aboveFifteen = true;
		}
		
		if(tristate && aboveFifteen)
		{
			perCredit = perCredit - Price.TRISTATE_DISCOUNT;
		}
		if(partTime)
		{
			universityFee = Price.UNIVERSITY_FEE_PART_TIME;
			tuitionDue = (perCredit * credit) + universityFee;
		}
		else if(aboveFifteen)
		{
			tuitionDue = (perCredit * Price.FULL_TIME_CREDITS) + universityFee;
		}
		else
		{
			tuitionDue = (perCredit * credit) + universityFee;
		}
		return tuitionDue;
	}
	
	@Override
	public String toString() 
	{
		String booleanVal = "F";
		if(tristate)
		{
			booleanVal = "T";
		}
		return "O " + super.toString() + " " + booleanVal;
	}
	
	//testbed
	public void testbedOutState()
	{
		Outstate test = new Outstate("harish","pillai",18,true);
		
		Outstate test1 = new Outstate("h","pil",9,false);
	
		System.out.println(test.toString());
		System.out.println(test.tuitionDue());
		
		System.out.println(test1.toString());
		System.out.println(test1.tuitionDue());
	}
}
