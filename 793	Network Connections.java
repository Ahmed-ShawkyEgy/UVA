import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException
	{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		while(t-->0)
		{
			if(first)
			{
				br.readLine();
			}
			int n = Integer.parseInt(br.readLine());
			UnionFind uf = new UnionFind(n);
			String s;
			int succes=0,fail=0;
			while(br.ready()&&!(s=br.readLine()).equals(""))
			{
				StringTokenizer st = new StringTokenizer(s);
				char c = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				switch (c) {
				case 'c':
					uf.union(x, y);
					break;
				case 'q':
				{
					if(uf.isSame(x, y))
						succes++;
					else
						fail++;
					break;
				}
				default:
					break;
				}
			}
			if(!first)
			{
				out.append("\n");
			}
			else
				first = false;
			out.append(succes+","+fail+"\n");			
		}
		out.flush();
	}
	static class UnionFind
	{
		int[] head,rank;
		public UnionFind(int n)
		{
			head = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++) 
			{
				head[i] = i;
				rank[i] = 1;
			}
		}
		public int findSet(int x)
		{
			if(head[x] == x)
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
				head[a] = b;
			}
			else
			{
				head[b] = a;
				if(rank[b]==rank[a])
				{
					rank[b]++;
				}
			}
		}
		public boolean isSame(int x,int y)
		{
			return findSet(x)==findSet(y);
		}
	}
}
