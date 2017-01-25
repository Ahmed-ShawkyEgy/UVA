import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Main{
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	public static void dfs(int n)
	{
		for(int i : adj[n])
			if(!visited[i])
			{
				visited[i] = true;
				dfs(i);
			}
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine().trim());
			if(n==0)
				break;
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			while(true)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				if(a==-1)
					break;
				while(st.hasMoreTokens())
				{
					int b = Integer.parseInt(st.nextToken())-1;
					if(b==-1)
						break;
					adj[a].add(b);
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			while(num-->0)
			{
				int x = Integer.parseInt(st.nextToken())-1;
				visited = new boolean[n];
				dfs(x);
				int ans = 0;
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < n; i++) {
					if(!visited[i])
					{
						ans++;
						if(ans==1)
							sb.append(i+1+"");
						else
							sb.append(" "+(i+1));
					}
				}
				System.out.print(ans);
				System.out.println((ans!=0)?" "+sb:"");
			}
		}
	}
}
