import java.util.Comparator;
import java.util.ListIterator;

/**
 * This a generic sorted double linked-list that implements the Comparator Interface. 
 * It extends BasicDoubleLinkedList class.
 * @param <T> the generic type
 * @author FATIMA MBODJI
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> implements Comparator<T>{

	protected Comparator<T> comparator ;
	
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		super();
		this.comparator = compareableObject;
	}
	
	/**
	 * Adds the specified element at the correct position in the sorted list. 
	 * @param data the data of the Node to be added to the list
	 */
	public void add(T data) {
		Node<T> newNode = new Node(data);
		if ( head==null) 
		{
			head = tail = newNode;
			size++;
		}
		else 
		{
			Node<T> currentNode = head;
			while (currentNode!=null)
			{
				if( this.comparator.compare(data, currentNode.getData()) < 0)
				{
					if (currentNode == head)
					{
						newNode.next = head;
						head.prev = newNode;
						head = newNode;
					}
					else
					{
						Node previousNode = currentNode.prev;
						previousNode.next = newNode;
						newNode.prev = previousNode;
						newNode.next = currentNode;
						currentNode.prev = newNode;
					}
					size++;
					return;
				}
				currentNode = currentNode.next;
			}
			//if the currentNode becomes null, add to the end
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			size ++;
		}
	}
	
	/**
	 * This method implements the iterator operation by calling the super class iterator method..
	 * @return an iterator positioned at the head of the list
	 */
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	/**
	 * This method implements the remove operation by calling the super class remove method.
	 * @param data the data to be removed
	 * @return a node containing the removed data, or null if not found
	 */
	public Node<T> remove(T data) {
		return super.remove(data, this.comparator);
	}
	
	/**
	 * This operation is invalid for a sorted list. 
	 * An UnsupportedOperationException will be generated 
	 * @return
	 * @throws UnsupportedOperationException
	 */
	public int addToFront() throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	/**
	 * This operation is invalid for a sorted list. 
	 * An UnsupportedOperationException will be generated 
	 * @return
	 * @throws UnsupportedOperationException
	 */
	public int addToEnd() throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}

	
	
	
	

}
