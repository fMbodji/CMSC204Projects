import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This is a generic double-linked list that implements the Iterable interface 
 * It relies on a head (reference to first element of the list) 
 * and tail (reference to the last element of the list).
 * It has the following entities: 
 * an inner class Node which has only three fields: data, the prev and next references, 
 * an inner class DoubleLinkedListIterator that implements ListIterator (for the iterator method)
 * @param <T> the generic type
 * @author FATIMA MBODJI
 */
	
public class BasicDoubleLinkedList<T> implements Iterable<T>, Comparator<T>{
	
	protected Node<T> head;
	protected Node<T> tail;
	protected int size;
	 
	/**
	 * Constructor initializing the attributes to their default value 
	 */
	BasicDoubleLinkedList(){
		head = tail = null;
		size = 0;
	}
	
	/**
	 * Get the size of the list
	 * @return size 
	 */
	public int getSize() {
		return this.size;
	}

	
	/**
	 * Adds an element to the front of the list and updated the size of the list
	 * @param data the data to be added to the list
	 */
	public void addToFront(T data) { 
		Node newNode = new Node(data);
		if (getSize()== 0)
		{
			this.head = this.tail = newNode;
		}
		else
		{
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
			
		}
		size++;
	}
	
	
	/**
	 * Adds an element to the end of the list and updated the size of the list
	 * @param data the data to be added to the list
	 */
	public void addToEnd(T data) {
		Node newNode = new Node(data);
		if (getSize()== 0)
		{
			this.head = this.tail = newNode;
		}
		else
		{
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}
		size++;
	}
	
	/**
	 * Gets (but does not remove) the first element of the list 
	 * @return the data element, or null if the list is empty
	 */
	public T getFirst() {
		if (getSize()== 0)
		{
			return null;
		}
		else
		{
			return this.head.getData();
		}
	}
	
	
	/**
	 * Gets (but does not remove) the last element of the list 
	 * @return the data element, or null if the list is empty
	 */
	public T getLast() {
		if (getSize()== 0)
		{
			return null;
		}
		else
		{
			return this.tail.getData();
		}
	}
	
	
	/**
	 * Removes and returns the first element of the list 
	 * @return the data element, or null if the list is empty
	 */
	public T retrieveFirstElement() {
		if ( getSize()==0 )
		{
			return null;
		}
		else 
		{
			T data = this.head.getData();
			if (getSize()== 1)
			{
				this.head = this.tail = null;
			}
			else
			{
				this.head = this.head.next;
				//this.head.prev = null;
			}
			this.size--;
			return data;
		}
	}
	
	
	/**
	 * Removes and returns the last element of the list 
	 * @return the data element, or null if the list is empty
	 */
	public T retrieveLastElement() {
		if ( getSize()==0 )
		{
			return null;
		}
		else 
		{
			T data = this.tail.getData();
			if (getSize()== 1)
			{
				this.head = this.tail = null;
			}
			else
			{
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			this.size--;
			return data;
		}
	}
	
	
	//Creating a comparator object using anonymous inner class since we cannot instantiate an interface
	public Comparator<T> comparator = new Comparator<T>(){
		@Override 
		public int compare(T targetData, T data) {
			if (targetData.equals(data))
				return 0;
			else
				return -1;
		}
	};
		
	/**
	 * Romoves a specified Node
	 * @param targetData the data to be removed
	 * @param comparator the comparator object
	 * @return the removed node, null if not found
	 */	
	public Node remove(T targetData, Comparator<T> comparator){
		Node currentNode = head;
		T data;
		while( currentNode != null ) 
		{
			data = (T) currentNode.getData();
			if( comparator.compare(targetData, data)== 0 )
			{
				if( currentNode.prev == null )
				{
					retrieveFirstElement();
				}
				else if( currentNode.next == null )
				{
					retrieveLastElement();
				}
				else 
				{
					Node previousNode = currentNode.prev;
					Node nextNode = currentNode.next;
					previousNode.next = nextNode ;
					nextNode.prev = previousNode;
					this.size--;
					return currentNode;
				}	
				
			}	
			currentNode = currentNode.next;
		}
		return null;
	}
		
	/**
	 * 
	 */
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	
	/**
	 * Converts the Double Linked list to an ArrayList 
	 * @return an arraylist of all the items in the Double Linked list 
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<>();
		Node currentNode = head;
		while (currentNode != null)
		{
			list.add((T) currentNode.getData());
			currentNode = currentNode.next;
		}
		return list;
	}
	

	@Override
	public int compare(T targetData, T data) {
		if (targetData.equals(data))
			return 0;
		else
			return -1;
	}
	
	
	
	//THE NODE CLASS
	 class Node<T>{
		T data;
		Node<T> prev;
		Node<T> next;
		
		Node(T data)
		{
			this.data = data;
		}

		public T getData() {
			return this.data; 
		}

	}
	
	
	
	//THE DOUBLE LINKED LIST ITERATOR CLASS
	 class DoubleLinkedListIterator<T> implements ListIterator<T>{
		BasicDoubleLinkedList<T>.Node<T> currentNode; 
		
		DoubleLinkedListIterator(){
			this.currentNode =  (BasicDoubleLinkedList<T>.Node<T>) head;
		}
		
		/**
		 * Not required in the project - created for my tests
		 * Function to check the current element
		 * @return the current element of the list
		 */
		public T getCurrent() {
			return this.currentNode.getData();
		}
		
		/**
		 * Function to check if there is a next element
		 * @return true if there is a next element, false otherwise
		 */
		@Override
		public boolean hasNext() {
			if(currentNode.next != null) {
				return true;
			}
			return false;
		}

		/**
		 * Function to get the next element of the list
		 * @return the next element of the list
		 * @throws NoSuchElementException if there is no element after this current
		 */
		public T next() {
			try {
		        if ( !hasNext() ) 
		        {
		            throw new NoSuchElementException("There is no next element");
		        } 
		        else 
		        {
		            T data = currentNode.next.getData();
		            currentNode = currentNode.next;
		            return data;
		        }
		    } catch (NoSuchElementException e) {
		        //No next element found
		        return null;
		    }
		}
		

		/**
		 * Function to check if there is a previous element
		 * @return true if there is a previous element, false otherwise
		 */
		public boolean hasPrevious() {
			if(currentNode.prev != null) {
				return true;
			}
			return false;
		}

		/**
		 * Function to get the previous element of the list
		 * @return the previous element of the list
		 * @throws NoSuchElementException if there is no element before this current
		 */
		public T previous() {
			try {
				if ( !hasPrevious() ) 
				{
			        throw new NoSuchElementException("There is no previous element");
			    } 
				else 
			    {
					T data = currentNode.prev.getData();
					currentNode = currentNode.prev;
					return data;
				}
		    }catch (NoSuchElementException e) {
		        //No previous element found
		        return null;
		    }
		}
			
		@Override
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(Object e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void add(Object e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
	}


}
