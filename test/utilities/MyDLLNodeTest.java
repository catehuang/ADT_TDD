package utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyDLLNodeTest {

	private MyDLLNode myDLLNode;
	
	/**
	 * @throws Exception if something wrong when assign and initialize MyArrayList
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		this.myDLLNode = new MyDLLNode();
	}
	
	/**
	 * @throws Exception if clear method is failed
	 */
	@AfterEach
	void tearDown() throws Exception
	{
		this.myDLLNode.clear();
	}
	

	@Test
	void testSize()
	{
		
	}
	
	@Test
	void testClear()
	{
		
	}
	
	@Test
	void testAdd()
	{
		
	}
	
	@Test
	void testAddAll()
	{
		
	}
	
	@Test
	void testGet()
	{
		
	}
	
	@Test
	void testRemove()
	{
		
	}
	
	@Test
	void testSet()
	{
		
	}
	
	@Test
	void testIsEmpty()
	{
		assertTrue(this.myArrayList.isEmpty());
		assertEquals(0, this.myArrayList.size());
	}
	
	@Test
	void testContains() {
		
	}
	
	@Test
	void testToArray()
	{
		
	}
	
	@Test
	void testIterator()
	{
		
	}

}
