import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
	static BigInteger[][][][] memo;
	// l specifies the number of consecutive H's that appeared so far
	// flag shows whether l has reached k at some point
	static BigInteger dp(int n , int k , int l,int flag)
	{
		if(l>=k)flag = 1;
		if(n==0)return (flag==1)? BigInteger.ONE : BigInteger.ZERO;
		if(memo[n][k][l][flag] != null)return memo[n][k][l][flag];
		BigInteger res = BigInteger.ZERO;
		res = res.add(dp(n-1,k,l+1,flag));
		res = res.add(dp(n-1,k,0,flag));
		return memo[n][k][l][flag] = new BigInteger(res.toString());		
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		memo = new BigInteger[101][101][101][2];
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			sb.append(dp(n,k,0,0)+"\n");
		}
		
		System.out.print(sb);
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(s));
		}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public String nextLine() throws IOException {return br.readLine();}		
		public long nextLong() throws IOException {return Long.parseLong(next());}		
		public double nextDouble() throws IOException {return Double.parseDouble(next());}	
		public boolean ready() throws IOException {return br.ready();}
	}
}
