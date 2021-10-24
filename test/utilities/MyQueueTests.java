package utilities;
import org.junit.Test;
import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;

public class MyQueueTests<E> {
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

		assertEquals(0, myQueue.size());
	}

	@Test
	public void testEnqueue() {

	}

	@Test
	public void testDequeue() {

	}

	@Test
	public void testPeek() {

	}

	@Test
	public void testEquals() {

	}

	@Test
	public void testIterator() {

	}

	@Test
	public void testToArray() {

	}

	@Test
	public void testIsFull() {

	}

	@Test
	public void testSize() {

	}

	@Test
	public void testIsEmpty() {

	}

	@Test
	public void testDequueAll() {

	}
}
