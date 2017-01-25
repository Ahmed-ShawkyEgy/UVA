import java.io.*;
import java.util.*;
public class Main{
	static ArrayList<Integer>[] adj;
	static int day,ans;
	public static void bfs(int n)
	{
		Queue<Integer> curLvl = new LinkedList<Integer>();
		Queue<Integer> nxtLvl = new LinkedList<Integer>();
		boolean[] visited = new boolean[adj.length];
		visited[n] = true;
		curLvl.add(n);
		int lvl = 0;
		ans = 0;
		while(!curLvl.isEmpty())
		{
			int total = 0;
			lvl++;
			while(!curLvl.isEmpty())
			{
				int cur = curLvl.poll();
				for(int i : adj[cur])
				{
					if(!visited[i])
					{
						nxtLvl.add(i);
						visited[i] = true;
						total ++;
					}
				}
			}
			if(total>ans)
			{
				ans = total;
				day = lvl;
			}
			while(!nxtLvl.isEmpty())
				curLvl.add(nxtLvl.poll());
		}
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) 
			adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			while(N-->0)
				adj[i].add(Integer.parseInt(st.nextToken()));
		}
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			int root = Integer.parseInt(br.readLine().trim());
			bfs(root);
			if(ans==0)
				out.append(0+"\n");
			else
				out.append(ans+" "+day+"\n");
		}
		out.flush();
	}
	
}
