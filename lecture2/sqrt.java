package lecture2;

import java.util.Scanner;

public class sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter the no:");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int z=0;
		int x=0,sqrt=1;
		while(z>=0){
			
			
			x = sqrt*sqrt;
		   // System.out.println(x);
		    //System.out.println(sqrt);
		    z=n-x;
		    if(z<0)
		    {
		    	break;
		    }
		   // System.out.println(z);
		    sqrt = sqrt + 1;
		    //System.out.println(sqrt);
		}
System.out.println("ans is " + (sqrt-1));
	}

}
