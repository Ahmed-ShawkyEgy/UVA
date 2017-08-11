import java.io.BufferedReader;
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
	
	static long kruskal()
	{
		Collections.sort(edgeList);
		UnionFind uf = new UnionFind(m);
		int ind = 0;
		int max = Integer.MAX_VALUE;
		int cnt = 0;
		while(ind<edgeList.size())
		{
			Edge cur = edgeList.get(ind++);
			int from = cur.from , to = cur.to ;
			double cost = cur.cost;
			if(!uf.isSameSet(from, to))
			{
				uf.union(from,to);
				if(m-n>cnt)
					max = (int)Math.ceil(cost);
				cnt++;
			}
		}
		return max;
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
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			n = Integer.parseInt(br.readLine());
			edgeList = new ArrayList<Edge>();
			m = 0;
			ArrayList<int[]> tmpList = new ArrayList<int[]>();
			while(true) 
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(a==-1)
					break;
				int b = Integer.parseInt(st.nextToken());
				int[] tmp = {a,b};
				tmpList.add(tmp);
				m++;
			}
			arr = new int[m][2];
			for(int i = 0;i<m;i++)
			{
				arr[i][0] = tmpList.get(i)[0];
				arr[i][1] = tmpList.get(i)[1];
			}
			for (int i = 0; i < m; i++) 
				for (int j = i+1; j < m; j++) 
					edgeList.add(new Edge(i, j, dist(i, j)));	
			sb.append(kruskal()+"\n");
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
