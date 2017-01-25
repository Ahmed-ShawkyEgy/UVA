import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main{
	static double[][] arr;
	static PriorityQueue<Edge> q;
	public static double kruskal(int n)
	{
		UnionFind uf = new UnionFind(n);
		double ans = 0;
		while(!q.isEmpty() && uf.numSet>1)
		{
			Edge cur = q.poll();
			int from = cur.from;
			int to = cur.to;
			if(!uf.isSameSet(from, to))
			{
				uf.union(from, to);
				ans += cur.cost;
			}
		}
		return ans;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine().trim());
		PrintWriter out = new PrintWriter(System.out);
		DecimalFormat f = new DecimalFormat("0.00");
		boolean first = true;
		while(cases-->0)
		{
			br.readLine();
			if(!first)
				out.append("\n");
			first = false;
			int n = Integer.parseInt(br.readLine().trim());
			arr = new double[n][2];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Double.parseDouble(st.nextToken());
				arr[i][1] = Double.parseDouble(st.nextToken());				
			}
			q = new PriorityQueue<Edge>();
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < n; j++) 
				{
					double a = arr[i][0]-arr[j][0]; a*=a;
					double b = arr[i][1]-arr[j][1]; b*=b;
					Edge x = new Edge(i, j, Math.sqrt(a+b));
					q.add(x);
				}
			}
			double ans = kruskal(n);
			out.append(f.format(ans)+"\n");
		}
		out.flush();
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
		int numSet;
		public UnionFind(int n)
		{
			set = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++) 
			{
				set[i] = i;
				rank[i] = 1;
			}
			numSet = n;
		}
		public int getSet(int x)
		{
			if(set[x]==x)
				return x;
			return set[x] = getSet(set[x]);
		}
		public boolean isSameSet(int a,int b)
		{
			return getSet(a)==getSet(b);
		}
		public void union(int a,int b){
			int x = getSet(a),y=getSet(b);
			if(rank[x]>rank[y])
				set[y] = x;
			else
			{
				set[x] = y;
				if(rank[y]==rank[x])
					rank[y]++;
			}
			numSet--;
		}
	}
}
