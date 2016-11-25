import java.io.*;
import java.util.*;

public class Main {
	static int[][] memo;
	static int[] arr;
	static int[] origin;
	static HashMap<Integer, Integer> map;
	public static int dp(int last,int i)
	{
		if(i==arr.length)
			return 0;
		if(memo[last][i]!=-1)
			return memo[last][i];
		int ans = 0;
		if(map.get(arr[i])>=map.get(arr[last]))
		{
			ans = Math.max(ans, 1+dp(i,i+1));
		}
		ans = Math.max(ans, dp(last,i+1));
		return memo[last][i] = ans;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new HashMap<Integer, Integer>();
		origin = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		map.put(0, 0);
		for (int i = 1; i <= n; i++) 
		{
			int x = Integer.parseInt(st.nextToken());
			origin[x] = i;
			map.put(i, x);
		}
		while(br.ready())
		{
			arr = new int[n+1];
			st = new StringTokenizer(br.readLine());
			memo = new int[22][22];
			for (int i = 0; i < memo.length; i++) 
			{
				for (int j = 0; j < memo[i].length; j++) 
				{
					memo[i][j] = -1;
				}
			}
			for (int i = 1; i < arr.length; i++) 
			{
				arr[Integer.parseInt(st.nextToken())] = i;
			}
			int ans = dp(0,1);
			System.out.println(ans);
		}
	}
}
