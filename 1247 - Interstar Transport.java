import java.io.*;
import java.util.*;
public class Main{
	static final int oo = (int) 1e9;
	static HashMap<Character, Integer> map;
	static HashMap<Integer, Character> map2;
	static int[][] cost;
	static ArrayList<Integer>[] adj;
	static Deque<Integer> list;
	public static void dijkstra(int n,int t)
	{
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(n,0));
		int[] dist = new int[cost.length];
		int[] parent = new int[cost.length];
		for (int i = 0; i < parent.length; i++) {
			dist[i] = oo;
			parent[i] = -1;
		}
		dist[n] = 0; parent[n] = n;
		while(!q.isEmpty())
		{
			Node cur = q.poll();
			int ind = cur.ind;
			for(int i = 0;i<adj[ind].size();i++)
			{
				int target = adj[ind].get(i);
				int newCost = dist[ind] + cost[ind][target];
				if(newCost<dist[target])
				{
					dist[target] = newCost;
					parent[target] = ind;
					q.add(new Node(target,newCost));
				}
			}
		}
		list = new LinkedList<Integer>();
		while(t!=n)
		{
			list.addFirst(t);
			t = parent[t];
		}
		list.addFirst(n);
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		map = new HashMap<Character, Integer>();
		map2 = new HashMap<Integer, Character>();
		adj = new ArrayList[n];
		cost = new int[n][n];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		int ind = 0;
		for (int i = 0; i < p; i++) 
		{
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			int c = Integer.parseInt(st.nextToken());
			if(!map.containsKey(a))
			{
				map.put(a, ind);
				map2.put(ind++, a);
			}
			if(!map.containsKey(b))
			{
				map.put(b, ind);
				map2.put(ind++,b);
			}
			adj[map.get(a)].add(map.get(b));
			adj[map.get(b)].add(map.get(a));
			cost[map.get(a)][map.get(b)] = c;			
			cost[map.get(b)][map.get(a)] = c;
		}
		int cases = Integer.parseInt(br.readLine());
		while(cases-->0)
		{
			st = new StringTokenizer(br.readLine());
			int a =map.get(st.nextToken().charAt(0));
			int b =map.get(st.nextToken().charAt(0));
			dijkstra(a,b);
			StringBuilder sb = new StringBuilder();
			sb.append(map2.get(list.pop()));
			while(!list.isEmpty())
			{
				sb.append(" "+map2.get(list.pop()));
			}
			out.append(sb+"\n");
		}
		out.flush();
	}
	static class Node implements Comparable<Node>
	{
		int ind,val;
		public Node(int i,int v){
			ind = i;
			val = v;
		}
		public int compareTo(Node o) {
			return val-o.val;
		}
		
	}
}
