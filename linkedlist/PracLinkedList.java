package lecture11;


public class PracLinkedList {
	public class ListNode{
		int data;
		ListNode next;
		public void setData(int data){
			this.data= data;
		}
        public int getData(){
        	return data;
        }
        public void setNext(ListNode next)
        {
        	this.next = next;
        }
        public ListNode getNext(){
        	return this.next;
        }
	}

		public static void main(String[] args) {
		ListNode node = new ListNode(56);
			
		}
}
