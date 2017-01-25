import java.io.*;
import java.util.*;
public class Main{
	static final int oo = (int) 1e9;
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = Integer.parseInt(br.readLine().trim());
		while(cases-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			LinkedList<Edge> edgeList = new LinkedList<Edge>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edgeList.add( new Edge(a, b, c));
			}
			int[] dist = new int[n];
			Arrays.fill(dist, oo);
			dist[0] = 0;
			boolean negativeCycle = false;
			for(int i = 0;i<n;i++)
			{
				for(Edge e : edgeList)
				{
					int from = e.from;
					int to = e.to;
					int newCost = dist[from] + e.cost;
					if(newCost<dist[to])
					{
						if(i==n-1)
							negativeCycle = true;
						dist[to] = newCost;
					}
				}
			}
			out.append(negativeCycle?"possible\n":"not possible\n");
		}
		out.flush();
	}
	static class Edge
	{
		int from,to,cost;
		public Edge(int f,int t,int c)
		{
			from = f;
			to = t;
			cost = c;
		}
	}
	
}
