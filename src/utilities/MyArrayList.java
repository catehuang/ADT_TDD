package utilities;

/**
A class that implements a list of objects by using an array.
Entries in a list have positions that begin with 1.
Duplicate entries are allowed.
Template provided by Mohamed Elmenshawy
*/
public class MyArrayList <E> implements ListADT<E>{
    
    private E[] list;   // Array of list entries; ignore list[0]
    private int numberOfEntries; 	//size
    private static final int DEFAULT_CAPACITY = 25;
    private int capacity = DEFAULT_CAPACITY;
    
    public MyArrayList()
    {
        E[] tempList = (E[])new Object[capacity];
        list = tempList;
        capacity = capacity;
        numberOfEntries = 0;
    } // end default constructor
   
    public MyArrayList(int initialCapacity)
    {
      // The cast is safe because the new array contains null entries
      E[] tempList = (E[])new Object[initialCapacity];
      list = tempList;
      capacity = initialCapacity;
      numberOfEntries = 0;
      
    } // end constructor

 
    @Override
    public int size() {
        return numberOfEntries;
    }

	@Override
	public void clear() 
	{
	    E[] tempList = (E[])new Object[capacity];
	    list = tempList;
	    numberOfEntries = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException 
	{
		if (index >= numberOfEntries || index < 0)
		{
			return false;
			//throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + numberOfEntries);
		}
		
		if (toAdd == null)
		{
			return false;
			//throw new NullPointerException("Can not add a null value");
		}

		ensureCapacity(numberOfEntries + 1);
		
		for (int i = numberOfEntries; i > index; i--)
		{
			list[i] = list[i - 1];
		}
		
		list[index] = toAdd;
		numberOfEntries++;
		return true;
	}

    private void ensureCapacity(int requireSpace) 
    {
		if (requireSpace > capacity)
		{
			E[] tempList = (E[])new Object[requireSpace];
			for (int i = 0; i < numberOfEntries; i++)
			{
				tempList[i] = list[i];
			}
			
			list = tempList;
			capacity = requireSpace;
		}
		
	} 

    @Override
    public boolean add(E toAdd) throws NullPointerException 
    {
		if (toAdd == null || toAdd.equals(""))
		{
			return false;
			//throw new NullPointerException("Can not add a null value");
		}

        if(numberOfEntries == 0)
        {
        	list[numberOfEntries] = toAdd;
        }
        else
        {
        	ensureCapacity(numberOfEntries + 1);
        	
        	list[numberOfEntries] = toAdd;
        }
    	
        numberOfEntries++;
        return true;
    }

	@Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException 
	{
		if (toAdd == null || toAdd.size() == 0)
		{
			return false;
			//throw new NullPointerException("Can not add a null value");
		}
		
		ensureCapacity(numberOfEntries + toAdd.size());

		for (int i = 0; i < toAdd.size(); i++)
		{
			list[numberOfEntries + i] = toAdd.get(i);
		}
		
		numberOfEntries = numberOfEntries + toAdd.size();
		
		return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException 
    {
		if (index < 0 || index >= numberOfEntries)
		{
			return null;
			//throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + numberOfEntries);
		}
		
		return list[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException 
    {
		if (index < 0 || index >= numberOfEntries)
		{
			return null;
			//throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + numberOfEntries);
		}
		
		E temp = list[index];
		
		for (int i = index; i < numberOfEntries - 1; i++ )
		{
			list[i] = list[i + 1];
		}
		
		numberOfEntries--;
		return temp;
    }

 

    @Override
    public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null)
		{
			return null;
			//throw new NullPointerException("Can not add a null value");
		}
		
		for (int i = 0; i < numberOfEntries; i++)
		{
			if (list[i].equals(toRemove))
			{
				return remove(i);
			}
		}
		
        return null;
    }

 
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null)
		{
			return null;
			//throw new NullPointerException("Can not add a null value");
		}
		
		if (index < 0 || index >= numberOfEntries)
		{
			return null;
			//throw new IndexOutOfBoundsException ("Index " + index + ", Size: " + numberOfEntries);
		}
		
		list[index] = toChange;
		
		return toChange;
    }

 
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

 

    @Override
    public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null)
		{
			return false;
			//throw new NullPointerException("Can not add a null value");
		}
		
		for (int i = 0; i < numberOfEntries; i++)
		{
			if (list[i].equals(toFind))
			{
				return true;
			}
		}
		
        return false;
    }

 
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
    	if (toHold == null)
		{
    		return null;
			//throw new NullPointerException("Can not add a null value");
		}
		
		
    	list = (E[]) new Object[toHold.length];
			
		for (int i = 0; i < toHold.length; i++ )
		{
			list[i] = toHold[i];
		}
			
		numberOfEntries = list.length;
		capacity = toHold.length;
		
		return list;
    }


    @Override
    public Object[] toArray() {
		if (list == null)
		{
			return null;
		}
		
		Object[] obj = new Object[numberOfEntries];
		
		for (int i = 0; i < numberOfEntries; i++)
		{
			obj[i] = list[i];
		}
		
		return obj;
    }

 

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
