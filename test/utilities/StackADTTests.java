package utilities;

import static org.junit.Assert.*;

import org.junit.*;

import utilities.MyStack;

public class StackADTTests<E> {

	private MyStack myStack;

	/**
	 * @throws Exception if something wrong when assign and initialize myStack
	 */
	@Before
	public void setUp() throws Exception {
		myStack = new MyStack(4);
	}

	/**
	 * @throws Exception if clear method is failed
	 * 
	 */
	@After
	public void tearDown() throws Exception {
		myStack.clear();
	}

	@Test
	public void testSize() {
		assertEquals(0, myStack.size());
		this.myStack.push("a");
		this.myStack.push("b");
		this.myStack.push("c");
		assertEquals(3, this.myStack.size());
	}

	@Test
	public void testClear() {
		this.myStack.push("a");
		this.myStack.push("b");
		this.myStack.clear();
		assertTrue(myStack.isEmpty());
		assertEquals(0, myStack.size());
	}

	@Test
	public void testPush() {
		try {
			this.myStack.push(null);
			fail("Push method failed to throw NullPointerException.");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
		myStack.push("a");
		myStack.push("b");
		myStack.push("c");
		myStack.push("d");
		assertEquals(4, myStack.size());
		myStack.push(5);
		assertEquals(5, myStack.peek());
		myStack.push(6);
		assertEquals(6, myStack.pop());

	}
}
