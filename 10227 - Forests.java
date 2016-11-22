import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

public class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		br.readLine();
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int tree = Integer.parseInt(st.nextToken());
			HashSet<Integer>[] arr = new HashSet[p];
			for (int i = 0; i < p; i++)
			{
				arr[i] = new HashSet<Integer>();
			}
			String s;
			while(br.ready() && !(s=br.readLine()).equals(""))
			{
				st = new StringTokenizer(s);
				int i = Integer.parseInt(st.nextToken())-1;
				int j = Integer.parseInt(st.nextToken());
					arr[i].add(j);
			}
			UnionFind uf = new UnionFind(p);
			for (int i = 0; i < p; i++) 
			{
				for (int j = i+1; j < p; j++) 
				{
					if(arr[i].size()==arr[j].size())
					{
						boolean areSame = true;
						for (int x : arr[i])
						{
							if(!arr[j].contains(x))
							{
								areSame = false;
								break;
							}						
						}
						if(areSame)
						uf.union(i, j);
					}
				}
			}
			if(!first)
				out.append("\n");
			first = false;
			out.append(uf.numSet+"\n");
		}
		out.flush();
	}
	static class UnionFind
	{
		int[] head,rank;
		int numSet;
		public UnionFind(int n)
		{
			head = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++) 
			{
				head[i] = i;
				rank[i] = 1;
			}
			numSet = n;
		}
		public int findSet(int x)
		{
			if(head[x]==x)
				return x;
			return head[x] = findSet(head[x]);
		}
		public void union(int x,int y)
		{
			int a = findSet(x), b = findSet(y);
			if(a==b)
				return;
			if(rank[a]>rank[b])
			{
				head[b] = a;
			}
			else
			{
				head[a] = b;
				if(rank[b]>rank[a])
					rank[b]++;
			}
			numSet--;
		}
	}
}
