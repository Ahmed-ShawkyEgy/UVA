import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static StringBuilder traverse;
	static boolean insert(int x,String s)
	{
		int cur = 1;
		for (int i = 0; i < s.length(); i++) 
		{
			if(s.charAt(i)=='L')
				cur = left(cur);
			else
				cur = right(cur);
		}
		if(cur<arr.length || arr[cur]!=0)
			arr[cur] = x;
		else
			return false;
		return true;
	}
	
	static int bfs(boolean fill)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 0;
		q.add(1);
		while(!q.isEmpty())
		{
			int cur = q.poll() , left = left(cur) , right = right(cur);
			if(arr[cur]==0)continue;
			++cnt;
			if(fill)
				traverse.append(((cur!=1)?" ":"")+arr[cur]);
			if(left<arr.length)
				q.add(left);
			if(right<arr.length)
				q.add(right);
		}
		return cnt;
	}
	
	static int left(int n){return n<<1;}
	static int right(int n){return n<<1|1;}
	
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			arr = new int[(int)1e6];
			boolean repeat = false;
			int size = 0;
			while(true)
			{
				String s = sc.next();
				if(s.equals("()"))
						break;
				s = s.substring(1, s.length()-1);
				String[] sa = s.split(",");
				int x = Integer.parseInt(sa[0]);
				String d;
				if(sa.length!=1)
					d = sa[1];
				else
					d = "";
				
				if(!insert(x, d))
					repeat = true;
				++size;
			}
			int cnt = bfs(false);
			if(repeat || cnt!=size)
			{
				sb.append("not complete\n");
				continue;
			}
			traverse = new StringBuilder();
			bfs(true);
			sb.append(traverse+"\n");
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
