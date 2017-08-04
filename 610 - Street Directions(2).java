import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n,counter;
	static ArrayList<Integer>[] adj;
	static int[] num,low;
	static Stack<String> stak;
	static boolean[][] matrix;
	static boolean[] vis;
	static void tarjan()
	{
		num = new int[n];
		low = new int[n];
		matrix = new boolean[n][n];
		vis = new boolean[n];
		
		counter = 0;
		stak = new Stack<String>();
		
		Arrays.fill(num, -1);
		Arrays.fill(low, (int)1e9);
		
		bridgeDetection(0,-1);
	}
	static void bridgeDetection(int cur,int parent)
	{
		num[cur] = low[cur] = counter++;
		for(int i: adj[cur])
		{
			if(num[i] == -1)
			{
				bridgeDetection(i,cur);
				
				stak.push((cur+1)+" "+(i+1));
				if(low[i]>num[cur])
				{
					stak.push((i+1)+" "+(cur+1));
				}
				matrix[i][cur] = true;
				matrix[cur][i] = true;
				
				low[cur] = Math.min(low[cur], low[i]);
			}
			else if(i!=parent)
			{
				low[cur] = Math.min(low[cur], num[i]);
				if(!matrix[cur][i] && !matrix[i][cur])
					stak.push((cur+1)+" "+(i+1));
				matrix[cur][i] = true;
				matrix[i][cur] = true;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				adj[a].add(b);
				adj[b].add(a);
			}
			
			tarjan();
			sb.append(cases+++"\n\n");
			while(!stak.isEmpty())
				sb.append(stak.pop()+"\n");
			
			sb.append("#\n");
		}
		System.out.print(sb);
	}
}
