import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SortedDoubleLinkedList_Student_Test {

	private class StringComparator implements Comparator<String>
	{
		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	StringComparator comparatorS;
	SortedDoubleLinkedList<String> sortedLinkedString;
	

	@BeforeEach
	void setUp() throws Exception {
		comparatorS = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparatorS);
		sortedLinkedString.addToEnd("Hi");
		sortedLinkedString.addToEnd("There");
	}

	@AfterEach
	void tearDown() throws Exception {
		sortedLinkedString=null;
		comparatorS=null;
	}

	@Test
	void testGetSize() {
		assertEquals(2,sortedLinkedString.getSize());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Hi", sortedLinkedString.getFirst());
		try {
			sortedLinkedString.addToFront("New");
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("There", sortedLinkedString.getLast());
		try {
			sortedLinkedString.addToEnd("End");
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Hi", sortedLinkedString.getFirst());
		sortedLinkedString.addToFront("Hello");
		assertEquals("Hello", sortedLinkedString.getFirst());
	}
	
	@Test
	public void testGetLast() {
		assertEquals("There", sortedLinkedString.getLast());
		sortedLinkedString.addToEnd("End");
		assertEquals("End", sortedLinkedString.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<String> list;
		sortedLinkedString.addToFront("ABC");
		list= sortedLinkedString.toArrayList();
		assertEquals("ABC", list.get(0));
	}
	
	@Test
	public void testRetrieveFirstElement() {
		
		assertEquals("Hi", sortedLinkedString.getFirst());
		sortedLinkedString.addToFront("New Thing");
		assertEquals("New Thing", sortedLinkedString.getFirst());
		assertEquals("New Thing", sortedLinkedString.retrieveFirstElement());
		assertEquals("Hi",sortedLinkedString.getFirst());
		assertEquals("Hi", sortedLinkedString.retrieveFirstElement());
		assertEquals("There",sortedLinkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("There", sortedLinkedString.getLast());
		sortedLinkedString.addToEnd("New End");
		assertEquals("New End", sortedLinkedString.getLast());
		assertEquals("New End", sortedLinkedString.retrieveLastElement());
		assertEquals("There",sortedLinkedString.getLast());
	}
	
	@Test
	public void testRemove() {
		assertEquals("Hi", sortedLinkedString.getFirst());
		sortedLinkedString.remove("Hi", comparatorS);
		assertEquals("There",sortedLinkedString.getFirst());
	}

}
