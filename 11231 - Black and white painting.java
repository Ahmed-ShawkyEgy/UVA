import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int n = sc.nextInt() , m = sc.nextInt() , c = sc.nextInt();
			if(n==0 && m==0 && c==0)break;
			
			int width = n-7 , height = m-7;
			int cw = 1-c;
			if((height)%2==1)cw = c;
			
			long firstRow = (width)/2 + cw;
			if(width %2==0) firstRow = width /2;
			
			long secRow = firstRow;
			if(width%2==1)secRow += ((cw==0)? 1 : -1); 

			int evenRowsCount = height /2;
			int oddRowsCount = height / 2;
			if(height %2==1)evenRowsCount++;
			
			long ans = 1l * (firstRow * evenRowsCount) + 1l * (secRow * oddRowsCount);
			
			sb.append(ans+"\n");
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
