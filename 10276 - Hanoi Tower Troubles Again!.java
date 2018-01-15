import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean isSquare(long n)
	{
		long s = (long) Math.sqrt(n);
		return s*s==n;
	}
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		int t = sc.nextInt() ;
		while(t-->0)
		{
			int n = sc.nextInt();
			int cur = 1;
			int[]a = new int[n];
			lop : while(true)
			{
				for (int i = 0; i < n; i++) 
				{
					if(a[i]==0 || isSquare(a[i] + cur))
					{
						a[i] = cur++;
						continue lop;
					}
				}
				break;
			}
			System.out.println(cur-1);
		}
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
