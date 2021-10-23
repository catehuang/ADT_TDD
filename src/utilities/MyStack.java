package utilities;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import adts.Iterator;
import adts.StackADT;

public class MyStack<E> implements StackADT<E> {

	private int top = 0; // equal to array stack's length
	private static final int DEFAULT_CAPACITY = 10;
	// Array-based implementation of the stack ADT
	private E[] arrayStack = (E[]) new Object[DEFAULT_CAPACITY];

	/**
	 * Default constructor An empty stack with default capacity
	 */
	public MyStack() {

	}

	/**
	 * Initial a Stack with a specified capacity
	 * 
	 * @param initial_capacity the capacity of an stack
	 */
	public MyStack(int initial_capacity) {
		E[] arrayStack = (E[]) new Object[initial_capacity];

	}

	/**
	 * creates an empty stack
	 */
	@Override
	public void create() {
		new MyStack();
	}

	/**
	 * Returns the size of stack
	 * 
	 * @return size of the stack
	 */
	@Override
	public int size() {
		return top;
	}

	/**
	 * Clears the content of array
	 */
	@Override
	public void clear() {
		top = 0;
	}

	/**
	 * Adds an element at the top of stack
	 * 
	 * @param toAdd the element to be added to the top of stack
	 * @throws NullPointerException If the specified element is <code>null</code>
	 */
	@Override
	public void push(E element) throws NullPointerException {
		if (element == null)
			throw new NullPointerException();
		if (top == arrayStack.length) {
			// need to resize the backing array
			arrayStack = Arrays.copyOf(arrayStack, 2 * arrayStack.length);// double the array length
		}
		arrayStack[top] = (E) element;
		top++;

	}

	/**
	 * Returns the top element and removes it from this stack
	 * 
	 * @return the top element from this stack
	 * @throws EmptyStackException If the stack is empty
	 */

	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		E stackTop = (E) arrayStack[top - 1];
		arrayStack[top - 1] = null;
		top--;

		return stackTop;
	}

	/**
	 * Returns the top element of this stack
	 * 
	 * @return the element on the top of this stack
	 * @throws EmptyStackException If the stack is empty
	 */
	@Override
	public E peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return arrayStack[top - 1];
	}

	/**
	 * Search specified element
	 * 
	 * @param obj the searched element
	 * @return the index of obj
	 * @throws NullPointerException If the specified element is <code>null</code>
	 * @throws EmptyStackException  If the stack is empty
	 */
	@Override
	public int search(E obj) throws NullPointerException, EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		if (obj == null) {
			throw new NullPointerException();
		}
		for (int i = top - 1; i >= 0; i--) {
			if (arrayStack[i].equals(obj))
				return i;
		}
		return -1;
	}

	/**
	 * Returns true if this stack contains specified obj
	 * 
	 * @param obj the searched element
	 * @return returns true if this stack contains specified obj
	 * @throws NullPointerException If the specified element is <code>null</code>
	 * @throws EmptyStackException  If the stack is empty
	 */

	@Override
	public boolean contains(E obj) throws NullPointerException, EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		if (obj == null) {
			throw new NullPointerException();
		}
		for (int i = top - 1; i >= 0; i--) {
			if (arrayStack[i].equals(obj))
				return true;
		}
		return false;
	}

	/**
	 * Returns true if this stack is empty
	 * 
	 * @return true if this stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	/**
	 * Returns an array containing all of the items in this stack
	 * 
	 * @param toHold an array is going to make a copy
	 * @return returns an array containing all of the items in this stack
	 * @throws NullPointerException If the specified element is <code>null</code>
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold == null) {
			throw new NullPointerException();
		}
		if (toHold.length > arrayStack.length) {
			// need to resize the backing array
			arrayStack = Arrays.copyOf(arrayStack, 2 * arrayStack.length);// double the array length
		}
		for (int i = 0, j = toHold.length - 1; i < toHold.length; i++, j--) {
			// The top of the stack corresponds to the first element of the array
			arrayStack[j] = toHold[i];
		
		}
		return arrayStack;
	}

	/**
	 * Returns an array containing all of the items in this stack
	 * 
	 * @return returns an array containing all of the items in this stack
	 */
	@Override
	public Object[] toArray() {
		if (isEmpty()) {
			return null;
		}
		Object[] o = new Object[top];
		for (int i = 0, j = top - 1; i < top; i++, j--) {
		o[i] = arrayStack[j];
		}
		return o;
	}

	/**
	 * Returns an iterator over the items contained in this stack. The remove()
	 * should not be supported
	 * 
	 * @return returns an iterator over the items contained in this stack
	 */

	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	// inner class
	public class StackIterator<E> implements adts.Iterator<E> {

		private int current = 0;

		@Override
		public boolean hasNext() {

			return current < size();
		}

		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext())
				throw new NoSuchElementException();
			return (E) arrayStack[current++];
		}

	}

	/**
	 * Returns true if two stack must contain equal items appearing in the same
	 * order
	 * 
	 * @param that a stack to compare to another stack
	 * @return returns true if two stack must contain equal items appearing in the
	 *         same order
	 */
	@Override
	public boolean equals(StackADT<E> that) {
		if (that.size() == arrayStack.length) {
			for (int i = 0; i < arrayStack.length; i++) {
				if (arrayStack[i] != that.toArray()[i])
					return false;

			}
			return true;
		} else
			return false;
	}

}
