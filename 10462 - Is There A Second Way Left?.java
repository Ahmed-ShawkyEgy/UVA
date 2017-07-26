import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static PriorityQueue<Edge> q;
	static int n,m;
	static boolean flag;
	static ArrayList<Integer> taken;
	public static int kruskal(int i)
	{
		UnionFind uf = new UnionFind(n);
		int total = 0;
		int ind = 0;
		while(q.size()>0)
		{
			Edge cur = q.poll();
			int a = cur.a , b = cur.b , c = cur.c;
			if(!uf.isSameSet(a, b))
			{
				if(flag)
					taken.add(ind);
				else if(ind==i)
				{
					ind++;
					continue;
				}
				uf.union(a, b);		
				total += c ;
			}
			ind++;
		}
		return (uf.numSets==1)?total:Integer.MAX_VALUE;
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			q = new PriorityQueue<Edge>();
			ArrayList<Edge> list = new ArrayList<Edge>();
			for (int i = 0; i < m; i++) 
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				list.add(new Edge(a, b, c));
			}
			flag = true;
			taken = new ArrayList<Integer>();
			fill(list);
			int best = kruskal(-1);
			if(best==Integer.MAX_VALUE)
			{
				sb.append("Case #"+cases++ +" : No way\n");
				continue;
			}
			int min = Integer.MAX_VALUE;
			flag = false;
			for(int i : taken)
			{
				fill(list);
				int cur = kruskal(i);
				min = Math.min(min, cur);
			}
			if(min!=Integer.MAX_VALUE)
				sb.append("Case #"+cases++ +" : "+min+"\n");
			else
				sb.append("Case #"+cases++ +" : No second way\n");
		}
		System.out.print(sb);
	}
	public static void fill(ArrayList<Edge>list)
	{
		q = new PriorityQueue<Edge>();
		for (int i = 0; i < m; i++) 
				q.add(list.get(i));
	}
	static class Edge implements Comparable<Edge>
	{
		int a,b,c;
		public Edge(int a,int b,int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
		public int compareTo(Edge o) {
			return c-o.c;
		}		
	}
	public static class UnionFind
	{
		int[] set,rank;
		int numSets;
		public UnionFind(int n)
		{
			set = new int[n];
			rank = new int[n];
			numSets = n;
			for (int i = 0; i < rank.length; i++) {
				set[i] = i;
				rank[i] = 1;
			}
		}
		public int find(int x)
		{
			if(x==set[x])
				return x;
			return set[x] = find(set[x]);
		}
		public void union(int a,int b)
		{
			int x = find(a) , y = find(b);
			if(x==y)
				return;
			if(rank[x]>rank[y])
			{
				set[y] = x;
			}
			else
			{
				set[x] = y;
				if(rank[x]==rank[y])
					rank[y]++;
			}
			numSets--;
		}
		public boolean isSameSet(int a,int b)
		{
			int x = find(a) , y = find(b);
			return x==y;
		}
	}
}
