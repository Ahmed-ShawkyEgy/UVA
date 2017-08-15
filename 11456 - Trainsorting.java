import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n , arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			String s;
			while((s=br.readLine()).isEmpty());
			n = Integer.parseInt(s.trim());
			arr = new int[n];
			for (int i = 0; i < arr.length; i++) 
			{
				while((s=br.readLine()).isEmpty());
				arr[i] = Integer.parseInt(s.trim());
			}
			int[] LIS = new int[n] , LDS = new int[n];
			dp(LIS);
			for (int i = 0; i < n; i++) 
				arr[i] *= -1;
			dp(LDS);
			int ans = 0;
			for (int i = 0; i < n; i++) 
				ans = Math.max(ans, LIS[i] + LDS[i] - 1);
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
	static void dp(int[] memo)	
	{
		Arrays.fill(memo, 1);
		for (int i = n-1; i >= 0; i--) 
		{
			int max = 0;
			for (int j = i+1; j < n; j++) 
				if(arr[j] > arr[i])
					max = Math.max(max, memo[j]);
			memo[i] += max;
		}
	}	
}
