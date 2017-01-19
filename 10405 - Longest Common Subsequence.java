import java.io.*;
import java.util.*;

public class Main {
	static String a,b;
	static int memo[][];
	public static int dp(int i,int j)
	{
		if(i>=a.length() || j>=b.length())
			return 0;
		if(memo[i][j]!=-1)
			return memo[i][j];
		int k;
		for(k = j;k<b.length();k++)
		{
			if(b.charAt(k)==a.charAt(i))
				break;
		}
		int take = (k!=b.length()?1:0)+dp(i+1,k+1),leave = dp(i+1,j);		
		return memo[i][j] = Math.max(take, leave);
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			a = br.readLine();
			b = br.readLine();
			memo = new int[a.length()][b.length()];
			for (int i = 0; i < memo.length; i++) 
			{
				Arrays.fill(memo[i], -1);
			}
			out.append(dp(0,0)+"\n");
		}
		out.flush();
	}
}
