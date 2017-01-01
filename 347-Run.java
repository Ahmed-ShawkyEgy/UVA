import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main{
	static int cases = 1;
	static ArrayList<Integer> arr;
	public static int binarySearch(int n)
	{
		int beg = 0,end = arr.size()-1;
		int ans = Integer.MAX_VALUE;
		while(beg<=end)
		{
			int mid = (end+beg)>>1;
			int x = arr.get(mid);
			if(x<n)
			{
				beg = mid+1;
			}
			else
			{
				ans = Math.min(ans, x);
				end = mid-1;
			}
		}
		return ans;
	}
	public static boolean isValid(String s)
	{
		boolean [] arr = new boolean[10];
		int ind = 0;
		int num = s.charAt(ind)-'0';
		for (int i = 0; i < s.length(); i++) 
		{			
			ind = (ind+num)%s.length();
			num = s.charAt(ind)-'0';
			if(arr[num])
				return false;
			arr[num] = true;
		}
		return ind==0;
	}

	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		arr = new ArrayList<Integer>();
		for (int i = 1; i <= 9682415; i++) 
		{
			if(isValid(i+""))
				arr.add(i);
		}
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			int ans = binarySearch(n);
			out.append("Case "+cases+++": "+ans+"\n");
		}
		out.flush();
	}
	
}	
