/**
 * Data Element class that implements Comparable interface 
 * It consists of five attributes: the Course ID (String), the CRN (int), 
 * the number of credits (int), the room number (String), and the instructor name (String).  
 * A CourseDBElement object consists of these five attributes and is referred to as a CDE.
 * @author FATIMA MBODJI
 */
public class CourseDBElement implements Comparable{
	
	String ID;
	int CRN;
	int numCredits ;
	String instructorName;
	String roomNum;
	
	/**
	 * Create a CourseDBELement object
	 * @param courseID the course ID
	 * @param cRN the CRN
	 * @param credits the number of credits
	 * @param roomNum the room number
	 * @param instructor the instructor's name
	 */
	public CourseDBElement(String courseID, int cRN, int credits, String roomNum, String instructor) {
		this.ID = courseID;
		this.CRN = cRN;
		this.numCredits = credits;
		this.instructorName = instructor;
		this.roomNum = roomNum;
	}

	public CourseDBElement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the ID
	 */
	public String getID() {
		return this.ID;
	}

	/**
	 * Update the ID
	 * @param courseID the ID replacement
	 */
	public void setID(String courseID) {
		this.ID = courseID;
	}

	/**
	 * @return the CRN
	 */
	public int getCRN() {
		return this.CRN;
	}

	/**
	 * @return the room number
	 */
	public String getRoomNum() {
		return this.roomNum;
	}
	
	/**
	 * Compare if two CourseDBElement objects have the same CRN
	 * @param element the CourseDBElement to be compared to
	 * @return the result of the comparison 
	 */
	public boolean equalsCRN(CourseDBElement element) {
		return this.CRN == element.CRN;
	}

	/**
	 * Compare if two CourseDBElement objects have the same ID
	 * @param element the CourseDBElement to be compared to
	 * @return the result of the comparison 
	 */
	public boolean equalsID(CourseDBElement element) {
		return this.ID == element.ID;
	}
	
	/**
	 * Return a String format of a CourseDBElement 
	 * Includes the ID, CRN, credits, roomNumber and instructor
	 */
	@Override
	public String toString() {
		return "Course:" + ID + " CRN:" + CRN + " Credits:" + numCredits + " Instructor:" + instructorName
				+ " Room:" + roomNum;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
