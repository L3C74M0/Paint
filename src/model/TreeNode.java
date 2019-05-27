package model;

public class TreeNode extends Node {

	private TreeNode left;
	private TreeNode right;
	
	/**
	 * Constructor for Node class.
	 * @param val this integer is set to the value attribute.
	 */
	public TreeNode(int val) {
		super(val);
	}
	
	//Getters and setters for left, right and value attributes:
	
	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
}
