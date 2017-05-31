import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adj;
	static boolean [] taken;
	public static void dfs(int n)
	{
		taken[n] = true;
		for(int i : adj[n])
		{
			if(!taken[i])
			{
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		br.readLine();
		boolean first = true;
		while(t-->0)
		{
			HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
			HashMap<Integer, Character> map2 = new HashMap<Integer, Character>();
			char c = br.readLine().charAt(0);
			int n = c-'A' + 1;
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			String s;
			int ind = 0;
			while(br.ready() && !(s=br.readLine()).isEmpty() )
			{
				char a = s.charAt(0);
				char b = s.charAt(1);
				if(!map1.containsKey(a))
				{
					map1.put(a, ind);
					map2.put(ind++, a);
				}
				if(!map1.containsKey(b))
				{
					map1.put(b, ind);
					map2.put(ind++, b);
				}
				int x = map1.get(a);
				int y = map1.get(b);
				adj[x].add(y);
				adj[y].add(x);
			}
			
			taken = new boolean[n];
			int ans = 0;
			int last = 0;
			for (int i = 0; i < n; i++) 
			{
				dfs(i);
				int cur = 0;
				for (int j = 0; j < n; j++) 
				{
					if(taken[j])
						cur++;
				}
				if(cur!=last)
				{
					ans++;
					last = cur;
				}
			}
			if(!first)
				out.append("\n");
			first = false;
			out.append(ans+"\n");
			
		}
		out.flush();
	}
}
