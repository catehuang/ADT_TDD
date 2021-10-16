package utilities;

/**
 * Requirements (from M5-StacksQueues page 3, 10)
 */
public interface StackADT<E> {
	
	
	/**
	 * creates an empty stack
	 */
	public void create();
	
	
	/**
	 * Adds the specified element to the top of this stack
	 * @param element the element to be pushed onto stack
	 */
	public void push(E element);
	

	/**
	 * Returns the top element and removes it from this stack
	 * @return the top element from this stack
	 */
	public E pop();
	
	
	/**
	 * Returns the top element of this stack
	 * @return the element on the top of this stack
	 */
	public E peek();
	
	
	/**
	 * Returns true if two stack must contain equal items appearing in the same order
	 * @param E a stack to compare to another stack
	 * @return returns true if two stack must contain equal items appearing in the same order
	 */
	boolean equals(StackADT<E> that);
	
	
	/**
	 * Returns an iterator over the items contained in this stack. The remove() should not be supported
	 * @return returns an iterator over the items contained in this stack
	 */
	Iterator<E> iterator();
	
	
	/**
	 * Returns an array containing all of the items in this stack
	 * @return returns an array containing all of the items in this stack
	 */
	Object[] toArray();
	
	
	/**
	 * Returns an array containing all of the items in this stack
	 * @param copy an array is going to make a copy
	 * @return returns an array containing all of the items in this stack
	 */
	E[] toArray(E[] copy);
	
	
	/**
	 * Search specified element
	 * @param obj the searched element
	 * @return the index of obj
	 */
	int search(E obj);
	
	
	/**
	 * Returns the number of elements in this stack
	 * @return the number of elements in this stack
	 */
	public int size();	
	
	
	/**
	 * Returns true if this stack is empty
	 * @return true if this stack is empty
	 */
	boolean isEmpty();
	
	
	/**
	 * Clear all elements of this stack
	 */
	public void clear();
	
	

	
	
	/**
	 * Returns true if this stack contains specified obj
	 * @param obj the searched element
	 * @return returns true if this stack contains specified obj
	 */
	boolean contains(E obj);
	
	
}
