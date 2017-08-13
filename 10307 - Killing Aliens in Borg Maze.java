import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static ArrayList<Edge> edgeList;
	static UnionFind uf;
	static char[][] arr;
	static Pair[] points;
	static int[] xx = {1,-1,0,0};
	static int[] yy = {0,0,1,-1};
	
	static int kruskal()
	{
		Collections.sort(edgeList);
		uf = new UnionFind(points.length);
		int ind = 0;
		int ans = 0;
		while(ind<edgeList.size())
		{
			Edge cur = edgeList.get(ind++);
			int from = cur.from , to = cur.to ;
			int cost = cur.cost;
			if(!uf.isSameSet(from, to))
			{
				uf.union(from,to);
				ans += cost;
			}
		}
		return ans;
	}	
	
	static void bfs(int ind)
	{
		int[][] dist = new int[n][m];
		for (int i = 0; i < dist.length; i++) 
			Arrays.fill(dist[i], (int)1e9);
		dist[points[ind].i][points[ind].j] = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(points[ind]);
		while(!q.isEmpty())
		{
			Pair cur = q.poll();
			int newDist = dist[cur.i][cur.j]+1;
			for (int i = 0; i < yy.length; i++) {
				Pair nxt = new Pair(cur.i+xx[i], cur.j+yy[i]);
				if(!isValid(nxt))continue;
				if(dist[nxt.i][nxt.j]>newDist)
				{
					dist[nxt.i][nxt.j] = newDist;
					q.add(nxt);
				}
			}
		}
		for(int i = 0;i<points.length;i++)
			if(i!=ind)
				edgeList.add(new Edge(ind, i, dist[points[i].i][points[i].j]));
	}
	
	static boolean isValid(Pair cur)
	{
		int i = cur.i , j = cur.j;
		return i>=0 && j>=0 && i<n && j<m && arr[i][j] != '#';
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			arr = new char[n][m];
			for (int i = 0; i < n; i++) 
				arr[i] = br.readLine().toCharArray();
			
			ArrayList<Pair> tmp = new ArrayList<Pair>();
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++) 
					if(arr[i][j] == 'S' || arr[i][j] == 'A')
						tmp.add(new Pair(i, j));
			points = new Pair[tmp.size()];
			for (int i = 0; i < points.length; i++) 
				points[i] = tmp.get(i);
			edgeList = new ArrayList<Edge>();
			for(int i = 0;i<points.length;i++)
				bfs(i);
			sb.append(kruskal()+"\n");			
		}
		System.out.print(sb);
	}
	
	static class Pair
	{
		int i,j;
		public Pair(int i,int j)
		{
			this.i = i;
			this.j = j;
		}
	}
	static class Edge implements Comparable<Edge>
	{
		int from,to;
		int cost;
		public Edge(int f,int t,int c)
		{
			from = f;
			to = t;
			cost = c;
		}
		public int compareTo(Edge o) {
			return cost - o.cost;
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
