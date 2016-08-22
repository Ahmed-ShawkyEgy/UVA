import java.util.*;
import java.io.*;
public class Main {
	static int[][] arr;
	static int[][] mem;
	static final int oo = (int) 1e9;
	public static int dp(int ind,int w)
	{
		if(w<0)
			return -oo;
		if(ind == arr.length || w == 0)
				return 0;
		if(mem[ind][w]!=-1)
			return mem[ind][w];
		int take = arr[ind][0] + dp(ind+1,w-arr[ind][1]);
		int leave = dp(ind+1,w);
		return mem[ind][w] = Math.max(take,leave);
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		mem = new int[1001][31];
		while(t-->0)
		{
			for(int[] i : mem)
				Arrays.fill(i, -1);
			int n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			for(int i =0;i<n;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i][0] = a;
				arr[i][1] = b;
			}
			
			int ans = 0;
			int g = Integer.parseInt(br.readLine());
			for (int i = 0; i < g; i++) {
				int maxW = Integer.parseInt(br.readLine());
				ans+=dp(0,maxW);
			}
			System.out.println(ans);
		}
		
	}

}
