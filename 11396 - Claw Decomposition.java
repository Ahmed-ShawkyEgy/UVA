import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer>[] adjList;
	static PrintWriter out = new PrintWriter(System.out);
	static int[] color;
	static final int oo = -1;
	static boolean ans;
	public static void check(int n)
	{
		color[n] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		while(!q.isEmpty())
		{
			int x = q.poll();
			for(int i : adjList[x])
			{
				if(color[i]==color[x])
				{
					ans = false;
					return;
				}
				if(color[i] == oo)
				{
					color[i] = 1- color[x];
					q.add(i);
				}				
			}
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(!(s=br.readLine()).equals("0"))
		{
			int n = Integer.parseInt(s);
			adjList = new ArrayList[n];
			for(int i =0;i<n;i++)
				adjList[i] = new ArrayList<Integer>(3);
			color = new int[n];
			while(!(s=br.readLine()).equals("0 0") )
			{
				StringTokenizer st = new StringTokenizer(s);
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				adjList[a].add(b);
				adjList[b].add(a);
				color[a] = oo;
				color[b] = oo;
			}
			ans = true;
			for (int i = 0; i < n; i++) {
				if(color[i] == oo)
				check(i);
			}
			System.out.println((ans)? "YES":"NO");
		}
		
	}

}
