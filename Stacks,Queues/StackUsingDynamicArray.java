package lecture13.stacks;
import lecture13.stacks.*;
import lecture13.shared.Istack;

public class StackUsingDynamicArray<T> implements Istack<T> {

	protected T[] data;
	protected int tos;
	public StackUsingDynamicArray(){
		this.data = (T[]) new Object[5];
	
		StackUsingArray<T> b = new StackUsingArray<T>();
	int tos = -1;
	}
	public void push(T data) {
		if(this.size()==this.data.length)
		{
			T[] temp = (T[]) new Object[ 2* this.size()];
		}
		
		this.tos++;
		this.data[this.tos] = data;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return b.tos+1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return b.pop();
	}

	@Override
	public int tos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
