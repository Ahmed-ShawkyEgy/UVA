import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adj;
	static int ans, tmp[], color[];// 1->White : 2->Black
	
	static void bt(int n,int cnt)
	{
		if(n==adj.length)
		{
			if(cnt>ans)
			{
				ans = cnt;
				tmp = color.clone();
			}
			return;
		}
		
		color[n] = 1;
		bt(n+1,cnt);
		color[n] = 0;
		
		boolean isWhite = false;
		for(int i : adj[n])
			if(color[i] == 2)
				isWhite = true;
		
		if(isWhite)return;
		
		color[n] = 2;
		bt(n+1,cnt+1);
		color[n] = 0;
	}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			int n = sc.nextInt() , m = sc.nextInt();
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			
			color = new int[n];
			while(m-->0)
			{
				int a = sc.nextInt()-1 , b = sc.nextInt()-1;
				adj[a].add(b);
				adj[b].add(a);
			}
			ans = 0;
			tmp = new int[n];
			bt(0,0);
			sb.append(ans+"\n");
			boolean first = true;
			for (int i = 0; i < tmp.length; i++) {
				if(tmp[i]==2)
				{
					if(!first)sb.append(" ");
					sb.append(i+1);
					first = false;
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

	static int max(int ...a)
	{
		int ans = Integer.MIN_VALUE;
		for(int i : a)
			if(i>ans)ans = i;
		return ans;		
	}
	
	static long max(long ...a)
	{
		long ans = Long.MIN_VALUE;
		for(long i : a)
			if(i>ans)ans = i;
		return ans;	
	}
	
	static int min(int ...a)
	{
		int ans = Integer.MAX_VALUE;
		for(int i : a)
			if(i<ans)ans = i;
		return ans;		
	}
	
	static long min(long ...a)
	{
		long ans = Long.MAX_VALUE;
		for(long i : a)
			if(i<ans)ans = i;
		return ans;		
	}

}
