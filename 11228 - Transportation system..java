import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n,r,statesNum;
	static double railRoad , road;
	static ArrayList<Edge> edgeList;
	static int[][] arr;
	static final double eps = (double)1e-7;
	static void kruskal()
	{
		Collections.sort(edgeList);
		UnionFind uf = new UnionFind(n);
		int ind = 0;
		statesNum = 1;
		railRoad = road = 0;
		while(uf.numSets>1 && ind<edgeList.size())
		{
			Edge cur = edgeList.get(ind++);
			int from = cur.from , to = cur.to;
			double cost = cur.cost;
			if(!uf.isSameSet(from, to))
			{
				uf.union(from,to);
				if(r>=cost)
					road += cost;
				else
				{
					statesNum ++;
					railRoad += cost;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(t-->0)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			edgeList = new ArrayList<Edge>();
			arr = new int[n][2];
			for (int i = 0; i < n; i++) 
			{
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}	
			for(int i = 0;i<n;i++)
			{
				for(int j = i+1;j<n;j++)
				{
					edgeList.add(new Edge(i, j, dist(i,j)));
					edgeList.add(new Edge(j, i, dist(i, j)));
				}
			}
			kruskal();
			sb.append("Case #"+cases+++": "+statesNum+" "+(int)(road+0.5)+" "+(int)(railRoad+0.5)+"\n");
		}
		System.out.print(sb);
	}
	static double dist(int i,int j)
	{
		int x = arr[j][0]-arr[i][0]; x*=x;
		int y = arr[j][1]-arr[i][1]; y*=y;
		return Math.sqrt(x+y);
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
			if(Math.abs(cost-o.cost)<=eps)
				return 0;
			return cost>o.cost?1:-1;
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
