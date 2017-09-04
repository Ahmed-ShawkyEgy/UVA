import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double EPS = 1e-9;
	static Segment[] arr;
	static int sim(Point p)
	{
		int last = -1;
		while(Math.abs(p.y)>EPS)
		{
			double max = -EPS;
			Segment s = null; 
			int curLast = -1;
			for (int i = 0; i < arr.length; i++) 
			{
				Point inter = arr[i].intersectPoint(p);
				if(inter!=null && max<inter.y+EPS && i!=last)
				{
					max = inter.y;
					s = arr[i];
					curLast = i;
				}
			}
			if(s==null)break;
			last = curLast;
			if(s.a.y>s.b.y)			
			{
				p.y = s.b.y;
				p.x = s.b.x;
			}
			else
			{
				p.y = s.a.y;
				p.x = s.a.x;
			}
		}
		return (int) (p.x+EPS);
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		int t = sc.nextInt();
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			int n = sc.nextInt();
			arr = new Segment[n];
			for (int i = 0; i < n; i++) {
				Point x = new Point(sc.nextInt(), sc.nextInt());
				Point y = new Point(sc.nextInt(), sc.nextInt());
				arr[i] = new Segment(x, y);
			}
			int m = sc.nextInt();
			if(!first)sb.append("\n");
			first = false;
			while(m-->0)
			{
				Point cur = new Point(sc.nextInt(), sc.nextInt());
				sb.append(sim(cur)+"\n");
			}
		}
		System.out.print(sb);
	}	
	
	static class Point 
	{
		double x , y;
		public Point(double a,double b) {
			x = a;
			y = b;
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
		public Segment(Point x,Point y) {a = x; b = y; l = new Line(x,y);}
		
		public Point intersectPoint(Point s)
		{
			if(s.x>Math.max(a.x, b.x) || s.x<Math.min(a.x, b.x))return null;
			double y = -l.c-l.a*s.x;
			if(s.y>=y-EPS)
				return new Point(s.x,y);
			return null;
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
		
		public boolean ready() throws IOException {return br.ready();}
	}
}
