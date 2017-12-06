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
		BigInteger[] fac = new BigInteger[101];
		fac[0] = BigInteger.ONE;
		for (int i = 1; i < fac.length; i++) 
			fac[i] = BigInteger.valueOf(i).multiply(fac[i-1]);
		
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int n = sc.nextInt() , m = sc.nextInt();
			if(n==0 && m==0)break;
			
			BigInteger num = fac[n];
			
			BigInteger den = fac[m].multiply(fac[n-m]);
			
			BigInteger ans = num.divide(den);
			
			sb.append(n+" things taken "+m+" at a time is "+ans+" exactly.\n");
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
