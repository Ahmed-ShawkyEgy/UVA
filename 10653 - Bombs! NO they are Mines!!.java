import java.io.*;
import java.util.*;
public class Main{
	static boolean[][] bomb;
	static int targetX,targetY,r,c;
	static int[] xx = {1,0,0,-1};
	static int[] yy = {0,1,-1,0};
	public static int bfs(int startX,int startY)
	{
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> cost = new LinkedList<Integer>();
		qx.add(startX);
		qy.add(startY);
		cost.add(0);
		boolean[][] taken = new boolean [r][c];
		taken[startX][startY] = true;
		while(!qx.isEmpty())
		{
			int x = qx.poll();
			int y = qy.poll();
			int res = cost.poll();
			if(x==targetX && y==targetY)
				return res;
			res++;
			for (int i = 0; i < xx.length; i++) 
			{
				int cX = x + xx[i];
				int cY = y + yy[i];
				if(isValid(cX, cY) && !taken[cX][cY] && !bomb[cX][cY])
				{
					taken[cX][cY] = true;
					qx.add(cX);
					qy.add(cY);
					cost.add(res);
				}
			}
		}
		return -1;
	}
	public static boolean isValid(int i,int j)
	{
		return i>=0 && i<r && j>=0 && j<c;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(r==0 && c==0)
				break;
			bomb = new boolean[r][c];
			int rows = Integer.parseInt(br.readLine().trim());
			while(rows-->0)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				st.nextToken();
				while(st.hasMoreTokens())
				{
					int y = Integer.parseInt(st.nextToken());
					bomb[x][y] = true;
				}
			}
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			targetX = Integer.parseInt(st.nextToken());
			targetY = Integer.parseInt(st.nextToken());
			int ans = bfs(x,y);
			out.append(ans+"\n");			
		}
		out.flush();
	}
}
