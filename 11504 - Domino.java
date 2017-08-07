import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n,m,cnt,sccCounter;
	static ArrayList<Integer>[] adj;
	static boolean[] inStack;
	static int[] num,low,parent,indOf,degree;
	static Stack<Integer> stak;
	
	static int solve()
	{
		int ans = 0;
		cnt = 1;
		sccCounter = 0;
		
		inStack = new boolean[n];
		
		num = new int[n]; 
		low = new int[n];
		indOf = new int[n];
		degree = new int[n];
		
		stak = new Stack<Integer>();
		
		for(int i = 0;i<n;i++)
			if(num[i]==0)
				dfs(i);
		
		for(int i = 0;i<n;i++)
			for(int j : adj[i])
				if(indOf[i] != indOf[j])
					degree[indOf[j]]++;
		
		
		int bound = Math.min(n, sccCounter);
		for(int i = 0;i<bound;i++)
			if(degree[i]==0)
				ans++;
		
		return ans;
	}
	static void dfs(int cur)
	{
		low[cur] = num[cur] = cnt++;
		inStack[cur] = true;
		stak.push(cur);
		for(int i : adj[cur])
		{
			if(num[i] == 0)
				dfs(i);
			if(inStack[i])
				low[cur] = Math.min(low[cur], low[i]);
		}
		
		if(low[cur]==num[cur])
		{
			while(true)
			{
				int c = stak.pop();
				inStack[c] = false;
				indOf[c] = sccCounter;
				if(c==cur) break;
			}
			sccCounter++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				adj[a].add(b);
			}				
			sb.append(solve()+"\n");
		}
		System.out.print(sb);
	}
}
