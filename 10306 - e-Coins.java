import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	static int[][] arr;
	static int[][] memo;
	static int target;
	static final int oo = (int)1e9;
	static final double eps = 1e-7;
	public static int dp(int a,int b)
	{
		double cur = f(a,b);
		if(Math.abs(cur-target) <=eps)
			return 0;
		if(cur>target)
			return oo;
		if(memo[a][b]!=-1)
			return memo[a][b];
		int ans = oo;
		for(int i = 0;i<arr.length;i++)
			ans = Math.min(ans,1 + dp(arr[i][0] + a,arr[i][1] + b));
		return memo[a][b] = ans;
	}
	public static double f(int a,int b)
	{
		return Math.sqrt( 1l * a * a + 1l * b * b) ; 
	}
	public static void main (String args[]) throws IOException 
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		int bound = 1000;
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			String s;
			while((s=br.readLine()).isEmpty());
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			memo = new int[bound][bound];
			arr = new int[n][2];
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);

			for (int i = 0; i < arr.length; i++) 
			{
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			int ans = dp(0,0);
			if(ans>=oo)
				sb.append("not possible\n");
			else
				sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
}
