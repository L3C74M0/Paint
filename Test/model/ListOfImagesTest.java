package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ListOfImagesTest {
	private ListOfImages list;

	private void setupStage1() {
		list = new ListOfImages();
		list.addNode(0);
		list.addNode(3);
		list.addNode(6);
		list.addNode(2);
		list.addNode(5);
		list.addNode(4);
	}

	private void setupStage2() {

	}

	@Test
	public void selectNextTest() {
		setupStage1();
		list.selectNext();
		list.selectNext();
		assertTrue(list.getFirst().getNext().isSelected(), "The wrong object or none was selected");
	}

	@Test
	void testListOfImages() {
		setupStage2();
		ListOfImages loi = new ListOfImages();
		assertTrue(loi.getFirst() == null, "The list is not empty");
	}

	@Test
	void testAddNode() {
		setupStage1();
		assertNotNull(list.getFirst(),
				"The first element must not be null since the first element has just been added to the list");
		assertNotNull(list.getFirst().getNext(),
				"The second element must not be null since the second element has just been added to the list");
		assertNotNull(list.getFirst().getNext().getNext(),
				"The third element must not be null since the third element has just been added to the list");
		assertNotNull(list.getLastNode().getPrevious().getPrevious(),
				"The fourth element must not be null since the fourth element has just been added to the list");
		assertNotNull(list.getLastNode().getPrevious(),
				"The fifth element must not be null since the fifth element has just been added to the list");
		assertNotNull(list.getLastNode(),
				"The last element must not be null since the last element has just been added to the list");

		assertEquals(list.getFirst().getValue(), 0, "The first element added must be 0");
		assertEquals(list.getFirst().getNext().getValue(), 3, "The second element added must be 3");
		assertEquals(list.getFirst().getNext().getNext().getValue(), 6, "The third element added must be 6");
		assertEquals(list.getFirst().getNext().getNext().getNext().getValue(), 2, "The fourth element added must be 2");
		assertEquals(list.getFirst().getNext().getNext().getNext().getNext().getValue(), 5,
				"The fifth element added must be 5");
		assertEquals(list.getLastNode().getValue(), 4, "The last element added must be 4");
	}

	@Test
	void testGetFirst() {
		setupStage1();
		assertTrue(list.getFirst().getValue() == 0, "The attribute first hasn't been initialized correctly");
	}

	@Test
	void testSetFirst() {
		setupStage1();
		list.setFirst(null);
		assertTrue(list.getFirst() == null, "The setter method didn't work");
	}

	@Test
	void testSize() {
		setupStage1();
		assertEquals(6, list.size());
	}

	@Test
	void testSelectPrevious() {
		setupStage1();
		list.selectPrevious();
		list.selectPrevious();
		assertTrue(list.getLastNode().isSelected(), "The wrong object or none was selected");
	}

	@Test
	void testGetLastNode() {
		setupStage1();
		assertTrue(list.getLastNode().getValue() == 4, "The last object of the list doesn't coincide with the correct one");
	}

	@Test
	void testLastSelected() {
		setupStage1();
		list.selectNext();
		list.selectNext();
		list.selectNext();
		assertTrue(list.lastSelected().getValue() == 6, "The last selected object doesn't coincide with the correct one");
	}
}