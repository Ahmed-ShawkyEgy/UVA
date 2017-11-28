import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
	
	static BigInteger[][][] memo;
	static BigInteger dp(int faces , int trial , int sum)
	{
		if(sum < 0)return BigInteger.ZERO;
		if(trial == 0)return (sum==0)?BigInteger.ONE:BigInteger.ZERO;
		if(memo[faces][trial][sum]!= null)return memo[faces][trial][sum];
		BigInteger res = BigInteger.ZERO;
		for(int i = 1 ; i <= faces;i++)
			res = res.add(dp(faces , trial - 1, sum - i));
		
		return memo[faces][trial][sum] = new BigInteger(res.toString());		
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		memo = new BigInteger[51][51][4001];
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			int F = sc.nextInt();
			int N = sc.nextInt();
			int S = sc.nextInt();
			BigInteger b = BigInteger.valueOf(F).pow(N);
			BigInteger a = dp(F,N,S);
			sb.append(a+"/"+b+"\n");
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
