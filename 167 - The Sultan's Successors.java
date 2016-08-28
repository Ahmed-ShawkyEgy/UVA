import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class Main {
	static int[][] grid;
	static int ans;
	static int[] taken;
	public static void backTrack(int col,int sum)
	{
		if(col == 8)
		{
			ans = Math.max(ans, sum);
			return;			
		}
		for(int i = 0;i < 8; i++)
		{
			if(isVal(col, i))
			{
				taken[col] = i;
				backTrack(col+1, sum+grid[i][col]);
			}
		}
	}
	public static boolean isVal(int c, int r)
	{
		for (int i = 0; i < c; i++) {
			int x = taken[i];
			if( r == x || Math.abs(r-x) == Math.abs(c-i) )
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt((new StringTokenizer(br.readLine())).nextToken());
		while(t-->0)
		{
			grid = new int[8][8];
			for (int i = 0; i < grid.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			ans = 0;
			taken = new int[8];
			backTrack(0, 0);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 5-(ans+"").length(); i++) {
				sb.append(" ");
			}
			sb.append(ans);
			out.append(sb+"\n");
		}
		out.flush();
    }
}
