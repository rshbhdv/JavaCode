package lecture12;

import java.util.ArrayList;

import javax.xml.crypto.NodeSetData;
import javax.xml.soap.Node;

public class Client {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		LinkedList<Integer> list3 = new LinkedList<>();
//		list.addLast("Hello");
//		//list.display();
//		list.addLast("there");
//		//list.display();
//		list.addLast("universe");
		//list.display();
		
//		list.addFirst("bingo");
		//list.display();
	//	list.addFirst("whatelse");
		//list.display();
		
		//list.addAt("abracadabra", 3);
		//list.display();
		list.addLast(-1);
		//list.display();
		list.addLast(11);
		//list.display();
		list.addLast(-2);
		//list.display();
		
		list.addFirst(-3);
		//list.display();
		list.addFirst(41);
		//list.display();
		
		list2.addLast(21);
		//list.display();
		list2.addLast(112);
		//list.display();
		list2.addLast(1);
		//list.display();
		
		list2.addFirst(2);
		//list.display();
		list2.addFirst(4);
		//list.display();
		
		//list.addAt("abracadabra", 3);
		//list.display();
		
//		while(!list.isEmpty()){
//			System.out.println(list.removeFirst());
//			list.display();
//		}
		
//		System.out.println(list.removeAt(3));
//		list.display();
//		
//		System.out.println(list.removeAt(3));
//		list.display();
//		
//		System.out.println(list.removeAt(3));
//		list.display();
//		
//		System.out.println(list.removeAt(2));
list.display();
revlist(list);
//		
//		
//		System.out.println(list.removeAt(0));
//		list.display();
//		
//		System.out.println(list.removeAt(0));
//list.display();
		
//		System.out.println(countClimb(4));
		//System.out.println(list.Ireverse());
//System.out.println("asd");		
//list.Ireverse();
	//	list.display();
		list.bubblesort();
		list.display();
	//	list.Ireverse();
		//list.display();
		list2.bubblesort();
		list2.display();
	//	list2.Ireverse();
	//	list2.display();
		list3 = list.mergeTwoSortedLists(list2);
		
		list3.display();
		list3.mergeSort();
		System.out.println("***");
		list3.display();
		
//list.display();
		//System.out.println(list.Nmidpt());
		//System.out.println(list.Rdisplay(list.getNodeAt(0)));
		//Node h = list.Nmidpt();
		//System.out.println("h: " + h);
		//System.out.println(subsetSum(new int[] {1, 2, 3, 4, 5}, 0, 5));
	}
	
	public static int countClimb(int num){
		if(num < 0){
			return 0;
		}
		else if (num == 0){
			return 1;
		}
		
		return countClimb(num - 1) + countClimb(num - 2) + countClimb(num - 3);
	}
	
	public static int cC2(int num){
		if(num == 3){
			return 4;
		}
		else if(num == 2){
			return 2;
		}
		else if(num == 1){
			return 1;
		}
		
		return countClimb(num - 1) + countClimb(num - 2) + countClimb(num - 3);
	}

	public static ArrayList<ArrayList<Integer>> subsetSum(int[] arr, int si, int sum){
		if(si == arr.length - 1){
			if(arr[si] == sum){
				ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();
				ArrayList<Integer> item = new ArrayList<>();
				
				item.add(arr[si]);
				retVal.add(item);
				
				return retVal;
			}
			else if(sum == 0){
				ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();
				ArrayList<Integer> item = new ArrayList<>();
				
				retVal.add(item);
				
				return retVal;
			}
			else{
				ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();
				return retVal;
			}
		}
		
		ArrayList<ArrayList<Integer>> excluders = subsetSum(arr, si + 1, sum);
		ArrayList<ArrayList<Integer>> includers = subsetSum(arr, si + 1, sum - arr[si]);
		
		ArrayList<ArrayList<Integer>> current = new ArrayList<>();
		
		current.addAll(excluders);
		for(int i = 0; i < includers.size(); i++){
			ArrayList<Integer> newList = new ArrayList<>();
			
			newList.addAll(includers.get(i));
			newList.add(arr[si]);
			
			current.add(newList);
		}
		
		return current;
	}
	public static void revlist(LinkedList<Integer> list)
	{
		Node temp;
		if(list.size%2==0)
		{
			
		}
		
	}
	public static int count(LinkedList<Integer> list)
	{
		Node temp = (Node) list.head;	
//		while(temp.next != null)
//		{
//			
//		}
		return 0;
	}
}
