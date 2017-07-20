import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
	static int [][] memo;
	static int[][] arr;
	static int n,m,oo=2*(int)1e9;
	static StringBuilder s;
	public static int dp(int r,int col)
	{
		if(col==m)
			return 0;
		if(memo[r][col]!=-1)
			return memo[r][col];
		int ans = (r==n-1)? arr[r][col]+dp(0,col+1) : (r==0)? arr[r][col] + dp(n-1,col+1) : oo;
		
		ans = Math.min(ans, arr[r][col] + dp(r,col+1));
		if(r>0)
		ans = Math.min(ans, arr[r][col] + dp(r-1,col+1));
		if(r<n-1)
		ans = Math.min(ans, arr[r][col] + dp(r+1,col+1));
		
		return memo[r][col] = ans;
	}
	public static void print(int r,int col)
	{
		if(col==m)
			return ;
		int ans = dp(r,col);
		if(r==n-1 && ans == arr[r][col]+dp(0,col+1))
		{
			s.append(" "+(r+1));
			print(0, col+1);
			return;
		}
		if(r>0 && ans == arr[r][col] + dp(r-1,col+1))
		{
			s.append(" "+(r+1));
			print(r-1, col+1);
			return;
		}
		if(ans == arr[r][col] + dp(r,col+1))
		{
			s.append(" "+(r+1));
			print(r, col+1);
			return;
		}
		if(r<n-1 && ans == arr[r][col] + dp(r+1,col+1))
		{
			s.append(" "+(r+1));
			print(r+1, col+1);
			return;
		}
		if(r==0 && ans == arr[r][col] + dp(n-1,col+1))
		{
			s.append(" "+(r+1));
			print(n-1, col+1);
			return;
		}				
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++) 
				{
					while(!st.hasMoreTokens())
						st = new StringTokenizer(br.readLine());
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			
			memo = new int[n][m];
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			
			int ans = oo,row = 0;
			for(int i = 0;i<n;i++)
			{
				int cur = dp(i,0);
				if(cur<ans)
				{
					ans = cur;
					row = i;
				}
			}
			s = new StringBuilder();
			print(row, 0);
			sb.append(s.toString().substring(1)+"\n"+ans+"\n");
		}
		System.out.print(sb);
	}
}
