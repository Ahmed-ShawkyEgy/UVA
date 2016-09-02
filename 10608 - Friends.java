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
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int x = uf.findSet(Integer.parseInt(st.nextToken())-1);
				int y = uf.findSet(Integer.parseInt(st.nextToken())-1);
				uf.union(x, y);
			}
			int ans = uf.getMaxSize();
			out.append(((ans==1)? 0:ans)+"\n");
		}
		out.flush();
	}
	static class UnionFind
	{
		int[] set;
		int[] rank;
		int[] size;
		int num;
		public UnionFind(int n)
		{
			set = new int[n];
			rank = new int[n];
			size = new int[n];
			num = n;
			for (int i = 0; i < n; i++) 
			{
				set[i] = i;
				rank[i] = size[i] = 1;
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
			if(rank[a]>rank[b])
			{
				set[b] = a;		
				size[a]+=size[b];
			}
			else
			{
				set[a] = b;
				size[b]+=size[a];
				if(rank[a]==rank[b])
				{
					rank[b]++;
				}
			}
		}
		public int getMaxSize()
		{
			int max = 0;
			for (int i = 0; i < size.length; i++) {
				max = Math.max(max, size[i]);
			}
			return max;
		}
	}
}
