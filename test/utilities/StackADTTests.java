package utilities;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.*;

import utilities.MyStack;

public class StackADTTests<E> extends MyStack<E> {

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
	public void testCreate() {
		super.create();
		assertEquals(0, this.size());

	}

	@Test
	public void testSize() {
		assertEquals(0, myStack.size());
		myStack.push("a");
		myStack.push("b");
		myStack.push("c");
		assertEquals(3, this.myStack.size());
	}

	@Test
	public void testClear() {
		myStack.push("a");
		myStack.push("b");
		myStack.clear();
		assertTrue(myStack.isEmpty());
		assertEquals(0, myStack.size());
	}

	@Test
	public void testPush() {
		try {
			myStack.push(null);
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
		myStack.pop();
		assertEquals(5, myStack.pop());

	}

	@Test
	public void testPop() {
		try {
			myStack.pop();
			fail("Pop method failed to throw EmptyStackException.");
		} catch (EmptyStackException e) {
			assertTrue(true);
		}
		myStack.push("a");
		myStack.push("b");
		assertEquals("b", myStack.pop());
		myStack.push(5);
		assertEquals(5, myStack.pop());
		assertEquals(1, myStack.size());
		assertEquals("a", myStack.peek());
	}
	
	@Test 
	public void testPeek() {
		try {
			myStack.peek();
			fail("Peek method failded to throw EmptyStackException.");
		}catch(EmptyStackException e) {
			assertTrue(true);
		}
		myStack.push("a");
		myStack.push("b");
		assertEquals("b", myStack.peek());
		myStack.push(5);
		assertEquals(5, myStack.peek());
		myStack.pop();
		assertEquals("b", myStack.peek());
		assertEquals(2, myStack.size());
		
	}
	
	@Test
	public void testSearch() {
		try {
			myStack.search("a");
			fail("Search method failed to throw EmptyStackException.");
		}catch(EmptyStackException e) {
			assertTrue(true);
		}
		try {
			myStack.push(1);
			myStack.search(null);
			fail("Search method failed to throw NullPointerException.");
		}catch(NullPointerException e) {
			assertTrue(true);
		}
		myStack.clear();
		myStack.push("a");
		myStack.push("b");
		assertEquals(0, myStack.search("a"));
		myStack.push(5);
		assertEquals(2, myStack.search(5));
		assertEquals(-1, myStack.search(6));
		myStack.push(6);
		assertEquals(3, myStack.search(6));
		myStack.push("a");
		assertEquals(4, myStack.search("a"));
	}
	
	@Test
	public void testContains() {
		try {
			myStack.contains("a");
			fail("Contains method failed to throw EmptyStackException.");
		}catch(EmptyStackException e) {
			assertTrue(true);
		}
		try {
			myStack.push(1);
			myStack.contains(null);
			fail("Contains method failed to throw NullPointerException.");
		}catch(NullPointerException e) {
			assertTrue(true);
		}
		
		myStack.push("a");
		myStack.push("b");
		assertTrue(myStack.contains("a"));
		myStack.push(5);
		assertTrue(myStack.contains(5));
		myStack.pop();
		assertFalse(myStack.contains(5));

	}
}
