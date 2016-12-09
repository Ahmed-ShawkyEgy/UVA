import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Main{
	static ArrayList<Integer> arr,sum;
	static int[][] memo;
	static int total;
	static final int oo = (int)1e9;
	static PrintWriter out;
	public static int dp(int ind,int leftLoad)
	{
		if(ind == arr.size())
			return 0;
		int rightLoad = sum.get(ind)-leftLoad;
		if(rightLoad>(total) || leftLoad>(total))
			return 0;
		if(memo[ind][leftLoad]!=-1)
			return memo[ind][leftLoad];
		int ans = 0;
		int left = 0,right = 0;
		if(leftLoad+arr.get(ind)<=total)	left = 1+dp(ind+1,leftLoad+arr.get(ind));
		if(rightLoad+arr.get(ind)<=total) right = 1+dp(ind+1,leftLoad);
		ans = Math.max(left, right);
		return memo[ind][leftLoad] = ans;
	}
	public static void print(int ind,int left)
	{
		if(ind == arr.size())
			return ;
		int right = sum.get(ind)-left;
		if(right>total || left>total)
			return;
		int l = 0,r=0;
		if(left+arr.get(ind)<=total) l = 1+dp(ind+1,left+arr.get(ind));
		if(right+arr.get(ind)<=total) r = 1+dp(ind+1,left);
		if(memo[ind][left]==l)
		{
			if(left+arr.get(ind)<=total)out.append("port\n");
			if(left+arr.get(ind)<=total)print(ind+1,left+arr.get(ind));
		}
		else if(memo[ind][left]==r)
		{
			if(right+arr.get(ind)<=total)out.append("starboard\n");
			if(right+arr.get(ind)<=total)print(ind+1,left);
		}
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		out = new PrintWriter(System.out);
		boolean first = true;
		while(t-->0)
		{
			if(!first)
				out.append("\n");
			first = false;
			br.readLine();
			total = Integer.parseInt(br.readLine().trim());
			total *= 100;
			int cur=0;
			arr = new ArrayList<Integer>();
			sum = new ArrayList<Integer>();
			sum.add(0);
			while(true)
			{
				String s = br.readLine().trim();
				if(s.equals(""))
					continue;
				int x = Integer.parseInt(s);
				if(x==0)
					break;
				cur+=x;
				arr.add(x);
				sum.add(cur);
			}
			memo = new int[arr.size()][10001];
			for (int i = 0; i < memo.length; i++) 
			{
				Arrays.fill(memo[i], -1);
			}
			out.append(dp(0,0)+"\n");
			print(0,0);
		out.flush();
		}
	}

}
