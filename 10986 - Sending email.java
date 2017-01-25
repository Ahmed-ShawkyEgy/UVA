import java.io.*;
import java.util.*;
public class Main{
	static ArrayList<Integer>[] adj,cost;
	static final int oo = (int) 1e9;
	public static int dijkstra(int n,int t)
	{
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		int[] dist = new int[adj.length];
		Arrays.fill(dist, oo);
		dist[n] = 0;
		q.add(new Node(n,0));
		while(!q.isEmpty())
		{
			Node cur = q.poll();
			int ind = cur.ind;
			for(int i = 0;i<adj[ind].size();i++)
			{
				int nCost = dist[ind] + cost[ind].get(i);
				if(nCost<dist[adj[ind].get(i)])
				{
					dist[adj[ind].get(i)] = nCost;
					q.add(new Node(adj[ind].get(i),nCost));
				}
			}
		}
		return dist[t];
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int bb = Integer.parseInt(br.readLine().trim());
		for(int cases =  1;cases<=bb;cases++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n];
			cost = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<Integer>();
				cost[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; i++) 
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
				cost[a].add(c);
				cost[b].add(c);
			}
			int ans = dijkstra(s, t);
			out.append("Case #"+cases+": ");
			if(ans==oo)
				out.append("unreachable\n");
			else
				out.append(ans+"\n");
		}
		out.flush();
	}
	static class Node implements Comparable<Node>
	{
		int ind,cost;
		public Node(int i,int c)
		{
			ind = i;
			cost = c;
		}
		public int compareTo(Node o) {
			return cost-o.cost;
		}
	}
	
}
