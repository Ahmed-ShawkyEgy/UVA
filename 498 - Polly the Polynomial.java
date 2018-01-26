import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] a;
	static int f(int base)
	{
		int ans = 0;
		for (int i = 0; i < a.length; i++) 
			ans = (ans*base)+a[i];
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			a = sc.nextIntArr();
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			sb.append(f(Integer.parseInt(st.nextToken())));
			while(st.hasMoreTokens())
				sb.append(" "+f(Integer.parseInt(st.nextToken())));
			
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
		public int[] nextIntArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			int[] res = new int[st.countTokens()];
			for (int i = 0; i < res.length; i++) {
				res[i] = Integer.parseInt(st.nextToken());
			}
			return res;
		}
	}	
}
