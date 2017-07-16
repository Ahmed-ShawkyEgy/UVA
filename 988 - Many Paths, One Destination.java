import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main {
	static int n;
	static ArrayList<Integer>[] adj;
	static long[] memo;
	static int[] inDeg;
	static boolean[] visited;
	public static void dfs(int n)
	{
		visited[n] = true;
		for(int i : adj[n])
		{
			memo[i] += memo[n];
			inDeg[i]--;
			if(inDeg[i]==0 && !visited[i])
				dfs(i);
		}
	}
	public static void main (String args[]) throws IOException 
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		while(br.ready())
		{
			if(!first)
				br.readLine();
			n = Integer.parseInt(br.readLine().trim());
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			inDeg = new int[n];
			LinkedList<Integer> death = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int len = Integer.parseInt(st.nextToken());
				if(len==0)
				{
					death.add(i);
					continue;
				}				
				for (int j = 0; j < len; j++) 
				{
					int x = Integer.parseInt(st.nextToken());
					inDeg[x]++;
					adj[i].add(x);
				}
			}
      
			memo = new long[n];
			memo[0] = 1;
			visited = new boolean[n];
      
			for(int i = 0;i<n;i++)
				if(!visited[i] && inDeg[i]==0)
					dfs(i);
          
			long ans = 0;
			while(death.size()>0)
				ans += 1l * memo[death.poll()];
			if(!first)
				sb.append("\n");
			first = false;
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
}
