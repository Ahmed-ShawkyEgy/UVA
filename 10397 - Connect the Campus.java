// This one has problems with the input
// just add a check if the current line is empty then continue

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static ArrayList<Edge> edgeList;
	static int[][] arr;
	static UnionFind uf;
	static double kruskal()
	{
		Collections.sort(edgeList);
		int ind = 0;
		double ans = 0;
		while(ind<edgeList.size())
		{
			Edge cur = edgeList.get(ind++);
			int from = cur.from , to = cur.to ;
			double cost = cur.cost;
			if(!uf.isSameSet(from, to))
			{
				uf.union(from,to);
				ans += cost;
			}
		}
		return ans;
	}	
	static double dist(int i,int j)
	{
		long x = 1l *arr[i][0] - arr[j][0]; x*=x;
		long y = 1l * arr[i][1] - arr[j][1]; y*=y;
		return Math.sqrt(x+y);		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		DecimalFormat f = new DecimalFormat("#0.00");
		while(br.ready())
		{
			String s = br.readLine();
			if(s.isEmpty())
				continue;
			n = Integer.parseInt(s.trim());
			arr = new int[n][2];
			for (int i = 0; i < n; i++) 
			{
				while((s=br.readLine()).isEmpty());
				st = new StringTokenizer(s);
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			while((s=br.readLine()).isEmpty());
			m = Integer.parseInt(s.trim());
			edgeList = new ArrayList<Edge>();
			uf = new UnionFind(n);
			for (int i = 0; i < m; i++) 
			{
				while((s=br.readLine()).isEmpty());
				st = new StringTokenizer(s);
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				uf.union(a, b);
			}
			for(int i = 0;i<n;i++)
				for(int j = i+1;j<n;j++)
					edgeList.add(new Edge(i, j, dist(i, j)));
			sb.append(f.format(kruskal())+"\n");
		}
		System.out.print(sb);
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
			return Double.compare(cost, o.cost);
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
