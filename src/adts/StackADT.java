package adts;

import java.io.Serializable;
import java.util.EmptyStackException;

import utilities.MyStack;

/**
 * Requirements (from M5-StacksQueues page 3, 10)
 */
public interface StackADT<E> extends Serializable {
	
	
	/**
	 * creates an empty stack
	 * @return 
	 */
	public void create();
	
	
	/**
	 * Adds the specified element to the top of this stack
	 * @param element the element to be pushed onto stack
	 */
	public void push(E element) throws NullPointerException;
	

	/**
	 * Returns the top element and removes it from this stack
	 * @return the top element from this stack
	 */
	public E pop() throws EmptyStackException;
	
	
	/**
	 * Returns the top element of this stack
	 * @return the element on the top of this stack
	 */
	public E peek() throws EmptyStackException;
	
	
	/**
	 * Returns true if two stack must contain equal items appearing in the same order
	 * @param E a stack to compare to another stack
	 * @return returns true if two stack must contain equal items appearing in the same order
	 */
	public boolean equals(StackADT<E> that);
	
	
	/**
	 * Returns an iterator over the items contained in this stack. The remove() should not be supported
	 * @return returns an iterator over the items contained in this stack
	 */
	public Iterator<E> iterator();
	
	
	/**
	 * Returns an array containing all of the items in this stack
	 * @return returns an array containing all of the items in this stack
	 */
	public Object[] toArray();
	
	
	/**
	 * Returns an array containing all of the items in this stack
	 * @param copy an array is going to make a copy
	 * @return returns an array containing all of the items in this stack
	 */
	public E[] toArray(E[] copy) throws NullPointerException;
	
	
	/**
	 * Search specified element
	 * @param obj the searched element
	 * @return the index of obj
	 */
	public int search(E obj);
	
	
	/**
	 * Returns the number of elements in this stack
	 * @return the number of elements in this stack
	 */
	public int size();	
	
	
	/**
	 * Returns true if this stack is empty
	 * @return true if this stack is empty
	 */
	public boolean isEmpty();
	
	
	/**
	 * Clear all elements of this stack
	 */
	public void clear();
	
	
	/**
	 * Returns true if this stack contains specified obj
	 * @param obj the searched element
	 * @return returns true if this stack contains specified obj
	 */
	public boolean contains(E obj) throws NullPointerException;
	
	
}
