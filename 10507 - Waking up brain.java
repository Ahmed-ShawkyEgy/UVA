import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Area>[] adj;
	static int ans;
	static HashMap<Character, Integer> map;
	public static void bfs(int s)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		ArrayList<Area>[] adjj = adj;
		HashMap<Character,Integer>mapp = map;
		boolean found = false;
		boolean[] taken = new boolean[adj.length];
		taken[s] = true;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		while(!q.isEmpty())
		{
			Area x = adj[q.poll()].get(0); 
			int counter = 0;
			for (Area i : adj[map.get(x.c)]) 
			{
				if(i.wake && i.c!=x.c)
				{
					counter++;
				}
				if(!taken[map.get(i.c)])
				{
					taken[map.get(i.c)] = true;
					q.add(map.get(i.c));
				}
			}
			if(counter>=3 && !adj[map.get(x.c)].get(0).wake)
			{
				found = true;
				tmp.add(map.get(x.c));
			}
		}
		for(int i : tmp)
		{
			adj[i].get(0).wake = true;
		}
		if(found)
			{
				ans++;
				bfs(s);
			}
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			StringTokenizer ss = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(ss.nextToken());
			ss = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(ss.nextToken());
			adj = new ArrayList[n+1];
			for(int i =0;i<n+1;i++)
			{
				adj[i] = new ArrayList<Area>();
			}
			map = new HashMap<Character, Integer>();
			ans = 0;
			int ind = 0;
			String s = br.readLine();
			char[] wake = new char[3];
			for(int i=0;i<3;i++)
			{
				char c = s.charAt(i);
				map.put(c, ind++);
				Area x = new Area(c);
				x.wake = true;
				adj[ind-1].add(x);
				wake[i] = c;
			}
			for(int i =0;i<m;i++)
			{
				s = br.readLine();
				char a = s.charAt(0);
				char b = s.charAt(1);
				if(!map.containsKey(a) && !map.containsKey(b))
				{
					map.put(a, ind++);
					map.put(b, ind++);
					adj[map.get(a)].add(new Area(a));
					adj[map.get(b)].add(new Area(b));
					adj[map.get(a)].add(adj[map.get(b)].get(0));
					adj[map.get(b)].add(adj[map.get(a)].get(0));
				}	
				else
				{
					if(map.containsKey(a) && !map.containsKey(b))
					{
						map.put(b, ind++);
						adj[map.get(b)].add(new Area(b));
						adj[map.get(a)].add(adj[map.get(b)].get(0));
						adj[map.get(b)].add(adj[map.get(a)].get(0));
					}
					else
					{
						if(map.containsKey(b) && !map.containsKey(a))
						{
							map.put(a, ind++);
							adj[map.get(a)].add(new Area(a));
							adj[map.get(a)].add(adj[map.get(b)].get(0));
							adj[map.get(b)].add(adj[map.get(a)].get(0));
						}
						else
						{
							adj[map.get(a)].add(adj[map.get(b)].get(0));
							adj[map.get(b)].add(adj[map.get(a)].get(0));
						}
					}
				}
			}
			for(Entry<Character, Integer> e : map.entrySet())
			{
				bfs(e.getValue());
			}
			boolean awake = true;
			for(int i =0;i<n;i++)
			{
				if(!map.containsValue(i) || !adj[i].get(0).wake)
				{
					awake = false;
					break;
				}
			}
			if(awake)
			out.append("WAKE UP IN, "+ans+", YEARS\n");
			else
				out.append("THIS BRAIN NEVER WAKES UP\n");
			br.readLine();
		}
		out.flush();
		
	}
	static class Area
	{
		boolean wake = false;
		char c;
		public Area(char x)
		{
			c = x;
		}
		public String toString()
		{
			return c+" "+wake;
		}
	}
}
