package sait.sll.utility;

import java.io.*;

/**
 * The Node class represents a node in the linked list.
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version July 24, 2020
 */
public class Node implements Serializable {

	/**
	 * Node link is the reference to the next node of the list.
	 */
	Node link;
	/**
	 * Object data is the reference the node has to an object.
	 */
	Object data;
	
	/**
	 * initializes a node with the specified data and link to the next node.
	 * @param link
	 * @param data
	 */
	public Node (Node link, Object data) {
		this.link = link;
		this.data = data;
	}
	
	/**
	 * getter of a reference to the next node after this node.
	 * @return link
	 */
	public Node getLink() {
		return link;
	}
	
	/**
	 * getter of the data from this node
	 * @return data
	 */
	public Object getData() {
		return data;
	}
	
	
	/**
	 * method to set the link to the next node after this node.
	 * @param link
	 */
	public void setLink(Node link) {
		this.link = link;
	}
	
	/**
	 * method to set the data in this node
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
