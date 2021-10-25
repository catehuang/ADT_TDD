package utilities;


import static org.junit.Assert.*;

import org.junit.*;

import adts.Iterator;
import utilities.MyDLLNode;

public class MyDLLTests<E>  {

	private MyDLL myDLL;
	
	/**
	 * @throws Exception if something wrong when assign and initialize MyArrayList
	 */
	@Before
	public void setUp() throws Exception
	{
		this.myDLL = new MyDLL();
	}
	
	/**
	 * @throws Exception if clear method is failed
	 */
	@After
	public void tearDown() throws Exception
	{
		this.myDLL.clear();
	}
	
    @Test
    public void testSize() {
        assertEquals(0, myDLL.size());
    }
    
    @Test
    public void testEmpty() {
    	assertTrue(myDLL.isEmpty());
    	myDLL.add("A CAR");  
    	assertFalse(myDLL.isEmpty());
    	myDLL.remove(0);
    	assertTrue(myDLL.isEmpty());
    }
    
    @Test
    public void testClear() {
    	myDLL.add("A CAR");    	 
    	myDLL.add("A TRUCK");   
    	assertEquals(2, myDLL.size());
    	myDLL.clear();
    	assertEquals(0, myDLL.size());
    	assertTrue(myDLL.isEmpty());
    }
    
    @Test
    public void testAdd() {
    	myDLL.add("A CAR");
    	assertEquals(1, myDLL.size());
    	 
    	myDLL.add("A TRUCK");
    	assertEquals(2, myDLL.size());
    	
    	myDLL.add(0, "A SUV");
    	assertEquals(3, myDLL.size());
    	
    	myDLL.add(3, "A VAN");
    	assertEquals(4, myDLL.size());
    	
    	assertEquals("A SUV", myDLL.get(0));
    	assertEquals("A CAR", myDLL.get(1));
    	assertEquals("A TRUCK", myDLL.get(2));
    	assertEquals("A VAN", myDLL.get(3));
    	
    	try 
    	{
    		myDLL.add("");
    	} 
    	catch (NullPointerException e)
    	{
    		assertTrue(true);
    	}
    	
    	try 
    	{
    		myDLL.add(0, "");
    	} 
    	catch (NullPointerException e)
    	{
    		assertTrue(true);
    	}
    	
    	try 
    	{
    		myDLL.add(5, "A TRAIN");
    	} 
    	catch (IndexOutOfBoundsException e)
    	{
    		assertTrue(true);
    	}
    }
    
    @Test
    public void testAddAll() {
    	MyDLL tmp = new MyDLL();
    	tmp.add("A CAR");
    	assertEquals(1, tmp.size());
    	 
    	tmp.add("A TRUCK");
    	assertEquals(2, tmp.size());
    	
    	tmp.add(0, "A SUV");
    	assertEquals(3, tmp.size());
    	
    	tmp.add(3, "A VAN");
    	assertEquals(4, tmp.size());
    	
    	myDLL.addAll(tmp);
    	
    	assertEquals(4, myDLL.size());
    	assertEquals("A SUV", myDLL.get(0));
    	assertEquals("A CAR", myDLL.get(1));
    	assertEquals("A TRUCK", myDLL.get(2));
    	assertEquals("A VAN", myDLL.get(3));
    	
    	myDLL.addAll(tmp);
    	assertEquals(8, myDLL.size());
    	assertEquals("A SUV", myDLL.get(0));
    	assertEquals("A VAN", myDLL.get(3));
    	assertEquals("A SUV", myDLL.get(4));
    	assertEquals("A CAR", myDLL.get(5));
    	assertEquals("A TRUCK", myDLL.get(6));
    	assertEquals("A VAN", myDLL.get(7));
    	
    	tmp.clear();
    	try 
    	{
    		myDLL.addAll(tmp);
    	} 
    	catch (NullPointerException e)
    	{
    		assertTrue(true);
    	}
    }
    
    @Test
    public void testGet() {
    	assertNull(myDLL.get(0));
    	
    	myDLL.add("A CAR");
    	assertEquals(1, myDLL.size());
    	 
    	myDLL.add("A TRUCK");
    	assertEquals(2, myDLL.size());
    	
    	myDLL.add(0, "A SUV");
    	assertEquals(3, myDLL.size());
    	
    	myDLL.add(3, "A VAN");
    	assertEquals(4, myDLL.size());
    	
    	assertEquals("A SUV", myDLL.get(0));
    	assertEquals("A CAR", myDLL.get(1));
    	assertEquals("A TRUCK", myDLL.get(2));
    	assertEquals("A VAN", myDLL.get(3));
    	
    	try 
    	{
    		myDLL.get(-1);
    	} 
    	catch (IndexOutOfBoundsException e)
    	{
    		assertTrue(true);
    	}
    	
    	try 
    	{
    		myDLL.get(4);
    	} 
    	catch (IndexOutOfBoundsException e)
    	{
    		assertTrue(true);
    	}
    }
    
    @Test
    public void testRemove() {
    	myDLL.add("A CAR");    	 
    	myDLL.add("A TRUCK");   	
    	myDLL.add(0, "A SUV");
    	myDLL.add(3, "A VAN");
    	assertEquals(4, myDLL.size());
    	
    	myDLL.remove(0); 
    	assertEquals(3, myDLL.size());
    	assertEquals("A CAR", myDLL.get(0));
    	assertEquals("A TRUCK", myDLL.get(1));
    	assertEquals("A VAN", myDLL.get(2));
    	
    	myDLL.remove(2); 
    	assertEquals(2, myDLL.size());
    	assertEquals("A CAR", myDLL.get(0));
    	assertEquals("A TRUCK", myDLL.get(1));

    	myDLL.remove("A TRUCK"); 
    	assertEquals(1, myDLL.size());
    	assertEquals("A CAR", myDLL.get(0));

    	try 
    	{
    		myDLL.remove(1);
    	} 
    	catch (IndexOutOfBoundsException e)
    	{
    		assertTrue(true);
    	}
    	
    	try 
    	{
    		myDLL.remove(-1);
    	} 
    	catch (IndexOutOfBoundsException e)
    	{
    		assertTrue(true);
    	}
    	
    	try 
    	{
    		myDLL.remove("A VAN");
    	} 
    	catch (NullPointerException e)
    	{
    		assertTrue(true);
    	}
    	
    	try 
    	{
    		myDLL.remove(null);
    	} 
    	catch (NullPointerException e)
    	{
    		assertTrue(true);
    	}
    	
    	myDLL.remove(0); 
    	assertEquals(0, myDLL.size());
    	assertTrue(myDLL.isEmpty());
    }
    
    @Test
    public void testSet() {
    	myDLL.add("A CAR");    	 
    	myDLL.add("A TRUCK");   	
    	myDLL.add(0, "A SUV");
    	myDLL.add(3, "A VAN");
    	
    	myDLL.set(0, "A LAKE");
    	myDLL.set(3, "A MOUNTAIN");
    	
    	assertEquals("A LAKE", myDLL.get(0));
    	assertEquals("A CAR", myDLL.get(1));
    	assertEquals("A TRUCK", myDLL.get(2));
    	assertEquals("A MOUNTAIN", myDLL.get(3));
    	
    	try 
    	{
    		myDLL.set(-1, "A CAT");
    	} 
    	catch (IndexOutOfBoundsException e)
    	{
    		assertTrue(true);
    	}
    	
    	try 
    	{
    		myDLL.set(4, "A CAT");
    	} 
    	catch (IndexOutOfBoundsException e)
    	{
    		assertTrue(true);
    	}
    	
    	try 
    	{
    		myDLL.set(2, null);
    	} 
    	catch (NullPointerException e)
    	{
    		assertTrue(true);
    	}
    }
    
    @Test
    public void testContains() {
    	myDLL.add("A CAR");    	 
    	myDLL.add("A TRUCK");   	
    	myDLL.add(0, "A SUV");
    	myDLL.add(3, "A VAN");
    	
    	assertFalse(myDLL.contains("A CAT"));
    	assertFalse(myDLL.contains("A"));
    	assertTrue(myDLL.contains("A CAR"));
    	assertTrue(myDLL.contains("A VAN"));
    	
    	try 
    	{
    		myDLL.contains(null);
    	} 
    	catch (NullPointerException e)
    	{
    		assertTrue(true);
    	}
    }
    
    @Test
    public void testToArray() {
		E[] temp = (E[]) new Object[] {"a", "b", "c"};
		Object[] myArray =  this.myDLL.toArray(temp);
		
		assertEquals("a", myArray[0]);
		assertEquals("b", myArray[1]);
		assertEquals("c", myArray[2]);
		
		myArray = this.myDLL.toArray((E[]) new Object[] {"d", "e", "f"});
		assertEquals("d", myArray[0]);
		assertEquals("e", myArray[1]);
		assertEquals("f", myArray[2]);
    }
    
    @Test
    public void testMyIterator() {
		this.myDLL.add("a");
		this.myDLL.add("b");
		this.myDLL.add("c");
		this.myDLL.add("d");
		
		Object[] o = new Object[myDLL.size()];
		Iterator<E> myDLLIterator = myDLL.iterator();
		
		int i = 0;
		while (myDLLIterator.hasNext()) {
			o[i] = myDLLIterator.next();
			i++;
		}

		assertEquals("a", o[0]);
		assertEquals("b", o[1]);
		assertEquals("c", o[2]);
		assertEquals("d", o[3]);
    }
}
