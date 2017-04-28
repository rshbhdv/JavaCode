package lecture13.shared;

public interface Iqueue<T> {

	int size();
	boolean isEmpty();
	T dequeue()  throws QueueEmptyException;
	void enqueue(T item) throws QueueOverflowException;
	int front() throws QueueEmptyException;
	void display();
}

