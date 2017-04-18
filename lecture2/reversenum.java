package lecture2;

import java.util.Scanner;

public class reversenum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("enter any no:");
Scanner s = new Scanner(System.in);
int n = s.nextInt();
/*int d=0 ,rev=0 ;*/
int x=0,y=0;
//int count=0;

while(n>0)
{
   x=n%10;
   System.out.println("x=" + x);
   y=y*10+x;
   System.out.println("y is " + y);
   n=n/10;
   System.out.println("n is" + n);
}
System.out.println("the rev number is" + y);
	}

}
