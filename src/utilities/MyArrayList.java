package utilities;

import java.util.NoSuchElementException;

import adts.Iterator;
import adts.ListADT;

/**
A class that implements a list of objects by using an array.
Entries in a list have positions that begin with 1.
Duplicate entries are allowed.
Template provided by Mohamed Elmenshawy
*/
public class MyArrayList <E> implements ListADT<E>{
    
    private int size; 	//size
    private static final int DEFAULT_CAPACITY = 25;
    //private int list.length = DEFAULT_CAPACITY;
    private E[] list = (E[])new Object[DEFAULT_CAPACITY];
    
    /**
     * Default constructor
     */
    public MyArrayList()
    {
    	
    } // end default constructor
   
    
    /**
     * Initial an array with a specified capacity
     * @param initial_capacity the capacity of an array
     */
    public MyArrayList(int initial_capacity)
    {
    	E[] list = (E[])new Object[DEFAULT_CAPACITY];
    } 
    
    
    /**
     * Returns the size of the array
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Clears the content of array
     */
	@Override
	public void clear() 
	{
	    E[] tempList = (E[])new Object[DEFAULT_CAPACITY];
	    list = tempList;
	    size = 0;
	}

	
	/**
	 * Adds an element at the specified index
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException 
	{
		if (index > size || index < 0)
		{
			throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + size);
		}
		
		if (toAdd == null)
		{
			throw new NullPointerException("Can not add a null value");
		}

		ensureCapacity(size + 1);
		
		for (int i = size; i > index; i--)
		{
			list[i] = list[i - 1];
		}
		
		list[index] = toAdd;
		size++;
		return true;
	}

	
	/**
	 * Makes sure that the capacity of array is enough
	 * @param requireSpace required space for an array
	 */
    private void ensureCapacity(int requireSpace) 
    {
		if (requireSpace >= list.length)
		{
			E[] tempList = (E[])new Object[requireSpace];
			for (int i = 0; i < size; i++)
			{
				tempList[i] = list[i];
			}
			list = tempList;
		}
	} 
    

    /**
     * Adds an element to array
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException 
    {
		if (toAdd == null || toAdd.equals(""))
		{
			throw new NullPointerException("Can not add a null value");
		}

        if(size == 0)
        {
        	list[size] = toAdd;
        }
        else
        {
        	ensureCapacity(size + 1);
        	
        	list[size] = toAdd;
        }
    	
        size++;
        return true;
    }

    
    /**
     * Adds more than one elements into array at one time
     */
	@Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException 
	{
		if (toAdd == null || toAdd.size() == 0)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		ensureCapacity(size + toAdd.size());

		for (int i = 0; i < toAdd.size(); i++)
		{
			list[size + i] = toAdd.get(i);
		}
		
		size = size + toAdd.size();
		
		return true;
    }

	
	/**
	 * Get the content of the specified index
	 */
    @Override
    public E get(int index) throws IndexOutOfBoundsException 
    {
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + size);
		}
		
		return list[index];
    }
    

    /**
     * Removes the element at the specified index
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException 
    {
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + size);
		}
		
		E temp = list[index];
		
		for (int i = index; i < size - 1; i++ )
		{
			list[i] = list[i + 1];
		}
		
		size--;
		
		if (size == 0)
		{
			clear(); 
		}
		return temp;
    }

    
	/**
	 * Removes the specified content of element
	 */
    @Override
    public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		for (int i = 0; i < size; i++)
		{
			if (list[i].equals(toRemove))
			{
				return remove(i);
			}
		}
		
        return null;
    }

 
    /**
     * Replace the content at the specified index
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + size);
		}
		
		list[index] = toChange;
		
		return toChange;
    }

 
    /**
     * Checks if the array is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

 
    /**
     * Examines if a specified content exists in an array 
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		for (int i = 0; i < size; i++)
		{
			if (list[i].equals(toFind))
			{
				return true;
			}
		}
		
        return false;
    }

 
    /**
     * Converts an array into array
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
    	if (toHold == null)
		{
			throw new NullPointerException("Can not add a null value");
		}
		
		
    	list = (E[]) new Object[toHold.length];
			
		for (int i = 0; i < toHold.length; i++ )
		{
			list[i] = toHold[i];
		}
			
		size = list.length;
		
		return list;
    }


    /**
     * Convert an array into object array
     */
    @Override
    public Object[] toArray() {
		if (isEmpty())
		{
			return null;
		}
		
		Object[] obj = new Object[size];
		
		for (int i = 0; i < size; i++)
		{
			obj[i] = list[i];
		}
		
		return obj;
    }

    
    /**
     *  Traverses a DLL in a particular order
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
			return (E) list[current++];
		}
    }
}
