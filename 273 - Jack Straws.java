import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * First I treat all segments as lines (infinite lines)
 * then I check for points of intersection
 * 2 main cases arise: 
 * 	1- if 2 lines are not parallel then this means that there is an intersection point between them
 * 		in such case I check if this point exists in both segments or not
 * 	2- if 2 lines are parallel then in such case I check if they overlap each other or not
 * PS: beware of vertical lines
 */
public class Main {
	static double EPS = 1e-9;
	static int n;
	static Segment[] arr;
	static UnionFind uf;
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
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner((System.in));
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while(t-->0)
		{
			n = sc.nextInt();
			arr = new Segment[n];
			for (int i = 0; i < n; i++) {
				Point a = new Point(sc.nextInt(), sc.nextInt());
				Point b = new Point(sc.nextInt(), sc.nextInt());
				arr[i] = new Segment(a, b);
			}
			uf = new UnionFind(n);
			
			for (int i = 0; i < n; i++) 
				for (int j = i+1; j < n; j++) 
					if(areTouch(i, j))
						uf.union(i, j);
			
			if(!first)sb.append("\n");
			first = false;
			while(true)
			{
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				if(a==-1)break;
				sb.append(uf.sameSet(a, b)?"CONNECTED\n":"NOT CONNECTED\n");
			}
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
	
	static class UnionFind 
	{
		int[] set,rank;
		public UnionFind(int n)
		{
			set = new int[n];
			rank = new int[n];
			for (int i = 0; i < set.length; i++) {
				set[i] = i;
				rank[i] = 1;
			}
		}
		int find(int x)
		{
			return set[x]==x? x:(set[x]=find(set[x]));
		}
		void union(int a,int b)
		{
			int x = find(a) , y = find(b);
			if(rank[x]>rank[y])
				set[y] = x;
			else
			{
				set[x] = y;
				if(rank[x]==rank[y])
					rank[y]++;
			}
		}
		boolean sameSet(int a,int b)
		{
			return find(a)==find(b);
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
