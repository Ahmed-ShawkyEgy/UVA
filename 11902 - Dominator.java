package temp;

import java.util.*;
import java.io.*;


public class temp {
	static ArrayList<Integer>[] adjList;
	static boolean[] taken;

	public static void dfs(int n,int x)
	{	
		if(n==x)return;
		taken[n] = true;
		for(int i : adjList[n])
		{
			if(!taken[i])
			{
				dfs(i,x);
			}
			
		}
	}
	public static void main(String[] args) throws IOException
    {		
		FileReader fs = new FileReader("D:\\temp.txt");
		BufferedReader br = new BufferedReader(fs);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int t = Integer.parseInt(br.readLine());
		int cases = 1;
		PrintWriter out = new PrintWriter(System.out);
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			adjList = new ArrayList[n];
			for(int i=0;i<n;adjList[i] = new ArrayList<Integer>(n),i++);
			for(int i =0;i<n;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) 
				{
					int x = Integer.parseInt(st.nextToken());
					if(x==1)
					{
						adjList[i].add(j);
					}
				}
			}
			taken  = new boolean[n];
			dfs(0,-1);
			boolean[] reachable = taken.clone();
			out.append("Case "+cases++ +":\n");
			StringBuilder cc = new StringBuilder();
			
			for(int i =0;i<(n<<1)-1;i++)
				cc.append("-");
			
			out.append("+"+cc.toString()+"+\n");
			
			for(int i =0;i<n;i++)
			{
				taken = new boolean[n];	
				dfs(0,i);							
				out.append("|");
				for(int j = 0;j<n;j++)
				{		
					char c ;
					if(reachable[j] && !taken[j])
						c = 'Y';
					else
						c='N';					
					out.append(c+"|");
				}
				out.append("\n");
				out.append("+"+cc.toString()+"+\n");
				
			}
		}
		out.flush();
    }
}
