package lecture13.queue;

import lecture13.shared.Iqueue;
import lecture13.shared.QueueEmptyException;
import lecture13.shared.QueueOverflowException;

public class QueueusingArrays<T> implements Iqueue<T> {

	protected T[] data ;
	protected int front ; 
	protected int size;
	public static final int Default_CAPACITY =10;
	
	public QueueusingArrays(){
		this(Default_CAPACITY);
	}
	
    public QueueusingArrays(int capacity)
    {
		this.data = (T[])new Object[capacity];
	    this.front=0;
	    this.size=0;
    }
	
	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size==0;
	}

	@Override
	public T dequeue() throws QueueEmptyException{
		
		T retval ;
		if(this.isEmpty())
		{
			throw new QueueEmptyException();
		}
		else
		{
			retval = this.data[this.front];
			this.data[this.front]= null; 
			this.front = (this.front-1)%this.data.length;
			this.size--;
			
		}
		return retval;
	}

	@Override
	public void enqueue(T item) throws QueueOverflowException {
		if(this.size()==this.data.length)
			{
		         throw new QueueOverflowException();    	
			}
		else{
			this.data[this.size()] = item;
			this.size++;
		}
		
	}

	@Override
	public int front() throws QueueEmptyException {
		if(this.isEmpty())
		{
			throw new QueueEmptyException();
		}
		else
		{
			int retval = this.front;
			return retval;
		}
	}

	@Override
	public void display() {
		System.out.println(this);
		
	}
	
	public String toString()
	{
		String retval="";
		for(int i=0;i<this.size();i++)
		{
			int aI = (this.front+this.size())%this.data.length;

			retval += this.data[aI];
		}
		retval += "END";
		 return retval;
	}

}
