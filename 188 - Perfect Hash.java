import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] w;
	static int n;
	
	static int solve()
	{
		int c = 0;
		while(true)
		{
			int newC = c;
			for (int i = 0; i < w.length; i++) 
			{
				for (int j = i+1; j < w.length; j++) 
				{
					if(((c/w[i])%n) == ((c/w[j])%n))
					{
						int c1 = (c/w[i] + 1)* w[i] , c2 = (c/w[j]+1)*w[j];
						newC = Math.max(newC, Math.min(c1,c2));
					}
				}
			}
			if(newC==c)break;
			c = newC;
			
		}
		
		return c;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			String s = sc.nextLine();
			StringTokenizer st = new StringTokenizer(s);
			n = st.countTokens();
			w = new int[n];
			
			for (int i = 0; i < n; i++) {
				char[] arr = st.nextToken().toCharArray();
				for (int j = 0; j < arr.length; j++) {
					w[i] <<= 5;
					w[i] += arr[j]-'a'+1;
				}
			}
			sb.append(s+"\n");
			sb.append(solve()+"\n\n");
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
