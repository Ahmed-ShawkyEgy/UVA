import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		while(sc.ready())
		{
			int step = sc.nextInt() , mod = sc.nextInt();
			boolean[] taken = new boolean[mod];
			int cur = 0 , cnt = 0;
			while(true)
			{
				if(taken[cur])break;
				taken[cur] = true;
				cnt++;
				cur += step;
				cur %= mod;
			}
			String s = (cnt==mod)? "Good Choice":"Bad Choice";
			System.out.printf("%10d%10d    %s%n",step,mod,s);
			System.out.println();
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
