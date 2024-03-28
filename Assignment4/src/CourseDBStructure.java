import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Data Structure Class that implements CourseDBStructureInterface
 * This class implements an hash table with buckets. 
 * Each bucket is an array of linked lists of CourseDBElements.  
 * Each CourseDBElement object will have a hash code that is calculate based on the CRN, 
 * since the CRN is unique for courses. 
 * This class is referred to as CDS .
 * @author FATIMA MBODJI
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	private int size;
	private LinkedList<CourseDBElement>[] hashtable;

	/**
	 * This is a helper method for the first constructor 
	 * It checks if a number is a prime number
	 * @param num the number to be checked
	 * @return true if prime number, false otherwise
	 */
	public boolean isPrimeNumber(int num) {
		if (num <= 1) {
			return false;
		}
		if (num == 2) {
			return true;
		}
		if (num % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * This is another helper method for the first constructor 
	 * Uses the first helper method isPrimerNumber()
	 * It checks if a number is a 4kprime number
	 * @param n the number to be checked
	 * @return true if prime number, false otherwise
	 */
	public int getNext4kprimeNumber(int n) {
		boolean is4kprime = false;
		int next = (int) (n / 1.5);
		next++;
		while (!is4kprime) {
			boolean prime = isPrimeNumber(next);
			int result = (next - 3) % 4;
			if (prime == true && result == 0) {
				is4kprime = true;
			} else
				next++;
		}
		return next;
	}

	/**
	 * Constructor that create a CourseDBStructure object
	 * It takes in an integer n and determines the size of the hash table
	 * by finding a 4K+3 prime just greater than n /loading factor (equals to 1.5)
	 * It also initialize the hashtable field
	 * @param n the estimated number of courses
	 */
	public CourseDBStructure(int n) {
		this.size = getNext4kprimeNumber(n);
		hashtable = new LinkedList[this.size];
	}

	/**
	 * Constructor for testing purposes
	 * @param str String
	 * @param n size of the table
	 */
	public CourseDBStructure(String str, int n) {
		this.size = n;
		hashtable = new LinkedList[this.size];
	}

	/**
	 * Adds a CourseDBElement object to the CourseDBStructure using the hashcode of
	 * the CourseDatabaseElement object's crn value. 
	 * If the CourseDatabaseElement already exists, exit quietly
	 * @param element the CourseDBElement to be added to CourseDBStructure
	 */
	@SuppressWarnings("unchecked")
	public void add(CourseDBElement element) {
		String CRNString = String.valueOf(element.getCRN());
		int hashcode = CRNString.hashCode();
		int indexElement = hashcode % size;
		if (hashtable[indexElement] == null) 
		{ 
			hashtable[indexElement] = new LinkedList<>();
		}
		//Checking whether or not the element to add already exist
		LinkedList<CourseDBElement> list = hashtable[indexElement];
	    for (CourseDBElement existingElement : list) {
	        if (existingElement.equalsCRN(element)) 
	        {
	            if (existingElement.equalsID(element))
	            	return; //ignore if no update
	            else
	            {
	            	existingElement.setID(element.getID()); 
	            	return ; //update, then return
	            }
	            	
	        }
	    }
	    //if it does not already exist, add it
		hashtable[indexElement].add(element); 	
	}

	/**
	 * Find a CourseDBElement based on the key (crn) of the CourseDBElement 
	 * If the CourseDBElement is found return it, otherwise throw an IOException
	 * @param crn crn(key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	public CourseDBElement get(int crn) throws IOException {
		String CRNString = String.valueOf(crn);
		int indexElement = CRNString.hashCode()%size;
		if (hashtable[indexElement] == null)
			throw new IOException("This course does not exist"); 
		else
		{
			for (CourseDBElement element : hashtable[indexElement])
			{
				if(element.CRN == crn)
					return element;	
			}
		}
		throw new IOException("This course does not exist"); 
	}

	/**
	 * Returns the size of the ConcordanceDataStructure (number of indexes in the
	 * array)
	 */
	public int getTableSize() {
		return this.size;
	}

	/**
	 * @return an array list of string representation of each course in the data
	 * structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100 
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<>();
		for (LinkedList<CourseDBElement> listElement : hashtable)
		{
			if(listElement!=null)
			{
				for (CourseDBElement element : listElement)
					list.add(element.toString() + "\n");
			}
		}
		return list;
	}

}
