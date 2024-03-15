import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDoubleLinkedList_Student_Test {
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	BasicDoubleLinkedList<String> linkedString;
	StringComparator comparatorS;

	@BeforeEach
	void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hi");
		linkedString.addToEnd("There");
		comparatorS = new StringComparator();
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedString=null;
		comparatorS=null;
	}

	@Test
	void testGetSize() {
		assertEquals(2,linkedString.getSize());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Hi", linkedString.getFirst());
		linkedString.addToFront("Bonjour");
		assertEquals("Bonjour", linkedString.getFirst());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("There", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Hi", linkedString.getFirst());
		linkedString.addToFront("Hello");
		assertEquals("Hello", linkedString.getFirst());
	}
	
	@Test
	public void testGetLast() {
		assertEquals("There", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<String> list;
		linkedString.addToFront("ABC");
		list= linkedString.toArrayList();
		assertEquals("ABC", list.get(0));
	}
	
	@Test
	public void testRetrieveFirstElement() {
		
		assertEquals("Hi", linkedString.getFirst());
		linkedString.addToFront("New Thing");
		assertEquals("New Thing", linkedString.getFirst());
		assertEquals("New Thing", linkedString.retrieveFirstElement());
		assertEquals("Hi",linkedString.getFirst());
		assertEquals("Hi", linkedString.retrieveFirstElement());
		assertEquals("There",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("There", linkedString.getLast());
		linkedString.addToEnd("New End");
		assertEquals("New End", linkedString.getLast());
		assertEquals("New End", linkedString.retrieveLastElement());
		assertEquals("There",linkedString.getLast());
	}
	
	@Test
	public void testRemove() {
		assertEquals("Hi", linkedString.getFirst());
		linkedString.remove("Hi", comparatorS);
		assertEquals("There",linkedString.getFirst());
	}


}
