import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.*;

public class Main {
	static int s,p;
	static PriorityQueue<Edge> q;
	public static double kruskal()
	{
		UnionFind u = new UnionFind(p);
		double d = 0;
		while(!q.isEmpty())
		{
			if(u.numSets==s)
				break;
			Edge cur = q.poll();
			int from = cur.from,to=cur.to;
			if(!u.isSameSet(from, to))
			{
				u.union(from, to);
				d = Math.max(d, cur.cost);
			}
		}
		return d;
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		DecimalFormat f = new DecimalFormat("0.00");
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			int[][] arr = new int[p][2];
			for (int i = 0; i < p; i++) 
			{
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			q = new PriorityQueue<Edge>();
			for (int i = 0; i < arr.length; i++) {
				for (int j = i+1; j < arr.length; j++) 
				{
					int x = (arr[i][0]-arr[j][0]);
					x*=x;
					int y = arr[i][1]-arr[j][1];
					y*=y;
					double cost = Math.sqrt(x+y);
					q.add(new Edge(i,j,cost));
				}
			}
			double res = kruskal();
			out.append(f.format(res)+"\n");
		}
		out.flush();
    }
    static class Edge implements Comparable<Edge>
    {
    	int from,to;
    	double cost;
    	public Edge(int f,int t,double c)
    	{
    		from = f;
    		to = t;
    		cost = c;
    	}
		public int compareTo(Edge o) {
			return Double.compare(cost, o.cost);
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
