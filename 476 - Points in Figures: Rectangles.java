import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static final double eps = 1e-9;
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		ArrayList<Rect> rect = new ArrayList<Rect>();
		StringBuilder sb = new StringBuilder();
		while(sc.next().charAt(0) != '*')
		{
			Point a = new Point(sc.nextDouble() , sc.nextDouble());
			Point b = new Point(sc.nextDouble() , sc.nextDouble());
			rect.add(new Rect(a, b));
		}
		int cnt = 0;
		while(true)
		{
			cnt++;
			double a = sc.nextDouble() , b = sc.nextDouble();
			if(9999.9 - a <=eps && 9999.9 - b <=eps)break;
			Point p = new Point(a, b);
			boolean contained = false;
			for (int i = 0; i < rect.size(); i++) 
			{
				if(rect.get(i).contains(p))
				{
					contained = true;
					sb.append("Point "+cnt+" is contained in figure "+(i+1)+"\n");
				}
			}
			if(!contained)
				sb.append("Point "+cnt+" is not contained in any figure\n");
		}
		System.out.print(sb);
	}
	
	static class Point{double x , y;public Point(double a,double b) {x = a; y = b;}}
	
	static class Rect{
		Point upper , lower;
		public Rect(Point x , Point y) {upper = x ; lower = y;}
		
		boolean contains(Point p)
		{
			if(p.x - upper.x >= eps && upper.y - p.y >= eps && lower.x - p.x >= eps && p.y - lower.y >= eps)
				return true;
			return false;
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
