package tests;

import org.junit.jupiter.api.*;

import sait.sll.utility.*;

/**
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version July 24, 2020
 */
class SLLFailTest {

	/**
	 * Contains the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;
	
	

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create your concrete linked list class and assign to to linkedList.
		this.linkedList = new SLL();
	}

	/**
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.linkedList.clear();
	}

	/**
	 *  Tests inserting node at invalid index.
	 * @throws Exception
	 */
	@Test 
	void testFailInsert() throws Exception {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		try {

			this.linkedList.insert("e", 7);

		} catch (IndexOutOfBoundsException e) {
			
			e.getMessage();
		}

	}
	
	/**
	 * Tests to replace data at invalid index
	 * @throws Exception
	 */
	@Test
	void testFailReplace() throws Exception {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		try {
			
			this.linkedList.replace("e", 7);
			
		} catch (NullPointerException e) {
			
			e.getMessage();
		}
	}
	
	/**
	 * Tests to delete data at invalid index
	 * @throws Exception
	 */
	@Test
	void testFailDelete() throws Exception {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		try {
			
			this.linkedList.delete(7);
			
		} catch (IndexOutOfBoundsException e) {

			e.getMessage();
		}
	}
	
	
	/**
	 * Tests to check if linked list contains invalid data
	 * @throws Exception
	 */
	@Test
	void testFailContains() throws Exception {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		try {
			
			this.linkedList.contains("e");
			
		} catch (NullPointerException e) {
			e.getMessage();
		}
	}
	
	/**
	 * Test to check for data at invalid index
	 * @throws Exception
	 */
	@Test
	void testFailIndexOf() throws Exception {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		try {
			this.linkedList.indexOf("e");
			
		} catch (NullPointerException e) {
			e.getMessage();
		}
		
	}
	
	/**
	 * Tests to retrieve data at invalid index
	 * @throws Exception
	 */
	@Test
	void testFailRetrieve () throws Exception {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		try {
			
			this.linkedList.retrieve(7);
		} catch (NullPointerException e) {
			
			e.getMessage();
		}
	} 

}
