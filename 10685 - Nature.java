import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		while(true)
		{
			if(!first)
				br.readLine();
			first = false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			UnionFind uf = new UnionFind(n);
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int ind= 0;
			while(n-->0)
				map.put(br.readLine(),ind++);	
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int x = map.get(st.nextToken());
				int y = map.get(st.nextToken());
				uf.union(x, y);
			}
			int ans = uf.getMaxSize();
			out.append((ans)+"\n");
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
