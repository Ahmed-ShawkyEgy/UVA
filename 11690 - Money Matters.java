import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			UnionFind uf = new UnionFind(n);
			int ind= 0;
			for(int i = 0;i<n;i++)
				uf.money[i]=Integer.parseInt(br.readLine());
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y =Integer.parseInt(st.nextToken());
				uf.union(x, y);
			}
			out.append((uf.isPos())?"POSSIBLE\n":"IMPOSSIBLE\n");
		}
		out.flush();
	}
	static class UnionFind
	{
		int[] set;
		int[] rank;
		int[] money;
		public UnionFind(int n)
		{
			set = new int[n];
			rank = new int[n];
			money = new int[n];
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
			if(rank[a]>rank[b])
			{
				set[b] = a;		
				money[a]+=money[b];
				money[b] = 0;
			}
			else
			{
				set[a] = b;
				money[b]+=money[a];
				money[a] = 0;
				if(rank[a]==rank[b])
				{
					rank[b]++;
				}
			}
		}
		public boolean isPos()
		{
			for (int i = 0; i < money.length; i++) {
				if(money[i]!=0)
					return false;
			}
			return true;
		}
	}
}
