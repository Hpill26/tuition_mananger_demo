package application;

public class Outstate extends Student {
	
	private boolean tristate;
	
	public Outstate(String fname, String lname, int credit, boolean newTristate)
	{
		super(fname, lname, credit);

		tristate = newTristate;
	}

	public int tuitionDue() 
	{	
		boolean partTime = false;
		boolean aboveFifteen = false;
		int universityFee = Price.UNIVERSITY_FEE;
		int perCredit = Price.PER_CREDIT_OUTSTATE;
		int tuitionDue = 0;
		
		if(tristate)
		{
			perCredit = perCredit - Price.TRISTATE_DISCOUNT;
		}
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
	
}
