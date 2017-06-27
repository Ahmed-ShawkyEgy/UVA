import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m,p;
	static double[][] adjMat;
	static int[] store;
	static double[] save;
	static final int oo = (int) 1e8;
	static double[][][] memo;
	public static double dp(int ind,int mask,int req) // Current store :: Operas purchased :: Remaining number of operas
	{
		if(req==0)
			return -round(adjMat[ind][0]);
		if(memo[ind][mask][req]!=-oo)
			return memo[ind][mask][req];
		double ans = -oo;
		for(int i =0;i<p;i++)
			if((mask&(1<<i))==0) // not taken
				ans = Math.max(round(ans), round(save[i] - adjMat[ind][store[i]] + dp(store[i],(mask|(1<<i)),req-1 )));
		return memo[ind][mask][req] = ans;
	}
	public static void main(String[] args) throws Throwable
	{
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		DecimalFormat f = new DecimalFormat("#0.00");
		int t = sc.nextInt();
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			adjMat = new double[n+1][n+1];
			for (int i = 0; i < adjMat.length; i++) 
				Arrays.fill(adjMat[i], oo);
			
			for (int i = 0; i < n+1; i++)
				adjMat[i][i] = 0;
			for(int i = 0;i<m;i++)
			{
				int from = sc.nextInt();
				int to = sc.nextInt();
				double c = sc.nextDouble();
				adjMat[from][to] = Math.min(adjMat[from][to], c);
				adjMat[to][from] = Math.min(adjMat[to][from], c);
			}
			
			for(int k = 0;k<n+1;k++)
				for(int i = 0;i<n+1;i++)
					for(int j = 0;j<n+1;j++)
						adjMat[i][j] = Math.min(round(adjMat[i][j]),round( adjMat[i][k]+adjMat[k][j] ) );
			
			p = sc.nextInt();
			store = new int[p];
			save = new double[p];
			for (int i = 0; i < p; i++) 
			{
				store[i] = sc.nextInt();
				save[i] = sc.nextDouble();
			}
			memo = new double[n+1][4100][13];
			for (int i = 0; i < memo.length; i++)
				for(int j = 0;j<memo[i].length;j++)
					Arrays.fill(memo[i][j], -oo);
			
			double ans = -oo;
			for(int i = 0;i<=p;i++)
				ans = Math.max(ans, round(dp(0,0,i)));
			if(ans>0)
				out.append("Daniel can save $"+f.format(round(ans))+"\n");
			else
				out.append("Don't leave the house\n");
		}
		out.flush();
	}
	public static double round(double d)
	{
		return (double) Math.round(d*100d)/100d;
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

		public boolean ready() throws IOException {return br.ready();}


	}
}
