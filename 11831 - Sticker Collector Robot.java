import java.awt.Point;
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
	static char[][] adj;
	static char[] arr;
	static char[] orientation = {'N','L','S','O'};
	static int facing;
	static Point pos;
	
	public static boolean isValid(int x,int y)
	{
		return x>=0 && x<adj.length && y>=0 && y<adj[0].length && adj[x][y]!='#';
	}
	
	public static int sim()
	{
		int ans = 0;
		for (int i = 0; i < arr.length; i++) 
		{
			char curIns = arr[i];
			switch(curIns)
			{
			case 'D': facing = (facing+1)%4;break;
			case 'E': facing--;if(facing==-1)facing=3;break;
			default: move();
			}
			if(adj[pos.y][pos.x]=='*')
				ans++;
			adj[pos.y][pos.x] = '.';
		}
		return ans;
	}
	
	public static void move()
	{
		Point p = new Point(pos.x,pos.y);
		switch(orientation[facing])
		{
		case 'N': p.y--;break;
		case 'L': p.x++;break;
		case 'S': p.y++;break;
		case 'O': p.x--;break;
		}
		if(isValid(p.y, p.x))
			pos = p;
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
			int s = Integer.parseInt(st.nextToken());
			if(n==0 && m==0 && s==0)
				break;
			adj = new char[n][m];
			for (int i = 0; i < n; i++) 
			{
				adj[i] = br.readLine().toCharArray();
				for (int j = 0; j < adj[i].length; j++) {
					if(adj[i][j]!='.' && adj[i][j]!='*' && adj[i][j]!='#')
					{
						char c = adj[i][j];
						pos = new Point(j,i);
						for (int k = 0; k < orientation.length; k++) {
							if(orientation[k]==c)
								facing = k;
						}
					}
				}
			}
			arr = br.readLine().toCharArray();
			out.append(sim()+"\n");
		}
		out.flush();
	}
}
