import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final double eps = 1e-9;
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		while(sc.ready())
		{
			try
			{
				Point a = new Point(sc.nextDouble() , sc.nextDouble());
				Point b = new Point(sc.nextDouble() , sc.nextDouble());
				Point c = new Point(sc.nextDouble() , sc.nextDouble());
				Point d = new Point(sc.nextDouble() , sc.nextDouble());
				
				double x , y;
				
				if(c.equals(a))
				{
					x = b.x + d.x - a.x;
					y = b.y + d.y - a.y;
				}else if(c.equals(b))
				{
					x = a.x + d.x - b.x;
					y = a.y + d.y - b.y;
				}else if(d.equals(a))
				{
					x = b.x + c.x - a.x;
					y = b.y + c.y - a.y;
				}else
				{
					x = a.x + c.x - b.x;
					y = a.y + c.y - b.y;
				}
				System.out.printf("%.3f %.3f\n", x, y);
			}catch(Exception e)
			{
				break;
			}
		}
	}
	
	static class Point {
		double x , y; public Point(double a,double b) {
			x = a; y = b;
		}
		
		boolean equals(Point p)
		{
			return Math.abs(x-p.x) < eps && Math.abs(y-p.y)< eps;
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
