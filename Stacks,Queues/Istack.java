package lecture13.shared;

public interface Istack<T> {

	int size();
	boolean isEmpty();
	T pop() ;//throws StackEmptyException;
	void push(T data);// throws StackOverflowException;
	int tos();// throws StackEmptyException;
	void display();
}
