package lecture13.queue;

import lecture13.shared.QueueEmptyException;
import lecture13.shared.QueueOverflowException;
import lecture13.stacks.StackUsingArray;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueusingArrays<Integer> list = new QueueusingArrays<>();
		for(int i=0;i<5;i++)
		{
			try {
				list.enqueue(i);
			} catch (QueueOverflowException e) {
				e.printStackTrace();
			}
		}
		list.display();
		while(list.size()!=0)
		{
	try {
		list.dequeue();
	} catch (QueueEmptyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
		list.display();
	}

}
