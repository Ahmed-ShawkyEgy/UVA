import java.io.*;
import java.util.*;
public class Main {
	static int[] xx = {1,0,0,-1};
	static int[] yy = {0,1,-1,0};
	static char[][] arr;
	public static void floodFill(int x,int y)
	{
		if(!isValid(x, y))
			return;
		if(arr[x][y]!='.')
		{
			arr[x][y] = '.';
			for(int i = 0;i<xx.length;i++)
			{
				floodFill(x+xx[i], y+yy[i]);
			}
		}
	}
	public static boolean isValid(int i,int j)
	{
		return i>=0 && j>=0 && i<arr.length && j<arr.length;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		int cases = 1;
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine().trim());
			arr = new char[n][n];
			for (int i = 0; i < arr.length; i++) 
				arr[i] = br.readLine().toCharArray();
			int ans = 0;
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < n; j++) 
				{
					if(arr[i][j]=='x')
					{
						floodFill(i, j);
						ans++;
					}
				}
			}
			out.append("Case "+cases+++": "+ans+"\n");
			
		}
		out.flush();
	}
}
