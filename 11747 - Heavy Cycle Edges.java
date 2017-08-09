import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static ArrayList<Edge> edgeList;
	static ArrayList<Integer> result;
	static void kruskal()
	{
		result = new ArrayList<Integer>();
		Collections.sort(edgeList);
		UnionFind uf = new UnionFind(n);
		int ind = 0;
		while(ind<edgeList.size())
		{
			Edge cur = edgeList.get(ind++);
			int from = cur.from , to = cur.to , cost = cur.cost;
			if(!uf.isSameSet(from, to))
				uf.union(from,to);
			else
				result.add(cost);			
		}
		Collections.sort(result);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n==0) break;
			
			edgeList = new ArrayList<Edge>(m);
			for(int i = 0;i<m;i++)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(a, b, c));
			}
			kruskal();
			if(result.size()==0)
				sb.append("forest\n");
			else
			{
				for(int i = 0;i<result.size()-1;i++)
					sb.append(result.get(i)+" ");
				sb.append(result.get(result.size()-1)+"\n");
			}
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
