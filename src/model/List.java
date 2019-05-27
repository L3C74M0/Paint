package model;

public class List implements Measurable {

	private ListNode first;
	
	/**
	 * Basic constructor for List class.
	 * post: a new instance of List with a ListNode reference as attribute first equals to 
	 * null can be created.
	 */
	public List() {
		
	}

	/**
	 * This method adds a new node, which value is passed as parameter, to the doubly linked list.
	 * If the first reference == null, the new node is going to be the first, otherwise, the node 
	 * is going to be added to the end of the list by calling another method.
	 * post: the new node is going to be added to the list.
	 * @param value is the integer which the new node will be created with.
	 * @see #addNode(ListNode, ListNode)
	 */
	public void addNode(int value) {
		ListNode n = new ListNode(value);
		if(first == null) {
			first = n;
		} else {
			addNode(n, first);
		}
	}
	
	/**
	 * This method adds a new node to the doubly linked list in a recursive way.
	 * pre: n != null && current != null.
	 * post: the node is going to be added at the end of the list.
	 * @param n the node to be added.
	 * @param current the needed parameter to make this method recursive.
	 */
	private void addNode(ListNode n, ListNode current) {
		if(current.getNext() != null) {
			addNode(n, current.getNext());
		} else {
			current.setNext(n);
			n.setPrevious(current);
		}
	}
	
	//Getters and setters

	public ListNode getFirst() {
		return first;
	}

	public void setFirst(ListNode first) {
		this.first = first;
	}

	@Override
	public int size() {
		ListNode current = first;
		int size = 0;
		while(current != null) {
			size++;
			current = current.getNext();
		}
		return size;
	}
	
	public void selectNext() {
		ListNode last = lastSelected();
		if(last != null) {
			last.setSelected(false);
			if(last.getNext() != null) {
				last.getNext().setSelected(true);
			} else {
				first.setSelected(true);
			}
		} else {
			first.setSelected(true);
		}
	}
	
	public void selectPrevious() {
		ListNode last = lastSelected();
		if(last != null) {
			last.setSelected(false);
			if(last.getPrevious() != null) {
				last.getPrevious().setSelected(true);
			} else {
				getLastNode().setSelected(true);
			}
		} else {
			first.setSelected(true);
		}
	}
	
	public ListNode getLastNode() {
		if(first != null) {
			ListNode ln = first;
			while(ln.getNext() != null) {
				ln = ln.getNext();
			}
			return ln;
		} else {
			return null;
		}
	}
	
	public ListNode lastSelected() {
		ListNode selected = null; //the last node selected
		ListNode current = first; //the iterator
		while(current != null && selected == null) { //it iterates over the list till the last selected node is found
			if(current.isSelected()) { // verifies if the actual node was the last selected
				selected = current; // updates the selected node reference
			}
			current = current.getNext(); // advances over the list
		}
		return selected;//returns null if none of the nodes was selected, otherwise it returns the last selected
	}
	
}
