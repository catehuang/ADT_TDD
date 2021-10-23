package utilities;

import static org.junit.Assert.*;
import org.junit.*;

public class MyDLLNodeTest<E> {
    private MyDLLNode myDLLNode;
    private MyDLLNode myDLLNode2;


    @Test
    public void testGetElement() {
        this.myDLLNode = new MyDLLNode("a");
        assertEquals("a", myDLLNode.getElement());
    }

    @Test
    public void testSetElement() {
        this.myDLLNode = new MyDLLNode("a");
        this.myDLLNode.setElement("b");
        assertEquals("b", myDLLNode.getElement());
    }

    @Test
    public void testGetPrev() {
        this.myDLLNode = new MyDLLNode("a");
        this.myDLLNode2 = new MyDLLNode("b");
        this.myDLLNode.setPrev(myDLLNode2);
        assertEquals(myDLLNode2, myDLLNode.getPrev());
    }

    @Test
    public void testGetNext() {
        this.myDLLNode = new MyDLLNode("a");
        this.myDLLNode2 = new MyDLLNode("b");
        this.myDLLNode.setNext(myDLLNode2);
        assertEquals(myDLLNode2, myDLLNode.getNext());
    }
}
