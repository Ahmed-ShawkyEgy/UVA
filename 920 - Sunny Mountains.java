import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static double EPS = 1e-9;
	static Point[] arr;
	static double dist(Point a,Point b)
	{
		double x = a.x - b.x; x*= x;
		double y = a.y - b.y; y*= y;
		return Math.sqrt(x+y);
	}
	
	static double solve()
	{
		double ans = 0;
		Point p = arr[arr.length-1];
		for(int i = arr.length-2;i>=0;i--)
		{
			if(arr[i].y>p.y+EPS)
			{
				Line l = new Line(arr[i], arr[i+1]);
				if(l.a>EPS)
				{
					double x = -p.y - l.c; x/= l.a;
					Point mid = new Point(x,p.y);
					ans += dist(arr[i], mid);
					p = arr[i];
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		DecimalFormat f = new DecimalFormat("0.00");
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			int n = sc.nextInt();
			arr = new Point[n];
			for (int i = 0; i < n; i++) 
				arr[i] = new Point(sc.nextDouble(), sc.nextDouble());
			Arrays.sort(arr);
			
			sb.append(f.format(solve())+"\n");
		}
		System.out.print(sb);
	}	
	
	static class Point implements Comparable<Point> 
	{
		double x , y;
		public Point(double a,double b) {
			x = a;
			y = b;
		}
		public int compareTo(Point o) {
			return Double.compare(x, o.x);
		}
		
	}
	
	static class Line
	{
		double a,b,c;
		public Line(Point p1 , Point p2)
		{
			if (Math.abs(p1.x - p2.x) < EPS) {
			a = 1.0; b = 0.0; c = -p1.x;
			} else {
			a = -(double)(p1.y - p2.y) / (p1.x - p2.x);
			b = 1.0; 
			c = -(double)(a * p1.x) - p1.y;
			} 
		}
	}
	
	static class Segment
	{
		Point a,b;
		Line l;
		double coef;
		public Segment(Point x,Point y,double c) {a = x; b = y; l = new Line(x,y);coef = c;}
		
		public boolean contains(double x) {return x < Math.max(a.x, b.x)+EPS && x > Math.min(a.x, b.x)+EPS;}
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
