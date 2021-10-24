package utilities;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.*;

import adts.Iterator;


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
	public void testCreate() {
		
		try {
			myStack.create();
			assertTrue(true);
		}catch(Exception e) {
			fail("Create Method failed");
		}

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
		} catch (EmptyStackException e) {
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
		} catch (EmptyStackException e) {
			assertTrue(true);
		}
		try {
			myStack.push(1);
			myStack.search(null);
			fail("Search method failed to throw NullPointerException.");
		} catch (NullPointerException e) {
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
		} catch (EmptyStackException e) {
			assertTrue(true);
		}
		try {
			myStack.push(1);
			myStack.contains(null);
			fail("Contains method failed to throw NullPointerException.");
		} catch (NullPointerException e) {
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

	@Test
	public void testIsEmpty() {
		assertTrue(myStack.isEmpty());
		assertEquals(0, myStack.size());
		myStack.push("A");
		assertTrue(!myStack.isEmpty());
		assertEquals(1, myStack.size());

	}

	@Test
	public void testToArrayToCopy() {
		// to test public E[] toArray(E[] toHold) throws NullPointerException method.
		try {
			myStack.toArray(null);
			fail("Contains method failed to throw NullPointerException.");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
		Object[] toHold = new Object[5];
		toHold[0] = "a";
		toHold[1] = "b";
		toHold[2] = "c";
		toHold[3] = "d";
		toHold[4] = 5;
		E[] copyArray = (E[]) myStack.toArray(toHold);
		// The top of the stack corresponds to the first element of the array
		assertEquals(5, copyArray[0]);
		assertEquals("d", copyArray[1]);
		assertEquals("c", copyArray[2]);
		assertEquals("b", copyArray[3]);
		assertEquals("a", copyArray[4]);
	}

	@Test
	public void testToArray() {
		assertNull(myStack.toArray());
		myStack.push("a");
		myStack.push("b");
		myStack.push("c");
		myStack.push("d");
		myStack.push("e");
		Object[] copyArray = myStack.toArray();
		assertEquals("e", copyArray[0]);
		assertEquals("d", copyArray[1]);
		assertEquals("c", copyArray[2]);
		assertEquals("b", copyArray[3]);
		assertEquals("a", copyArray[4]);
	}

	@Test
	public void testIterator() {
		myStack.push("a");
		myStack.push("b");
		myStack.push("c");
		myStack.push("d");
		myStack.push("e");

		Object[] o = new Object[myStack.size()];
		Iterator<E> myStackIterator = myStack.iterator();
		
		int i = 0;
		while (myStackIterator.hasNext()) {
			o[i] = myStackIterator.next();
			i++;
		}

		assertEquals("a", o[0]);
		assertEquals("b", o[1]);
		assertEquals("c", o[2]);
		assertEquals("d", o[3]);
		assertEquals("e", o[4]);
	}
	
	@Test 
	public void testEquals() {
		myStack.push("a");
		myStack.push("b");
		myStack.push("c");
		myStack.push("d");
		myStack.push("e");
		
		MyStack otherStack = new MyStack();
		otherStack.push("a");
		otherStack.push("b");
		otherStack.push("c");
		otherStack.push("d");
		otherStack.push("e");
		
		assertTrue(myStack.equals(otherStack));
		otherStack.pop();
		assertFalse(myStack.equals(otherStack));
		otherStack.push("f");
		assertFalse(myStack.equals(otherStack));
		
		
	}
}
