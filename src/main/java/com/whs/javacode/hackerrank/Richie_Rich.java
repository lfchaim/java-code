package com.whs.javacode.hackerrank;

import java.util.Scanner;

public class Richie_Rich
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String tem = s.nextLine();
		String tem1[] = tem.split(" ");

		int n = Integer.parseInt(tem1[0]);
		int k = Integer.parseInt(tem1[1]);

		String data1 = s.nextLine();
		char data[] = data1.toCharArray();
		if (n % 2 == 0)
		{
			int count = 0;
			for (int i = (n / 2) - 1; i >= 0; i--)
			{
				if (data[i] > data[n - 1 - i])
				{
					data[n - 1 - i] = data[i];
					count++;
				} else if (data[i] < data[n - 1 - i])
				{
					data[i] = data[n - 1 - i];
					count++;
				}
				if (count > k)
					break;

			}
//			System.out.println(count);
//			disp(data);
			if (count > k)
				System.out.println("-1");
			else if (count == k)
			{
				disp(data);
			} else if (count < k)
			{
				int now = k - count;
				if (now % 2 == 1)
					now--;
				now = now / 2;
				for (int i = 0; i <= (n / 2) - 1; i++)
				{
					if(data[i]!='9')
					{
					data[i] = '9';
					data[n - 1 - i] = '9';
					now=now-2;
					}
					if (now <= 0)
						break;
				}

				disp(data);

			}
		}
		else
		{

			int count = 0;
			for (int i = (n / 2) - 1; i >= 0; i--)
			{
				if (data[i] > data[n - 1 - i])
				{
					data[n - 1 - i] = data[i];
					count++;
				} else if (data[i] < data[n - 1 - i])
				{
					data[i] = data[n - 1 - i];
					count++;
				}
				if (count > k)
					break;

			}
//			System.out.println(count);
			if (count > k)
				System.out.println("-1");
			else if (count == k)
			{
				disp(data);
			} else if (count < k)
			{
				int now = k - count;
				if (now % 2 == 1)
				{
					now--;
					data[n/2]='9';
				}
				now = now / 2;
				for (int i = 0; i <= (n / 2) - 1; i++)
				{
					if(data[i]!='9')
					{
					data[i] = '9';
					data[n - 1 - i] = '9';
					now=now-2;
					}
					if (now <= 0)
						break;
				}

				disp(data);

			}
		
		}

	}

	public static void disp(char data[])
	{
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i]);
		}
		System.out.println();
	}

}
