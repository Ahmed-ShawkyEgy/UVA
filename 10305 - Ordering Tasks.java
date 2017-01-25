import java.io.*;
import java.util.*;
public class Main{
	static ArrayList<Integer>[] in,out;
	static boolean[] visited;
	static Deque<Integer> list;
	public static void dfs(int n)
	{
		ArrayList<Integer>[] inn=in,outt=out;
		visited[n] = true;
		for(int i:in[n])
		{
			if(!visited[i])
			{
				dfs(i);
			}
		}
		list.addLast(n+1);
		for(int i:out[n])
		{
			if(!visited[i])
			{
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(m==0 && n==0)
				break;
			in = new ArrayList[n];
			out = new ArrayList[n];
			visited = new boolean[n];
			list = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				in[i] = new ArrayList<Integer>();
				out[i] = new ArrayList<Integer>();
			}
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				in[b].add(a);
				out[a].add(b);
			}
			for (int i = 0; i < n; i++) 
				if(!visited[i])
					dfs(i);
			System.out.print(list.pop());
			while(!list.isEmpty()) {
				System.out.print(" "+list.pop());
			}
			System.out.println();
		}
	}
}
