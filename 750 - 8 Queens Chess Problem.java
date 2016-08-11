import java.util.*;
import java.io.*;


public class Main{
	static int[] taken;
	static int row;
	static int col;
	static int num;
	static PrintWriter out = new PrintWriter(System.out);
	public static void backTrack(int c)
	{
		if(c==8)
		{
			if(taken[col]==row)
				print();
		}
		else
		{
			for(int i =0;i<8;i++)
			{
				if(isValid(i, c))
				{
					taken[c] = i;
					backTrack(c+1);
				}
			}
		}
	}
	public static boolean isValid(int r,int c)
	{
		for(int i =0;i<c;i++)
		{
			if(r==taken[i] || Math.abs(c-i)==Math.abs(r-taken[i]))
				return false;
		}
		return true;
	}
	public static void print()
	{
		if(num/10>0)
			out.append(""+num++);
		else
			out.append(" "+num++);
		out.append("      "+(taken[0]+1));
		for (int i = 1; i < 8; i++) {
			out.append(" "+(taken[i]+1));
		}		
		out.append("\n");
	}
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int t = Integer.parseInt(br.readLine());
		boolean first = true;
		while(t-->0)
		{
			br.readLine();
			if(first)first = false;
			else
				out.append("\n");
			out.append("SOLN       COLUMN\n");
			out.append(" #      1 2 3 4 5 6 7 8\n\n");
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken())-1;
			col = Integer.parseInt(st.nextToken())-1;
			taken = new int[8];
			num = 1;
			backTrack(0);
			
		}
		out.flush();
    } 
	
}
