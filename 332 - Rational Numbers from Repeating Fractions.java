import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int gcd(int a,int b){if(b==0)return a; return gcd(b,a%b);}
	static int pow(int n){
		int ans = 1;
		while(n-->0)ans*=10;
		return ans;
	}
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		int cases = 1;
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int j = sc.nextInt();
			if(j==-1)break;
			String s = sc.next();
			int k = s.length() - 2 - j;
			
			int num = Integer.parseInt(s.substring(2)) - (k==0?0:Integer.parseInt(s.substring(2, 2+k)));
			int den = pow(k+j) - pow(k);
			
			if(j==0)
			{
				num = Integer.parseInt(s.substring(2));
				den = pow(k);
			}
			
			int g = gcd(num, den);

			num /= g;
			den /= g;
			sb.append("Case "+cases+++": "+num+"/"+den+"\n");

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
