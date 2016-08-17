import java.io.*;
import java.util.*;

public class Main {
	static int[][] mem;
	static int[][] arr;
	static int n,m;
	static final int oo= (int)-1e5;
	public static int dp(int ind,int sum)
	{
		if(sum>(m+200))return oo;
		if(ind==n)
		{
			if(sum>2000)sum-=200;
			if(sum>m)return oo;
			return 0;
		}
		if(mem[ind][sum]!=-1)
			return mem[ind][sum];
		return mem[ind][sum] = Math.max(arr[ind][1]+dp(ind+1,sum+arr[ind][0]), dp(ind+1,sum));
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mem = new int[100][4000*100];
		while(br.ready())
		{
			for(int i=0;i<100;i++)
				Arrays.fill(mem[i], -1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n][2];
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			System.out.println(dp(0,0));
		}
		
	}
}
