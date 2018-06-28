package TestCases_Debug;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args)
	{
		ArrayList<String> arraylist=new ArrayList<String>();
		arraylist.add("aa");
		arraylist.add("zz");
		arraylist.add("cc");
		System.out.println("before sorting");
		for(String obj:arraylist)
		{
			System.out.println(obj);
		}
		Collections.sort(arraylist,Collections.reverseOrder());
		System.out.println("after sorting decending");
		for(String obj:arraylist)
		{
			System.out.println(obj);
		}
		Collections.sort(arraylist,Collections.r);
		for(String obj)
			}
		}
