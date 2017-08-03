import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static int[][] arr;
	static int[][] memo;
	static int dp(int i,int j)
	{
		if(memo[i][j]!=-1)
			return memo[i][j];
		int ans = arr[i][j];
		for(int x = 1;x<=k;x++)
		{
			if(i+x<n && arr[i+x][j] > arr[i][j])
				ans = Math.max(ans, arr[i][j] + dp(i+x,j));
			if(i-x>=0 && arr[i-x][j] > arr[i][j])
				ans = Math.max(ans, arr[i][j] + dp(i-x,j));
		}
		for(int x = 1;x<=k;x++)
		{	
			if(j+x<n && arr[i][j+x] > arr[i][j])
				ans = Math.max(ans, arr[i][j] + dp(i,j+x));
			if(j-x>=0 && arr[i][j-x] > arr[i][j])
				ans = Math.max(ans, arr[i][j] + dp(i,j-x));
		}
		
		return memo[i][j] = ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while(t-->0)
		{
			br.readLine();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) 
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			memo = new int[n][n];
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			
			if(!first)
				sb.append("\n");
			first = false;
			sb.append(dp(0,0)+"\n");
		}
		System.out.print(sb);
		
	}
}
