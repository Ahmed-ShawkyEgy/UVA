import java.io.*;
import java.util.*;
public class Main{
	static PriorityQueue<Edge> q;
	public static long kruskal(int n) 
	{
		long ans = 0;
		UnionFind uf = new UnionFind(n);
		while(!q.isEmpty())
		{
			Edge cur = q.poll();
			int from  = cur.a;
			int to = cur.b;
			if(!uf.isSameSet(from, to))
			{
				uf.union(from, to);
			}
			else
			{
				ans += (long) cur.cost;
			}
		}
		return ans;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			q = new PriorityQueue<Edge>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				Edge x = new Edge(a, b, c);
				q.add(x);
			}
			out.append(kruskal(n)+"\n");
		}
		out.flush();
	}
	static class Edge implements Comparable<Edge>
	{
		int a,b,cost;
		public Edge(int a,int b,int c){
			this.a = a;
			this.b = b;
			cost = c;
		}
		public int compareTo(Edge o) {
			return o.cost-this.cost;
		}		
	}
	static class UnionFind
	{
		int[] set,rank;
		int numSet;
		public UnionFind(int n)
		{
			set = new int[n];
			rank = new int[n];
			for (int i = 0; i < rank.length; i++) {
				set[i] = i;
				rank[i] = 1;
			}
			numSet = n;
		}
		public int getSet(int x)
		{
			if(set[x]==x)
				return x;
			return set[x] = getSet(set[x]);
		}
		public boolean isSameSet(int a,int b)
		{
			return getSet(a)==getSet(b);
		}
		public void union(int a,int b)
		{
			int x = getSet(a),y = getSet(b);
			if(rank[x]>rank[y])
			{
				set[y] = x;
			}
			else
			{
				set[x] = y;
				if(rank[y]==rank[x])
				{
					rank[y]++;
				}
			}
			numSet--;
		}
	}
}
