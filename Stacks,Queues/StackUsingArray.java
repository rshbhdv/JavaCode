package lecture13.stacks;

import lecture13.shared.Istack;

//import lecture13.shared.StackEmptyException;
public class StackUsingArray<T> implements Istack<T> {

	protected T[] data;
	protected int tos;
	private static final int DEFAULT_CAPACITY = 10;
	//StackUsingArray b = new StackUsingArray();
	public StackUsingArray() {
		this.data = (T[]) new Object[5];
         
		int tos = -1;
	}

	@Override
	public int size() {

		return this.tos + 1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public  T pop() {// throws StackEmptyException {

		if (this.size() == 0) {
			System.out.println("stack is empty");
		}

		T retval = this.data[this.tos];
		this.data[this.tos] = null;
		this.tos--;
		return retval;

	}

	@Override
	public void push(T data) {
		// TODO Auto-generated method stub

		if(tos<4){this.tos++;
		this.data[this.tos] = data;
		}
	}

	@Override
	public int tos() // throws StackEmptyException
	{

		return tos;
	}
	public String toString() {
		String retVal = "";

		for (int i = this.tos; i >= 0; i--) {
			retVal += this.data[i] + " => ";
		}
		retVal += "END";

		return retVal;
	}

	@Override

	public void display() {
		System.out.println(this);

	}

}
