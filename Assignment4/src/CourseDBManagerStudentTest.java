import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManagerStudentTest {

	private CourseDBManagerInterface dataMgr= new CourseDBManager(); 

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/** 
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDatabase() {
		dataMgr.add("CMSC204", 12345, 4, "ST329", "Fatima Mbodji");
		assertEquals(dataMgr.get(12345).toString() ,"Course:CMSC204 CRN:12345 Credits:4 Instructor:Fatima Mbodji Room:ST329");
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC204", 12345, 4, "ST329", "Fatima Mbodji");
		dataMgr.add("CMSC203", 34345, 4, "ST328", "Fatima Mbodji");
		dataMgr.add("CMSC140", 37845, 3, "ST330", "Fatima Mbodji");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"Course:CMSC140 CRN:37845 Credits:3 Instructor:Fatima Mbodji Room:ST330\n");
		assertEquals(list.get(1),"Course:CMSC204 CRN:12345 Credits:4 Instructor:Fatima Mbodji Room:ST329\n");
	 	assertEquals(list.get(2),"Course:CMSC203 CRN:34345 Credits:4 Instructor:Fatima Mbodji Room:ST328\n");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testReadFile() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 12345 4 ST329 Fatima Mbodji");
			inFile.print("CMSC203 34345 4 ST328 Fatima Mbodji");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC204",dataMgr.get(12345).getID());
			assertEquals("CMSC203",dataMgr.get(34345).getID());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	

}
