import java.io.*;
import java.util.*;
public class Main{
	static ArrayList<Integer>[] adj,outDeg;
	public static void bfs(int n)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		int[] dist = new int[adj.length];
		dist[n] = 0;
		q.add(n);
		while(!q.isEmpty())
		{
			int cur = q.poll();
			for(int i : outDeg[cur])
			{
				dist[i] = dist[cur] + 1;
				q.add(i);
			}
		}
		for (int i = 0; i < dist.length; i++) 
			if(dist[i]==1)
				adj[i].add(n);
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine().trim());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			HashMap<Integer, String>  map2 = new HashMap<Integer, String>();
			outDeg = new ArrayList[n];
			adj = new ArrayList[n];
			String[] arr = new String[n];
			int[] in = new int[n],out = new int[n];
			for (int i = 0; i < n; i++) 
			{
				outDeg[i] = new ArrayList<Integer>();
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < n; i++) 
			{
				String s = br.readLine();
				map.put(s, i);
				map2.put(i, s);
				arr[i] = s;
			}
			Arrays.sort(arr);
			int m = Integer.parseInt(br.readLine().trim());
			while(m-->0)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = map.get(st.nextToken());
				int X = Integer.parseInt(st.nextToken());
				in[a] += X;
				while(X-->0)
				{
					int b = map.get(st.nextToken());
					outDeg[b].add(a);
					out[b]++;
				}
			}
			for (int i = 0; i < n; i++) 
			{
				bfs(i);
			}
			for(String s : arr)
			{
				int ind = map.get(s);
				if(adj[ind].size()>0)
				{
					pw.append(s+" "+adj[ind].size());
					ArrayList<String> list = new ArrayList<String>(adj[ind].size());
					for (int i = 0; i < adj[ind].size(); i++) {
						list.add(map2.get(adj[ind].get(i)));
					}
					Collections.sort(list);
					for(String c : list)
						pw.append(" "+c);
					pw.append("\n");
				}
			}
		}
		pw.flush();
	}
	
	
}
