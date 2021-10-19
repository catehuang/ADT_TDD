package problemdomain;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyArrayListTest {

	private MyArrayList myArrayList;
	
	/**
	 * @throws Exception if something wrong when assign and initialize MyArrayList
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		this.myArrayList = new MyArrayList();
	}
	
	/**
	 * @throws Exception if clear method is failed
	 */
	@AfterEach
	void tearDown() throws Exception
	{
		this.myArrayList.clear();
	}
	
	
	@Test
	void testSize()
	{
		assertEquals(0, this.myArrayList.size());
		this.myArrayList.add("a");
		this.myArrayList.add(0, "b");
		assertEquals(2, this.myArrayList.size());
	}
	
	@Test
	void testClear()
	{
		this.myArrayList.add("a");
		this.myArrayList.add(0, "b");
		this.myArrayList.clear();
		assertTrue(this.myArrayList.isEmpty());
		assertEquals(0, this.myArrayList.size());
	}
	
	@Test
	void testAdd()
	{
		this.myArrayList.add("a");
		this.myArrayList.add(0, "b");
		
		assertEquals("0", "b");
		assertEquals("1", "a");
		assertEquals(2, this.myArrayList.size());
	}
	
	@Test
	void testAddAll()
	{
		
	}
	
	@Test
	void testGet()
	{
		this.myArrayList.add("a");
		this.myArrayList.add(0, "b");
		assertEquals("b", this.myArrayList.get(0));
		assertEquals("a", this.myArrayList.get(1));
		assertNull(this.myArrayList.get(2));
	}
	
	@Test
	void testRemove()
	{
		this.myArrayList.add("a");
		this.myArrayList.add(0, "b");
		this.myArrayList.add("c");
		this.myArrayList.add("d");
		
		// b a c d
		asserEquals(4, this.myArrayList.size());
		
		this.myArrayList.remove(3);
		
		// b a c
		assertEquals(3, this.myArrayList.size());
		assertEquals("b", this.myArrayList.get(0));
		assertEquals("a", this.myArrayList.get(1));
		assertEquals("c", this.myArrayList.get(2));
		
		this.myArrayList.remove("a");
		// b c
		assertEquals(2, this.myArrayList.size());
		assertEquals("b", this.myArrayList.get(0));
		assertEquals("c", this.myArrayList.get(1));
		
		assertNull(this.myArrayList.remove(2));
		assertNull(this.myArrayList.remove("f"));
		
		// remove all elements
		this.myArrayList.remove(0);
		this.myArrayList.remove(0);
		assertEquals(0, this.myArrayList.size());
		assertTrue(this.myArrayList.isEmpty());
	}
	
	@Test
	void testSet()
	{
		this.myArrayList.add("a");
		this.myArrayList.add("b");
		this.myArrayList.add("c");
		this.myArrayList.add("d");

		assertNull(this.myArrayList.set(4, "x"));
		
		// x b c d
		this.myArrayList.set(0, "x");
		assertEquals(4, this.myArrayList.size());
		assertEquals("x", this.myArrayList.get(0));
		assertEquals("b", this.myArrayList.get(1));
		assertEquals("c", this.myArrayList.get(2));
		assertEquals("d", this.myArrayList.get(3));
		
		// x b c y
		this.myArrayList.set(3, "y");
		assertEquals("x", this.myArrayList.get(0));
		assertEquals("b", this.myArrayList.get(1));
		assertEquals("c", this.myArrayList.get(2));
		assertEquals("y", this.myArrayList.get(3));
		
		// x b c y
		this.myArrayList.set(2, "z");
		assertEquals("x", this.myArrayList.get(0));
		assertEquals("b", this.myArrayList.get(1));
		assertEquals("c", this.myArrayList.get(2));
		assertEquals("y", this.myArrayList.get(3));
	}
	
	@Test
	void testIsEmpty()
	{
		assertTrue(this.myArrayList.isEmpty());
		assertEquals(0, this.myArrayList.size());
	}
	
	@Test
	void testContains() {
		this.myArrayList.add("a");
		this.myArrayList.add("b");
		this.myArrayList.add("c");
		this.myArrayList.add("d");
		
		assertTrue(this.myArrayList.contains("a"));
		assertTrue(this.myArrayList.contains("d"));
		assertFalse(this.myArrayList.contains("x"));
	}
	
	@Test
	void testToArray()
	{
		
	}
	
	@Test
	void testIterator()
	{
		
	}

}
