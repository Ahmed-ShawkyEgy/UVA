import java.io.*;
import java.util.*;

public class Main{
	static ArrayList<Integer>[] adj;
	static boolean visited[];
	static int[] color;
	public static boolean dfs(int n,int col)
	{
		visited[n] = true;
		color[n] = col;
		for(int i : adj[n])
		{
			if(!visited[i])
			{
				dfs(i,1-col);
			}
			else
			{
				if(color[i]==color[n])
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			int n = Integer.parseInt(br.readLine().trim());
			if(n==0)
				break;
			int m = Integer.parseInt(br.readLine().trim());
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++)
				adj[i] = new ArrayList<Integer>();
			for (int i = 0; i < m; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}
			color = new int[n];
			Arrays.fill(color, -1);
			visited = new boolean[n];
			boolean ans = dfs(0,0);
			if(!ans)
				out.append("NOT BICOLORABLE.\n");
			else
				out.append("BICOLORABLE.\n");
		}
		out.flush();
	}
}
