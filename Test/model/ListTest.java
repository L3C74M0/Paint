package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.Test;

public class ListTest {
	private List list;
	private ListNode listNode;

	private void setupStage1() {
		list = new List();
		list.addNode(0);
		list.addNode(3);
		list.addNode(6);
		list.addNode(2);
		list.addNode(5);
		list.addNode(4);
	}
	
	private void setupStage2() {
		listNode = new ListNode(list.size());
	}

	@Test
	public void addNodeTest() {
		setupStage1();
		assertNotNull(list.getFirst(), "The first element must not be null since the first element has just been added to the list");
		assertNotNull(list.getFirst().getNext(),"The second element must not be null since the second element has just been added to the list");
		assertNotNull(list.getFirst().getNext().getNext(), "The third element must not be null since the third element has just been added to the list");
		assertNotNull(list.getLastNode().getPrevious().getPrevious(), "The fourth element must not be null since the fourth element has just been added to the list");
		assertNotNull(list.getLastNode().getPrevious(),"The fifth element must not be null since the fifth element has just been added to the list");
		assertNotNull(list.getLastNode(), "The last element must not be null since the last element has just been added to the list");
		
		assertEquals(list.getFirst().getValue(), 0, "The first element added must be 0");
		assertEquals(list.getFirst().getNext().getValue(), 3, "The second element added must be 3");
		assertEquals(list.getFirst().getNext().getNext().getValue(), 6, "The third element added must be 6");
		assertEquals(list.getFirst().getNext().getNext().getNext().getValue(), 2, "The fourth element added must be 2");
		assertEquals(list.getFirst().getNext().getNext().getNext().getNext().getValue(), 5, "The fifth element added must be 5");
		assertEquals(list.getLastNode().getValue(), 4, "The last element added must be 4");
	}
	
	@Test
	public void sizeTest(){
		setupStage1();
		assertEquals(6, list.size());
	}
	
	@Test
	public void selectNextTest() {
		setupStage1();
		setupStage2();	
		
	}
}
