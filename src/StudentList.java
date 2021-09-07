package application;

/**
 * Growable container class. Creates a studentlist which can be used to add different types of students. Also provides functionality 
 * to remove students from the list and print the list. 
 * @author Group 13
 *
 */
public class StudentList {
	   private final int NOT_FOUND = -1;
	   private final int SIZE = 100; 
	   private Student [] list;
	   private int numStudents;
	   
	   /**
	    * Creates the Student list object which will be holding all the students the user inputs.
	    */
	   public StudentList()
	   {
	      //this is the default constructor
		   this.list = new Student[SIZE];
		   this.numStudents = 0;
	   }
	   /**
	    * Checks if the student list is empty
	    * @return true if empty, false otherwise
	    */
	   public boolean isEmpty()
	   {
	       if(numStudents == 0) 
	       {
	    	   return true;
	       } else {
	    	   return false;
	       }
	   }
	   
	   /**
	    * Finds the index position of the desired student from our list.
	    * @param s is the student we are searching for
	    * @return index of the student searched, -1 if not found
	    */
	   private int find(Student s)
	   {
	       for(int i = 0; i < numStudents; i++) {
	    	   if(s.compareTo(list[i])== 0) {
	    		   return i;
	    	   } 
	       }
	       return NOT_FOUND;
	   }
	   /**
	    * Finds out if a student is in the list.
	    * @param s is the student to be searched
	    * @return true if found, false otherwise
	    */
	   public boolean contains(Student s)
	   {
	       if(find(s) > NOT_FOUND)
	       {
	    	   return true;
	       } 
	       else {
	    	   return false;
	       }
	   } 
	   /**
	    * Increases the size of the TeamMember array, allowing the team object to be 
	    * a grow able container class. 
	    */
	   private void grow()
	   {
	       Student[] temp = new Student[list.length + SIZE];
	       for (int i = 0; i < list.length; i++)
	       {
	    	      temp[i] = this.list[i];
	       }
	       this.list = temp;
	   }
	   /**
	    * Adds a student to the list. Checks to make sure list is not full, and grows accordingly. 
	    * @param s is the student we want to add to the list; can take all types of students (InState,OutState,International)
	    */
	   public void add(Student s)
	   {     
		   //check if array is full
		   if(numStudents == list.length) 
		   {
			   this.grow();
		   }
		   numStudents ++;
	   
		   int i = 0;
		   while(list[i] != null) {
			   i++;
		   }
		   
		   list[i] = s;	   
	   }
	   /**
	    * Removes the student entered from the list.
	    * @param s is the student we want removed.
	    * @return true if removed, false otherwise
	    */
	   public boolean remove(Student s)
	   {
		   int i = find(s);    
	       if(i > NOT_FOUND) 
	       {
	    	   numStudents --;
	    	   if(i == numStudents+1) { //to be removed is last item in array
	    		   list[i] = null;
	    		   return true;
	    	   } else {
	    		   int k;
				   for(k = 0; k < list.length-1; k++) //finds last item of array
				   {
					   if(list[k] == null) {
						   break;
					   }
				   }
	    		   list[i] = list[k-1]; //sets removal to last item in array
		    	   list[k-1] = null;  
		    	   return true;
	    	   }
	       } else {
	    	   return false;
	       }
	   } 
	   /**
	    * prints out all the Students in the list with the appropriate calculation for their tuition
	    */
	   public void print()
	   {
	       //4eset up a for loop and call the toString() method
		   for(int i = 0; i < numStudents; i ++)
		   {
			   System.out.println(list[i].toString() + "  Tuition Due: $" + list[i].tuitionDue());
		   }
		   
	   } 
	   public String printGUI()
	   {
		   StringBuilder agg = new StringBuilder(""); 
		   for(int i = 0; i < numStudents; i ++)
		   {
			   agg.append(list[i].toString() + "  Tuition Due: " + list[i].tuitionDue()+ "\n");
			   
		   }
		   return agg.toString();
	   }

	   public void TestbedStudentList()
	   {
		   Student a = new Outstate("Bill" , "a" , 0, true);
		   Student b = new Outstate("adam" , "a", 0, true);
		   Student c = new Outstate("Bill" , "a", 0, true);
		   Student d = new Outstate("Suzie" ,"a", 0, true);
		   Student e = new Outstate("Tom" , "a", 0, true);
		   Student f = new Outstate("Dan" ,"a" , 0, true);
		   Student g = new Outstate("Mike" ,"a", 0, true);
		   Student h = new Outstate("Amber" ,"a", 0, true);
		   Student i = new Outstate("Brooke" ,"a", 0, true);
		   
		   StudentList test = new StudentList();
		   test.add(a);
		   test.add(b);
		   test.add(c);
		   test.add(d);
		   test.add(e);
		   test.add(f);
		   test.add(g);
		   test.add(h);
		   test.add(i);
		   
		   //find works
		   int p = test.find(e);
		   System.out.println("4? - " + p);
		   
		   //Remove
		   
		   if(test.remove(g)) 
		   {
			   System.out.println("mike shldnt be there");
		   }
		   
		   
		   //Print Works
		   test.print();
		   }
	   
}
