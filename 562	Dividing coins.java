import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	static int[][] memo;
	static int total;
	
	public static int dp(int sum,int ind)
	{
		if(ind==arr.length)
		{
			int sum2 = total - sum;
			return Math.abs(sum2-sum);
		}
		if(memo[sum][ind]!=-1)
		{
			return memo[sum][ind];
		}
		int take = dp(sum+arr[ind],ind+1);
		int leave = dp(sum,ind+1);
		return memo[sum][ind] = Math.min(take, leave);
	}	
	public static void main(String[] args) throws Throwable{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		memo = new int[500*100][100];
		while(t-->0)
		{
			for(int[]i:memo)
				Arrays.fill(i,-1);
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			total = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				total += arr[i];
			}
			out.append((dp(0,0)+"\n"));
		}
		out.flush();
	}

}
