import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static String[] nameUp,nameDown;
	static int[] costUp,costDown;
	static long memo[][];
	static int memo2[][];
	public static long dp(int down,int up)
	{
		if(down==m || up == n )
			return 0;
		if(memo[down][up]!=-1)
			return memo[down][up];
		long ans = 0;
		ans = Math.max(ans, dp(down,up+1));
		ans = Math.max(ans, dp(down+1,up));
		ans = Math.max(ans, dp(down+1,up+1));
		if(nameUp[up].equals(nameDown[down]))
			ans = Math.max(ans,(long) (costDown[down] + costUp[up] + dp(down+1,up+1)));
		return memo[down][up] = ans;
	}
	public static int getCount (int d,int u)
	{
		if(d==m || u==n)
			return 0;
		if(memo2[d][u]!=-1)
			return memo2[d][u];
		long ans = dp(d,u);
		int res = Integer.MAX_VALUE;
		if(ans==dp(d,u+1))	res = Math.min(res, getCount(d, u+1));
		if(ans==dp(d+1,u))	res = Math.min(res, getCount(d+1, u));
		if(ans==dp(d+1,u+1))res = Math.min(res, getCount(d+1, u+1));
		if(nameUp[u].equals(nameDown[d]) && ans==(long) (costDown[d] + costUp[u] + dp(d+1,u+1))) res = Math.min(res, 1+getCount(d+1,u+1));
		return memo2[d][u] = res;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		while(t-->0)
		{
			n = sc.nextInt();
			nameUp = new String[n];
			costUp = new int[n];
			for (int i = 0; i < n; i++) 
			{
				sc.next();
				nameUp[i] = sc.next();
				costUp[i] = sc.nextInt();
				
			}
			m = sc.nextInt();
			nameDown = new String[m];
			costDown = new int[m];
			for (int i = 0; i < m; i++) 
			{
				sc.next();
				nameDown[i] = sc.next();
				costDown[i] = sc.nextInt();
			}
			memo = new long[m+1][n+1];
			memo2 = new int[m+1][n+1];
			for (int i = 0; i < memo.length; i++) {
				Arrays.fill(memo[i], -1);
				Arrays.fill(memo2[i], -1);
			}
			sb.append(dp(0,0) + " " + getCount(0, 0)+"\n");
		}
		System.out.print(sb);
	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
	
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
	
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
	
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}
	
		public String nextLine() throws IOException {return br.readLine();}
		
		public boolean ready() throws IOException {return br.ready();}
	
	
	}
}
