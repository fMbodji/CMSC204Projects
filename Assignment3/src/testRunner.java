import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;


public class testRunner {
	
	public static void main(String[] args) {
		BasicDoubleLinkedList<String> linkedString =  new BasicDoubleLinkedList<String>();
		
		linkedString.addToEnd("Hello");
		linkedString.addToEnd("World"); 
		linkedString.addToEnd("End");

		
		class StringComparator implements Comparator<String>
		{
			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1); 
			}
			
		}
		StringComparator comparator = new StringComparator();
		linkedString.remove("End", comparator );
		System.out.println(linkedString.getLast());
		System.out.println("");
		
		String a ="Ford, F150, 2005";
		String b ="Jeep, Renegade, 2005";
		String c ="Honda, Civic, 2005";
		String d ="Subaru, Outback, 2005";
		String e ="Chevrolet, Silverado, 2005";
		String f ="Chrysler, PTCruiser, 2005";
		
		linkedString.addToFront(a);
		linkedString.addToFront(b);
		
		ListIterator<String> iteratorString = linkedString.iterator();	
		System.out.println(iteratorString.previous());
		System.out.println(iteratorString.next());
		System.out.println(iteratorString.next());
		System.out.println(iteratorString.next());
		System.out.println(iteratorString.next());
		System.out.println(iteratorString.previous());
		System.out.println(iteratorString.previous());
		System.out.println("");
		System.out.println("");
		
		//////////////////////////////////////////////////////////////////////////////////////
		class DoubleComparator implements Comparator<Double>
		{
			@Override
			public int compare(Double arg0, Double arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1);
			}
			
		}
		DoubleComparator comparatorD = new DoubleComparator();
		SortedDoubleLinkedList<Double> sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);

		sortedLinkedDouble.add((Double)5.0);
		sortedLinkedDouble.add((Double)10.0);
		sortedLinkedDouble.add((Double)8.0);
		sortedLinkedDouble.add((Double)2.0);
		System.out.println("Sorted List");
		System.out.println("First:" +  sortedLinkedDouble.getFirst());
		System.out.println("Last: " + sortedLinkedDouble.getLast());
		System.out.println("");
		
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		iterator = sortedLinkedDouble.iterator();
		System.out.println("Has Next: " + iterator.hasNext());
		System.out.println( iterator.next());
		System.out.println( iterator.next());
		System.out.println( iterator.next());
		System.out.println("Has Next: " + iterator.hasNext());
		System.out.println("Has Previous: " + iterator.hasPrevious());
		System.out.println( iterator.previous());
		System.out.println("");
		
		System.out.println(sortedLinkedDouble.getSize());
		sortedLinkedDouble.remove(5.0, comparatorD);
		iterator = sortedLinkedDouble.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(sortedLinkedDouble.getSize());
		
	}

}
