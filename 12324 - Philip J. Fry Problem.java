import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n , arr[][] , memo[][];
	static int dp(int ind,int num)
	{
		num = Math.min(num, 100);
		if(ind==n)return 0;
		if(memo[ind][num]!=-1)return memo[ind][num];
		int ans = arr[ind][0] + dp(ind+1,num+arr[ind][1]);
		if(num>0) ans = Math.min(ans, (arr[ind][0]>>1) + dp(ind+1,num+arr[ind][1]-1));
		return memo[ind][num] = ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			n = Integer.parseInt(br.readLine().trim());
			if(n==0)break;
			arr = new int[n][2];
			for (int i = 0; i < n; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			memo = new int[n][101];
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			sb.append(dp(0,0)+"\n");
		}
		System.out.print(sb);
	}	
}
