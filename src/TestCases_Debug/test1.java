package TestCases_Debug;

import java.util.Scanner;

public class test1 {
	
	public static void main(String[] args)
	 {
		/* String str = "HELLO";
		 int i = str.length();
		 StringBuffer strb = new StringBuffer();
		 for( int j=i-1; j>=0; j--){
		strb = strb.append(str.charAt(j));
		 }
		 System.out.println(strb); */
	/*	String str = "I use selenium webdriver.";
		 String toBeReplaced = "selenium";
		 String toReplacedWith = "Firefox";
		 String[] astr = str.split(toBeReplaced);
		 StringBuffer strb = new StringBuffer();
		 for ( int i = 0; i <= astr.length - 1; i++ ) {
		 strb = strb.append( astr[i] );
		 if (i != astr.length - 1) {
		 strb = strb.append(toReplacedWith);
		 }
		 }
		 System.out.println(strb);*/

	
		//Addition of two number
		/*int a,b,sum;
		Scanner s1=new Scanner(System.in);
		System.out.println("enter first number: ");
		a=s1.nextInt();
		System.out.println("Enter second number: ");
		b=s1.nextInt();
		sum=a+b;
		//int c=a+b;
		System.out.println("addition of sum: " +sum);
		}
*/
		
		/*//print 1 to 5 using for loop
		for(int i=0;i<=5;i++)
		{
			System.out.println(i);
		}*/
		
		/*Scanner s1=new Scanner(System.in);
		System.out.println("Enter number: ");
		int i=s1.nextInt();
		if(i%2==0)
		{
			System.out.println("entered number is even");
		}else
		{
			System.out.println("Entered number is odd");
		}
		*/
		//compare stirng
	/*String str=	"HelloWorld";
	String str1="hello world";
	System.out.println(str.compareTo(str1));
	System.out.println(str.equals(str1));*/
		
		/*//find last index of string
		String str="Hello vrushali Hello";
		int s1=str.lastIndexOf("Hello");
		if(s1 == -1)
		{
			System.out.println("Hello not found");
		}else
		{
			System.out.println("Hello found: " +s1);
		}*/
		
		/*//remove particular character
		String str="Hello";
		System.out.println(str.replace('H','W'));*/
		
		/*String str="abcdef";
		StringBuffer s1=new StringBuffer(str).reverse();
		System.out.println(s1);
		*/
		
		/*String str="Hello";
		int intindex=str.indexOf("e");
		if(intindex==-1)
		{
			System.out.println("Not Found");
		}else
		{
			System.out.println("Found: " +intindex);
		}
	 }*/
		
		/*String s1="Hello";
		String[] word =s1.split("\\s");
        for(String s:word)
        {
        	System.out.println(s);
        }*/
		
		
		/*int num, i, j, temp;
	    Scanner input = new Scanner(System.in);
	 
	    System.out.println("Enter the number of integers to sort:");
	    num = input.nextInt();
	 
	    int array[] = new int[num];
	 
	    System.out.println("Enter " + num + " integers: ");
	 
	    for (i = 0; i < num; i++) 
	      array[i] = input.nextInt();
	 
	    for (i = 0; i < ( num - 1 ); i++) {
	      for (j = 0; j < num - i - 1; j++) {
	        if (array[j] > array[j+1]) 
	        {
	           temp = array[j];
	           array[j] = array[j+1];
	           array[j+1] = temp;
	        }
	      }
	    }
	 
	    System.out.println("Sorted list of integers:");
	 
	    for (i = 0; i < num; i++) 
	      System.out.println(array[i]);
	  }*/

		//Prime Number
		/*boolean isPrime=true;
		int temp;
		Scanner src=new Scanner(System.in);
		int num=src.nextInt();
		for(int i=2;i<=num/2;i++)
		{
			 temp=num%i;
		}
		if(temp==0)
		{
			isPrime=false;
		}
	if(isPrime)
	{
		System.out.println("number if Prime");
	}else
	{
		System.out.println("number if not Prime");
	}
}*/
		
		//Reverse a string
		/*String str="Hello";
		StringBuffer sr=new StringBuffer(str);
		System.out.println(sr.reverse());*/
		
		//Reverse a number
		/*int num=123;
	      int reversenum =0;
	      while( num != 0 )
	      {
	          reversenum = reversenum * 10;
	          reversenum = reversenum + num%10;
	          num = num/10;
	      }

	      System.out.println("Reverse of specified number is: "+reversenum);
	   */

		//sum of all number
		int count=1, total=0;
		Scanner src=new Scanner(System.in);
		int num=src.nextInt();
		
		while(count<=num)
		{
			total=total+count;
		}
		System.out.println("total is: " +total);
}
}
