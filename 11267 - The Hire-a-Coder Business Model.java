import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static ArrayList<Edge> edgeList;
	static UnionFind uf;
	static ArrayList<Integer>[]adj;
	static int kruskal()
	{
		Collections.sort(edgeList);
		UnionFind uf = new UnionFind(n);
		int ind = 0;
		int ans = 0;
		while(ind<edgeList.size())
		{
			Edge cur = edgeList.get(ind++);
			int from = cur.from , to = cur.to ;
			int cost = cur.cost;
			if(!uf.isSameSet(from, to) || cost<0)
			{
				uf.union(from,to);
				ans += cost;
			}
		}
		return ans;
	}
	static boolean biCheck()
	{
		Queue<Integer> q = new LinkedList<Integer>();
		int[] col = new int[n];
		q.add(0);
		col[0] = 1;
		while(!q.isEmpty())
		{
			int cur = q.poll();
			for(int i : adj[cur])
			{
				if(col[i]==col[cur])
					return false;
				if(col[i]==0)
				{
					col[i] = 3-col[cur];
					q.add(i);
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			n = Integer.parseInt(br.readLine().trim());
			if(n==0)break;
			m = Integer.parseInt(br.readLine().trim());
			edgeList = new ArrayList<Edge>(m);
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < m; i++) 
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(a, b, c));
				adj[a].add(b);
				adj[b].add(a);
			}
			if(!biCheck())
				sb.append("Invalid data, Idiot!\n");
			else
				sb.append(kruskal()+"\n");
		}
		System.out.print(sb);
	}
	static class Edge implements Comparable<Edge>
	{
		int from,to;
		int cost;
		public Edge(int f,int t,int c)
		{
			from = f;
			to = t;
			cost = c;
		}
		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}
	static class UnionFind
	{
		int[] set,rank;
		int numSets;
		public UnionFind(int n)
		{
			numSets = n;
			set = new int[n];
			rank = new int[n];
			for (int i = 0; i < rank.length; i++) {
				set[i] = i;
				rank[i] = 1;
			}
		}
		public int find(int x)
		{
			return (set[x]==x)?x:(set[x]=find(set[x]));
		}
		public void union(int a,int b)
		{
			int x = find(a) , y = find(b);
			if(isSameSet(a, b))
				return;
			if(rank[x]>rank[y])
				set[y] = x;
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
			return find(a)==find(b);
		}
	}
}
