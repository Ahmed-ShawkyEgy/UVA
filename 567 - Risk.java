import java.io.*;
import java.util.*;
public class Main{
	static int N = 20;
	static ArrayList<Integer>[] adjList;
	public static int bfs(int s,int t)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		int[] dist = new int[N];
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty())
		{
			int cur = q.poll();
			for(int i : adjList[cur])
			{
				if(!visited[i])
				{
					q.add(i);
					visited[i] = true;
					dist[i] = dist[cur]+1;
				}
			}
		}
		return dist[t];
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = 1;
		while(br.ready())
		{
			adjList = new ArrayList[20];
			for (int i = 0; i < adjList.length; i++) 
				adjList[i] = new ArrayList<Integer>();
			for (int i = 0; i < 19; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				while(num-->0)
				{
					int j = Integer.parseInt(st.nextToken())-1;
					adjList[i].add(j);
					adjList[j].add(i);
				}
			}
			int m = Integer.parseInt(br.readLine());
			System.out.println("Test Set #"+cases++);
			while(m-->0)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int ans = bfs(a, b);
				System.out.printf("%2d %s %2d%s %d%n",a+1,"to",b+1,":",ans);
			}
			System.out.println();
		}
	}
	
	
}
