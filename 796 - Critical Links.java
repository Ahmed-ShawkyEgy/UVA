import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n,counter;
	static ArrayList<Integer>[] adj;
	static int[] num,low;
	static ArrayList<Pair> res;
	
	static class Pair implements Comparable<Pair>
	{
		int a,b;
		public Pair(int a,int b)
		{
			this.a = a;
			this.b = b;
		}
		public int compareTo(Pair o) 
		{
			if(a!=o.a)
				return a - o.a;
			return b-o.b;
		}
		
	}
	static void tarjan()
	{
		num = new int[n];
		low = new int[n];
		counter = 0;
		res = new ArrayList<Pair>();
		
		Arrays.fill(num, -1);
		Arrays.fill(low, (int)1e9);
		
		for(int i = 0;i < n;i++)
			if(num[i]==-1)
				dfs(i,-1);
		
		Collections.sort(res);		
	}
	static void dfs(int cur,int parent)
	{
		num[cur] = low[cur] = counter++;
		for(int i : adj[cur])
		{
			if(num[i]==-1)
			{
				dfs(i,cur);
				
				if(low[i]>num[cur])
					res.add(new Pair(Math.min(cur, i),Math.max(cur, i)));
				
				low[cur] = Math.min(low[cur], low[i]);
			}
			else if(i!=parent)
				low[cur] = Math.min(low[cur], num[i]);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		while(br.ready())
		{
			String s;
			while((s=br.readLine().trim()).isEmpty());
			n = Integer.parseInt(s.trim());
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			
			while((s=br.readLine())!=null && !s.isEmpty())
			{
				st = new StringTokenizer(s);
				int a = Integer.parseInt(st.nextToken());
				String size = st.nextToken();
				int m = Integer.parseInt(size.substring(1, size.length()-1));
				while(m-->0)
				{
					int b = Integer.parseInt(st.nextToken());
					adj[a].add(b);
					adj[b].add(a);
				}
			}
			
			tarjan();
			sb.append(res.size()+" critical links\n");
			for(int i = 0;i<res.size();i++)
				sb.append(res.get(i).a + " - " + res.get(i).b+"\n");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
