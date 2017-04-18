package linkedlist;

public class AddLinkedList {

	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data =d;
			next=null;
		}
	}
public static void main(String[] args){
	AddLinkedList l = new AddLinkedList();
 l.head = new Node(5);
 Node sec = new Node(8);
 Node third = new Node(6);
 System.out.println("nwe ll");
 AddLinkedList m = new AddLinkedList();
 m.head = new Node(2);
 Node sec1 = new Node(1);
 Node third1 = new Node(3);
 
 Node n = l.head;
 Node n1 = m.head;
 System.out.println("entering");
 while(n.next!=null)
 {
	 System.out.println("hindi");
 while(n1.next != null){
	 System.out.println("hey");
	 n.data = n.data+n1.data;
	 n = n.next;
	 n1= n1.next;
 }}
 System.out.println("jj");
 Node n2 = l.head;
 while(n2.next!=null)
 {
	 System.out.println("sdnb");
	 System.out.println(n2.data);
	 n2=n2.next;
 }
}
}