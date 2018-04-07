import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static char[] a;
	static long[][] memo;
	static long mod = (long) 1e9;
	
	static long dp(int i,int j)
	{
		if(i>j)return 0;
		if(i==j)return 1;
		if(memo[i][j]!=-1)return memo[i][j];
		
		long ans = 0;
		for (int k = i+1; k <=j ; k++) 
			if(a[k]==a[i])
				ans += ( (dp(i+1,k-1)%mod) * ( dp(k,j)%mod ) ) %mod;
		
		
		return memo[i][j] = ans % mod;
		
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			a = sc.nextLine().toCharArray();
			memo = new long[a.length][a.length];
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			sb.append(dp(0,a.length-1)%mod+"\n");
		}
		System.out.print(sb);
	}
	


	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String s) throws FileNotFoundException {br = new BufferedReader(new FileReader(s));}
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
		public char nextChar() throws IOException{return next().charAt(0);}
		public boolean ready() throws IOException {return br.ready();}
		public int[] nextIntArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			int[] res = new int[st.countTokens()];
			for (int i = 0; i < res.length; i++)
				res[i] = nextInt();
			return res;
		}
		public char[] nextCharArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			char[] res = new char[st.countTokens()];
			for (int i = 0; i < res.length; i++) 
				res[i] = nextChar();
			return res;
		}
	}

}
