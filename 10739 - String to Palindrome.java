import java.io.*;
import java.util.*;
public class Main{
	static char[] arr;
	static int memo[][];
	public static int dp(int i,int j)
	{
		if(i>=j)
			return 0;
		if(memo[i][j]!=-1)
			return memo[i][j];
		if(arr[i]==arr[j])
			return memo[i][j] = dp(i+1,j-1);
		return memo[i][j] = 1 + Math.min(dp(i+1,j),Math.min(dp(i+1,j-1), dp(i,j-1)));
	}
	public static void main(String[] args) throws Throwable
	{	
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		sc.nextLine();
		int cases = 1;
		while(t-->0)
		{
			arr = sc.nextLine().toCharArray();
			memo = new int[arr.length+1][arr.length+1];
			for (int i = 0; i < memo.length; i++) {
				Arrays.fill(memo[i], -1);
			}
			out.append("Case "+cases+++": "+dp(0,arr.length-1)+"\n");
		}
		out.flush();
	}
}
