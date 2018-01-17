import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long gcd(long a,long b){return b==0?a:gcd(b,a%b);}
	static long lcm(long a,long b){return 1l * a * (b/gcd(a,b));}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			int N = sc.nextInt() , M = sc.nextInt();
			int[] a = new int[M];
			for (int i = 0; i < a.length; i++) 
				a[i] = sc.nextInt();
			
			int ans = 0 , mask = 0 , bound = 1<<M;
			while(++mask<bound)
			{
				long LCM = 1 ;
				int setSize = 0;
				for (int i = 0; i <= M; ++i)
				{
					if( (mask & (1<<i)) != 0)
					{
						LCM = lcm(LCM, a[i]);
						++setSize;
					}
				}
				if(setSize%2==0)
					ans -= N / LCM;
				else
					ans += N / LCM;
			}
			ans = N - ans;
			sb.append(ans+"\n");
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
