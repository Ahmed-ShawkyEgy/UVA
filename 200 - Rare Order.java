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
	static ArrayList<Integer>[] adj;
	static int[] inDeg;
	static boolean[] vis;
	static Queue<Character> q;
	static LinkedHashSet<Character> charsUsed;
	static void dfs(int cur)
	{
		vis[cur] = true;
		q.add((char)(cur+'A'));
		for(int i : adj[cur])
		{
			inDeg[i]--;
			if(inDeg[i]==0 && !vis[i])
				dfs(i);
		}
	}
	static void solve()
	{
		vis = new boolean[26];
		q = new LinkedList<Character>();
		for(char c : charsUsed)
		{
			int ind = c-'A';
			if(!vis[ind] && inDeg[ind]==0)
				dfs(ind);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		while(br.ready())
		{
			ArrayList<char[]> arr = new ArrayList<char[]>();
			charsUsed = new LinkedHashSet<Character>();
			while(true)
			{
				String s = br.readLine().trim();
				if(s.equals("#"))
					break;
				arr.add(s.toCharArray());
				for (int i = 0; i < s.length(); i++)
					charsUsed.add(s.charAt(i));
			}
			adj = new ArrayList[26];
			inDeg = new int[26];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < arr.size()-1; i++) 
			{
					for(int k = 0;k<Math.min(arr.get(i).length, arr.get(i+1).length);k++)
					{
						char a = arr.get(i)[k] , b = arr.get(i+1)[k];
						if(a!=b)
						{
							adj[a-'A'].add(b-'A');
							inDeg[b-'A']++;
							break;
						}
					}
			}
			
			solve();
			while(!q.isEmpty())
				sb.append(q.poll());
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
