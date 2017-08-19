import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n , arr[] , memo[];
	static int dp(int mask)
	{
		if(mask==(1<<n)-1)return 0;
		if(memo[mask]!=-1)return memo[mask];
		int ans = 0;
		for (int i = 0; i < n; i++) 
			for (int j = i+1; j < n; j++) 
				for (int k = j+1; k < n; k++) 
					if(		(mask&(1<<i))==0 
						&&	(mask&(1<<j))==0
						&& 	(mask&(1<<k))==0)
					{
						int val = arr[i] + arr[j] + arr[k] >= 20? 1:0;
						ans = Math.max(ans, val + dp((mask|(1<<i)|(1<<j)|(1<<k))));
					}
		return memo[mask] = ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(true)
		{
			n = Integer.parseInt(br.readLine().trim());
			if(n==0)break;
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			memo = new int[(1<<n)+1];
			Arrays.fill(memo, -1);
			sb.append("Case "+cases+++": "+dp(0)+"\n");
		}
		System.out.print(sb);
	}	
}
