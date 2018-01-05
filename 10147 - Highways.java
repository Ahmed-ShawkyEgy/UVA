// Print blank lines between test cases and not after the last test case
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
	static int[][] arr;
	static double eps = 1e-9;
	static double dist(int i,int j)
	{
		long x = arr[j][0] - arr[i][0]; x*=x;
		long y = arr[j][1] - arr[i][1]; y*=y;
		return Math.sqrt(x+y);
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while(t-->0)
		{
			if(!first)
				sb.append("\n");
			first = false;
			int n = sc.nextInt() ;
			arr = new int[n][2];
			for (int i = 0; i < n; i++) 
			{
				arr[i][0] = sc.nextInt() ;
				arr[i][1] = sc.nextInt();
			}
			ArrayList<Edge> edgeList = new ArrayList<Edge>();
			for (int i = 0; i < n; i++) 
				for (int j = i+1; j < n; j++) 
					edgeList.add(new Edge(i,j,dist(i, j)));
			UnionFind u = new UnionFind(n);
			int m = sc.nextInt();
			for (int i = 0; i < m; i++) 
				u.unionSet(sc.nextInt()-1, sc.nextInt()-1);
			
			if(u.numSets==1)
			{
				sb.append("No new highways need\n");
				continue;
			}
			Collections.sort(edgeList);
			for(Edge e : edgeList)
			{
				if(!u.isSameSet(e.a, e.b))
				{
					u.unionSet(e.a, e.b);
					sb.append((e.a+1)+" "+(e.b+1)+"\n");
				}
			}
		}
		System.out.print(sb);
	}
	
	static class Edge implements Comparable<Edge>
	{
		int a,b;
		double c;
		public Edge(int x,int y,double z) {
			a = x; b = y; c = z;
		}
		public int compareTo(Edge o) {
			if(c-eps>o.c)
				return 1;
			if(Math.abs(c-o.c) <= eps)return 0;
			return -1;
		}
	}
	
	static class UnionFind {                                              
		int[] p, rank, setSize;
		int numSets;

		public UnionFind(int N) 
		{
			p = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
		}

		public int findSet(int i) { return p[i] == i ? i : (p[i] = findSet(p[i])); }

		public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

		public void unionSet(int i, int j) 
		{ 
			if (isSameSet(i, j)) 
				return;
			numSets--; 
			int x = findSet(i), y = findSet(j);
			if(rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
			else
			{	p[x] = y; setSize[y] += setSize[x];
				if(rank[x] == rank[y]) rank[y]++; 
			} 
		}

		public int numDisjointSets() { return numSets; }

		public int sizeOfSet(int i) { return setSize[findSet(i)]; }
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(s));
		}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public String nextLine() throws IOException {return br.readLine();}		
		public long nextLong() throws IOException {return Long.parseLong(next());}		
		public double nextDouble() throws IOException {return Double.parseDouble(next());}	
		public boolean ready() throws IOException {return br.ready();}
	}
}
