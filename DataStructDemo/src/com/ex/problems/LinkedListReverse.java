package com.ex.problems;

public class LinkedListReverse {

	static final class LNode<T>
	{
		T data;
		LNode<T> next;
		
		/**
		 * 注明，构造函数不需要带额外的类型参数，不管是C++还是Java，注意啦，带额外参数的是类类型
		 * @param data
		 * @param next
		 */
		public LNode(T data, LNode<T> next) {
			this.data = data;
			this.next = next;
		}
		
	}
	
	private static LNode<Integer> head;
	
	private static void initLinkedList() {
		head=new LNode<Integer>(null, null);
	}
	
	private static void createLinkedList(int...nArr)
	{
		LNode<Integer> prev=head,cur;
		for (int i = 0; i < nArr.length; i++) {
			cur=new LNode<Integer>(nArr[i], null);
			prev.next=cur;
			prev=cur;
		}
		
	}
	
	public static void printLinkedList() {
		LNode<Integer> cur=head;
		while (cur.next!=null) {
			System.out.println(cur.next.data);
			cur=cur.next;
		}
	}
	
	private static void reverseLinkedList() {
		if (head==null) {
			return;
		}
		LNode<Integer> prev,cur,next;
		prev=head;
		cur=prev.next;
		while (cur!=null) {
			next=cur.next;
			if(prev!=head)//当时收个节点时候直接将next域置为空
			   cur.next=prev;
			else 
			   cur.next=null;
			prev=cur;
			cur=next;
		}
		head.next=prev;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initLinkedList();
		createLinkedList(1,3,5,6,7);
		System.out.println("反正前链表为:");
		printLinkedList();
		System.out.println("反转后链表为:");
		reverseLinkedList();
		printLinkedList();
	}

}
