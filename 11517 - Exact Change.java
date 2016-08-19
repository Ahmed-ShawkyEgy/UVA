import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static int[][] mem;
	static int[][] mem2;
	static int target;
	static final int oo = (int) 1e5;
	static boolean found;
	public static int dp(int sum,int index)
	{
		if(sum<0)
			return oo;
		if(sum==0)
		{
			found = true;
			return 0;
		}
		if(index >= arr.length)
		{
			if(sum==0)
			{
				found = true;
				return 0;
			}
			return oo;
		}
		if(mem[index][sum]!=-1 )
			return mem[index][sum];
		int a = 1+dp( sum-arr[index], index+1 );
		int b = dp( sum,index+1 );
		return mem[index][sum]= Math.min(a, b);
	}	
	public static int getSum(int sum,int ind)
	{
		if(ind == arr.length)
		{
			if(sum>=target)
			{
				return sum;
			}
			return oo;
		}
		if(sum>=target)return sum;
		if(mem2[ind][sum]!=-1)
			return mem2[ind][sum];
		int take = getSum(sum+arr[ind], ind+1);
		int leave = getSum(sum, ind+1);
		return mem2[ind][sum] = Math.min(take, leave);
	}
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter out = new PrintWriter(System.out);
		mem = new int[101][30001];
		mem2 = new int[101][30001];
		while(t-->0)
		{
			for(int[] i : mem)
				Arrays.fill(i, -1);
			for(int[] i : mem2)
				Arrays.fill(i, -1);
			int x = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			found = false;
			target = x;
			int sum=getSum(0, 0);
			int coins =dp(sum,0);
			out.append(sum+" "+coins+"\n");
		}
		out.flush();
    }
	
}
