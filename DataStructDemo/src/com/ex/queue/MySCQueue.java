package com.ex.queue;

public class MySCQueue<T> {

	// ˳��ѭ�����д�С�������Զ�����
	private static int nQueueSize = 10;

	/**
	 * ����˳��ѭ�����е����ݽṹ
	 * 
	 * @author lenovo
	 *
	 * @param <M>
	 */
	private static final class SCQueue<M> {
		int front;
		int rear;
		M[] queue;

		public SCQueue() {
			// TODO Auto-generated constructor stub
			front = rear = 0;
			queue = (M[]) new Object[nQueueSize];
		}
	}

	/**
	 * ����һ��˳��ѭ�����еĶ���
	 */
	private SCQueue<T> SQ;

	/**
	 * ��ʼ��˳��ѭ������SQ
	 */
	private void initQueue() {
		SQ = new SCQueue<T>();
		SQ.rear = SQ.front = 0;
	}

	/**
	 * ��˳��ѭ�������в���Ԫ�أ�����������������н����Զ���������
	 * 
	 * @param e
	 */
	private void EnterQueue(T e) {
		if (SQ.front == (SQ.rear + 1) % nQueueSize) {
			System.out.println("��ǰ�������������н�����Ϊԭ��������");
			enlargeQueue();
		}
		SQ.queue[SQ.rear] = e;
		SQ.rear = (SQ.rear + 1) % nQueueSize;
	}

	/**
	 * ������е�����Ϊԭ��������
	 */
	private void enlargeQueue() {
		T[] tmpQueue = (T[]) new Object[(SQ.rear + nQueueSize - SQ.front) % nQueueSize];
		for (int i = 0; i < tmpQueue.length; i++) {
			tmpQueue[i] = DeleteQueue();
		}
		SQ.front = SQ.rear = 0;
		nQueueSize *= 2;
		SQ.queue = (T[]) new Object[nQueueSize];
		for (int i = 0; i < tmpQueue.length; i++) {
			EnterQueue(tmpQueue[i]);
		}
	}

	/**
	 * ɾ�����еĶ�ͷԪ�ز����ض�ͷԪ��
	 * 
	 * @return
	 */
	private T DeleteQueue() {
		if (SQ.front == SQ.rear) {
			System.out.println("�������Ѿ�Ϊ��:");
			return null;
		}
		T e = SQ.queue[SQ.front];
		SQ.front = (SQ.front + 1) % nQueueSize;
		return e;
	}

	/**
	 * ��ӡ����Ԫ��
	 */
	private void printSCQueue() {
		int i = SQ.front, j = 0;
		while (i != SQ.rear) {
			System.out.println("���еĵ�" + (++j) + "����Ԫ��Ϊ:" + SQ.queue[i]);
			i = (i + 1) % nQueueSize;
		}
	}

	/**
	 * ������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySCQueue<Character> queue = new MySCQueue<Character>();
		queue.initQueue();
		for (int i = 0; i < 26; i++) {
			queue.EnterQueue((char) (i + 65));
		}
		System.out.println("������ǰ�����е�Ԫ��Ϊ:");
		queue.printSCQueue();
		queue.DeleteQueue();
		System.out.println("��ͷԪ�س����к�����е�Ԫ��Ϊ:");
		queue.printSCQueue();
	}

}
