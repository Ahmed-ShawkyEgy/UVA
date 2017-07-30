import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[][] memo;
	static int[] arr;
	static int n,t,p;
	static long dp(int ind,int sum)
	{
		if(ind==n)		
			return (sum-p==t)? 1 : 0;
		if(sum>t)
			return 0;
		if(memo[ind][sum]!=-1)
			return memo[ind][sum];
		long ans = 0;
		if(sum<t)
			ans += dp(ind,sum+1);
		ans += dp(ind+1,sum+p);
		return memo[ind][sum] = ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int c = Integer.parseInt(br.readLine().trim());
		while(c-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			
			memo = new long[n][t+1];
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			
			sb.append(dp(0,p)+"\n");
		}
		System.out.print(sb);
	}
}
