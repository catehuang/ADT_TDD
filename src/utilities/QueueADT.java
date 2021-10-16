package utilities;

/**
 * Requirements (from M5-StacksQueues page 19, 23)
 */
public interface QueueADT<E> {
	
	/**
	 * creates an empty queue
	 */
	public void create();
	
	/**
	 * Adds one element to the rear of this queue
	 * @param element the element to be added to the rear of the queue
	 */
	public void enqueue(E element);
	
	
	/**
	 * Removes and returns the element at the front of this queue
	 * @return the element at the front of this queue
	 */
	public E dequeue();
	
	
	/**
	 * Returns the element at the front of this queue
	 * @return returns the element at the front of this queue
	 */
	public E peek();

	/**
	 * Returns true if two queues contain equal items appearing in the same order
	 * @param queue compared queue
	 * @return returns true if two queues contain equal items appearing in the same order
	 */
	public boolean equals(QueueADT<E> that); 
	
	
	/**
	 * Returns an iterator over the items contained in this stack
	 * @return returns an iterator over the items contained in this stack
	 */
	public Iterator<E> iterator();
	
	
	/**
	 * Returns an array containing all of the items in this queue
	 * @return returns an array containing all of the items in this queue
	 */
	public Object[] toArray();
	
	
	/**
	 * Returns an array containing all of the items in this queue
	 * @param copy the original queue 
	 * @return returns an array containing all of the items in this queue
	 */
	public E[] toArray(E[] copy);
	 
	
	/**
	 * Returns true if the queue is full. Optional method if the queue is fixed size
	 * @return returns true if the queue is full
	 */
	public boolean isFull();
	
	
	/**
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size();
	
	
	/**
	 * Returns true if this stack is empty
	 * @return true if this stack is empty
	 */
	public boolean isEmpty();
	
	
	/**
	 * Clear all elements of this queue
	 */
	public void dequeueAll();
	
	
}
