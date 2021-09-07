package application;

public class International extends Student{

	private boolean exchange;
	
	public International(String fname, String lname, int credit,boolean newExchange) {
		super(fname, lname, credit);
		
		exchange = newExchange;
	}
	
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
			if(partTime)
			{
				universityFee = Price.UNIVERSITY_FEE_PART_TIME;
				tuitionDue = universityFee + internationalFee;
			}
			else
			{
				tuitionDue = universityFee + internationalFee;
			}	
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

}
