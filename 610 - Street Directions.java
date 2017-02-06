import java.io.*;
import java.util.*;
public class Main{
	static ArrayList<Integer>[] adjList;
	static int[] dfs_low, dfs_num, parent;
	static int V, counter, root, rootChildren;
	static boolean[] artPoints,visited;	
	static boolean[][] isBridge;
	static LinkedList<Edge> list;
	static void findArtPointsAndBridges()	
	{
		dfs_low = new int[V];
		dfs_num = new int[V];
		parent = new int[V];
		counter = 0;
		artPoints = new boolean[V];
		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
			{
				root = i;
				
				rootChildren = 0;
				
				dfs(i);
				
				if(rootChildren <= 1)	
					artPoints[i] = false;
			}
	}	
	static void dfs(int u)
	{
		dfs_num[u] = dfs_low[u] = ++counter;
		
		for(int v: adjList[u])
			if(dfs_num[v] == 0)
			{
				parent[v] = u;
				if(u == root)
					++rootChildren;
				
				dfs(v);
				
				if(dfs_low[v] >= dfs_num[u])
					artPoints[u] = true;
				
				if(dfs_low[v] > dfs_num[u])
				{
					isBridge[u][v] = true;
					isBridge[v][u] = true;
					list.add(new Edge(u, v));
					list.add(new Edge(v, u));
				}
				
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
			}
			else
				if(parent[u] != v)
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
				
	}
	public static void dfs2(int n)
	{
		visited[n]=true;
		for(int i : adjList[n])
		{
			if(!isBridge[n][i])
			{
				list.add(new Edge(n,i));
				isBridge[n][i] = true;
				isBridge[i][n] = true;
			}
			if(!visited[i])
				dfs2(i);
		}
	}
	
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(V==0 && m ==0)
				break;
			isBridge = new boolean[V][V];
			adjList = new ArrayList[V];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			list = new LinkedList<Edge>();
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken())-1;
				int j = Integer.parseInt(st.nextToken())-1;
				adjList[i].add(j);
				adjList[j].add(i);
			}
			visited = new boolean[V];
			findArtPointsAndBridges();
			dfs2(0);
			out.append(cases+++"\n\n");
			for(Edge e: list)
				out.append((e.from+1)+" "+(e.to+1)+"\n");
			out.append("#\n");
		}
		out.flush();
	}
	public static class Edge
	{
		int from,to;
		public Edge(int f,int t){
			from = f;
			to = t;
		}
	}
}
