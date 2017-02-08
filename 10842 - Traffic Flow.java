import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.*;

public class Main{
	static PriorityQueue<Edge> q;
	static int n,m;
	public static int kruskal()
	{
		UnionFind u = new UnionFind(n);
		int ans = Integer.MAX_VALUE;
		while(!q.isEmpty() && u.numSets>1)
		{
			Edge cur = q.poll();
			int c = -cur.cost;
			int f = cur.from;
			int t = cur.to;
			if(!u.isSameSet(f, t))
			{
				u.union(f, t);
				ans = Math.min(ans, c);
			}
		}
		return ans;
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		int cases = 1;
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			q = new PriorityQueue<Edge>(m);
			for (int i = 0; i < m; i++) 
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				q.add(new Edge(a, b, -c));
			}
			int res = kruskal();
			out.append("Case #"+cases+++": "+res+"\n");
		}
		out.flush();
    }
    static class Edge implements Comparable<Edge>
    {
    	int from,to,cost;
    	public Edge(int f,int t,int c)
    	{
    		from = f;
    		to = t;
    		cost = c;
    	}
		public int compareTo(Edge o) {
			return cost-o.cost;
		}
    }
    static class UnionFind {
    	int[] rep,rank,setSize;
    	int numSets;
    	public UnionFind(int n)
    	{
    		rep = new int[n];
    		rank = new int[n];
    		setSize = new int[n];
    		for(int i =0;i<n;i++)
    		{
    			rep[i] = i;
    			rank[i] = 1;
    			setSize[i] = 1;
    		}
    		numSets = n;
    	}
    	public int findSet(int x)
    	{
    		if(rep[x]==x)
    			return x;
    		return rep[x] = findSet(rep[x]);
    	}
    	public boolean isSameSet(int x,int y)
    	{
    		return findSet(x)==findSet(y);
    	}
    	public void union(int x,int y)
    	{
    		int a = findSet(x),b=findSet(y);
    		if(rank[a]>rank[b])
    		{
    			rep[b]=a;
    			if(a!=b)
    			setSize[a]+=setSize[b];
    		}
    		else
    		{
    			rep[a] = b;
    			if(rank[a]==rank[b] && a!=b)
    				rank[b]++;
    			if(a!=b)
    				setSize[b]+=setSize[a];
    		}
    		numSets--;
    	}
    }
}
