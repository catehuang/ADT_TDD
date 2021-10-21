package utilities;


import static org.junit.Assert.*;
import org.junit.*;

public class MyArrayListTest<E> {

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
		this.myList.add("a");
		this.myList.add("b");
		this.myList.add("c");
		assertEquals(3, this.myList.size());
	}
	
	@Test
	public void testClear()
	{
		this.myList.add("a");
		this.myList.add(0, "b");
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
			this.myList.add(-3, "x");
			fail("Add method failed to throw IndexOutOfBoundsException.");
		}
		catch (IndexOutOfBoundsException e) 
		{
			assertTrue(true);
		}
		
		assertTrue(this.myList.add(this.myList.size(), "x"));
		assertEquals("x", this.myList.get(this.myList.size() - 1));

		assertTrue(this.myList.add("a"));
		assertTrue(this.myList.add(0, "b"));
		
		assertEquals("b", this.myList.get(0));
		assertEquals("x", this.myList.get(1));
		assertEquals("a", this.myList.get(2));
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
		
		temp.add("a");
		temp.add("b");
		assertTrue(this.myList.addAll(temp));
		
		assertEquals(2, this.myList.size());
		assertEquals("a", this.myList.get(0));
		assertEquals("b", this.myList.get(1));
		
		this.myList.add("c");
		assertTrue(this.myList.addAll(temp));
		
		assertEquals(5, this.myList.size());
		assertEquals("a", this.myList.get(0));
		assertEquals("b", this.myList.get(1));
		assertEquals("c", this.myList.get(2));
		assertEquals("a", this.myList.get(3));
		assertEquals("b", this.myList.get(4));
		
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
		this.myList.add("a");
		this.myList.add(0, "b");
		assertEquals("b", this.myList.get(0));
		assertEquals("a", this.myList.get(1));

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
		this.myList.add("a");
		this.myList.add(0, "b");
		this.myList.add("c");
		this.myList.add("d");
		
		// b a c d
		assertEquals(4, this.myList.size());
		
		this.myList.remove(3);
		
		// b a c
		assertEquals(3, this.myList.size());
		assertEquals("b", this.myList.get(0));
		assertEquals("a", this.myList.get(1));
		assertEquals("c", this.myList.get(2));
		
		this.myList.remove("a");
		// b c
		assertEquals(2, this.myList.size());
		assertEquals("b", this.myList.get(0));
		assertEquals("c", this.myList.get(1));
		
		try 
		{
			this.myList.remove(2);
			fail("Add method failed to throw IndexOutOfBoundsException.");
		}
		catch (IndexOutOfBoundsException e) 
		{
			assertTrue(true);
		}
		
		assertNull(this.myList.remove("f"));

		// remove all elements
		this.myList.remove(0);
		this.myList.remove(0);
		assertEquals(0, this.myList.size());
		assertTrue(this.myList.isEmpty());
	}
	
	@Test
	public void testSet()
	{
		this.myList.add("a");
		this.myList.add("b");
		this.myList.add("c");
		this.myList.add("d");

		try 
		{
			this.myList.set(4, "x");
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
		this.myList.set(0, "x");
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
