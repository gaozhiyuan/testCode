package com.vw.test2.utils;

public class Test1 {

	private static class Node {
		boolean isHead;
		int value;
		Node next;

		public Node(boolean isHead) {
			this.isHead = isHead;
		}

		public Node(boolean isHead, int value, Node next) {
			this.isHead = isHead;
			this.value = value;
			this.next = next;
		}
	}

	private static void reverseSingleLinkedList2(Node head, Node newHead) {
		Node p = head.next;

		while (p != null) {
			Node next = p.next;
			p.next = newHead.next;
			newHead.next = p;
			p = next;
		}
	}

	private static void reverseSingleLinkedList(Node head, Node newHead) {

		// 1. find the last item of source linkedTable
		Node p = head.next;
		Node parent = head;
		while (p.next != null) {
			parent = p;
			p = p.next;
		}

		// 2. remove the last item from the source linked table
		parent.next = null;

		// 3. find the last item of new target linked table
		while (newHead.next != null)
			newHead = newHead.next;

		// 4. insert the last item of source linked table to the new target linked table
		// the order is reversed, the last item of source linked table will become the
		// first item of the new target linked table.
		newHead.next = p;

		// 5. if the source linked table still has item, then repeat the above process
		while (head.next != null)
			reverseSingleLinkedList(head, newHead);
	}

	private static boolean isExistLoop(Node head) {
		if (head == null || head.next == null)
			return false;

		Node slow = head.next;
		Node quick = head.next.next;

		while (quick != null) {
			if (slow.value == quick.value)
				return true;

			slow = slow.next;
			quick = quick.next.next;
		}

		return false;
	}

	private static Node findStartOfLoop(Node head) {
		if (head == null || head.next == null)
			return null;

		Node slow = head.next;
		Node quick = head.next.next;
		while (quick != null) {
			if (slow.value == quick.value) {
				quick = head.next;
				slow = slow.next;
				while (quick.value != slow.value) {
					quick = quick.next;
					slow = slow.next;
				}

				return quick;
			}

			slow = slow.next;
			quick = quick.next.next;
		}

		return null;
	}

	public static void mergeOrderedLinkedList(Node head1, Node head2, int order) {

		Node item2 = head2.next;
		while (item2 != null) {
			Node next2 = item2.next;

			Node parent = head1;
			Node item1 = head1.next;
			while (item1 != null) {
				if (order == 0) {
					if (item1.value <= item2.value) {
						parent = item1;
						item1 = item1.next;
						continue;
					}
				} else {
					if (item1.value > item2.value) {
						parent = item1;
						item1 = item1.next;
						continue;
					}
				}
				parent.next = item2;
				item2.next = item1;
				break;
			}
			parent.next = item2;
			item2.next = item1;
			item2 = next2;
		}

	}
	
	public static Node deleteLastNNode(Node head, int number) {
		int length = 0;
		Node node = head.next;
		while(node != null) {
			length ++;
			node = node.next;
		}
		
		if(number > length || number <= 0)
			return null;
		
		int position = length - number + 1;
		int index = 1;
		Node parent = head;
		node = head.next;
		while(index < position) {
			parent = node;
			node = node.next;
			index ++;
		}
		
		parent.next = node.next;
		node.next = null;
		
		return node;
	}
	
	public static Node getMiddleItemOfLinkedList(Node head) {
		int length = 0;
		Node node = head.next;
		while(node != null) {
			length ++;
			node = node.next;
		}
		
		if(length % 2 == 0 || length < 3) {
			return null;
		}
		
		Node slow = head.next;
		Node fast = head.next.next;
		while(fast != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	public static void main(String[] args) {
		/*
		 * check loop Node head = new Node(true); Node one = new Node(false, 1, null);
		 * head.next = one; Node two = new Node(false, 2, null); one.next = two; Node
		 * three = new Node(false, 3, null); two.next = three; Node four = new
		 * Node(false, 4, null); three.next = four; Node five = new Node(false, 5,
		 * null); four.next = five;
		 * 
		 * five.next = two;
		 * 
		 * boolean isExistLoop = isExistLoop(head); System.out.println(isExistLoop);
		 * 
		 * Node start = findStartOfLoop(head); if(start != null)
		 * System.out.println(start.value); else System.out.println("no loop!");
		 */

		// Node newHead = new Node(true);

		// reverseSingleLinkedList(head, newHead);

		// reverseSingleLinkedList2(head, newHead);

		// Node p = newHead.next;
		// while(p != null) {
		// Node next = p.next;
		// System.out.print(p.value + " , ");
		// p = next;
		// }

		Node head = new Node(true);
		Node one = new Node(false, 5, null);
		head.next = one;
		Node two = new Node(false, 4, null);
		one.next = two;
		Node three = new Node(false, 3, null);
		two.next = three;
		Node four = new Node(false, 2, null);
		three.next = four;
		Node five = new Node(false, 1, null);
		four.next = five;

		Node head2 = new Node(true);
		Node one2 = new Node(false, 10, null);
		head2.next = one2;
		Node two2 = new Node(false, 9, null);
		one2.next = two2;
		Node three2 = new Node(false, 8, null);
		two2.next = three2;
//		Node four2 = new Node(false, 7, null);
//		three2.next = four2;
//		Node five2 = new Node(false, 6, null);
//		four2.next = five2;
//		
//		Node six2 = new Node(false, 12, null);
//		five2.next = six2;

//		mergeOrderedLinkedList(head, head2, 1);
		
//		Node n = deleteLastNNode(head, 0);
		
		Node n = getMiddleItemOfLinkedList(head2);

		Node p = head2.next;
		while (p != null) {
			Node next = p.next;
			System.out.print(p.value + " , ");
			p = next;
		}
		
		System.out.println("=============================");
		
		if(n != null)
			System.out.println(n.value);
		else {
			System.out.println("no valid node got deleted!");
		}
	}

}
