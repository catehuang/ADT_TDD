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
	void testCreate()
	{
		this.myQueue.create();
		assertTrue(this.myQueue.isEmpty());
		assertEquals(0, this.myQueue.size());
	}
	
	@Test
	void testEnqueue()
	{
		this.myQueue.enqeue("a");
		this.myQueue.enqeue("b");
		assertEquals(2, this.myQueue.size());
		assertEquals("a", this.myQueue.peek());
		
		this.myQueue.enqeue("c");
		assertEquals(3, this.myQueue.size());
		assertEquals("a", this.myQueue.peek());
	}
	
	@Test
	void testDequeue()
	{
		this.myQueue.enqeue("a");
		this.myQueue.enqeue("b");
		this.myQueue.enqeue("c");
		assertEquals(3, this.myQueue.size());
		assertEquals("a", this.myQueue.peek());
		this.myQueue.deqeue();
		assertEquals(2, this.myQueue.size());
		assertEquals("b", this.myQueue.peek());
		
		this.myQueue.deqeue();
		this.myQueue.deqeue();
		assertEquals(0, this.myQueue.size());
		assertNull(this.myQueue.peek());
	}
	
	@Test
	void testPeek()
	{
		assertNull(this.myQueue.peek());
		this.myQueue.enqeue("a");
		this.myQueue.enqeue("b");
		this.myQueue.enqeue("c");
		assertEquals("a", this.myQueue.peek());
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
		assertEquals(0, this.myQueue.size());
		this.myQueue.enqeue("a");
		assertEquals(1, this.myQueue.size());
		this.myQueue.enqeue("b");
		assertEquals(2, this.myQueue.size());
		this.myQueue.enqeue("c");
		assertEquals(3, this.myQueue.size());
		this.myQueue.deqeue();
		assertEquals(2, this.myQueue.size());
		this.myQueue.deqeue();
		assertEquals(1, this.myQueue.size());
		this.myQueue.deqeue();
		assertEquals(0, this.myQueue.size());
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
		this.myQueue.enqeue("a");
		this.myQueue.enqeue("b");
		this.myQueue.enqeue("c");
		this.myQueue.eequeueAll();
		assertTrue(this.myQueue.isEmpty());
		assertEquals(0, this.myQueue.size());
	}
}
