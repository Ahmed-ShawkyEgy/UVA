import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] danger;
	static int [][] mem;
	static int count;
	static int min;
	static int r,c;
	public static int dp(int i,int j,int dist)
	{
		if(isValid(i,j))
		{
			if(i==r-1 && j==c-1)
			{
				update(dist);
				return dist;
			}
			if(mem[i][j]!=-1)
			{
				update(dist);
				return dist;
			}
			return mem[i][j] = Math.min(dp(i+1,j,dist+1) , dp(i,j+1,dist+1));
		}
		return -1;
	}
	public static boolean isValid(int i,int j)
	{
		return (i>=0 && i<r && j>=0 && j<c && !danger[i][j]);
	}
	public static void update(int dist)
	{
		if(dist<min)
		{
			min = dist;
			count = 1;
		}
		else
		{
			if(dist==min)
				count++;
		}
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		boolean first = true;
		while(t-->0)
		{
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			danger = new boolean[r][c];
			for(int i =0;i<r;i++)
			{
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken())-1;
				while(st.hasMoreTokens())
				{
					int j = Integer.parseInt(st.nextToken())-1;
					danger[n][j] = true;
				}
			}
			count = 0;
			min = Integer.MAX_VALUE;
			mem = new int[r][c];
			for(int i =0;i<r;i++)
			Arrays.fill(mem[i], -1);
			dp(0,0,0);
			if(first)first = false;
			else
				out.append("\n");
			out.append(count+"\n");
		}
		out.flush();
	}

}
