/*
 * Class: CMSC204
 * Instructor: 
 * Description: JUnit Test for the methods in GradeBook class
 * Due: 01/30/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * 
   Print your Name here: Fatima Mbodji
*/


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	
	GradeBook g1, g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);	
		g2 = new GradeBook(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		g1.addScore(1.5);
		g1.addScore(45);
		g2.addScore(3.5);
		g2.addScore(50);
		g2.addScore(37);
		assertTrue(g1.toString().contains("1.5 45.0 0.0 0.0 0.0"));	
		assertEquals(3, g2.getScoreSize());
	}
	
	@Test
	void testSum() {	
		g1.addScore(78);
		g1.addScore(87);
		assertEquals(165, g1.sum());
		g2.addScore(35);
		g2.addScore(50);
		g2.addScore(37);
		assertEquals(122, g2.sum());
	}
	
	@Test
	void testMinimum() {	
		g1.addScore(78);
		g1.addScore(87);
		g1.addScore(1.5);
		g1.addScore(45);
		assertEquals(1.5, g1.minimum());
		g2.addScore(35);
		g2.addScore(50);
		g2.addScore(3.5);
		g2.addScore(37);
		assertEquals(3.5, g2.minimum());
	}
	
	@Test
	void testFinal() {	
		g1.addScore(78);
		g1.addScore(87);
		g1.addScore(1.5);
		g1.addScore(45);
		assertEquals(210.0, g1.finalScore());
		g2.addScore(35);
		g2.addScore(50);
		g2.addScore(3.5);
		g2.addScore(37);
		assertEquals(122.0, g2.finalScore());
	}
	
	
	
	

}
