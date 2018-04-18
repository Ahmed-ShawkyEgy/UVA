import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] f(int n)
	{
		int[] ret = new int[4];
		int cnt = 0;
		for(int i= 2;cnt<2 && 1l*i*i<=n;i++)
		{
			if(n%i==0 && i!=ret[0] && i!=ret[1])
			{
				int other = n/i;
				if(other!=i && other!=ret[0] && other!=ret[1])
				{
					if(cnt==0)
					{
						ret[0] = i;
						ret[1] = other;
					}
					else
					{
						ret[2] = i;
						ret[3] = other;
					}
					++cnt;
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = f(n);
			sb.append("Case #"+cases+++": "+n+" = "+a[0]+" * "+a[1]+" = "+a[2]+" * "+a[3]+"\n");
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
