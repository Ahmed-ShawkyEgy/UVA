import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n,cnt,sccCounter;
	static ArrayList<Integer>[] adj,adj2;
	static int[] num,low,size,indOf;
	static boolean[] inStack,mat[];
	static Stack<Integer> stak;
	static int[] memo;
	
	static int solve()
	{
		cnt = sccCounter = 0;
		num = new int[n];
		low = new int[n];
		size = new int[n];
		indOf = new int[n];
		inStack = new boolean[n];
		stak = new Stack<Integer>();
		
		for(int i = 0;i<n;i++)
			if(num[i]==0)
				tarjan(i);
		
		mat = new boolean[sccCounter][sccCounter];
		adj2 = new ArrayList[sccCounter];
		for (int i = 0; i < adj2.length; i++) 
			adj2[i] = new ArrayList<Integer>();
		
		int[] degree = new int[sccCounter];
		for(int i = 0;i<n;i++)
			for(int j : adj[i])
			{
				int a = indOf[i] , b = indOf[j];
				if(a!=b && !mat[a][b])
				{
					mat[a][b] = true;
					adj2[a].add(b);
					degree[b]++;
				}
			}
		
		int ans = 0;
		memo = new int[sccCounter];
		Arrays.fill(memo, -1);
		for(int i = 0;i<sccCounter;i++)	
			if(degree[i]==0)
				ans = Math.max(ans, dp(i));
		
		return ans;
		
	}
	static int dp(int cur)
	{
		if(memo[cur]!=-1)
			return memo[cur];
		int ans = 0;
		for(int j : adj2[cur])
			ans = Math.max(ans, dp(j));
		
		return memo[cur] = size[cur] + ans;
	}
	static void tarjan(int cur)
	{
		num[cur] = low[cur] = ++cnt;
		inStack[cur] = true;
		stak.add(cur);
		for(int i : adj[cur])
		{
			if(num[i]==0)
				tarjan(i);
			if(inStack[i])
				low[cur] = Math.min(low[cur], low[i]);
		}
		if(low[cur]==num[cur])
		{
			int curSize = 0;
			while(true)
			{
				int v = stak.pop();
				inStack[v] = false;
				curSize++;
				indOf[v] = sccCounter;
				if(v==cur)break;
			}
			size[sccCounter++] = curSize;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
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
