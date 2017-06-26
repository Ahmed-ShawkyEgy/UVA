import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n,m,SCC,ind;
	static ArrayList<Integer>[] adj;
	static boolean[] visited,inStak;
	static int[] dfsNum,dfsLow;
	static Stack<Integer> stak;
	
	public static void tarjan()
	{
		ind = SCC = 0;
		visited = new boolean[n];
		inStak = new boolean[n];
		dfsNum = new int[n];
		dfsLow = new int[n];
		stak = new Stack<Integer>();
		for(int i = 0;i<n;i++)
			if(!visited[i])
				dfs(i);
	}
	public static void dfs(int cur)
	{
		stak.push(cur);
		inStak[cur] = visited[cur] = true;
		dfsNum[cur] = dfsLow[cur] = ind++;
		for(int i : adj[cur])
		{
			if(!visited[i])
				dfs(i);
			if(inStak[i])
				dfsLow[cur] = Math.min(dfsLow[cur],dfsLow[i]);
		}
		if(dfsNum[cur]==dfsLow[cur])
		{
			while(!stak.isEmpty())
			{
				int x = stak.pop();
				inStak[x] = false;
				if(x==cur)
					break;
			}
			SCC++;
		}
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++)
				adj[i] = new ArrayList<Integer>();
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				if(v==2)adj[b].add(a);
			}
			tarjan();
			out.append(SCC==1?"1\n":"0\n");
		}
		out.flush();
	}
}
