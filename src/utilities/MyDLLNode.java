package utilities;

public class MyDLLNode<E> {
	private E element;
	private MyDLLNode<E> prev, next;
	
	/**
	 * Constructor for initiating a node with content and predesessor and successor
	 * @param element the content of node
	 * @param prev predecessor
	 * @param next successor
	 */
	
	
	public MyDLLNode(E element, MyDLLNode<E> prev, MyDLLNode<E> next)
	{
		super();
		this.element = element;
		this.prev = prev;
		this.next = next;
	}

	public MyDLLNode() {
		super();
	}

	/**
	 * Constructor for initiating a node with content 
	 * @param element the content of node
	 */
	public MyDLLNode(E element) {
		super();
		this.element = element;
		this.prev = null;
		this.next = null;
	}

	/**
	 * Get the content of a node
	 * @return the content of a node
	 */
	public E getElement() {
		return element;
	}

	/**
	 * Set the content of a node
	 * @param element the content of a node
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * Get the previous node
	 * @return the previous node
	 */
	public MyDLLNode<E> getPrev() {
		return prev;
	}

	/**
	 * Set the previous node
	 * @param prev the previous node
	 */
	public void setPrev(MyDLLNode<E> prev) {
		this.prev = prev;
	}

	/**
	 * Get the next node
	 * @return the next node
	 */
	public MyDLLNode<E> getNext() {
		return next;
	}

	/**
	 * Set the next node
	 * @param next the next node
	 */
	public void setNext(MyDLLNode<E> next) {
		this.next = next;
	}
	
}
