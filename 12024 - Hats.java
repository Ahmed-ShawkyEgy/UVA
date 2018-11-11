import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {

	static int n;
	static int[][]memo;
	
	static int dp(int idx,int msk)
	{
		if(idx==0)return 1;
		if(memo[idx][msk]!=-1)return memo[idx][msk];
		int ans = 0;
		for(int i = 1;i<=n;i++)
			if(i!=idx && (msk&(1<<i))==0)
				ans += dp(idx-1,msk|(1<<i));
		return memo[idx][msk] = ans;
	}
	
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		int[] fac = new int[13];
		fac[0] = fac[1] = 1;
		for(int i = 2;i<fac.length;i++)fac[i]=fac[i-1]*i;
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		memo = new int[13][1<<13];
		for(int i = 0; i < memo.length;i++)
			Arrays.fill(memo[i], -1);
		while(t-->0)
		{
			n = sc.nextInt();
			String ans = dp(n,0)+"/"+fac[n];
			sb.append(ans+"\n");
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
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}
}
