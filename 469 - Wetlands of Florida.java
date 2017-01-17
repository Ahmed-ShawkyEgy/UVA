import java.io.*;
import java.util.*;

public class Main{
	static char[][] arr;
	static int[] xx = {1,1,1,0,0,-1,-1,-1};
	static int[] yy = {1,0,-1,1,-1,1,0,-1};
	static boolean[][] visited;
	public static int floodFill(int x,int y)
	{
		if(!isValid(x, y))
			return 0;
		visited[x][y] = true;
		int ans = 1;
		for (int i = 0; i < xx.length; i++) 
		{
			int ii = x + xx[i];
			int jj = y + yy[i];
			if(isValid(ii, jj) && !visited[ii][jj])
			{
				ans += floodFill(ii,jj);
			}
		}
		return ans;
	}
	public static boolean isValid(int i,int j)
	{
		return i<arr.length && i>= 0 && j<arr[0].length && j>=0 && arr[i][j]=='W';
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		while(t-->0)
		{
			if(!first)
			{
				out.append("\n");
			}
			else
				br.readLine();
			first = false;	
			String s;
			ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
			while((s=br.readLine()).charAt(0)=='W' || s.charAt(0)=='L')
			{
				ArrayList<Character> x = new ArrayList<Character>();
				for (int i = 0; i < s.length(); i++) 
				{
					x.add(s.charAt(i));
				}
				list.add(x);
			}
			arr = new char[list.size()][list.get(0).size()];
			for (int i = 0; i < arr.length; i++) 
			{
				for (int j = 0; j < arr[i].length; j++) 
				{
					arr[i][j] = list.get(i).get(j);
				}
			}
			while(s!=null && !s.equals(""))
			{
				StringTokenizer st = new StringTokenizer(s);
				int x = Integer.parseInt(st.nextToken())-1,y = Integer.parseInt(st.nextToken())-1;
				s =br.readLine();
				visited = new boolean[arr.length][arr[0].length];
				int ans = floodFill(x, y);
				out.append(ans+"\n");
			}
		}
		out.flush();		
	}
}
