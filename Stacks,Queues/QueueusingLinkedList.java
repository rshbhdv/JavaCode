package lecture13.queue;

import java.util.LinkedList;

import lecture13.shared.Iqueue;
import lecture13.shared.QueueEmptyException;
import lecture13.shared.QueueOverflowException;

public class QueueusingLinkedList<T extends Comparable <T>> implements Iqueue<T>  {

private LinkedList<T> list;
	
	public QueueusingLinkedList() {
		this.list = new LinkedList<>();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size()==0;
	}

	@Override
	public T dequeue() throws QueueEmptyException {
	return this.list.getFirst();
	}

	@Override
	public void enqueue(T item) throws QueueOverflowException {
		this.list.addLast(item);
	}

	@Override
	public int front() throws QueueEmptyException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void display() {
		System.out.println(this);
	}

	public String toString(){
		return this.list.toString();
	}

}
