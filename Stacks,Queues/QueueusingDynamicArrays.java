package lecture13.queue;
import lecture13.shared.*;
import lecture13.shared.Iqueue;
import lecture13.shared.QueueEmptyException;
import lecture13.shared.QueueOverflowException;
import lecture13.queue.*;


public class QueueusingDynamicArrays<T> extends QueueusingArrays<T> implements Iqueue<T>  {

	public QueueusingDynamicArrays(){
		super();
	}
	
	public void enqueue(T item) throws QueueOverflowException {
		if(this.size() == this.data.length){
			T[] temp = (T[])new Object[2 * this.data.length];
			
			for(int i = 0; i < this.size(); i++){
				int ai = 0;
				temp[i] = this.data[ai];
			}
			
			this.data = temp;
			
		}

		int ai = (this.front+this.size())% this.data.length;

		this.size++;
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T dequeue() throws QueueEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int front() throws QueueEmptyException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
}
