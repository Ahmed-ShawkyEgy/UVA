import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				if(!st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				if(i==0)
				{
					if(j==0)
						arr[i][j] = x;
					else
						arr[i][j] = arr[i][j-1]+x;
				}
				else
				{
					if(j==0)
						arr[i][j] = arr[i-1][j]+x;
					else
					arr[i][j] = x + arr[i-1][j-1] + (arr[i][j-1] - arr[i-1][j-1]) + (arr[i-1][j] - arr[i-1][j-1]);
				}
				ans = Math.min(ans, arr[i][j]);
			}
		}
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++) 
				for (int i2 = i; i2 < arr.length; i2++) 
					for (int j2 = j; j2 < arr.length; j2++) 
					{
						if(i==i2 && j==j2)
						{
							ans = Math.max(ans, arr[i][j]);
							continue;
						}
						int cur = arr[i2][j2];	
						if(i>0)
							cur -= arr[i-1][j2];
						if(j>0)
							cur -= arr[i2][j-1];
						if(i>0 && j>0)
							cur += arr[i-1][j-1];
						ans = Math.max(ans, cur);
					}
				
			
		System.out.println(ans);
	}
}	
