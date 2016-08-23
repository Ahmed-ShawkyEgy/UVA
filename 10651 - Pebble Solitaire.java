import java.util.*;
import java.io.*;

public class Main {
	static int[] mem;
	public static int dp(int mask)
	{
		if(mem[mask]!=-1)
			return mem[mask];	
		int ans = 0;
		for(int i=0;i<12;i++)
		{
			if(isOne(i, mask))
			{
				//for left path
				if(i<10)
				{
					if(isOne(i+1,mask) && !isOne(i+2,mask))
					{
						int cur = take(i,mask);
						cur = take(i+1,cur);
						cur = put(i+2,cur);
						ans = Math.max(ans,1+dp(cur));
					}
				}
				//for right path
				if(i>1)
				{
					if(isOne(i-1,mask) && !isOne(i-2,mask))
					{
						int cur = take(i,mask);
						cur = take(i-1,cur);
						cur = put(i-2,cur);
						ans = Math.max(ans, 1+dp(cur));
					}
				}				
			}
		}
		return mem[mask] = ans;
		
	}
	
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		mem = new int[(1<<12)+1];
		Arrays.fill(mem, -1);
		while(t-->0)
		{
			String s = br.readLine();
			int mask = 0;
			int count = 0;
			for(int i=11;i>-1;i--)
			{
				if(s.charAt(i)=='o')
				{
					mask = put(11-i,mask);
					count++;
				}
			}
			int ans = dp(mask);
			ans = count-ans;
			out.append(ans+"\n");
		}
		out.flush();
    }
	public static boolean isOne(int ind,int mask)
	{
		return ((1<<ind)&mask) !=0;
	}
	public static int take(int ind,int mask)
	{
		return mask^(1<<ind);
	}
	public static int put(int ind,int mask)
	{
		return mask | (1<<ind);
	}
}
