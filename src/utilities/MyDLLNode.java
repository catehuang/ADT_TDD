package utilities;

public class MyDLLNode<E> {
	private E element;
	private MyDLLNode<E> prev, next;
	
	public MyDLLNode(E element, MyDLLNode<E> prev, MyDLLNode<E> next)
	{
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
}
