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
	static int n ;
	static ArrayList<Edge> list ;
	static ArrayList<Integer> taken;
	
	static int kruskal(int ignore,boolean fill)
	{
		UnionFind uf = new UnionFind(n);
		int idx = -1;
		int ans = 0;
		
		for(Edge e : list)
		{
			++idx;
			if(idx==ignore)
				continue;
			if(!uf.isSameSet(e.a, e.b))
			{
				ans += e.c;
				uf.union(e.a, e.b);
				if(fill)
					taken.add(idx);
			}
		}
		
		if(uf.numSets > 1)
			ans = -1;
		return ans;
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(t-->0){
			n = sc.nextInt();
			int m = sc.nextInt();
			list = new ArrayList<Edge>();
			while(m-->0)
				list.add(new Edge(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()));
			
			Collections.sort(list);
			taken = new ArrayList<Integer>();
			int ans1 = kruskal(-1, true);
			int ans2 = (int)1e9;
			for(int i : taken)
			{
				int k = kruskal(i, false);
				if(k==-1)k=ans2;
				ans2 = Math.min(ans2,k );
			}
			
			sb.append(ans1+" "+ans2+"\n");
		}
		System.out.print(sb);
	}
	
	static class Edge implements Comparable<Edge>
	{
		int a,b,c;
		public Edge(int x,int y,int z) {
			a = x; b = y; c = z;
		}
		
		public int compareTo(Edge o) {
			return c-o.c;
		}
		
	}
	
	static class UnionFind
	{
		int[] set,rank;
		int numSets;
		public UnionFind(int n) {
			set = new int[n];
			rank = new int[n];
			numSets = n;
			for (int i = 0; i < n; i++) 
				set[i] = i;
			
		}
		
		public int find(int x){return set[x] == x? x : (set[x]=find(set[x]));}
		
		void union(int a,int b)
		{
			int x = find(a) , y = find(b);
			if(x==y)return;
			if(rank[x] > rank[y])
				set[y] = x;
			else
			{
				set[x] = y;
				if(rank[x]==rank[y])
					rank[y]++;
			}
			numSets--;
		}
		
		boolean isSameSet(int i,int j){return find(i)==find(j);}
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
