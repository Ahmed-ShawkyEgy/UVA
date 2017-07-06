import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static double memo[];
	static int [][] arr;
	public static double dist(int i,int j)
	{
		int x = arr[i][0] - arr[j][0];
		int y = arr[i][1] - arr[j][1];
		return Math.sqrt((x*x)+(y*y));
	}
	public static double dp(int mask)
	{
		if(mask==(1<<n)-1)
			return 0;
		if(memo[mask]>=0)
			return memo[mask];
		double ans = Double.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) 
			if((mask&(1<<i))==0) // i'th person Not taken
				for (int j = i+1; j < arr.length; j++) 
					if((mask&(1<<j))==0) // j'th person Not taken
					{
						int newMask = mask | (1<<i) | (1<<j); // Mark both persons as taken
						ans = Math.min(ans, dist(i,j) + dp(newMask));
					}
		return memo[mask] = ans;
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		DecimalFormat f = new DecimalFormat("#0.00");
		while(true)
		{
			n = Integer.parseInt(br.readLine().trim()) << 1;
			if(n==0)
				break;
			arr = new int[n][2];
			for (int i = 0; i < n; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			memo = new double[(1<<n)+1];
			Arrays.fill(memo, -1);
			sb.append("Case "+cases+++": "+f.format(dp(0))+"\n");
		}
		System.out.print(sb);
	}
	
}
