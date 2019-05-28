package model;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TreeOfImagesTest {

	private TreeOfImages tree;
	
	private void setupScenary1() {
		
	}
	
	private void setupScenary2() {
		this.tree = new TreeOfImages();
		tree.addNode(5);
		tree.addNode(2);
		tree.addNode(4);
		tree.addNode(1);
		tree.addNode(7);
		tree.addNode(6);
		tree.addNode(8);
	}
	
	@Test
	void testTreeOfImages() {
		setupScenary1();
		this.tree = new TreeOfImages();
		assertTrue(tree.getRoot() == null, "The first attribute should be null.");
	}

	@Test
	void testAddNodeInt1() {
		setupScenary2();
		tree.addNode(10);
		assertTrue(search(tree, 10), "The ImageOnTree instance with value == 10 was not added.");
	}

	@Test
	void testAddNodeImageOnTreeImageOnTree() {
		setupScenary2();
		ImageOnTree n = new ImageOnTree(9);
		tree.addNode(n, tree.getRoot());
		assertTrue(search(tree, 9), "The ImageOnTree instance with value == 9 was not added.");
	}

	@Test
	void testSelectRandomNode() {
		setupScenary2();
		ImageOnTree iot = tree.selectRandomNode();
		assertTrue(search(tree, iot.getValue()), "The random node selected doesn't belong to the tree.");
	}

	@Test
	void testSize() {
		setupScenary2();
		assertTrue(tree.size() == 7, "The size method doesn't return the actual weight of the tree.");
	}

	@Test
	void testGetRoot() {
		setupScenary2();
		assertTrue(tree.getRoot().getValue() == 5, "The root reference hasn't been correctly assigned.");
	}
	
	public boolean search(TreeOfImages toi, int key) {
		return search(toi.getRoot(), key);
	}
	
	public boolean search(ImageOnTree current, int key) {
		if(current != null) {
			if(current.getValue() == key) {
				return true;
			} else {
				if(key <= current.getValue()) {
					return search(current.getLeft(), key);
				} else {
					return search(current.getRight(), key);
				}
			}
		}
		return false;
	}
	
}
