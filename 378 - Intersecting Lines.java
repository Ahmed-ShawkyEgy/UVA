import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final double eps = 1e-9;
	
	static boolean areParallel(Line l1,Line l2){return (Math.abs(l1.a - l2.a) < eps) && Math.abs(l1.b - l2.b) < eps;}
	
	static boolean areSame(Line l1,Line l2){return areParallel(l1, l2) && (Math.abs(l1.c - l2.c) < eps);}
	
	static Point intersect(Line l1,Line l2)
	{
		Point p = new Point(0,0);
		p.x = (l2.b * l1.c - l1.b * l2.c) / (l2.a * l1.b - l1.a * l2.b);
		if(Math.abs(l1.b) > eps) p.y = -(l1.a * p.x + l1.c);
		else p.y = -(l2.a * p.x + l2.c);
		return p;
	}
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		System.out.println("INTERSECTING LINES OUTPUT");
		int t = sc.nextInt();
		while(t-->0)
		{
			Point a1 = new Point(sc.nextInt(), sc.nextInt());
			Point b1 = new Point(sc.nextInt(), sc.nextInt());
			Point a2 = new Point(sc.nextInt(), sc.nextInt());
			Point b2 = new Point(sc.nextInt(), sc.nextInt());
			Line l1 = new Line(a1, b1) , l2 = new Line(a2, b2);
			
			if(areSame(l1, l2))
				System.out.println("LINE");
			else if(areParallel(l1, l2))
				System.out.println("NONE");
			else
			{
				Point p = intersect(l1, l2);
				System.out.printf("POINT %.2f %.2f\n",p.x ,p.y);
			}
		}
		System.out.println("END OF OUTPUT");
	}
	
	static class Point
	{
		double x,y;
		public Point(double x,double y) {this.x = x;this.y = y;}
	}
	
	static class Line
	{
		double a,b,c;
		public Line(Point p1 ,Point p2) {
			if(Math.abs(p1.x - p2.x) < eps)
			{
				a = 1; b = 0; c = -p1.x;
			}
			else
			{
				a = -(double)(p1.y - p2.y) / (p1.x - p2.x);
				b = 1;
				c = -(double)(a*p1.x) - p1.y;
			}
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
