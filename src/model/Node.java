package model;

public class Node {

	private Node left;
	private Node right;
	private int value;
	
	/**
	 * Constructor for Node class.
	 * @param val this integer is set to the value attribute.
	 */
	public Node(int val) {
		this.value = val;
	}
	
	//Getters and setters for left, right and value attributes:
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		return value+"";
	}
	
}
