import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Edge> edgeList;
	static ArrayList<Integer>[] adj;
	static ArrayList<Double>[]price;
	static int[][] arr;
	static double minAns;
	
	static void kruskal()
	{
		Collections.sort(edgeList);
		UnionFind uf = new UnionFind(n);
		int ind = 0;
		adj = new ArrayList[n];
		price = new ArrayList[n];
		for (int i = 0; i < n; i++) 
		{
			adj[i] = new ArrayList<Integer>();
			price[i] = new ArrayList<Double>();
		}
		while(ind<edgeList.size())
		{
			Edge cur = edgeList.get(ind++);
			int from = cur.from , to = cur.to ;
			double cost = cur.cost;
			if(!uf.isSameSet(from, to))
			{
				uf.union(from,to);
				adj[from].add(to);
				price[from].add(cost);
				
				adj[to].add(from);
				price[to].add(cost);
			}
		}
		minAns = Double.MAX_VALUE;
		dfs(0, 0,-1);			
	}	
	static void dfs(int cur,double max,int parent)
	{
		if(cur==1)
		{
			minAns = Math.min(minAns, max);
			return;
		}
		for(int i = 0;i<adj[cur].size();i++)
		{
			int u = adj[cur].get(i);
			if(u==parent)
				continue;
			dfs(u,Math.max(max, price[cur].get(i) ),cur);			
		}
	}
	static double dist(int i,int j)
	{
		int x = arr[i][0] - arr[j][0]; x*=x;
		int y = arr[i][1] - arr[j][1]; y*=y;
		return Math.sqrt(x+y);		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		DecimalFormat f = new DecimalFormat("#0.000");
		boolean first = true;
		while(true)
		{
			if(!first)
				br.readLine();
			n = Integer.parseInt(br.readLine());
			if(n==0)break;
			edgeList = new ArrayList<Edge>();
			arr = new int[n][2];
			for (int i = 0; i < n; i++) 
			{
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < n; i++) 
				for (int j = i+1; j < n; j++) 
					edgeList.add(new Edge(i, j, dist(i, j)));	
			
			first = false;
			kruskal();
			sb.append("Scenario #"+cases+++"\nFrog Distance = "+f.format(minAns)+"\n\n");
		}
		System.out.print(sb);
	}
	static class Edge implements Comparable<Edge>
	{
		int from,to;
		double cost;
		public Edge(int f,int t,double c)
		{
			from = f;
			to = t;
			cost = c;
		}
		public int compareTo(Edge o) {
			return Double.compare(cost, o.cost);
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
