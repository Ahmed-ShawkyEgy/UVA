import java.io.*;
import java.util.*;
public class Main{
	static int n,m;
	static PriorityQueue<Edge> q;
	public static int kruskal()
	{
		UnionFind u = new UnionFind(n);
		int ans = 0;
		while(!q.isEmpty())
		{
			Edge cur = q.poll();
			if(!u.isSameSet(cur.from, cur.to))
			{
				u.Union(cur.from, cur.to);
				ans += cur.cost;
			}
		}
		return ans;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		boolean first = true;
		while(t-->0)
		{
			br.readLine();
			if(!first)
				out.append("\n");
			first = false;
			n = Integer.parseInt(br.readLine().trim());
			m = Integer.parseInt(br.readLine().trim());
			q = new PriorityQueue<Edge>();
			HashMap<String,Integer> map = new HashMap<String, Integer>();
			int ind = 0;
			for (int i = 0; i < m; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if(!map.containsKey(a))
					map.put(a, ind++);
				if(!map.containsKey(b))
					map.put(b, ind++);
				int c = Integer.parseInt(st.nextToken());
				q.add(new Edge(map.get(a), map.get(b), c));
			}
			int res = kruskal();
			out.append(res+"\n");
		}
		out.flush();
	}
	public static class Edge implements Comparable<Edge>
	{
		int from,to,cost;
		public Edge(int f,int t,int c){
			from = f;
			to = t;
			cost = c;
		}
		public int compareTo(Edge o) {
			return cost-o.cost;
		}
	}
	static class UnionFind {

		int[] rep, rank, setSize;
		int numSets;

		public UnionFind(int n) {
			rep = new int[n];
			rank = new int[n];
			setSize = new int[n];
			for (int i = 0; i < n; i++) {
				rep[i] = i;
				rank[i] = 1;
				setSize[i] = 1;
			}
			numSets = n;
		}

		public int findSet(int x) {
			if (rep[x] == x)
				return x;
			return rep[x] = findSet(rep[x]);
		}

		public void Union(int x, int y) {
			int x1 = findSet(x), y1 = findSet(y);
			if (x1 == y1)
				return;
			if (rank[x1] > rank[y1]) {
				rep[y1] = x1;
				setSize[x1] += setSize[y1];
			} else {
				rep[x1] = y1;
				setSize[y1] += setSize[x1];
				if (rank[y1] == rank[x1])
					rank[y1]++;
			}
			numSets--;
		}

		public boolean isSameSet(int x, int y) {
			return findSet(x) == findSet(y);
		}
	}
}
