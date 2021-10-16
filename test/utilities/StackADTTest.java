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
		
	}
	
	@Test
	void testClear()
	{
		
	}
	
	@Test
	void testPush()
	{
		
	}
	
	@Test
	void testPop()
	{
		
	}
	
	@Test
	void testPeek()
	{
		
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
		
	}
	
	@Test
	void contains()
	{
		
	}
	
}
