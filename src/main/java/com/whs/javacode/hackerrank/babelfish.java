package com.whs.javacode.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class babelfish
{

	public static void main(String[] args)
	{
		
		Scanner s = new Scanner(System.in);
		String data = s.nextLine();
		Map<String, String> data_base = new HashMap<String,String>();
		while(data!=null)
		{
			String [] tem = data.split(" ");
			if(tem.length<=1)
				break;
			data_base.put(tem[1], tem[0]);
			
			
		data = s.nextLine();	
		}
		
		
		while(s.hasNext())
		{
			data = s.nextLine();
			if(data_base.get(data)==null)
				System.out.println("eh");
			else
				System.out.println(data_base.get(data));
			
			
		}
		
		
		
		
		
	}

}
