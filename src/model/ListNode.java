package model;

public class ListNode extends Node {

	private ListNode next;
	private ListNode previous;
	private boolean selected;
	
	/**
	 * Constructor for ListNode class.
	 * post: a new instance of this class with it's correspondent value assigned 
	 * and the next and previous references == null can be created.
	 * @param value the value for the actual node created.
	 */
	public ListNode(int value) {
		super(value);
	}
	
	//Getters and setters
	
	public ListNode getNext() {
		return next;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public ListNode getPrevious() {
		return previous;
	}
	
	public void setPrevious(ListNode prev) {
		this.previous = prev;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}