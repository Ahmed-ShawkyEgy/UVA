import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		while(t-->0)
		{
			String a = (new StringBuilder(sc.next()).reverse()).toString();
			String b = (new StringBuilder(sc.next()).reverse()).toString();
			
			BigInteger n = (new BigInteger(a)).add(new BigInteger(b));
			StringBuilder tmp = new StringBuilder(n.toString());
			tmp = tmp.reverse();
			StringBuilder res = new StringBuilder();
			boolean trail = true;
			for (int i = 0; i < tmp.length(); i++) 
			{
				if(trail && tmp.charAt(i) == '0')continue;
				trail = false;
				res.append(tmp.charAt(i));
			}
			sb.append(res+"\n");
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
