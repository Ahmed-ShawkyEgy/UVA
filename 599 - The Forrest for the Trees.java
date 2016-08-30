import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer>[] adj;
	static boolean taken[];
	static HashMap<Character, Integer>map;
	
	public static void dfs(int n)
	{
		taken[n] = true;
		for(int i : adj[n])
		{
			if(!taken[i])
				dfs(i);
		}
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		map = new HashMap<Character, Integer>();
		char x = 'A';
		for (int i = 0; i < 26; i++) {
			map.put((char) (x+i), i);
		}
		while(t-->0)
		{
			adj = new ArrayList[26];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			taken = new boolean [26];
			String s;
			while( ( s=br.readLine() ).charAt(0)=='(' ) 
			{
				char a = s.charAt(1);
				char b = s.charAt(3);
				if(a!=b)
				{
					adj[map.get(a)].add(map.get(b));
					adj[map.get(b)].add(map.get(a));
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine(),",");
			int tree = 0,acorn = 0;
			int ind;
			while(st.hasMoreTokens())
			{
				char a = st.nextToken().charAt(0);
				ind = map.get(a);
				if(!taken[ind])
				{
					if(adj[ind].size()==0)
					{
						taken[ind] = true;
						acorn++;
					}
					else
					{
						dfs(ind);
						tree++;
					}
				}
			}
			out.append("There are "+tree+" tree(s) and "+acorn+" acorn(s).\n");
		}
		out.flush();
	}
}
