package utilities;


import static org.junit.Assert.*;
import org.junit.*;

import adts.Iterator;

public class MyQueueTests<E> {
	private MyQueue myQueue;
	private MyQueue myQueue2;


	/**
	 * @throws Exception if something wrong when assign and initialize MyArrayList
	 */

	@Before
	public void setUp() throws Exception
	{
		this.myQueue = new MyQueue();
		this.myQueue.create();
		this.myQueue2 = new MyQueue();
		this.myQueue2.create();

	}

	/**
	 * @throws Exception if clear method is failed
	 */
	@After
	public void tearDown() throws Exception
	{
		this.myQueue.dequeueAll();
		this.myQueue2.dequeueAll();
	}

	@Test
	public void testCreate() {
		assertEquals(0, this.myQueue.size());
		assertTrue("True", this.myQueue.isEmpty());
	}

	@Test
	public void testEnqueue() {
		try {
			this.myQueue.enqueue("");
			fail("Failed and throw NullPointerException.");
		} catch (NullPointerException e) {
			assertTrue(true);
		}

		this.myQueue.enqueue("a");
		assertEquals("a", this.myQueue.peek());

		this.myQueue.enqueue("b");
		this.myQueue.enqueue("c");
		assertEquals(3, this.myQueue.size());
	}

	@Test
	public void testDequeue() {
		this.myQueue.enqueue("a");
		assertEquals("a", this.myQueue.dequeue());
	}

	@Test
	public void testPeek() {
		this.myQueue.enqueue("a");
		assertEquals("a", this.myQueue.peek());
	}

	@Test
	public void testEquals() {
		this.myQueue.enqueue("a");
		this.myQueue2.enqueue("a");
		assertTrue("True", this.myQueue.equals(this.myQueue2));

	}

	@Test
	public void testIterator() {
		this.myQueue.enqueue("a");
		this.myQueue.enqueue("b");
		this.myQueue.enqueue("c");
		this.myQueue.enqueue("d");

		Object[] o = new Object[myQueue.size()];
		Iterator<E> myIterator = myQueue.iterator();

		int i = 0;
		while(myIterator.hasNext()) {
			o[i] = myIterator.next();
			i++;
		}

		assertEquals("a", o[0]);
		assertEquals("b", o[1]);
		assertEquals("c", o[2]);
		assertEquals("d", o[3]);
	}

	@Test
	public void testToArray() {
		E[] temp = (E[])  new Object[] {"a", "b", "c"};
		Object[] myArray = this.myQueue.toArray(temp);

		assertEquals("a", myArray[0]);
		assertEquals("b", myArray[1]);
		assertEquals("c", myArray[2]);

		myArray = this.myQueue.toArray((E[]) new Object[] {"d", "e", "f"});
		assertEquals("d", myArray[0]);
		assertEquals("e", myArray[1]);
		assertEquals("f", myArray[2]);

	}


	@Test
	public void testSize() {
		assertEquals(0, this.myQueue.size());
		myQueue.enqueue("a");
		myQueue.enqueue("b");
		myQueue.enqueue("c");
		assertEquals(3, this.myQueue.size());

	}

	@Test
	public void testIsEmpty() {
		assertTrue(this.myQueue.isEmpty());
		assertEquals(0, this.myQueue.size());
		this.myQueue.enqueue("a");
		assertFalse(this.myQueue.isEmpty());
		assertEquals(1, this.myQueue.size());
	}

	@Test
	public void testDequeAll() {
		this.myQueue.dequeueAll();
		assertTrue(this.myQueue.isEmpty());
		assertEquals(0, this.myQueue.size());
	}
}
