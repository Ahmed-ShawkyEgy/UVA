import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main{
	static int[][] arr;
	static int[][] memo;
	static int w;
	static PrintWriter out = new PrintWriter(System.out);
	static StringBuilder sb;
	static final int oo = (int) 1e8;
	public static int dp(int i,int t)
	{
		if(t<0)
			return -oo;
		if(t==0 || i>=arr.length)
			return 0;
		if(memo[i][t]!=-1)
			return memo[i][t];
		if(i==arr.length-1)
		{
			int x = 2;
			x++;
		}
		int take = arr[i][1] + dp(i+1,t-((w*arr[i][0])+(2*w*arr[i][0])));
		int leave =  dp(i+1,t);
		return memo[i][t] = Math.max(take, leave);
	}
	public static int print(int i,int t)
	{
		if(t==0 || i>=arr.length || t<0)
			return 0;
		int take = arr[i][1] + dp(i+1,t-(w*arr[i][0]+2*w*arr[i][0]));
		int leave =  dp(i+1,t);
		if(memo[i][t] == take)
		{
			sb.append(arr[i][0]+" "+arr[i][1]+"\n");
			return 1 + print(i+1,t-(w*arr[i][0]+2*w*arr[i][0]));
		}
		else
		{
			return print(i+1,t);
		}
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean first = true;
		while(br.ready())
		{
			if(!first)
			{
				String s = br.readLine();	
				out.append("\n");
			}
			first = false;	
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int t = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			for (int i = 0; i < arr.length; i++) 
			{
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			memo = new int[n][t+1];
			for (int i = 0; i < memo.length; i++) {
				Arrays.fill(memo[i], -1);
			}
			int value = dp(0,t);
			sb = new StringBuilder();
			int count = print(0,t);
			out.append(value+"\n"+count+"\n");
			out.append(sb);
		}
		out.flush();
	}
	
}	
