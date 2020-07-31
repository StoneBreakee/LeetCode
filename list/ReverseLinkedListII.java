package com.lyj.list;

public class ReverseLinkedListII {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * Thinking: List : 1->2->3->4->5 m:2 n:4 create a new node: ListNode temp =
	 * new ListNode(-1); Step: 1. head temp.next | | 1 4->3->2->5 2.head.next =
	 * temp.next;
	 */
	public static ListNode reverseBetween1(ListNode head, int m, int n) {
		ListNode node = new ListNode(-1);
		node.next = null;
		ListNode pre = null, cur = head, tmp = head, start = null;
		int index = 1;
		if (head == null || head.next == null || n == 1 || m == n) {
			return head;
		}
		while (index < m) {
			pre = cur;
			cur = cur.next;
			index++;
		}
		start = cur;
		while (cur != null && index <= n) {
			tmp = cur;
			cur = cur.next;
			tmp.next = node.next;
			node.next = tmp;
			index++;
		}
		start.next = cur;
		if (pre == null) {
			head = node.next;
		} else {
			pre.next = node.next;
		}
		return head;
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}
		ListNode node = new ListNode(-1);
		node.next = head;
		ListNode pre = node;
		int index = 1;
		while (index < m) {
			pre = pre.next;
			index++;
		}

		ListNode start = pre.next;
		ListNode then = start.next;

		while (index < n) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
			index++;
		}
		return node.next;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		for (int i = 0; i < 1; i++) {
			ListNode t = new ListNode(5 - i);
			t.next = head.next;
			head.next = t;
		}
		head = reverseBetween(head, 2, 2);
		while (head != null) {
			System.out.print(head.val + "  ");
			head = head.next;
		}
	}

}