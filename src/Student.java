package application;
public abstract class Student implements Comparable 
	{
		private String fname;
		private String lname;
		protected int credit;
		
		public Student(String newFname, String newLname, int newCredit)
		{
			fname = newFname;
			lname = newLname;
			credit = newCredit;
		} //constructor
		
		//must implement compareTo method because Student class implements the Comparable Interface
		//return 0 if fname and lname of the two students are equal,
		//return -1 if this fname and lname is < obj’s, return 1 if this fname and lname is > obj’s
		//Hint: use the compareToIgnoreCase methods of the String class to compare fname
		//and lname; compare the fname first, then lname; names are not case-sensitive;
		
		public int compareTo(Object obj)
		{
			Student tempVar = (Student) obj;
			
			if(tempVar.fname.equals(this.fname) && tempVar.lname.equals(this.lname)) {
				return 0;
			}
			
			//temp < this
			if(tempVar.fname.compareToIgnoreCase(this.fname) < 0)
			{
				return 1;
			}
			else if(tempVar.fname.compareToIgnoreCase(this.fname) > 0)
			{
				return -1;
			}
			else if(tempVar.lname.compareToIgnoreCase(this.lname) < 0)
			{
				return 1;
			} else if(tempVar.lname.compareToIgnoreCase(this.lname) > 0) 
			{
				return -1;
			}
			return 0;
			
		}
		
		//return a string with fname, lname and credit hours; subclasses will be using this method.
		public String toString() 
		{
			return fname + " " + lname + " " + credit;
		}
		
		//compute the tuition due; concrete implementation is required in the subclasses.
		public abstract int tuitionDue();
		
	  	public void TestbedStudent()
	    {
			Student a,b,c,d;
			a = new Outstate("bob","bab",0,true);
			b = new Outstate("bob","abb",0,true);
			c = new Outstate("cat","f",0,true);
			d = new Outstate("dave","f",0,true);
			
			System.out.println(a.compareTo(b));
		   }
	}
	

