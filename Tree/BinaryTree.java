package lecture16;
 
import java.util.Scanner;

import lecture15.GenericTree.*;

// Binary tree file
public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			String retVal = "";

			if (this.left != null) {
				retVal += this.left.data + " => ";
			}

			retVal += this.data;

			if (this.right != null) {
				retVal += " <= " + this.right.data;
			}

			retVal += "\n";

			if (this.left != null) {
				retVal += this.left.toString();
			}
			if (this.right != null) {
				retVal += this.right.toString();
			}

			return retVal;
		}
	}

	private class Pair {
		int height;
		int diameter;

		Pair(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}
	}

	private Node root;
	private int size;

	public BinaryTree(boolean takeInput) {
		if (takeInput) {
			Scanner scn = new Scanner(System.in);
			this.root = this.takeInput(scn, null, false);
		}
	}

	private Node takeInput(Scanner scn, Node parentNode, boolean isParentsLeftChild) {
		if (parentNode == null) {
			System.out.println("Please enter the data for root: ");
		} else {
			if (isParentsLeftChild) {
				System.out.println("Please enter the data for left child of " + parentNode.data);
			} else {
				System.out.println("Please enter the data for right child of " + parentNode.data);
			}
		}

		int cData = scn.nextInt();
		Node child = new Node(cData, null, null);
		this.size++;

		System.out.println("Do you have a left child for " + child.data);
		boolean isChildsLeft = scn.nextBoolean();

		if (isChildsLeft) {
			child.left = this.takeInput(scn, child, true);
		}

		System.out.println("Do you have a right child for " + child.data);
		boolean isChildsRight = scn.nextBoolean();

		if (isChildsRight) {
			child.right = this.takeInput(scn, child, false);
		}

		return child;
	}

	public void display() {
		System.out.println(this);
	}

	public String toString() {
		return this.root.toString();
	}

	public int size() {
		return this.size(this.root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}

		int retVal = 1;

		retVal += this.size(node.left);
		retVal += this.size(node.right);

		return retVal;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int leftHeight = height(node.left);
		int rightHeight = height(node.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public int diameter() {
		// return this.diameter(this.root);
		return this.diameter2(this.root).diameter;
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int factor1 = diameter(node.left);
		int factor2 = diameter(node.right);
		int factor3 = height(node.left) + height(node.right) + 2;

		return Math.max(factor1, Math.max(factor2, factor3));
	}

	private Pair diameter2(Node node) {
		if (node == null) {
			return new Pair(-1, 0);
		}

		int myHeight = 0, myDiameter = 0;

		Pair lPair = diameter2(node.left);
		Pair rPair = diameter2(node.right);

		// calculating myHeight
		myHeight = Math.max(lPair.height, rPair.height) + 1;

		// calculating myDiameter
		int factor1 = lPair.diameter;
		int factor2 = rPair.diameter;
		int factor3 = lPair.height + rPair.height + 2;

		myDiameter = Math.max(factor1, Math.max(factor2, factor3));

		// creating myPair
		Pair retVal = new Pair(myHeight, myDiameter);
		return retVal;
	}

	public boolean findElement(int item) {
		return this.findElement(this.root, item);
	}

	private boolean findElement(Node node, int item) {
		if (node == null) {
			return false;
		}

		// if(node.data == item){
		// return true;
		// }
		// else{
		// boolean foundInLeft = findElement(node.left, item);
		// if(foundInLeft){
		// return true;
		// }
		// else{
		// boolean foundInRight = findElement(node.right, item);
		// if(foundInRight){
		// return true;
		// }
		// else{
		// return false;
		// }
		// }
		// }
		if (node.data == item) {
			return true;
		} else if (findElement(node.left, item) == true) {
			return true;
		} else if (findElement(node.right, item) == true) {
			return true;
		} else {
			return false;
		}
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		if (node == null) {
			return;
		}

		this.mirror(node.left);
		this.mirror(node.right);

		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public BinaryTree mirror2(){
		BinaryTree retVal = new BinaryTree(false);
		
		retVal.root = this.mirror2(this.root);
		
		return retVal;
	}

	private Node mirror2(Node node) {
		if (node == null) {
			return null;
		}

		Node retVal = new Node(node.data, null, null);
		
		retVal.left = this.mirror2(node.right);
		retVal.right = this.mirror2(node.left);
		
		return retVal;
	}

	
	// type  =0 -> pre & in 
	// type  =1 -> post & in 
	
	public void typeselector(int type,int[] one,int[] two)
	{
		if(type==0){
		this.root = this.Subtreefromprein(one, 0, one.length-1, two, 0, two.length-1);
		//System.out.println(this.root);
		
	}
		else if(type==1)
		{
		//this.root = this.Subtreefrompostin(one, 0, one.length-1, two, 0, two.length-1)	;
		}
		else
		{
			System.out.println("invalid args");
		}
	}
	

	private Node Subtreefromprein(int[] pre ,int presi, int preei,int[] in,int insi, int inei)
	{
		//System.out.println("presi" + presi);
		//System.out.println("preei" + preei);
		//System.out.println("insi" + insi);
		int seain=0;
		int count =0 ;
		Node retVal = new Node(pre[presi],null,null);
		for(int i = 0;i<in.length-1;i++)
		{
			if(pre[0] == in[i])
			{
				seain =i;
				break;
			}
			count++;
			System.out.println("count: " + count);
		}
		retVal.left = Subtreefromprein(pre, presi + 1, presi+count, in, insi, count-1);
		retVal.right = Subtreefromprein(pre, presi+count, preei, in, count+1, seain);
		return retVal;
	}
	//private Node Subtreefrompostin(int[] post,int postsi,int postsi,int[] in,int insi,int inei)
	{
		
	}
	public int max()
	{
		return this.max(this.root);
	}
	private int max(Node node)
	{
		if(node==null)
		{
			return Integer.MIN_VALUE;
		}
		int  rootdata = this.root.data;
		int lmax = max(node.left);
		int rmax = max(node.right);
		
		return Math.max(rootdata, Math.max(lmax, rmax));
	}
	
	public int min()
	{
		return this.min(this.root);
	}
	private int min(Node node)
	{
		if(node==null)
		{
			return Integer.MAX_VALUE;
		}
		int  rootdata = this.root.data;
		int lmax = min(node.left);
		int rmax = min(node.right);
		
		return Math.min(rootdata, Math.min(lmax, rmax));
	}
	class triplet{
		boolean b;
		int min;
		int max;
		
		triplet(boolean b,int min,int max)
		{
			this.b = b;
			this.max = max;
			this.min = min;
		}
	}
	public boolean isbst()
	{
		return this.isbst(this.root).b;
	}
	private triplet isbst(Node node)
	{
		if(node==null)
		{
			return null;
		}
		
		triplet lresult = isbst(node.left);
		triplet rresult = isbst(node.right);
		
		triplet retval = new triplet(true,node.data,node.data);
		if(lresult != null && rresult != null){
		if(lresult.max>this.root.data || rresult.min<this.root.data)
		{
			triplet t = new triplet(false,node.data,node.data);
			return t;
		}
		
		if(lresult.b == false && rresult.b == false)
		{
			retval.b=false;
			return retval;
		}
		else
		{
	
			return retval;
		}
	}
		return null;
	}

	
	public boolean isbst3()
	{
		return this.isbst3(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private boolean isbst3(Node node,int min,int max)
	{
	
		if(node == null)
		{
			return false;
		}
		if(node.data>min && node.data <max)
		{
			
			isbst3(node.left,min,node.data);
			isbst3(node.right,node.data,max);
			return true;
		}
		else
		{
			return false;
		}
	
	}
}
