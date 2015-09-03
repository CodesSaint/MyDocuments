package com.ex.list;

import sun.net.www.content.text.plain;

public class DBLinkedList<T> {

	/**
	 * ����˫����������ݽṹ
	 * @author lenovo
	 * @param <M>
	 */
	static final class DBLinkNode<M>
	{
		M data;
		DBLinkNode<M> prior;
		DBLinkNode<M> next;
		public DBLinkNode(M data, DBLinkNode<M> prior, DBLinkNode<M> next) {
			this.data = data;
			this.prior = prior;
			this.next = next;
		}
		
	}
	
	//����һ��˫������ͷָ��
	private DBLinkNode<T> head;
	
	/**
	 * ˫�������ʼ������
	 */
	private void init() {
		head=new DBLinkNode<T>(null,null,null);
		head.prior=head;
		head.next=head;
	}
	
	private void insertElement(T e,int nPos) {
		DBLinkNode<T> cur=getLocation(nPos);
		DBLinkNode<T> newNode=new DBLinkNode<T>(e, cur.prior, cur);
		cur.prior.next=newNode;
		cur.prior=newNode;
	}
	
	private DBLinkNode<T> getLocation(int nPos) {
		int i=0;
		DBLinkNode<T> cur=head.next;
		while (i<nPos&&cur!=head) {
			cur=cur.next;
			i++;
		}
		return cur;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
