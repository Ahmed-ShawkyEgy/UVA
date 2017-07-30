import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
	static int n;
	static int[][] memo;
	static int[] height,width;
	static int dp(int i,int lst)
	{
		if(i==n)
			return 0;
		if(memo[i][lst]!=-1)
			return memo[i][lst];
		int ans = dp(i+1,lst); // leave
		if(height[i]>height[lst])
			ans = Math.max(ans, width[i] + dp(i+1,i)); // take
		return memo[i][lst] = ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int cases = 1;
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			n = Integer.parseInt(br.readLine().trim()) + 1;
			height = new int[n]; height[0] = Integer.MIN_VALUE;
			width = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n; i++) 
				height[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n; i++) 
				width[i] = Integer.parseInt(st.nextToken());

			fill();
			int increasingScore = dp(1,0);
      
			for (int i = 0; i < height.length; i++)  // This step is for decreasing subsequence
				height[i] *=-1;
			
			fill();
			int decreasingScore = dp(1,0);
			
			sb.append("Case "+cases+++". ");
			if(increasingScore >= decreasingScore)
				sb.append("Increasing ("+increasingScore+"). Decreasing ("+decreasingScore+").\n");
			else
				sb.append("Decreasing ("+decreasingScore+"). Increasing ("+increasingScore+").\n");
		}
		System.out.print(sb);
	}
	static void fill()
	{
		memo = new int[n][n];
		for (int i = 0; i < memo.length; i++) 
			Arrays.fill(memo[i], -1);
		
	}
}
