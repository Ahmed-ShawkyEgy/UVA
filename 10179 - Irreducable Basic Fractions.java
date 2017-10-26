import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Totient Euler
public class Main {
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int n = sc.nextInt();
			if(n==0)break;
			int ans = n;
			for(int i = 2; i * i <= n ; i++)
				if(n%i==0)
				{
					while(n%i==0)
						n /= i;
					ans -= ans / i;
				}
			if(n > 1)
				ans -= ans / n;
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
