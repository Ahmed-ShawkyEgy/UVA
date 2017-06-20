import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] memo,arr;
	public static int dp(int ind,int time)
	{
		if(time>m)
			return -(int) 1e9;
		if(ind==n)
			return 0;
		if(memo[ind][time]!=-1)
			return memo[ind][time];
		int ans = -(int)1e9;
		for (int i = 0; i < m; i++) 
		{
			if(arr[ind][i]>=5)
				ans = Math.max(ans, arr[ind][i] + dp(ind+1,time+i+1));
		}
		return memo[ind][time] = ans;
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		NumberFormat format = new DecimalFormat("#0.00");
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			for (int i = 0; i < n; i++) 
			{
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) 
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			memo = new int[n][m+1];
			for (int i = 0; i < memo.length; i++) {
				Arrays.fill(memo[i], -1);
			}
			double res = dp(0,0);
			res = Math.round( (res/(n*1.0)) * 100d ) / 100d;
			if(res>0)
			out.append("Maximal possible average mark - "+format.format(res)+".\n");
			else
				out.append("Peter, you shouldn't have played billiard that much.\n");
		}
		out.flush();
	}
}
