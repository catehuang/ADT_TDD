package utilities;

import static org.junit.Assert.*;
import org.junit.*;

public class MyDLLNodeTest<E> {
    private MyDLLNode myDLLNode;
    private MyDLLNode myDLLNode2;

    /**
     * @throws Exception if something wrong when assign and initialize MyArrayList
     */

    @Before
    public void setUp() throws Exception
    {
        myDLLNode = new MyDLLNode("a");
        myDLLNode2 = new MyDLLNode("b");
    }

    /**
     * @throws Exception if clear method is failed
     */
    @After
    public void tearDown() throws Exception
    {
        myDLLNode = null;
        myDLLNode2 = null;
    }

    @Test
    public void testGetElement() {

        assertEquals("a", myDLLNode.getElement());
    }

    @Test
    public void testSetElement() {

        this.myDLLNode.setElement("b");
        assertEquals("b", myDLLNode.getElement());
    }

    @Test
    public void testGetPrev() {

        this.myDLLNode.setPrev(myDLLNode2);
        assertEquals(myDLLNode2, myDLLNode.getPrev());
    }

    @Test
    public void testGetNext() {

        this.myDLLNode.setNext(myDLLNode2);
        assertEquals(myDLLNode2, myDLLNode.getNext());
    }
}
