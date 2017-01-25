import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer>[] adj;
	static int[] num,low;
	static Stack<Integer>stak;
	static boolean[] inCycle;
	static int count,ans;
	public static void tarjan(int n)
	{
		num[n] = low[n] = count++;
		stak.push(n);
		for(int i: adj[n])
		{
			if(num[i]==0)
				tarjan(i);
			if(!inCycle[i])
				low[n] = Math.min(low[n], low[i]);
		}
		if(low[n]==num[n])
		{
			while(true)
			{
				int x = stak.pop();
				inCycle[x] = true;
				if(x==n)
					break;
			}
			ans++;
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
			HashMap<String, Integer>map = new HashMap<String, Integer>();
			adj = new ArrayList[n];
			for (int i = 0; i < n; i++) 
			{
				map.put(br.readLine().trim(), i);
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; i++) 
			{
				int a = map.get(br.readLine().trim());
				int b = map.get(br.readLine().trim());
				adj[a].add(b);
			}
			num = new int[n];
			low = new int[n];
			stak = new Stack<Integer>();
			inCycle = new boolean[n];
			count = 1;ans=0;
			for (int i = 0; i < n; i++)
				if(num[i]==0)
					tarjan(i);	
			
			System.out.println(ans);
		}
	}
}
