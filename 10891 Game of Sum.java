import java.io.*;
import java.util.*;

public class Main {
	static long[][] memo;
	static long[] arr;
	static final long oo = (long) 1e10;
	public static long dp(int i,int j)
	{
		if(i>j)
			return 0;
		if(i==j)
			return arr[i];
		if(memo[i][j]!=-1)
			return memo[i][j];
		long tmp1 = 0,tmp2 = 0;
		long ans1 = -oo,ans2 = -oo;
		for (int k = i; k <= j; k++) 
		{
			tmp1 += (long)arr[k];
			ans1 = Math.max(ans1, (long)tmp1-dp(k+1,j));
		}
		for (int k = j; k > i; k--) 
		{
			tmp2 +=(long) arr[k];
			ans2 = Math.max(ans2,(long) tmp2-dp(i,k-1));
		}
		return memo[i][j] = Math.max(ans1, ans2);
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine().trim());
			if(n==0)
				break;
			arr = new long[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) 
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			memo = new long[n][n];
			for (int i = 0; i < memo.length; i++) 
			{
				Arrays.fill(memo[i], -1);
			}
			System.out.println(dp(0,n-1));
		}
	}
}
