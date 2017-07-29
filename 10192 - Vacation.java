import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] memo;
	static char[] arr1,arr2;
	static int dp(int i,int j)
	{
		if(i==arr1.length || j==arr2.length)
			return 0;
		if(memo[i][j]!=-1)
			return memo[i][j];
      
      
		int ans = dp(i,j+1);
		ans = Math.max(ans, dp(i+1,j));
		if(arr1[i]==arr2[j])
			ans = Math.max(ans, 1 + dp(i+1,j+1));
      
		return memo[i][j] = ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(true)
		{
			String s = br.readLine();
			if(s.equals("#"))
				break;
			arr1 = s.toCharArray();
			arr2 = br.readLine().toCharArray();
			memo = new int[arr1.length][arr2.length];
      
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			
			sb.append("Case #"+cases+++": you can visit at most "+dp(0,0)+" cities.\n");
		}
		System.out.print(sb);
	}
}
