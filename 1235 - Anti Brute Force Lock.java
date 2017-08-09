import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Edge> edgeList;
	static int[][] list;
	static int kruskal()
	{
		Collections.sort(edgeList);
		UnionFind uf = new UnionFind(n);
		int ind = 0;
		int ans = 0;
		
		while(ind<edgeList.size())
		{
			Edge cur = edgeList.get(ind++);
			int from = cur.from , to = cur.to , cost = cur.cost;
			if(!uf.isSameSet(from, to))
			{
				uf.union(from,to);		
				ans += cost;
			}
		}
		
		return ans;
	}
	static int dist(int[] s,int[] t)
	{
		int ans = 0;
		for(int i = 0;i<4;i++)
		{
			int min = Math.min(s[i], t[i]);
			int max = Math.max(s[i], t[i]);
			ans += Math.min(max-min,min+10-max);		
		}
		return ans;
	}	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			edgeList = new ArrayList<Edge>(n);
			list = new int[n][4];
			for(int i = 0;i<n;i++)
			{
				char[] cur = st.nextToken().toCharArray();
				for(int j = 0;j<4;j++)
					list[i][j] = Integer.parseInt(cur[j]+"");
			}
			int min = Integer.MAX_VALUE;
			int[] start = new int[4];
			for(int i = 0;i<list.length;i++)
				min = Math.min(min,dist(start, list[i]));
			for (int i = 0; i < list.length; i++) 
				for(int j = i+1;j<list.length;j++)
					edgeList.add(new Edge(i, j, dist(list[i], list[j])));
			
			int ans = kruskal();
			sb.append((ans+min)+"\n");
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
