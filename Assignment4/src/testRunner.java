import java.io.IOException;
import java.util.*;

public class testRunner {

	public static void main(String[] args) throws IOException {
		System.out.println(15 + " is prime: " + isPrimeNumber(15));
		System.out.println(getNext4kprimeNumber(20));
		System.out.println(getNext4kprimeNumber(25));
		System.out.println(getNext4kprimeNumber(45));
		System.out.println(getNext4kprimeNumber(55));
		
		CourseDBElement cde1 = new CourseDBElement("CMSC500", 39999, 4, "SC100", "Nobody InParticular");
		CourseDBElement cde2 = new CourseDBElement("CMSC600", 4000, 4, "SC100", "Nobody InParticular");
		CourseDBStructure cds = new CourseDBStructure(25);
		cds.add(cde1);
		cds.add(cde2);
		ArrayList<String> courseList = cds.showAll(); 
		System.out.println("Size cds: " + cds.getTableSize());
		System.out.println("Size course list: " + courseList.size());
		//System.out.println("1: " + cds.get(39999));
		//System.out.println("2: " + cds.get(4000));
		System.out.println("Course list: " + courseList);
		CourseDBElement cde1Update = new CourseDBElement("CMSC500-updated", 39999, 4, "SC100", "updated");
		cds.add(cde1Update);  //Same CRN updated information
		courseList = cds.showAll();
		System.out.println("Size course list: " + courseList.size());
		System.out.println("Course list: " + courseList);
		System.out.println();
		
		CourseDBStructure testStructure = new CourseDBStructure("Testing", 25);
		testStructure.add(cde1); 
		ArrayList<String> courseList2 = cds.showAll(); 
		courseList2 = testStructure.showAll(); 
		System.out.println("Size course list 2: " + courseList.size());
	
		System.out.println();
		String cdeLine = "CMSC100 21556 2 Distance-Learning Janet E. Joy";
		String [] cdeTab = cdeLine.split("\\s+", 5);
		String id = cdeTab[0].trim();
		int crn = Integer.parseInt(cdeTab[1].trim());
		int credits = Integer.parseInt(cdeTab[2].trim());
		String roomNum = cdeTab[3].trim();
		String instructor = cdeTab[4].trim();
		System.out.println("ID: " + id);
		System.out.println("CRN: " + crn);
		System.out.println("Credits: " + credits);
		System.out.println("Room Number: " + roomNum);
		System.out.println("Instructor's name: " + instructor);
		
	}
	
	
	    
	public static boolean isPrimeNumber(int num) 
	{
        if (num <= 1) 
        {
            return false;  
        }
        if (num == 2) 
        {
            return true;  
        }
        if (num % 2 == 0) 
        {
            return false;  
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) 
        {
            if (num % i == 0) 
                return false;  
        }
        return true;  
    }
	
	public static int getNext4kprimeNumber(int n)
	{
		boolean num4kprime= false;
		int next = (int) (n / 1.5);
		next++;
		while ( !num4kprime ) 
		{
			boolean prime = isPrimeNumber(next);
			int result = (next-3)%4;
			if ( prime == true && result == 0)
			{
				num4kprime = true;
			}
			else
				next++;
		}
		return next;
	}
	

}
