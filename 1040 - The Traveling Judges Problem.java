import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,target,minAns,minCityNum;
	static ArrayList<Edge> edgeList;
	static UnionFind uf;
	static ArrayList<Integer>[]adj;
	static int[] source;
	static StringBuilder result;
	
	static void kruskal(int mask)
	{
		uf = new UnionFind(n);
		int ind = 0;
		int ans = 0;
		
		int cityNum = 1;
		
		adj = new ArrayList[n];
		for (int i = 0; i < adj.length; i++) 
			adj[i] = new ArrayList<Integer>();
		
		while(ind<edgeList.size())
		{
			Edge cur = edgeList.get(ind++);
			int from = cur.from , to = cur.to ;
			int cost = cur.cost;
			if((mask&(1<<from))!=0 && (mask&(1<<to))!=0 && !uf.isSameSet(from, to))
			{
				uf.union(from,to);
				ans += cost;
				adj[from].add(to);
				adj[to].add(from);
				cityNum++;
			}
		}
		StringBuilder curResult = bfs();
		if(curResult==null)
			return;
		
		if(ans<minAns)
		{
			minAns = ans;
			minCityNum = cityNum;
			result = curResult;
		}
		else if(ans==minAns)
		{
			if(cityNum<minCityNum || curResult.toString().compareTo(result.toString())<0 || result.toString().isEmpty())
			{
				minCityNum = cityNum;
				result = curResult;
			}
		}
	}
	
	static StringBuilder bfs()
	{
		int[] dist = new int[n] , parent = new int[n];
		for (int i = 0; i < n; i++) 
		{
			dist[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}
		dist[target] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(target);
		while(!q.isEmpty())
		{
			int cur = q.poll();
			for(int i : adj[cur])
			{
				if(dist[i] > dist[cur]+1)
				{
					dist[i] = dist[cur] + 1;
					q.add(i);
					parent[i] = cur;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		for(int i : source)
		{
			if(parent[i]==-1)
				return null;
			else
			{
				int cur = parent[i];
				res.append("   "+(i+1));
				while(cur!=-1)
				{
					res.append("-"+(cur+1));
					cur = parent[cur];
				}
				res.append("\n");
			}		
		}
		return res;
	}
	
	static void permutate()
	{
		Collections.sort(edgeList);
		minAns = Integer.MAX_VALUE;
		minCityNum = Integer.MAX_VALUE;
		result = new StringBuilder("");
		int mask = -1;
		int bound = 1<<n;
		while(++mask<=bound)
			if(isValid(mask))
				kruskal(mask);
	}
	
	static boolean isValid(int mask)
	{
		for(int i : source)
			if((mask&(1<<i))==0)
				return false;
		return (mask&(1<<target))!=0;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==-1)break;
			while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			target = Integer.parseInt(st.nextToken())-1;
			while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			edgeList = new ArrayList<Edge>(m);
			
			for (int i = 0; i < m; i++) 
			{
				while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
				int b = Integer.parseInt(st.nextToken())-1;
				while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				
				edgeList.add(new Edge(a, b, c));
			}
			while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			int judgeNum = Integer.parseInt(st.nextToken());
			source = new int[judgeNum];
			for (int i = 0; i < source.length; i++) {
				while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
				source[i] = Integer.parseInt(st.nextToken())-1;
			}
			permutate();
			sb.append("Case "+cases+++": distance = "+minAns+"\n");
			sb.append(result+"\n");
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
