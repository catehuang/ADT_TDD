package utilities;

import java.util.NoSuchElementException;

import adts.Iterator;
import adts.QueueADT;

public class MyQueue<E> implements QueueADT<E> 
{

	private int length = 0;
	private MyDLL myDll;
	
	public MyQueue( ) {
		create();
	}
	
	/**
	 * Creates an empty queue
	 */
	@Override
	public void create() 
	{
		myDll = new MyDLL();
	}

	/**
	 * Adds an element to the rear of the queue
	 */
	@Override
	public void enqueue(E element) 
	{
		myDll.add(element);
	}

	/**
	 * Removes the first element of the queue
	 */
	@Override
	public E dequeue() {
		return (E) myDll.remove(0);
	}

	/**
	 * Returns the element at the front of this queue
	 */
	@Override
	public E peek() {
		if (isEmpty())
		{
			return null;
		}
		else
		{
			return (E) myDll.get(0);
		}	
	}

	/**
	 * Returns true if two queues contain equal items appearing in the same order
	 */
	@Override
	public boolean equals(QueueADT<E> that) {
		Object[] array1 = new Object[that.size()];
		array1 = that.toArray();

		Object[] array2 = new Object[myDll.size()];
		array2 = myDll.toArray();
		
		if (that.size() != myDll.size())
		{
			return false;
		}
		
		for (int i = 0; i < myDll.size(); i++)
		{
			System.out.println(array1[i] + " vs. " + array2[i]);
			if (! array1[i].equals(array2[i]))
			{
				return false;
			}
		}
		
		return true;
	}

	/**
	 *  Returns an iterator over the items contained in this queue
	 */
	@Override
	public Iterator<E> iterator() {
		return myDll.iterator();
    }

    /**
     * Returns an array containing all of the items in this queue
     */
	@Override
	public Object[] toArray() {
		return myDll.toArray();
	}

	/**
	 * Returns an array containing all of the items in this queue
	 */
	@Override
	public E[] toArray(E[] copy) {
		return (E[]) myDll.toArray(copy);
	}

	/**
	 * Checks if this queue is full (we don't implement it)
	 */
	@Override
	public boolean isFull() {
		// option method and we chosen not to have this.
		// Because this queue is linked list based which means the size is not fixed. 
		return false;
	}

	/**
	 * Returns the number of elements in this queue
	 */
	@Override
	public int size() {
		return myDll.size();
	}

	/**
	 * Checks if this queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return myDll.isEmpty();
	}

	/**
	 * Clears all elements in the queue
	 */
	@Override
	public void dequeueAll() {
		myDll.clear();
	}
	
}
