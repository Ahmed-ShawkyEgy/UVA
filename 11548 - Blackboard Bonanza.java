import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static int compare(String a,String b)
	{
		int res = 0;
		for (int i = 0; i < a.length() && i<b.length(); i++) 
		{
			if(a.charAt(i)==b.charAt(i))
				res++;
		}
		return res;
	}
	public static int adjoin(String prev,String cur)
	{
		int max = 0;
		for (int i = 1; i <= cur.length() && i <= prev.length(); i++) 
		{
			int x = compare(cur.substring(cur.length()-i), prev.substring(0, i));
			max = Math.max(max, x);
		}
		for (int i = 0; i+cur.length() <= prev.length(); i++) 
		{
			int x = compare(cur, prev.substring(i, i+cur.length()));
			max = Math.max(max, x);
		}
		if(prev.length()<cur.length())
		for (int i = cur.length()-prev.length(); i >=0; i--) 
		{
			if(i+prev.length()<=cur.length())
			{
				int x = compare(prev, cur.substring(i, i+prev.length()));
				max = Math.max(max, x);
			}
		}
		for (int i = 1; i <= cur.length() && prev.length()-i>=0; i++) 
		{
			int x = compare(cur.substring(0, i), prev.substring(prev.length()-i));
			max = Math.max(max, x);
		}
		return max;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			int ans = 0;
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) 
			{
				arr[i] = br.readLine();
			}
			for (int i = 0; i < arr.length; i++) 
			{
				for (int j = i+1; j < arr.length; j++) 
				{
					ans = Math.max(ans, adjoin(arr[i], arr[j]));
				}
			}
			System.out.println(ans);
			
		}
	}
}
