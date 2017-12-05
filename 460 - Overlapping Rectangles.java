import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while(t-->0)
		{
			if(!first)sb.append("\n");
			first = false;
			Rect[] rect = new Rect[2];
			for (int i = 0; i < 2; i++) 
			{
				Point[] p = new Point[2];
				for (int j = 0; j < p.length; j++) 
					p[j] = new Point(sc.nextInt(), sc.nextInt());
				rect[i] = new Rect(p[0], p[1]);
			}
			
			if(overlap(rect[0], rect[1]) || overlap(rect[1], rect[0]))
			{
				int llx = Math.max(rect[0].lower.x, rect[1].lower.x);
				int lly = Math.max(rect[0].lower.y,rect[1].lower.y);
				int urx = Math.min(rect[0].upper.x, rect[1].upper.x);
				int ury = Math.min(rect[0].upper.y, rect[1].upper.y);
				if(llx-urx==0 || lly-ury==0)
					sb.append("No Overlap\n");
				else
					sb.append(llx+" "+lly+" "+urx+" "+ury+"\n");
			}
			else
				sb.append("No Overlap\n");
			
		}
		System.out.print(sb);
	}
	
	static boolean overlap(Rect a, Rect b)
	{
		return a.lower.x >= b.lower.x && a.lower.x <= b.upper.x 
				&& a.lower.y <= b.upper.y
				&& a.upper.y >= b.lower.y;
	}
	
	static class Point{int x , y;public Point(int a,int b) {x = a; y = b;} }
	
	static class Rect{
		Point upper , lower;
		public Rect(Point x , Point y) {lower = x ; upper= y;}
		
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
