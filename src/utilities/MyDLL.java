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
	
	/**
	 * Default constructor to init DLL
	 */
	public MyDLL()
	{
		this.head = this.tail = null;
	}

	/**
	 * Find out the size of this DLL
	 * @return the number of nodes in this DDL
	 */
	@Override
	public int size() 
	{
		return size;
	}

	/**
	 * Clear all nodes
	 */
	@Override
	public void clear() 
	{
		this.tail = this.head = null;
		size = 0;
	}

	/**
	 * Adds a node to a specified index
	 * @param index a specified index to put the new node
	 * @param toAdd the content of the new node would be
	 * @return succede or failed to add the node
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException 
	{
		if (toAdd == null || toAdd.equals(""))
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

	/**
	 * Adds a node to this DLL
	 * @param toAdd the content of the new node would be
	 * @return succede or failed to add the node
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException 
	{
		if (toAdd == null  || toAdd.equals(""))
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

	/**
	 * Adds all nodes in the toAdd to this DLL
	 * @param toAdd those nodes to be added into DLL
	 * @return true if add these nodes to DLL successfully
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException 
	{
		if (toAdd == null  || toAdd.equals(""))
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

	/**
	 * Get the content at the specified index
	 * @param index the specified index for visiting
	 * @return the content at the index
	 */
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

	/**
	 * Removes the node at the index
	 * @param index the index of a node will be removed
	 * @return the node successfully had been removed
	 */
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

	/**
	 * Removes the node with a specified content
	 * @param toRemove spcified content of a node to be removed 
	 * @return the node successfully had been removed
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException 
	{
		if (isEmpty()) {
			return null;
		} 
		
		if (toRemove == null  || toRemove.equals(""))
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

	/**
	 * Replace the content of node at the specified index
	 * @param index would be replaced index
	 * @param toChange new content of node
	 * @return the new content of node
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException
	{
		if (toChange == null || toChange.equals(""))
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

	/**
	 * Checks if this DLL is empty
	 * @return true if this DLL is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Checks if this DLL contains a specific content of node
	 * @param toFind a specific content of node
	 * @return true if a specific content of node existed in this DLL
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException 
	{
		if (toFind == null || toFind.equals(""))
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

	/**
	 * Converts an array into array
	 * @param toHold the array wanted to be converted
	 * @return the converted array
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException 
	{
		if (toHold == null || toHold.equals(""))
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

	/**
	 * Convert a DLL into object array
	 * @return an object array converted from a DLL
	 */
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

	/**
	 * Traverses a DLL in a particular order
	 */
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
