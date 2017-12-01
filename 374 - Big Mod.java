import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static long pow(long n,long p,long mod)
	{
		if(p==0)
			return 1%mod; 
		long sq = pow(n,p/2,mod);
		sq = ((sq%mod) * (sq%mod))%mod;
		
		if(p%2==1)
			sq = ((sq%mod) * (n%mod))%mod;
		
		return sq%mod;
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			long n = sc.nextLong() , p = sc.nextLong() ,mod = sc.nextInt();
			sb.append(pow(n,p,mod)%mod+"\n");
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
