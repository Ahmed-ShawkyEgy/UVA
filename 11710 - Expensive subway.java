import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static ArrayList<Edge> edgeList;
	static int kruskal()
	{
		int ans = 0;
		Collections.sort(edgeList);
		UnionFind uf = new UnionFind(n);
		int ind = 0;
		while(uf.numSets>1 && ind<m)
		{
			Edge cur = edgeList.get(ind++);
			int from = cur.from , to = cur.to;
			if(!uf.isSameSet(from, to))
			{
				uf.union(from,to);
				ans += cur.cost;
			}
		}
		return uf.numSets==1?ans:-1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashMap<String, Integer> map;
		StringBuilder sb = new StringBuilder();
		while(br.ready())
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			map = new HashMap<String, Integer>(n);
			edgeList = new ArrayList<Edge>();
			for (int i = 0; i < n; i++) 
				map.put(br.readLine(), i);
			for (int i = 0; i < m; i++) 
			{
				st = new StringTokenizer(br.readLine());
				int a = map.get(st.nextToken());
				int b = map.get(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(a, b, c));
			}	
			br.readLine();
			int ans = kruskal();
			sb.append(ans!=-1?ans:"Impossible");
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static class Edge implements Comparable<Edge>
	{
		int from,to,cost;
		public Edge(int f,int t,int c)
		{
			from = f;
			to = t;
			cost = c;
		}
		public int compareTo(Edge o) {
			return cost-o.cost;
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
