import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			String tmp = sc.next();
			if(tmp.equals("#"))break;
			Stack<Pair>[] a = new Stack[52];
			for (int i = 0; i < a.length; i++)
				a[i] = new Stack<Pair>();
			
			a[0].push(new Pair(tmp));
			for (int i = 1; i < a.length; i++) 
				a[i].push(new Pair(sc.next()));
			
			
			for (int i = 1; i < a.length; i++) 
			{
				
				int j = i;
				if(a[i].empty())
					while(++j<a.length && a[j].empty());
				
				if(a[i].empty() && j<a.length)
				{
					a[i] = a[j];
					a[j] = new Stack<Pair>();
				}
				
				if(a[i].empty())
					break;
				
				if(i-3>=0 && a[i-3].peek().equals(a[i].peek()))
				{
					a[i-3].push(a[i].pop());
					i-=4;
				}
				else if(i-1>=0 && a[i-1].peek().equals(a[i].peek()))
				{
					a[i-1].push(a[i].pop());
					i-=2;
				}
				
			}
			
			int size = 0;
			for (int i = 0; i < a.length; i++) {
				if(a[i].empty())
				{
					size = i;
					break;
				}
			}
			if(size>1)
				sb.append(size+" piles remaining:");
			else
				sb.append(size+" pile remaining:");
			for (int i = 0; i < a.length && !a[i].empty(); i++) 
				sb.append(" " + a[i].size());
			
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static class Pair
	{
		char a,b;
		public Pair(String s)
		{
			a = s.charAt(0);
			b = s.charAt(1);
		}
		
		public boolean equals(Pair o){return a==o.a || b==o.b;}
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
