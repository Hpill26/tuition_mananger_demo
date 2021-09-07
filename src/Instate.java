package application;

public class Instate extends Student
{
	private int funds;
	
	public Instate(String fname, String lname, int credit, int newFunds) 
	{
		super(fname, lname, credit);
		funds = newFunds;
	}
	
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
//}
}