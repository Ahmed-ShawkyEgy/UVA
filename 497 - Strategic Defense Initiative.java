import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] a;
	static int[][] memo;
	static Queue<Integer> q;
	
	static int dp(int idx,int last)
	{
		if(idx==a.length)return 0;
		if(memo[idx][last]!=-1)return memo[idx][last];
		
		int c1 = dp(idx+1,last);
		int c2 = 0;
		if(a[idx]>a[last])
			c2 = 1 + dp(idx+1,idx);
		return memo[idx][last] = Math.max(c1, c2);
	}
	
	static void print(int idx,int last)
	{
		if(idx==a.length)return;
		
		int c1 = dp(idx+1,last);
		int ans = dp(idx,last);
		if(ans == c1)
			print(idx+1, last);
		else
		{
			q.add(a[idx]);
			print(idx+1, idx);
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		br.readLine();
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while(t-->0)
		{
			if(!first) sb.append("\n");
			first = false;
			ArrayList<Integer> ar = new ArrayList<Integer>();
			ar.add(-1);
			while(br.ready())
			{
				String s = br.readLine().trim();
				if(s.isEmpty())break;
				ar.add(Integer.parseInt(s));
			}
			
			a = new int[ar.size()];
			for(int i = 0; i < a.length;i++)
				a[i] = ar.get(i);
			
			q = new LinkedList<Integer>();
			memo = new int[a.length][a.length];
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			
			int ans = dp(1,0);
			print(1, 0);
			
			sb.append("Max hits: "+ans+"\n");
			while(!q.isEmpty())
				sb.append(q.poll()+"\n");
				
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
