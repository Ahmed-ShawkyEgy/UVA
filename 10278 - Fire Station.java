import java.io.*;
import java.util.*;
public class Main{
	static final int oo = (int) 1e8;
	public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		br.readLine();
		boolean first = true;
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(!first)
				out.append("\n");
			first = false;
			int f = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			boolean[] hasStation = new boolean[n];
			while(f-->0)
				hasStation[Integer.parseInt(br.readLine())-1] = true;
			int[][] adj = new int[n][n];
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < n; j++) 
					adj[i][j] = oo;
			while(br.ready())
			{
				st = new StringTokenizer(br.readLine());
				if(st.countTokens()==0)
					break;
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				adj[a][b] = c;
				adj[b][a] = c;				
			}
			for (int i = 0; i < n; i++) 
				adj[i][i] = 0;
			for (int k = 0; k < n; k++) 
				for (int i = 0; i < n; i++) 
					for (int j = 0; j < n; j++) 
						adj[i][j] = Math.min(adj[i][j],adj[i][k] + adj[k][j]);
			int[] dist = new int[n];
			for (int i = 0; i < n; i++) 
			{
				dist[i] = oo;
				for (int j = 0; j < n; j++) 
				{
					if(hasStation[j])
					{
						dist[i] = Math.min(dist[i], adj[i][j]);
					}
				}
			}
			int ind=0,max =oo;
			for (int i = 0; i < n; i++) 
			{
				int cur = 0;
				for (int j = 0; j < n; j++) 
					cur = Math.max(cur,Math.min(dist[j], adj[i][j]));
				if(cur<max)
				{
					max = cur;
					ind = i+1;
				}
			}
			out.append(ind+"\n");
		}
		out.flush();
	}
}
