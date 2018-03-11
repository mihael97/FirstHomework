package hr.fer.zemris.java.hw01;

import static org.junit.Assert.*;
import static hr.fer.zemris.java.hw01.UniqueNumbers.*;
import org.junit.Test;

import hr.fer.zemris.java.hw01.UniqueNumbers.TreeNode;

@SuppressWarnings("javadoc")
public class UniqueNumbersTest {

	private static TreeNode head=null;

	@Test
	public void beforeAddTest() {
		assertEquals(0, treeSize(head));
		
		head = addNode(head, 42);
		head = addNode(head, 76);
		head = addNode(head, 21);
		head = addNode(head, 76);
		head = addNode(head, 35);
	}
	
	@Test 
	public void afterAddTest() {
		assertEquals(4, treeSize(head));
	}

}
