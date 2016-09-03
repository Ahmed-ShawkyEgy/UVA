import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);		
		int t = Integer.parseInt(br.readLine());
		int cases = 1;
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0)
			{
				out.append("Case 1: Possible from station 1\n");
				br.readLine();br.readLine();
				continue;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] amount = new int[n+1];
			int [] required = new int[n+1];
			int a = 0;
			int b = 0;
			for(int i =0;i<n;i++)
			{
				if(!st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				amount[i] = Integer.parseInt(st.nextToken());
				a+=amount[i];
			}
			for(int i =0;i<n;i++)
			{
				if(!st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				required[i] = Integer.parseInt(st.nextToken());
				b+=required[i];
			}
			if(b>a)
			{
				out.append("Case "+cases++ +": Not possible\n");
				continue;
			}
			int fuel = 0;
			int req = 0;
			int ans = 0;
			for (int i = 0; i < n; i++)
			{
				fuel+=amount[i];
				req+=required[i];
				if(req>fuel)
				{
					fuel = 0;
					req = 0;
					ans=i+1;
				}
			}
				out.append("Case "+cases++ +": Possible from station "+ ++ans+"\n");
		}		
		out.flush();
	}
	public static void clone(int [] arr1,int [] arr2)
	{
		for (int i = 0; i < arr2.length; i++) {
			arr1[i] = arr2[i];
		}
	}
}
