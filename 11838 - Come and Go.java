import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main{
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	public static void dfs(int n)
	{
		visited[n] = true;
		for(int i : adjList[n])
		{
			if(!visited[i])
				dfs(i);
		}
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));	       
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			adjList = new ArrayList[n];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken())-1;
				int w = Integer.parseInt(st.nextToken())-1;
				int p = Integer.parseInt(st.nextToken());
				adjList[v].add(w);
				if(p==2)
					adjList[w].add(v);
			}
			boolean flag = true;
			for (int i = 0; i < n; i++) 
			{
				visited = new boolean[n];
				dfs(i);
				for (int j = 0; j < n; j++) 
				{
					if(!visited[j])
						flag = false;
				}
				if(!flag)
					break;
			}
			if(flag)
				out.append(1+"\n");
			else
				out.append(0+"\n");
		}
		out.flush();
	}
}
