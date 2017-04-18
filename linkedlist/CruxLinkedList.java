package linkedlist;

import java.util.Scanner;

//import javax.swing.text.AbstractDocument.LeafElement;

//import linkedlist.LinkedList;
//import linkedlist.LinkedList.Node;
public class CruxLinkedList {
          Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			Node next = null;
		}
		
	}
    public static void dupl1(CruxLinkedList cl){
    	 int l =lens(cl);
    	 int count=0;
    	 Node n = cl.head;
    	 while(n.next!=null)
    	 {
    	int check = n.data;
    	///System.out.println("check->"+check);
    		  
    	Node n1 = n.next;
    	//System.out.println("n1:"+n1.data+","+"n:"+n.data);
    		  while(n1!=null && n1.next!=null)
    		  {
    			  //System.out.println("n1:"+n1.data);
    			  if(n1.data==check)
    			  {
    				  //System.out.println("count");
    				  deln(cl,n1);
    			  }
    			  n1=n1.next;
    		  }
    		  n=n.next;
    	 }
    	 Node temp1 = cl.head;
    		while(temp1!=null)
    		{
    			System.out.println(temp1.data);
    			temp1=temp1.next;
    		}
    }
	public static void main(String[] args) {
		//LinkedList l1 = new LinkedList();
		CruxLinkedList cl = new CruxLinkedList();
		Scanner s = new Scanner(System.in);
		
	cl.head = new Node(2);
	Node sec = new Node(5);
	Node fir = new Node(2);
	Node third = new Node(3);                         //5 should left from 9
	Node third1 = new Node(1);
	Node third2 = new Node(1);
	Node third3 = new Node(3);	
	Node third4 = new Node(2);
	Node third5 = new Node(5);
	Node third6 = new Node(2);
	cl.head.next = sec;
	sec.next = fir;
	fir.next = third;
	//fir.next = third;
	third.next = third1;
	third1.next = third2;
	third2.next = third3;
	third3.next = third4;
	third4.next = third5;
	third5.next = third6;
	//dupl1(cl);
	boolean b = pallin(cl);
	System.out.println(b);
 //   System.out.println("jdfkj");
	}

public static int lens(CruxLinkedList cl) {
	int count=0;
	Node n = cl.head;
	while(n.next!=null)
	{
		count++;
		n=n.next;
	}
	//System.out.println(count+1);
	return count+1;
}
public static void deln(CruxLinkedList cl,Node n)
{
	//System.out.println("in deln");
	Node temp = new Node(0);
	Node n1 = cl.head;
	while(n1.next!=null)
	{
		if(n1.next.equals(n))
		{
			n1.next=n.next;
		}
		n1=n1.next;
	}
	
}
public static boolean pallin(CruxLinkedList cl)
{
	int i=0;
	int[] arr = new int[10];
	boolean b=true;
	Node n = cl.head;
	Node n1 = cl.head;
	while(n!=null)
	{
		arr[i]=n.data;
		System.out.println("i->"+arr[i
		                             ]);
		n=n.next;
		i++;
	}
	for(int j=0;j<arr.length/2;j++)
	{
		if(arr[j]!=arr[arr.length-1-j])
		{
			System.out.println(j+"->"+arr[j]+","+(arr.length-(1-j))+"->"+arr[arr.length-1-j]);
			b=false;
		}
	}
	return b;
}
}
