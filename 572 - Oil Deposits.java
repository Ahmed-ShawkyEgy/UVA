import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] adj;
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {1,1,0,-1,-1,-1,0,1};
	public static void flood(int x,int y)
	{
		if(!isValid(x, y) || !adj[x][y])
			return;
		adj[x][y] = false;
		for (int i : dx) 
		{
			for (int j : dy)
			{
				flood(x+i,y+j);
			}
		}
	}
	public static boolean isValid(int x,int y)
	{
		return x>=0 && x<adj.length && y>=0 && y<adj[0].length;
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			adj = new boolean[n][m];
			for (int i = 0; i < n; i++) 
			{
				String s = br.readLine();
				for (int j = 0; j < s.length(); j++) 
				{
					if(s.charAt(j)=='@')
						adj[i][j] = true;
				}
			}
			int ans = 0;
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < m; j++) 
				{
					if(adj[i][j])
					{
						ans++;
						flood(i,j);
					}
				}
			}
			out.append(ans+"\n");
		}
		out.flush();
	}
}
