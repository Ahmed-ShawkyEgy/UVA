import java.io.*;
import java.util.*;
public class Main{
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int[] color;
	static int n;
	static boolean isB;
	public static void bfs(int x)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		color = new int[n];
		q.add(x);
		color[x] = 1;
		isB = true;
		while(!q.isEmpty())
		{
			int cur = q.poll();
			visited[cur] = true;
			for(int i : adj[cur])
			{
				if(!visited[i])
				{
					color[i] = 3-color[cur];
					visited[i] = true;
					q.add(i);
					continue;
				}
				if(color[i]==color[cur])
					isB = false;
			}
		}
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			br.readLine();
			n = Integer.parseInt(br.readLine().trim());
			adj = new ArrayList[n<<1];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				while(p-->0)
				{
					int x = Integer.parseInt(st.nextToken())-1;
					if(x>=n)
						continue;
					adj[x].add(i);
					adj[i].add(x);
					
				}
			}
			int ans = 0;
			visited = new boolean[n<<1];
			for (int i = 0; i < n ;i++) 
			{
				if(!visited[i])
				{
					bfs(i);
					if(isB)
					{
						int a  = 0,b =0;
						for(int j = 0;j<n;j++)
						{
							if(color[j]==1)
								a++;
							if(color[j]==2)
								b++;
						}
					ans += Math.max(a, b);
					}
				}
			}
			out.append(ans+"\n");
		}
		out.flush();
	}
	
}
