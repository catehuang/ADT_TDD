package utilities;


import static org.junit.Assert.*;
import org.junit.*;

public class MyArrayListTests<E> {

	private MyArrayList myList;
	
	/**
	 * @throws Exception if something wrong when assign and initialize this.myList
	 */
	@Before
	public void setUp() throws Exception
	{
		this.myList = new MyArrayList(10);
	}
	
	/**
	 * @throws Exception if clear method is failed
	 */
	@After
	public void tearDown() throws Exception
	{
		this.myList.clear();
	}
	
	@Test
	public void testSize()
	{
		assertEquals(0, this.myList.size());
		this.myList.add("ONE");
		this.myList.add("TWO");
		this.myList.add("THREE");
		assertEquals(3, this.myList.size());
	}
	
	@Test
	public void testClear()
	{
		this.myList.add("FOUR");
		this.myList.add(0, "THREE");
		this.myList.clear();
		assertTrue(this.myList.isEmpty());
		assertEquals(0, this.myList.size());
	}
	
	@Test
	public void testAdd()
	{
		try 
		{
			this.myList.add("");
			fail("Add method failed to throw NullPointerException.");
		}
		catch (NullPointerException e) 
		{
			assertTrue(true);
		}
		
		try 
		{
			this.myList.add(0, null);
			fail("Add method failed to throw NullPointerException.");
		}
		catch (NullPointerException e) 
		{
			assertTrue(true);
		}
		
		try 
		{
			this.myList.add(-3, "YOU CAN'T SEE ME");
			fail("Add method failed to throw IndexOutOfBoundsException.");
		}
		catch (IndexOutOfBoundsException e) 
		{
			assertTrue(true);
		}
		
		assertTrue(this.myList.add(this.myList.size(), "ZERO"));
		assertEquals("ZERO", this.myList.get(this.myList.size() - 1));

		assertTrue(this.myList.add("TWO"));
		assertTrue(this.myList.add(0, "ONE"));
		
		assertEquals("ONE", this.myList.get(0));
		assertEquals("ZERO", this.myList.get(1));
		assertEquals("TWO", this.myList.get(2));
		assertEquals(3, this.myList.size());
	}
	
	@Test
	public void testAddAll()
	{
		MyArrayList temp = new MyArrayList(3);
		
		try 
		{
			this.myList.addAll(temp);
			fail("Add method failed to throw NullPointerException.");
		}
		catch (NullPointerException e) 
		{
			assertTrue(true);
		}
		
		temp.add("TEN");
		temp.add("ELEVEN");
		assertTrue(this.myList.addAll(temp));
		
		assertEquals(2, this.myList.size());
		assertEquals("TEN", this.myList.get(0));
		assertEquals("ELEVEN", this.myList.get(1));
		this.myList.add("TWELVE");
		assertTrue(this.myList.addAll(temp));
		
		assertEquals(5, this.myList.size());
		assertEquals("TEN", this.myList.get(0));
		assertEquals("ELEVEN", this.myList.get(1));
		assertEquals("TWELVE", this.myList.get(2));
		assertEquals("TEN", this.myList.get(3));
		assertEquals("ELEVEN", this.myList.get(4));
		
		try 
		{
			this.myList.addAll(new MyArrayList(3));
			fail("Add method failed to throw NullPointerException.");
		}
		catch (NullPointerException e) 
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void testGet()
	{
		this.myList.add("PUMPKIN");
		this.myList.add(0, "STRAWBERRY");
		assertEquals("STRAWBERRY", this.myList.get(0));
		assertEquals("PUMPKIN", this.myList.get(1));

		try 
		{
			this.myList.get(2);
			fail("Add method failed to throw IndexOutOfBoundsException.");
		}
		catch (IndexOutOfBoundsException e) 
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void testRemove()
	{
		this.myList.add("WHITE WINE");
		this.myList.add(0, "WINE");
		this.myList.add("BEER");
		this.myList.add("SELTZER");
		
		assertEquals(4, this.myList.size());
		
		this.myList.remove(3);
		
		assertEquals(3, this.myList.size());
		assertEquals("WINE", this.myList.get(0));
		assertEquals("WHITE WIN", this.myList.get(1));
		assertEquals("BEER", this.myList.get(2));
		
		this.myList.remove("a");
		// b c
		assertEquals(2, this.myList.size());
		assertEquals("WINE", this.myList.get(0));
		assertEquals("BEER", this.myList.get(1));
		
		try 
		{
			this.myList.remove(2);
			fail("Add method failed to throw IndexOutOfBoundsException.");
		}
		catch (IndexOutOfBoundsException e) 
		{
			assertTrue(true);
		}
		
		assertNull(this.myList.remove("SOY SAUCE"));

		// remove all elements
		this.myList.remove(0);
		this.myList.remove(0);
		assertEquals(0, this.myList.size());
		assertTrue(this.myList.isEmpty());
	}
	
	@Test
	public void testSet()
	{
		this.myList.add("CHAIR");
		this.myList.add("DINING DESK");
		this.myList.add("TABLE CLOTH");
		this.myList.add("DINNER NAPKIN");

		try 
		{
			this.myList.set(4, "SPORT SHOES");
			fail("Add method failed to throw IndexOutOfBoundsException.");
		}
		catch (IndexOutOfBoundsException e) 
		{
			assertTrue(true);
		}
		
		try 
		{
			this.myList.set(3, null);
			fail("Add method failed to throw NullPointerException.");
		}
		catch (NullPointerException e) 
		{
			assertTrue(true);
		}
		
		// x b c d
		this.myList.set(0, "TRAY");
		assertEquals(4, this.myList.size());
		assertEquals("x", this.myList.get(0));
		assertEquals("b", this.myList.get(1));
		assertEquals("c", this.myList.get(2));
		assertEquals("d", this.myList.get(3));
		
		// x b c y
		this.myList.set(3, "y");
		assertEquals("x", this.myList.get(0));
		assertEquals("b", this.myList.get(1));
		assertEquals("c", this.myList.get(2));
		assertEquals("y", this.myList.get(3));
		
		// x b c y
		this.myList.set(2, "z");
		assertEquals("x", this.myList.get(0));
		assertEquals("b", this.myList.get(1));
		assertEquals("z", this.myList.get(2));
		assertEquals("y", this.myList.get(3));
	}
	
	@Test
	public void testIsEmpty()
	{
		assertTrue(this.myList.isEmpty());
		assertEquals(0, this.myList.size());
	}
	
	@Test
	public void testContains() {
		this.myList.add("a");
		this.myList.add("b");
		this.myList.add("c");
		this.myList.add("d");
		
		assertTrue(this.myList.contains("a"));
		assertTrue(this.myList.contains("d"));
		assertFalse(this.myList.contains("x"));
		
		try 
		{
			this.myList.contains(null);
			fail("Add method failed to throw NullPointerException.");
		}
		catch (NullPointerException e) 
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void testToArray()
	{
		E[] temp = (E[]) new Object[] {"a", "b", "c"};
		Object[] myArray =  this.myList.toArray(temp);
		
		assertEquals("a", myArray[0]);
		assertEquals("b", myArray[1]);
		assertEquals("c", myArray[2]);
		
		myArray = this.myList.toArray((E[]) new Object[] {"d", "e", "f"});
		assertEquals("d", myArray[0]);
		assertEquals("e", myArray[1]);
		assertEquals("f", myArray[2]);
	}
	
	@Test
	public void testIterator()
	{
		
	}


}
