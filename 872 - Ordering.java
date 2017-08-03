import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static ArrayList<Integer>[] adj;
	static int[] inDeg;
	static boolean[] vis;
	static ArrayList<String> result;
	static boolean isCyclic;
	
	static void dfs(int n,String s)
	{
		if(isCyclic)
			return;
		vis[n] = true;
		boolean isLeaf = true;
		for(int i : adj[n])
		{
			if(vis[i])
			{
				isCyclic = true;
				return;
			}
			inDeg[i]--;
		}
		for(int i : arr)
			if(inDeg[i]==0 && !vis[i])
			{
				isLeaf = false;
				dfs(i,s+(char)(i+'A'));
			}
		
		for(int i : adj[n])
			inDeg[i]++;
		if(isLeaf)
			result.add(s);
		vis[n] = false;
	}
	static void solve()
	{
		isCyclic= false;
		result = new ArrayList<String>();
		vis = new boolean[26];
		for (int i : arr) 
			if(!vis[i] && inDeg[i]==0)
				dfs(i,(char)(i+'A')+"");
		Collections.sort(result);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine().trim());
		boolean first = true;
		while(t-->0)
		{
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[st.countTokens()];
			for (int i = 0; i < arr.length; i++) 
				arr[i] = st.nextToken().charAt(0)-'A';
			
			adj = new ArrayList[26];
			inDeg = new int[26];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
			{
				String s = st.nextToken();
				int a = s.charAt(0)-'A';
				int b = s.charAt(2)-'A';
				adj[a].add(b);
				inDeg[b]++;
			}
			
			solve();
			if(!first)
				sb.append("\n");
			first = false;
			if(isCyclic || result.size()==0)
			{
				sb.append("NO\n");
				continue;
			}
			for (int i = 0; i < result.size(); i++) 
			{
				String s = result.get(i);
				sb.append(s.charAt(0));
				for(int j = 1;j<s.length();j++)
				{
					sb.append(" "+s.charAt(j));
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
