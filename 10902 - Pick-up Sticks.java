import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static double EPS = 1e-9;
	static Segment[] arr;
	
	static boolean areParallel(Line l1, Line l2) 
	{
		return (Math.abs(l1.a-l2.a) < EPS) && (Math.abs(l1.b-l2.b) < EPS); 
	}
	static boolean areSame(int i1,int i2)
	{
		Segment s1 = arr[i1] , s2 = arr[i2];
		if(!areSame(s1.l, s2.l))return false;
		
		return !(Math.min(s1.a.x, s1.b.x)>Math.max(s2.a.x, s2.b.x)+EPS || Math.min(s2.a.x, s2.b.x)>Math.max(s1.a.x, s1.b.x));
	}
	static 	boolean areSame(Line l1, Line l2)
	{ 
		return areParallel(l1 ,l2) && (Math.abs(l1.c - l2.c) < EPS); 
	}
	static boolean areIntersect(Line l1, Line l2, Point p) 
	{
		if (areParallel(l1, l2)) return false; 
		p.x = (l2.b * l1.c - l1.b * l2.c) / (l2.a * l1.b - l1.a * l2.b);
		if (Math.abs(l1.b) > EPS) p.y = -(l1.a * p.x + l1.c);
		else p.y = -(l2.a * p.x + l2.c);
		return true; 
	}
	
	static boolean areTouch(int i1,int i2)
	{
		Segment s1 = arr[i1] , s2 = arr[i2];
		if(areSame(i1, i2))return true;
		Point p = new Point(0, 0);
		if(areIntersect(s1.l, s2.l, p) )
			if(s1.contains(p) && s2.contains(p))return true;
		return false;
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			n = sc.nextInt();
			if(n==0)break;
			
			arr = new Segment[n];
			for (int i = 0; i < n; i++) 
			{
				Point a = new Point(sc.nextDouble(), sc.nextDouble());
				Point b = new Point(sc.nextDouble(), sc.nextDouble());
				arr[i] = new Segment(a, b);
			}
			HashSet<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < n; i++) 
			{
				Iterator<Integer> it = set.iterator();
				while(it.hasNext())
				{
					int j = it.next();
					if(areTouch(i, j-1))
					{
						it.remove();
					}
				}
				set.add(i+1);
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i : set)
				list.add(i);
			Collections.sort(list);
			sb.append("Top sticks: ");
			sb.append(list.get(0));
			for(int i = 1 ; i<list.size();i++)
				sb.append(", "+list.get(i));
			sb.append(".\n");
		}
		System.out.print(sb);
	}	
	static class Point
	{
		double x,y;
		public Point(double a,double b)
		{
			x = a;
			y = b;
		}
	}
	
	static class Line
	{
		double a,b,c;
		public Line(Point p1,Point p2) 
		{
			if (Math.abs(p1.x - p2.x) < EPS) 
			{ 
				a = 1.0; b = 0.0; c = -p1.x;
			}
			else 
			{
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
		public Segment(Point x,Point y) 
		{
			a = x;
			b = y;
			l = new Line(a, b);
		}
		
		boolean contains(Point p)
		{
			return p.x>=Math.min(a.x, b.x)-EPS && p.x<=Math.max(a.x, b.x)+EPS && p.y>=Math.min(a.y, b.y)-EPS && p.y<=Math.max(a.y, b.y)+EPS ;
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
