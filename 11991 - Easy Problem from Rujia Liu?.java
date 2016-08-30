import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<Integer>[] adj;
	static HashMap<Integer, Integer>map;
	
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n+1];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			int ind = 0;
			map = new HashMap<Integer, Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i =1;i<=n;i++)
			{
				int x = Integer.parseInt(st.nextToken());
				if(!map.containsKey(x))
				{
					map.put(x, ind++);
				}
				adj[map.get(x)].add(i);
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(map.containsKey(b))
				{
					if(a <= adj[map.get(b)].size())
					{
						out.append(adj[map.get(b)].get(a-1)+"\n");
					}
					else
						out.append(0+"\n");
				}
				else
					out.append(0+"\n");
			}
		}
		out.flush();
	}
}
