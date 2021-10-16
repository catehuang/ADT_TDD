package problemdomain;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackADTTest {

	private  MyStack myStack;
	
	/**
	 * @throws Exception if something wrong when assign and initialize MyArrayList
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		this.myStack = new MyStack();
	}
	
	/**
	 * @throws Exception if clear method is failed
	 */
	@AfterEach
	void tearDown() throws Exception
	{
		this.myStack.clear();
	}
	
	@Test
	void testIsEmpty() 
	{
		assertTrue(this.myStack.isEmpty());
		assertEquals(0, this.myStack.size());
	}
	
	@Test
	void testSize()
	{
		assertEquals(0, this.myStack.size());
		this.myStack.push("a");
		this.myStack.push("b");
		assertEquals(2, this.myStack.size());
	}
	
	@Test
	void testClear()
	{
		this.myStack.push("a");
		this.myStack.push("b");
		this.myStack.clear();
		assertTrue(this.myStack.isEmpty());
		assertEquals(0, this.myStack.size());
	}
	
	@Test
	void testPush()
	{
		this.myStack.push("a");
		this.myStack.push("b");
		assertEquals("b", this.myStack.peek());
		assertEquals(2, this.myStack.size());
	}
	
	@Test
	void testPop()
	{
		this.myStack.push("a");
		this.myStack.push("b");
		this.myStack.push("c");
		assertEquals("c", this.myStack.pop());
		assertEquals("b", this.myStack.peek());
		assertEquals(2, this.myStack.size());
	}
	
	@Test
	void testPeek()
	{
		this.myStack.push("a");
		this.myStack.push("b");
		assertEquals("b", this.myStack.peek());
		this.myStack.push("c");
		assertEquals("c", this.myStack.peek());
	}
	
	@Test
	void testEquals()
	{
		
	}
	
	@Test
	void testIterator()
	{
		
	}
	
	@Test
	void testToArray()
	{
		
	}
	
	@Test
	void testSearch()
	{
		this.myStack.push("a");
		this.myStack.push("b");
		this.myStack.push("c");
		this.myStack.push("d");
		assertEquals("3", this.myStack.search("d"));
		assertEquals("0", this.myStack.search("a"));
		assertEquals("-1", this.myStack.search("x"));
	}
	
	@Test
	void contains()
	{
		this.myStack.push("a");
		this.myStack.push("b");
		this.myStack.push("c");
		this.myStack.push("d");
		assertTrue(this.myStack.contains("d"));
		assertTrue(this.myStack.contains("a"));
		assertFalse(this.myStack.contains("x"));
	}
	
}
