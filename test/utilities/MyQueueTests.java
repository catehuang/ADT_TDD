package utilities;
import org.junit.Test;
import utilities.MyQueue;
import static org.junit.Assert.*;
import org.junit.*;


import org.junit.After;
import org.junit.Before;

public class MyQueueTests<E> extends MyQueue<E> {
	private MyQueue myQueue;

	
	/**
	 * @throws Exception if something wrong when assign and initialize MyArrayList
	 */

	@Before
	public void setUp() throws Exception
	{
		myQueue = new MyQueue();
	}
	
	/**
	 * @throws Exception if clear method is failed
	 */
	@After
	public void tearDown() throws Exception
	{
		myQueue.dequeueAll();
	}

	@Test
	public void testCreate() {
		super.create();
		assertEquals(0, this.size());
	}
}
