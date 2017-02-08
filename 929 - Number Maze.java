import java.io.*;
import java.util.*;
public class Main{
	static int[] xx = {1,0,0,-1};
	static int[] yy = {0,1,-1,0};
	static int n,m,oo=(int)1e9;
	static int[][] arr;
	public static int dijkstra()
	{
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		int[][] dist = new int[n][m];
		for (int i = 0; i < dist.length; i++)
			Arrays.fill(dist[i], oo);
		dist[0][0] = arr[0][0];
		q.add(new Node(0,0,dist[0][0]));
		while(!q.isEmpty())
		{
			Node cur = q.poll();
			for (int i = 0; i < xx.length; i++) 
			{
				int x = cur.x + xx[i];
				int y = cur.y + yy[i];
				if(isValid(x, y))
				{
					int newCost = cur.dist + arr[x][y];
					if(newCost<dist[x][y])
					{
						dist[x][y] = newCost;
						q.add(new Node(x,y,newCost));
					}
				}
			}
		}
		return dist[n-1][m-1];
	}
	public static boolean isValid(int i,int j)
	{
		return i>=0 && j>=0 && i<n && j<m;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			n = Integer.parseInt(br.readLine().trim());
			m = Integer.parseInt(br.readLine().trim());
			arr = new int[n][m];
			for (int i = 0; i < n; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) 
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			out.append(dijkstra()+"\n");
		}
		out.flush();
	}
	static class Node implements Comparable<Node>
	{
		int x,y,dist;
		public Node(int i,int j,int d)
		{
			x = i;
			y = j;
			dist = d;
		}
		public int compareTo(Node o) {
			return dist-o.dist;
		}
	}
}
