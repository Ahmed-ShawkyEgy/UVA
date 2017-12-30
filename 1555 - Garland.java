import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final double eps = 1e-9;
	static double isValid(int n ,double h1,double h2)
	{
		double h3 = 0;
		for(int i = 3;i<=n;i++)
		{
			h3 = - h1 + 2 + 2*h2;
			if(h3<0) return -1;
			h1 = h2;
			h2 = h3;
		}
		return h3;
	}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		while(sc.ready())
		{
			int n = sc.nextInt();
			double a = sc.nextDouble();
			
			double lo = 0, hi = a , ans = 0 ;
			for(int i = 0; i < 50;i++)
			{
				double mid = (lo+hi)/2;
				double cur = isValid(n,a,mid);
				if(cur>=-eps)
				{
					ans = cur;
					hi = mid;
				}
				else
					lo = mid;
				
			}
			System.out.printf("%.2f%n",ans);
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
