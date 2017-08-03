import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static boolean isCyclic;
	static ArrayList<Integer>[] adj;
	static int[] inDeg;
	static boolean[] vis;
	static Queue<Integer> q;
	static void dfs(int cur)
	{
		if(isCyclic)
			return;
		vis[cur] = true;
		q.add(cur);
		for(int i:adj[cur])
		{
			inDeg[i] --;
			if(vis[i])
				isCyclic = true;
			if(inDeg[i]==0 && !vis[i])				
				dfs(i);
		}
	}
	static void solve()
	{
		q = new LinkedList<Integer>();
		vis = new boolean[n];
		isCyclic = false;
		for(int i = 0;i<n;i++)
			if(inDeg[i]==0 && !vis[i])
				dfs(i);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			
			inDeg = new int[n];
			for (int i = 0; i < m; i++) 
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				adj[a].add(b);
				inDeg[b]++;
			}
			solve(); 
			
			if(isCyclic || q.isEmpty())
			{
				sb.append("IMPOSSIBLE\n");
				continue;
			}
			while(!q.isEmpty())
				sb.append((1+q.poll())+"\n");
		}
		System.out.print(sb);
	}
}
