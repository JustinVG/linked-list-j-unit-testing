package sait.sll.utility;

import java.io.*;
import java.util.*;


/**
 * 
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version July 24, 2020
 */
public class SLL implements LinkedListADT, Serializable{

	private Node head;
	
	private int size;
	
	/**
	 * User-defined constructor
	 */
	public SLL() {
		head = null;
		size = 0;

	}
	@Override
	/**
	 * Checks if the list is empty.
	 * @return True if it is empty.
	 */
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		} else return false;
	}

	@Override
	/**
	 * Clears the list.
	 */
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	@Override
	/**
	 * Adds to the end of the list.
	 * @param data Data to append.
	 */
	public void append(Object data) {
		Node tmp = new Node (head, data);
		Node current = new Node (head, data);
		if (head == null) {
			tmp.setData(data);
			tmp.setLink(null);
			head = tmp;
		}	
		else {
			current = head;
			while (current.getLink() != null) {
				current = current.link; 
			}
			current.link = new Node (current.link, data);
		}
		size++;
	}

	@Override
	/**
	 * Prepends (adds to beginning) data to the list.
	 * @param data Data to store inside element.
	 */
	public void prepend(Object data) {
		Node tmp = new Node (head, data);
		tmp.setLink(head);
		head = tmp;
		size++;
	}

	@Override
	/**
	 * Adds a new element at a specific position.
	 * @param data Data that element is to contain.
	 * @param index Index to add new element at.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or past the size of the list.
	 */
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			head = new Node (head, data);
		} else {
			Node current = head;
			for (int i = 0; i < index -1; i++) {
				current = current.link; 
			}
			current.link = new Node (current.link, data);
		}
		size++;
	}

	@Override
	/**
	 * Replaces the data  at index.
	 * @param data Data to replace.
	 * @param index Index of element to replace.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
	 */
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.link; 
		}
		current.data = data;
		
	}

	@Override
	/**
	 * Gets the number of elements in the list.
	 * @return Size of list (0 meaning empty)
	 */
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	/**
	 * Removes element at index from list, reducing the size.
	 * @param index Index of element to remove.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or past the size - 1.
	 */
	public void delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			size--;
			Object obj = head.data;
			head = head.link;
		} else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.link; 
			}
			current.link = current.link.link;
			size--;
		}
		
	}

	@Override
	/**
	 * Gets the data at the specified index.
	 * @param index Index of element to get.
	 * @return Data in element or null if it was not found.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of the list.
	 */
	public Object retrieve(int index) throws IndexOutOfBoundsException {

		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.link;
		}
		return current.data;
		
	}

	@Override
	/**
	 * Gets the first index of element containing data.
	 * @param data Data object to find the first index of.
	 * @return First of index of element with matching data or -1 if not found.
	 */
	public int indexOf(Object data) {
		int index = 0;
		Node current = head;
		while (current != null) {
			if (current.data.equals(data)) {
				return index;
			}
			index++;
			current = current.link;
		}
		return -1;
	}

	@Override
	/**
	 * Go through elements and check if we have one with data.
	 * @param data Data object to search for.
	 * @return True if element exists with value.
	 */
	public boolean contains(Object data) {
		if ( this.indexOf(data) >= 0 ) {
			return true;
		} else return false;
	}

}
