import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] adj;
	static int[] inDeg;
	static boolean[] vis;
	static ArrayList<String> result;
	static HashMap<Character,Integer> map1;
	static HashMap<Integer, Character> map2;
	static void dfs(int cur,String trace)
	{
		vis[cur] = true;
		for(int i : adj[cur])
			inDeg[i]--;
		boolean isLeaf = true;
		for(int i = 0;i<n;i++)
			if(inDeg[i]==0 && !vis[i])
			{
				dfs(i,trace + map2.get(i));
				isLeaf = false;
			}
		
		for(int i : adj[cur])
			inDeg[i]++;
		
		vis[cur] = false;
		
		if(isLeaf)
			result.add(trace);
	}
	static void solve()
	{
		result = new ArrayList<String>();
		vis = new boolean[n];
		for(int i = 0;i<n;i++)
			if(inDeg[i]==0)
				dfs(i,map2.get(i)+"");
		Collections.sort(result);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = st.countTokens();
			map1 = new HashMap<Character, Integer>();
			map2 = new HashMap<Integer, Character>();
			int ind = 0;
			while(st.hasMoreTokens())
			{
				char c = st.nextToken().charAt(0);
				map1.put(c, ind);
				map2.put(ind++, c);
			}
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			
			inDeg = new int[n];
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
			{
				int a = map1.get(st.nextToken().charAt(0));
				int b = map1.get(st.nextToken().charAt(0));
				inDeg[b]++;
				adj[a].add(b);
			}
			
			solve();
			if(!first)
				sb.append("\n");
			first = false;
			
			for (int i = 0; i < result.size(); i++) 
				sb.append(result.get(i)+"\n");
		}
		System.out.print(sb);
	}
}
