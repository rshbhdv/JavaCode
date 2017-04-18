package linkedlist;

import java.util.Scanner;

public class LinkedList {

	Node head;              //head of list
	static class Node{                   //remember to make it static
		int data;
		Node next;
		
		Node(int d)             //constructor to create new node
		{
			data = d;
			next = null;
		}
	}

	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		l.head = new Node(65);
		Node second  = new Node(75);
		Node third = new Node(85);
		Node fourth = new Node(95);
		Node fifth = new Node(105);
		Node sixth = new Node(115);
		
		/* Three nodes have been allocated  dynamically.
        We have refernces to these three blocks as first,  
        second and third

        llist.head        second              third
           |                |                  |
           |                |                  |
       +----+------+     +----+------+     +----+------+
       | 65  | null |     | 75  | null |     |  85 | null |
       +----+------+     +----+------+     +----+------+ */
	
	   l.head.next = second;
	   
	   /*  Now next of first Node refers to second.  So they
       both are linked.

    llist.head        second              third
       |                |                  |
       |                |                  |
   +----+------+     +----+------+     +----+------+
   | 1  |  o-------->| 2  | null |     |  3 | null |
   +----+------+     +----+------+     +----+------+ */
	   second.next = third;
	   /*  Now next of second Node refers to third.  So all three
       nodes are linked.

    llist.head        second              third
       |                |                  |
       |                |                  |
   +----+------+     +----+------+     +----+------+
   | 1  |  o-------->| 2  |  o-------->|  3 | null |
   +----+------+     +----+------+     +----+------+ */
//	   
//	   System.out.println("second:"+second.data+","+second.next);
//	   System.out.println("third"+third.next);
//	   System.out.println("head:"+l.head.data+","+l.head.next);
	   third.next=fourth;
	   fourth.next = fifth;
	   fifth.next = sixth;
	   Node n = l.head;
	   Scanner s = new Scanner(System.in);
	   System.out.println("enter:");
	   int opt = s.nextInt();
	   if(opt==1)
	   {
		   addatone(l);
	   }
	   else if(opt==2)
	   {
		   addatnode(l,third);
	   }
	   else if(opt==3)
	   {
		  delatone(l); 
	   }
	   else if(opt==4)
	   {
		   delatmiddata(l,75);
	   }
	   else if(opt==5)
	   {
		   delatmidadd(l,second);
	   }
	   else if(opt==6)
	   {
		  delatlast(l); 
	   }
	   else if(opt==7)
	   {
		  int lentgh = len(l);
		  System.out.println("length:"+lentgh);
	   }
	   else if(opt==8){
		   swap(l,second,sixth);
	   }
	   else if(opt==9){
		   reverseLinkedList(l);
	   }
	   else if(opt==10)
	   {
		   find(l,715);
	   }
	   else if(opt==11)
	   {
		   findn(l,5);
	   }
	   else if(opt==12)
	   {
		   mid(l);
	   }
	   else if(opt==13)
	   {
		   mide(l);
	   }
	   else if(opt==14)
	   {
		   repe(l);
	   }
	   else{
		   addatlast(l);
	   }
//	   Node n5 = l.head;
//	   while(n5!= null)
//	   {
//		   System.out.println(n.data+"");
//		   n5=n5.next;
//	   }
	   
	}
	public static void delatone(LinkedList l)
	{ 
		Node n = l.head.next;
		l.head = n;
		 while(n!= null)
		   {
			   System.out.println(n.data+"");
			   n=n.next;
		   }
	}
	public static void delatmiddata(LinkedList m,int d)
	{
		
		Node n1 = m.head; 
		Node n = m.head;
		while(n.data!=d)
		{
			n=n.next;
		}
		while(n1.next!=n)
		{
		   n1=n1.next; 	
		}
		n1.next=n.next;
	}
public static void delatmidadd(LinkedList l,Node second)
{
	Node n = l.head;
	while(n.next!=second)
	{
		n=n.next;
	}
	n.next=second.next;
}
public static void delatlast(LinkedList l)
{
	Node n1 = l.head;
	Node n = l.head;
	while(n.next!=null)
	{
		n1=n;
		n=n.next;
	}
	while(n1.next!=n)
	{
		//n1=n;
		n1=n1.next;
	}
	n1.next=null;
	
}
	public static void addatone(LinkedList l){
		Node n  = new Node(10);
		n.next = l.head;
		l.head = n;                              //now make the new node the head
		                                         // then only linked list will show it
		while(n!= null)
		   {
			   System.out.println(n.data+"");
			   n=n.next;
		   }
	}
	public static void addatlast(LinkedList l)
	{
		Node n  = l.head;
		while(n.next!=null)
		{
			n=n.next;
		}
		Node nl = new Node(35);
		n.next = nl;
		
	}
	public static void addatnode(LinkedList l,Node second)
	{
		Node n = new Node(12);
		Node n1=l.head;
		while(n1.next!=second.next)
		{
			n1=n1.next;
		}
		n.next = n1.next ;
		n1.next =  n;
	}

public static int len(LinkedList l )
{
	int count=0;
	Node n = l.head;
	while(n.next!=null)
	{
		count++;
		n=n.next;
	}
	return count+1;
}

public static void swap(LinkedList l,Node second,Node third)
{
	Node temp1 = new Node(0);
	Node temp = new Node(0);
	Node n = l.head;
	while(n.next!=second)
	{
		n=n.next;
	}
	Node n1 = l.head;
	while(n1.next!=third)
	{
		n1=n1.next;
	}
	temp.next=n.next;
	n.next = n1.next;
	n1.next = temp.next;
	
	temp1.next=second.next;
	second.next = third.next;
	third.next = temp1.next;
	
	
}
public static void find(LinkedList l,int d){
	Node n = l.head;
	while(n.next!=null)
	{
		if(n.data==d)
		{	System.out.println("yes");
		return;}
		n=n.next;
	}
	System.out.println("No");
}
public static void reverse(LinkedList l)
{
	int lenthg = len(l);
	int count=0;
	for(int i=1;i<=lenthg-1;i++)
	{
		count=0;
		Node n = l.head;
		if(lenthg-i-1>0){
			System.out.println("i ma in");
			System.out.println(n.next);
			while(count<=lenthg-i-2){
			  
			int check1 = lenthg-i-2;
			System.out.println(check1);
			System.out.println(n.data);
			n=n.next;
			   count++;
			}
		count=0;
		Node n1 = l.head;
		System.out.println(n1.next);
			while(count<=lenthg-i-1){
				int check2 = lenthg-i-1;
				System.out.println(check2);
				System.out.println(n1.data);
				n1=n1.next;
			count++;	
			}
			n1.next=n;
	}}
	
	
}

public static void findn(LinkedList l,int n)
{
	Node no = l.head;
	for(int i=0;i<n;i++)
	{
		no=no.next;
	}
	System.out.println(no.data);
}


public static void mide(LinkedList l)
{
	int count=0;
	Node n = l.head;
	while(n.next!=null)
	{
		n=n.next;
		count++;
	}
	findn(l,(count+1)/2);
}

public static void mid(LinkedList l)
{
	Node n  = l.head;
	Node n1 = l.head;
	while(n1.next!=null && n1.next.next!=null)
	{
		n=n.next;
		n1=n1.next.next;
	}
	System.out.println(n.data);
}

public static void repe(LinkedList l)
{
	//int l1 = 0;

	Node n=l.head;
	//Node n1=l.head;
	while(n.next!=null)
	{int l1 = 0;
	Node n1=l.head;
		while(n1.next!=null)
		{
			if(n.data==n1.data)
			{
				l1++;
			}
			
			n1=n1.next;
		}
		System.out.println(n.data+"->"+l1);
		n=n.next;
	}
}

public static void reverseLinkedList(LinkedList l)
{
Node current = l.head;
Node next = null;
Node prev  = null;
while(current!=null)
{
	next = current.next;
	System.out.println(next +":next");
	current.next = prev;                 //in first iteration it will point to null
	System.out.println(prev+":prev");
	prev = current;
	current = next;
	System.out.println(current+":current");
	// System.out.println(current.data); 
}
l.head = current ;
 System.out.println(current.next); 
  Node n5 = l.head;
  while(n5!= null)
  {
	  System.out.println("sdj");
	   System.out.println(n5.data+"");
	   n5=n5.next;
  }
}

//public static void nfromend(LinkedList l,int ind)
//{
//	Node n1 = l.head;
//	Node n = l.head;
//	while(n.next!=null)
//	{
//		n=n.next;
//	}
//	
//	for()
//}

}
