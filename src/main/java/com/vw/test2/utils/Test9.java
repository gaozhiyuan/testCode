package com.vw.test2.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Test9 {

	public static class BinaryTree {
		private String value;
		private BinaryTree leftNode;
		private BinaryTree rightNode;
		
		public BinaryTree(String value, BinaryTree left, BinaryTree right) {
			this.value = value;
			this.leftNode = left;
			this.rightNode = right;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public BinaryTree getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(BinaryTree leftNode) {
			this.leftNode = leftNode;
		}

		public BinaryTree getRightNode() {
			return rightNode;
		}

		public void setRightNode(BinaryTree rightNode) {
			this.rightNode = rightNode;
		}
		
		
	}
	
	public void preOrder(BinaryTree root) {
		if(root == null)
			return;
		System.out.print(root.getValue() + ", ");
		preOrder(root.getLeftNode());
		preOrder(root.getRightNode());
	}
	
	public void midOrder(BinaryTree root) {
		if(root == null)
			return;		
		midOrder(root.getLeftNode());
		System.out.print(root.getValue() + ", ");
		midOrder(root.getRightNode());
	}
	
	public void postOrder(BinaryTree root) {
		if(root == null)
			return;
		
		postOrder(root.getLeftNode());
		postOrder(root.getRightNode());
		System.out.print(root.getValue() + ", ");
	}
	
	public void printByRow(BinaryTree root) {
		if(root == null)
			return;
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTree node = queue.poll();
			System.out.print(node.value + ", ");
			if(node.leftNode != null)
				queue.add(node.leftNode);
			if(node.rightNode != null)
				queue.add(node.rightNode);
		}
	}
	
	public void printByRow2(BinaryTree root) {
		if(root == null)
			return;
		BinaryTree last = root;
		BinaryTree nLast = null;
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTree node = queue.poll();
			System.out.print(node.value + ", ");
			
			if(node.leftNode != null) {
				queue.add(node.leftNode);
				nLast = node.leftNode;
			}
			if(node.rightNode != null) {
				queue.add(node.rightNode);
				nLast = node.rightNode;
			}
			
			if(last == node) {
				System.out.println();
				last = nLast;
			}
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTree h = new BinaryTree("H", null, null);
		BinaryTree k = new BinaryTree("K", null, null);
		BinaryTree d = new BinaryTree("D", null, null);
		BinaryTree g = new BinaryTree("G", h, k);
		BinaryTree f = new BinaryTree("F", g, null);
		BinaryTree e = new BinaryTree("E", null, f);
		BinaryTree c = new BinaryTree("C", d, null);
		BinaryTree b = new BinaryTree("B", null, c);
		BinaryTree a = new BinaryTree("A", b, e);
		
		Test9 t = new Test9();
		t.preOrder(a);
		System.out.println();
		t.midOrder(a);
		System.out.println();
		t.postOrder(a);
		
		System.out.println();		
		t.printByRow(a);
		
		System.out.println();		
		t.printByRow2(a);
		
		HashMap map;
		
		LinkedHashMap lMap;
		
	}
}
