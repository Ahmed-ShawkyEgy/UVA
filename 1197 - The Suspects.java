import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			Set u = new Set(n);
			for(int i =0;i<m;i++)
			{
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				int s=0;
				if(k>1)
					s = Integer.parseInt(st.nextToken());
				for(int j = 0;j<k-1;j++)
				{
					u.union(s, Integer.parseInt(st.nextToken()));
				}
			}
			out.append(u.size[u.findSet(0)]+"\n");
		}
		out.flush();
	}
	static class Set
	{
		int[] set;
		int[] rank;
		int[] size;
		public Set(int n)
		{
			set = new int[n];
			rank = new int[n];
			size = new int[n];
			for(int i =0;i<n;i++)
				set[i]=i;
			Arrays.fill(rank, 1);
			Arrays.fill(size, 1);
		}
		public int findSet(int n)
		{
			if(set[n]==n)
				return n;
			return set[n] = findSet(set[n]);
		}
		public void union(int x,int y)
		{
			int a = findSet(x),b = findSet(y);
			if(a!=b)
			{
				if(rank[a]<rank[b])
				{
					set[a] = b;
					size[b] +=size[a];
				}
				else
				{
					set[b] = a;
					if(rank[a]==rank[b])
					{
						rank[a]++;
					}
					size[a]+=size[b];
				}
			}
		}
	}

}
