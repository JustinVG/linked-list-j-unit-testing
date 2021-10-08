package tests;

import static org.junit.jupiter.api.Assertions.*;

import sait.sll.problemdomain.*;
import sait.sll.utility.*;

import java.io.*;
import org.junit.jupiter.api.*;


/**
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version July 24, 2020
 *
 */
class SerializationTests {
	
	private FileOutputStream fos;
	private ObjectOutputStream oos;
	private LinkedListADT users;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.fos = new FileOutputStream("res//users.dat");
		this.oos = new ObjectOutputStream(this.fos);
		
		// Create your implemented linked list here and assign to the linkedList attribute.
		this.users = new SLL(); 
		this.users.append(new User(1, "Joe Blow", "jblow@gmail.com", "password"));
		this.users.append(new User(2, "Joe Schmoe", "joe.schmoe@outlook.com", "abcdef"));
		this.users.append(new User(3, "Colonel Sanders", "chickenlover1890@gmail.com", "kfc5555"));
		this.users.append(new User(4, "Ronald McDonald", "burgers4life63@outlook.com", "mcdonalds999"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.fos.close();
		this.oos.close();
		
		this.users.clear();
	}

	/**
	 * Tests the object was serialized.
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	@Test
	void testSerialize() throws IOException, ClassNotFoundException {
		this.oos.writeObject(this.users);
		
		FileInputStream fis = new FileInputStream("res//users.dat");
		ObjectInputStream ios = new ObjectInputStream(fis);
		assertTrue(ios.readObject()instanceof SLL);
		ios.close();
	}

	/**
	 * Tests the object was deserialized.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@Test
	void testDeserialize() throws ClassNotFoundException, IOException {
		this.oos.writeObject(this.users);
		
		this.oos.close();
		
		FileInputStream fis = new FileInputStream("res//users.dat");
		ObjectInputStream ios = new ObjectInputStream(fis);
		
		LinkedListADT users = (LinkedListADT) ios.readObject();
		
		assertFalse(users.isEmpty());
		
		User expectedUser1 = new User(1, "Joe Blow", "jblow@gmail.com", null);
		User actualUser1 = (User) users.retrieve(0);
		
		assertEquals(expectedUser1, actualUser1);
		assertTrue(actualUser1.isCorrectPassword("password"));
		
		User expectedUser2 = new User(2, "Joe Schmoe", "joe.schmoe@outlook.com", null);
		User actualUser2 = (User) users.retrieve(1);
		
		assertEquals(expectedUser2, actualUser2);
		assertTrue(actualUser2.isCorrectPassword("abcdef"));
		
		User expectedUser3 = new User(3, "Colonel Sanders", "chickenlover1890@gmail.com", null);
		User actualUser3 = (User) users.retrieve(2);
		
		assertEquals(expectedUser3, actualUser3);
		assertTrue(actualUser3.isCorrectPassword("kfc5555"));
		
		User expectedUser4 = new User(4, "Ronald McDonald", "burgers4life63@outlook.com", null);
		User actualUser4 = (User) users.retrieve(3);
		
		assertEquals(expectedUser4, actualUser4);
		assertTrue(actualUser4.isCorrectPassword("mcdonalds999"));
		
		ios.close();
		fis.close();
		
	}
}
