import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

/**
 * Data Manager Class that implements CourseDBManagerInterface
 * This class allows the user to read input from a file or from the textfields 
 * and add it to the data structure through its add method.
 * The add method uses the CDS's add method
 * This class is referred to as CDM.
 * @author FATIMA MBODJI
 */
public class CourseDBManager implements CourseDBManagerInterface{
	private CourseDBStructure cds;
	
	public CourseDBManager() {
		cds = new CourseDBStructure(100);
	}
	
	/**
	 * Adds a course (CourseDBElement) with the given information to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(cde);	
	}

	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 */
	public void readFile(File inputFile) {
		FileReader file = null;
		try {
			file = new FileReader(inputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bfReader = new BufferedReader(file);
		String cdeLine ;
		try {
			while ( (cdeLine=bfReader.readLine()) != null)
			{
				String [] cdeTab = cdeLine.split("\\s+", 5);
				String id = cdeTab[0].trim();
				int crn = Integer.parseInt(cdeTab[1].trim());
				int credits = Integer.parseInt(cdeTab[2].trim());
				String roomNum = cdeTab[3].trim();
				String instructor = cdeTab[4].trim();
				add(id, crn, credits, roomNum, instructor);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bfReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 */
	public CourseDBElement get(int crn) {
		CourseDBElement element = null;
		try {
			element = cds.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	
	
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	public ArrayList<String> showAll() {
		return cds.showAll();
	}

}
