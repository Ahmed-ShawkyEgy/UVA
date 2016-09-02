import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			UnionFind uf = new UnionFind(n);
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				uf.union(uf.findSet(a), uf.findSet(b));				
			}
			out.append("Case "+cases++ +": "+uf.num+"\n");
		}
		out.flush();
	}
	static class UnionFind
	{
		int[] set;
		int[] rank;
		int num;
		public UnionFind(int n)
		{
			set = new int[n];
			rank = new int[n];
			num = n;
			for (int i = 0; i < n; i++) 
			{
				set[i] = i;
				rank[i] = 1;
			}
		}
		public int findSet(int x)
		{
			return set[x]==x?x:(set[x]=findSet(set[x]));
		}
		public void union(int x,int y)
		{
			int a = findSet(x),b=findSet(y);
			if(a==b)
				return;
				num--;
			if(rank[a]>rank[y])
			{
				set[y] = a;			
			}
			else
			{
				set[a] = y;
				if(rank[a]==rank[y])
				{
					rank[y]++;
				}
			}
		}		
	}
}
