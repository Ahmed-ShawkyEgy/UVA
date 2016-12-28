import java.io.*;
import java.util.*;
public class Main{
	static int[] arr;
	static int[][] memo;
	public static int dp(int left,int right)
	{
		if(arr.length==0)
			return 0;
		if(arr[0]>right)
			return 0;
		if(memo[left][right]!=-1)
			return memo[left][right];
		int ans = Integer.MAX_VALUE;
		boolean found = false;
		for (int i = 0; i < arr.length; i++) 
		{
			int x = arr[i];
			if(x>left && x<right)
			{
				found = true;
				int fine = right-left;	
				int cutLeft = dp(x,right);
				int cutRight =  dp(left,x);
				ans = Math.min(ans, fine + cutLeft + cutRight);
			}
		}
		if(!found)ans = 0;
		return memo[left][right] = ans;
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			int l = Integer.parseInt(br.readLine());
			if(l==0)
				break;
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) 
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			memo = new int[l+2][l+2];
			for (int i = 0; i < memo.length; i++) 
			{
				Arrays.fill(memo[i], -1);
			}
			int ans = dp(0,l);
			out.append("The minimum cutting is "+ans+".\n");
		}
		out.flush();
	}
}	
