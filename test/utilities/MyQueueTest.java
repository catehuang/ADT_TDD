package utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyQueueTest {

	private MyQueue myQueue;
	
	/**
	 * @throws Exception if something wrong when assign and initialize MyArrayList
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		this.myQueue = new MyQueue();
	}
	
	/**
	 * @throws Exception if clear method is failed
	 */
	@AfterEach
	void tearDown() throws Exception
	{
		this.myQueue.clear();
	}
	
	@Test
	void testEquals()
	{
		
	}
	
	@Test
	void testIterator() {
		
	}
	
	@Test
	void testToArray()
	{
		
	}
	
	@Test
	void testIsFull()
	{
		
	}
	
	@Test
	void testSize()
	{
		
	}
	
	@Test
	void testIsEmpty()
	{
		assertTrue(this.myQueue.isEmpty());
		assertEquals(0, this.myQueue.size());
	}
	
	@Test
	void testDequeueAll()
	{
		
	}
}
