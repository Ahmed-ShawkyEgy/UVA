// naive algorithm

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
	static int n,T,time[];
	static double EPS = 1e-9;
	static Point[] arr;
	static StringBuilder sb = new StringBuilder();
	static DecimalFormat f = new DecimalFormat("0.0000");
	
	static void solve()
	{
		Point cur = arr[0];
		Point nxt = rotate(cur,new Point(0,0),getRad(time[0]));
		sb.append(f.format(dist(nxt)));
		vec trans = new vec(cur,nxt);
		for(int i = 1;i<n;i++)
		{
			Point prev = nxt;
			cur = arr[i];
			nxt = rotate(translate(cur, trans),prev,getRad(time[i]));
			sb.append(" "+f.format(dist(nxt)));
			trans = new vec(cur,nxt);
		}
		sb.append("\n");
	}
	
	// Distance from origin to point a
	static double dist(Point a)
	{
		return Math.sqrt(a.x*a.x + a.y*a.y);
	}
	
	// Rotates point a around point b
	static Point rotate(Point a,Point b,double rad)
	{
		double x1 = a.x - b.x;
		double y1 = a.y - b.y;

		double x2 = x1 * Math.cos(rad) - y1 * Math.sin(rad);
		double y2 = x1 * Math.sin(rad) + y1 * Math.cos(rad);

		return new Point( x2 + b.x,y2 + b.y);
	}
	
	// Translates point p by vector v
	static Point translate(Point p, vec v) { return new Point(p.x + v.x , p.y + v.y); }
	
	// Calculates rotation degree in radiant using t to T ratio
	static double getRad(int t)	{ return (T * 2.0 * Math.PI)/t; }
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		
		while(sc.ready())
		{
			n = sc.nextInt();
			T = sc.nextInt();
			arr = new Point[n];
			time = new int[n];
			arr[0] = new Point(sc.nextInt(),0);
			time[0] = sc.nextInt();
			for (int i = 1; i < n; i++) 
			{
				arr[i] = new Point(arr[i-1].x+sc.nextInt(),0);
				time[i] = sc.nextInt();
			}
			
			solve();
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
	
	static class vec{
		double x,y;
		
		public vec(Point a, Point b) { 	x = b.x - a.x; y = b.y - a.y; }
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
