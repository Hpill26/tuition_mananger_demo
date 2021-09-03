/**
 * International is a child of the student class and is designed to accommodate International
 *  students who are either exchange students or regular students. Provides a toString 
 * and tuition due method which calculates the correct tuition due for this case. 
 * 
 * @author Harishkarthik Kumaran Pillai
 */
public class International extends Student{

	private boolean exchange;
	
	/**
	 * Constructs the International student object while also incorporating the object requirements of the Superclass (student).
	 * @param fname is the first name of the student
	 * @param lname is the last name of the student
	 * @param credit is the number of credits the student is attempting
	 * @param newExchange indicates whether or not the student is a exchange student; true if exchange, false otherwise
	 */
	public International(String fname, String lname, int credit,boolean newExchange) {
		super(fname, lname, credit);
		
		exchange = newExchange;
	}
	
	/**
	 *  Calculates the exact tuition an international student owes to the institution
	 *  by taking into account their part time status and exchange student status. 
	 */
	public int tuitionDue() 
	{	
		boolean partTime = false;
		boolean aboveFifteen = false;
		int universityFee = Price.UNIVERSITY_FEE;
		int perCredit = Price.PER_CREDIT_INTERNATIONAL;
		int internationalFee = Price.INTERATIONAL_FEE;
		int tuitionDue = 0;
		
		
		if(credit < Price.PART_TIME_CREDITS)
		{
			partTime = true;
		}
		else if(credit > Price.FULL_TIME_CREDITS)
		{
			aboveFifteen = true;
		}
		
		if(exchange)
		{
				tuitionDue = universityFee + internationalFee;	
		}
		else
		{
			if(partTime)
			{
				universityFee = Price.UNIVERSITY_FEE_PART_TIME;
				tuitionDue = (perCredit * credit) + universityFee + internationalFee;
			}
			else if(aboveFifteen)
			{
				tuitionDue = (perCredit * Price.FULL_TIME_CREDITS) + universityFee + internationalFee;
			}
			else
			{
				tuitionDue = (perCredit * credit) + universityFee + internationalFee;
			}
		}
		return tuitionDue;
	}
	
	@Override
	public String toString() 
	{
		String booleanVal = "F";
		if(exchange)
		{
			booleanVal = "T";
		}
		return "N " + super.toString() + " " + booleanVal;
	}
	
	//testbed
	public void testbedInternational()
	{
		International test1 = new International("harry","pillai",18,true);
		International test2 = new International("harry","pillai",9,false);
		
		System.out.println(test1.toString());
		System.out.println(test1.tuitionDue());
		
		System.out.println(test2.toString());
		System.out.println(test2.tuitionDue());
		
	}
}
