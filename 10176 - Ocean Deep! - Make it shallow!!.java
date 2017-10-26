import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		BigInteger two = new BigInteger("2");
		BigInteger mod = new BigInteger("131071");
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			String s = "";
			while(true)
			{
				s += sc.nextLine();
				if(s.charAt(s.length()-1) == '#')
					break;
			}
			BigInteger n = new BigInteger("0");			
			for(int i = s.length()-1;i>=0;--i)
			{
				if(s.charAt(i)=='1')
					n = n.add(two.pow(s.length() - i - 1).mod(mod));
				n = n.mod(mod);
			}
			n = n.mod(mod);
			if(n.equals(BigInteger.ZERO))
				sb.append("YES\n");
			else
				sb.append("NO\n");
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
