import java.io.*;
import java.util.*;

public class Main{
	static HashMap<String, Integer> map;
	static HashMap<Integer, String> map2;
	static int[] count;
	static ArrayList<Integer>[] out,in;
	static Deque<Integer> list;
	public static void topo()
	{
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		boolean[] taken = new boolean[map.size()];
		for (int i = 0; i < taken.length; i++) 
		{
			if(count[i]==0)
			{
				q.add(i);
			}
		}
		while(!q.isEmpty())
		{
			int cur = q.poll();
			if(!taken[cur])
			{
				list.addLast(cur);
				taken[cur] = true;
				for(int i = 0;i<out[cur].size();i++)
				{
					int node = out[cur].get(i);
					count[node]--;
					if(count[node]==0)
					{
						q.add(node);
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int cases = 1;
		boolean first = true;
		while(br.ready())
		{
			
			if(!first)
			{
				pw.append("\n");
			}
			first = false;
			map = new HashMap<String, Integer>();
			map2 = new HashMap<Integer, String>();
			int n = Integer.parseInt(br.readLine().trim());
			out = new ArrayList[n];
			in = new ArrayList[n];
			count = new int[n];
			for (int i = 0; i < n; i++) 
			{
				String s = br.readLine().trim();
				map.put(s, i);
				map2.put(i, s);
			}
			for (int i = 0; i < n; i++) 
			{
				out[i] = new ArrayList<Integer>();
				in[i] = new ArrayList<Integer>();
			}
			int m = Integer.parseInt(br.readLine().trim());
			
			while(m-->0)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				String x = st.nextToken();
				String y = st.nextToken();
				int a = map.get(x);
				int b = map.get(y);
				if(a==b)
					continue;
				in[b].add(a);
				out[a].add(b);
				count[b]++;
			}
			list = new LinkedList<Integer>();
			topo();
			pw.append("Case #"+cases+++": Dilbert should drink beverages in this order:");
			for(int i:list)
			{
				pw.append(" "+map2.get(i));
			}
			pw.append(".\n");
			if(br.ready())
				br.readLine();
		}
		pw.append("\n");
		pw.flush();
	}
}
