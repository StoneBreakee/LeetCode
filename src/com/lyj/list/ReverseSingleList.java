package com.lyj.list;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class ReverseSingleList {

	// 非递归,链表倒置
	public static ListNode reverseList(ListNode head) {
		ListNode phead = new ListNode(-1);

		while (head != null) {
			ListNode tmp = head;
			head = head.next;
			
			tmp.next = phead.next;
			phead.next = tmp;
		}

		return phead.next;
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (m < n) {
			ListNode tmp = new ListNode(-1);
			tmp.next = head;
		}
		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		ListNode p = head;
		for (int i = 0; i < 4; i++) {
			ListNode tmp = new ListNode(i + 1);
			tmp.next = p.next;
			p.next = tmp;
			p = p.next;
		}
		showList(head);
		head = reverseList(head);
		showList(head);
	}

	private static void showList(ListNode head) {
		ListNode p = head;
		while (p != null) {
			System.out.print(p.val + " ");
			if (p.next != null)
				p = p.next;
			else
				p = null;
		}
		System.out.println();
	}

}
