import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static boolean solve(int a,int b)
	{
		int min = Math.min(a, b) , max = Math.max(a, b);
		if(max%min==0)return true;
		
		boolean f = false;
		if(max/min > 1)
			f = !solve(min, max - (min*((max/min) - 1)));
		
		return !solve(max%min,min) | f;
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int a = sc.nextInt() , b = sc.nextInt();
			if(a==0 && b==0)break;
			if(solve(a, b))sb.append("Stan wins\n");
			else sb.append("Ollie wins\n");
		}
		System.out.print(sb);
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
