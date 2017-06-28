import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main { // This is bottom-up approach
	static long[][] memo;
	static Pair[][] trace;
	public static StringBuilder print(int i,int j)
	{
		if(i==j)
			return new StringBuilder("A"+(i+1));
		StringBuilder sb = new StringBuilder("(");
		Pair p = trace[i][j];
		Point a = p.l,b = p.r;
		sb .append( print(a.x,a.y) + " x " );
		sb .append( print(b.x,b.y) + ")");
		return sb;
	}
	public static void main(String[] args) throws Throwable
	{
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int cases = 1;
		while(true)
		{
			int n = sc.nextInt();
			if(n==0)
				break;
			int[] arr = new int[n+1];
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			for(int i = 2;i<=n;i++)
			{
				sc.nextInt();
				arr[i] = sc.nextInt();
			}
			memo = new long[n][n];
			trace = new Pair[n][n];
			for(int len = 1;len<n;len++)
			{
				for (int i = 0; i < n; i++) 
				{
					int j = i+len;
					if(j>=n)
						break;
					long min = Long.MAX_VALUE;
					Pair p = new Pair(i, i,j,j);
					for(int k = i;k<j;k++)
					{
						long cur =(long) (memo[i][k] + memo[k+1][j] + arr[i]*arr[k+1]*arr[j+1]);  
						if(cur<min)
						{
							p = new Pair(i,k,k+1,j);
							min = cur;
						}
					}
					memo[i][j] = min;
					trace[i][j] = p;
				}
			}
			StringBuilder res = print(0,n-1);
			out.append("Case "+cases+++": "+res+"\n");
		}
		out.flush();
	}
	static class Pair
	{
		Point l,r;
		public Pair(int l1,int r1,int l2,int r2)
		{
			this.l = new Point(l1,r1);
			this.r = new Point(l2,r2);
		}
	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public Scanner(FileReader r){	br = new BufferedReader(r);}

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

		public boolean ready() throws IOException 
		{return br.ready();}
	}
}
