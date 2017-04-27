package lecture15;

public class Client {
	// 111 3 2 2 5 0 66 0 3 0 4 2 7 0 88 1 99 0
		public static void main(String[] args) {
			GenericTree tree = new GenericTree<>();
			System.out.println("+++");
			tree.display();
			System.out.println("+++");
			System.out.println(tree.size());
			System.out.println("####");
			System.out.println(tree.size2());
			System.out.println("@@@");
			System.out.println(tree.max());
			System.out.println("@@@@");

			System.out.println(tree.height());
			System.out.println("****");
			tree.printAtDepth(3);
			System.out.println("****");
			System.out.println(tree.maxSumOfNodes());
			tree.preOrderIterative();
			tree.levelOrder();
		}

}
