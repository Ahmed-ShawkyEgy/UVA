import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int a = sc.nextInt() , b = sc.nextInt();
			if(a==1 && b == 1)break;
			
			// Left parent = aLeft/bLeft 
			// Right parent = aRight/bRight
			int aLeft = 0 , aRight = 1 , bLeft = 1 , bRight = 0;
			while(true)
			{
				// Current child = x/y
				int x = aLeft + aRight , y = bLeft + bRight;

				int val = a*y - x*b;
				if(val==0)break;
				if(val<0)// Go left
				{
					aRight = x;
					bRight = y;
					sb.append("L");
				}
				else // Go right
				{
					aLeft = x;
					bLeft = y;
					sb.append("R");
				}
			}
			sb.append("\n");
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
