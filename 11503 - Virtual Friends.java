import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			UnionFind uf = new UnionFind();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int ind = 0;
			for (int i = 0; i < n; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				String x = st.nextToken();
				String y = st.nextToken();
				if(!map.containsKey(x))
				{
					map.put(x, ind++);
				}
				if(!map.containsKey(y))
				{
					map.put(y, ind++);
				}
				uf.union(map.get(x),map.get(y));
				out.append(uf.size[uf.findSet(map.get(x))]+"\n");
			}
		}
		out.flush();
    }
	static class UnionFind
	{
		int[] set,rank,size;
		public UnionFind()
		{
			set = new int[500_000+1];
			rank = new int[500_000+1];
			size = new int[500_000+1];
			for (int i = 0; i < 500_000+1; i++) {
				set[i] = i;
				rank[i] = 1;
				size[i] = 1;
			}
		}
		public int findSet(int x)
		{
			return set[x]==x? x: (set[x] = findSet(set[x]));
		}
		public void union(int x,int y)
		{
			int a = findSet(x),b=findSet(y);
			if(a!=b)
			{
				if(rank[a]>rank[b])
				{
					set[b] = a;
					size[a]+=size[b];
				}
				else
				{
					set[a] = set[b];
					size[b] += size[a];
					if(rank[a]==rank[b])
						rank[b]++;
				}
			}
		}
	}
}
