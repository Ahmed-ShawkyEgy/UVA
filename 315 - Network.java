import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Main{
	static ArrayList<Integer>[] adj;
	static int[] num,low,parent;
	static int count,rootChildren;
	static boolean[] isArt;
	public static void dfs(int n)
	{
		num[n] = low[n] = count++;
		for(int v : adj[n])
		{
			if(num[v]==0)
			{
				parent[v] = n;
				if(parent[n]==-1)
					rootChildren++;
				dfs(v);
				if(low[v]>=num[n])
					isArt[n] = true;
				low[n] = Math.min(low[n], low[v]);
			}
			else
			{
				if(parent[n]!=v)
					low[n] = Math.min(low[n], num[v]);
			}
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
				int a = Integer.parseInt(st.nextToken());
				if(a==0)
					break;
				a--;
				while(st.hasMoreTokens())
				{
					int b = Integer.parseInt(st.nextToken())-1;
					adj[a].add(b);
					adj[b].add(a);
				}
			}
			num = new int[n];
			parent = new int[n]; Arrays.fill(parent, -1);
			low = new int[n];
			isArt = new boolean[n];
			count = 1; rootChildren = 0;
			dfs(0);
			if(rootChildren<2)isArt[0] = false;
			int ans = 0;
			for (int i = 0; i < isArt.length; i++) 
				ans += isArt[i]? 1:0;
			System.out.println(ans);
		}
	}
}
