import java.util.*;
import java.io.*;


public class Main{
	static int[] taken;
	static int[] arr;
	static int ans;
	static PrintWriter out = new PrintWriter(System.out);
	public static void backTrack(int c)
	{
		if(c==8)
		{
			ans = Math.min(ans, getMoves());
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
	public static int getMoves()
	{
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			if(taken[i] != arr[i])
				x++;
		}
		return x;
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
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		int cases = 1;
		boolean first = true;
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 10;
			arr = new int[8];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken())-1;
			}
			out.append("Case "+cases+++": ");
			taken = new int[8];
			backTrack(0);
			out.append(ans+"\n");
		}
		out.flush();
    } 
	
}
