import java.io.*;
import java.util.*;
public class Main{
	static ArrayList<Integer>[] adjList;
	static HashMap<String, Integer> map;
	static HashMap<Integer, String> map2;
	static int[] dfs_low, dfs_num, parent;
	static int V, counter, root, rootChildren;
	static boolean[] artPoints;	
	static void findArtPointsAndBridges()	
	{
		counter = 0;
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
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
			}
			else
				if(parent[u] != v)
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{
			int n = Integer.parseInt(br.readLine().trim());
			if(n==0)
				break;
			if(cases!=1)
				out.append("\n");
			map = new HashMap<String, Integer>();
			map2 = new HashMap<Integer, String>();
			adjList = new ArrayList[n];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < n; i++) {
				String x = br.readLine().trim();
				map.put(x, i);
				map2.put(i, x);
			}
			int m = Integer.parseInt(br.readLine().trim());
			while(m-->0)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = map.get(st.nextToken());
				int b = map.get(st.nextToken());
				adjList[a].add(b);
				adjList[b].add(a);
			}
			dfs_low = new int[n];
			dfs_num = new int[n];
			parent = new int[n];
			artPoints = new boolean[n];
			V = n;
			findArtPointsAndBridges();
			TreeSet<String> set = new TreeSet<String>();
			int total = 0;
			for(int i = 0;i<artPoints.length;i++)
			{
				if(artPoints[i])
				{
					set.add(map2.get(i));
					total++;
				}
			}
			out.append("City map #"+cases+++": "+total+" camera(s) found\n");
			for(String s: set)
			{
				out.append(s+"\n");
			}
		}
		out.flush();
	}
	
}
