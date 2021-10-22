package utilities;

import java.util.NoSuchElementException;

import adts.Iterator;
import adts.ListADT;

/**
 * Linked List based
 *
 * @param <E> Element
 */
public class MyDLL<E> implements ListADT<E>
{
	private MyDLLNode<E> head;
	private MyDLLNode<E> tail;
	private int size = 0;
	
	public MyDLL()
	{
		this.head = this.tail = null;
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public void clear() 
	{
		this.tail = this.head = null;
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException 
	{
		if (toAdd == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		if (index > size || index < 0)
		{
			throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + size);
		}
		
		MyDLLNode<E> newNode = new MyDLLNode(toAdd);
		
		if (index == 0)
		{
			if (isEmpty())
			{
				this.head = newNode;
				this.tail = newNode;
			}
			else
			{
				// head
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			}
		}
		else if (index == size || index == size - 1)
		{
			// tail
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		else
		{
			MyDLLNode<E> curr = head;
			for (int i = 0; i < index; i++)
			{
				curr = curr.getNext();
			}
			curr.getPrev().setNext(newNode);
			newNode.setPrev(curr.getPrev());
			curr.setPrev(newNode);
			newNode.setNext(curr);
		}
		
		size++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException 
	{
		if (toAdd == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		MyDLLNode<E> newNode = new MyDLLNode(toAdd);
		
		if (isEmpty())
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else
		{
			// tail
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		
		size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException 
	{
		if (toAdd == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		for (int i = 0; i < toAdd.size(); i++)
		{
			MyDLLNode<E> newNode = new MyDLLNode(toAdd.get(i));
			
			if (isEmpty())
			{
				this.head = newNode;
				this.tail = newNode;
			}
			else
			{
				// tail
				tail.setNext(newNode);
				newNode.setPrev(tail);
				tail = newNode;
			}
			
			size++;
		}
	
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException 
	{
		if (index > size - 1 || index < 0)
		{
			throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + size);
		}
		
		if (isEmpty())
		{
			return null;
		} 

		MyDLLNode<E> curr = head;

		for (int i = 0; i < index; i++)
		{
			curr = curr.getNext();
		}

		return curr.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException 
	{
		if (isEmpty()) {
			return null;
		} 
		
		if (index > size - 1 || index < 0)
		{
			throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + size);
		}
		
		MyDLLNode<E> removed = head;
		
		for (int i = 0; i < index; i++)
		{
			removed = removed.getNext();
		}
		
		if (size == 1 && index == size - 1) 
		{
			head = tail = null;
		} 
		else 
		{
			if (index == 0) 
			{
				// head
				head.getNext().setPrev(null);
				head = head.getNext();
			}
			else if (index == size -1)
			{
				// tail
				tail.getPrev().setNext(null);
				tail = tail.getPrev();
			}
			else
			{
				MyDLLNode<E> curr = head;
				for (int i = 0; i < index; i++)
				{
					curr = curr.getNext();
				}
				curr.getPrev().setNext(curr.getNext());
				curr.getNext().setPrev(curr.getPrev());	
			}
		}
		size--;	
		return removed.getElement();
	}

	@Override
	public E remove(E toRemove) throws NullPointerException 
	{
		if (isEmpty()) {
			return null;
		} 
		
		if (toRemove == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		MyDLLNode<E> curr = head;
		int index = 0;
		
		for (int i = 0; i < size; i++)
		{
			// looking for the first occurrence of element in this DLL
			if (curr.getElement().equals(toRemove) && index == 0) {
				index = i;
			}
			else
			{
				curr = curr.getNext();
			}
		}
		
		return remove(index);
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException
	{
		if (toChange == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		if (index > size - 1 || index < 0)
		{
			throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + size);
		}
		
		MyDLLNode<E> curr = head;
		for (int i = 0; i < index; i++)
		{
			curr = curr.getNext();
		}
		
		curr.setElement(toChange);
		return curr.getElement();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException 
	{
		if (toFind == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		MyDLLNode<E> curr = head;
		
		for (int i = 0; i < size; i++)
		{
			if (curr.getElement().equals(toFind)) 
			{
				return true;
			}
			else
			{
				curr = curr.getNext();
			}
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException 
	{
		if (toHold == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		clear();
		
		E[] myDll = (E[])new Object[toHold.length];
		
		for (int i = 0; i < toHold.length; i++ )
		{
			myDll[i] = toHold[i];
			size++;
		}
			
		return myDll;
	}

	@Override
	public Object[] toArray() 
	{
		
		if (isEmpty())
		{
			return null;
		}
		
		Object[] obj = new Object[size];
		
		MyDLLNode<E> curr = head;
		
		for (int i = 0; i < size; i++)
		{
			obj[i] = curr.getElement();
			curr = curr.getNext();
		}
		
		return obj;
	}

	@Override
    public Iterator<E> iterator() {
        
        return new MyIterator();
    }
    
    //inner class
    private class MyIterator<E> implements adts.Iterator<E>
    {
    	private int current = 0;
    	
		@Override
		public boolean hasNext() 
		{
			return current < size;
		}

		@Override
		public E next() throws NoSuchElementException 
		{
			return (E) tail.getNext();
		}
    }
}
