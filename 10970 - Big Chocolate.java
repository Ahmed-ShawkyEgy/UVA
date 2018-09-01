import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			int n = sc.nextInt() , m = sc.nextInt();
			int ans = (n-1) + ((m-1)*n);
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
	
	

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String s) throws FileNotFoundException {br = new BufferedReader(new FileReader(s));}
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
		public char nextChar() throws IOException{return next().charAt(0);}
		public boolean ready() throws IOException {return br.ready();}
		public int[] nextIntArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			int[] res = new int[st.countTokens()];
			for (int i = 0; i < res.length; i++)
				res[i] = nextInt();
			return res;
		}
		public char[] nextCharArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			char[] res = new char[st.countTokens()];
			for (int i = 0; i < res.length; i++) 
				res[i] = nextChar();
			return res;
		}
	}

}
