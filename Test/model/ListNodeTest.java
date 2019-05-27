package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListNodeTest {
	private ListNode listNode;

	public void setupStage1() {
		listNode = new ListNode(1);
	}

	@Test
	void constructorTest() {
		setupStage1();
		assertNotNull(listNode, "The listNode must not be null since a new one has just been instantiated");
	}

	@Test
	void testListNode() {
		
	}

	@Test
	void testGetNext() {
		
	}

	@Test
	void testSetNext() {
		
	}

	@Test
	void testGetPrevious() {
		
	}

	@Test
	void testSetPrevious() {
		
	}

	@Test
	void testIsSelected() {
		
	}

	@Test
	void testSetSelected() {
		
	}
}
