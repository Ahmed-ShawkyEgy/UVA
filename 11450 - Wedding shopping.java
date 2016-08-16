import java.io.*;
import java.util.*;
public class Main {
	static int m;
	static int[][] arr;
	static int[][] mem;
	public static int dp(int i,int sum)
	{
		if(sum>m)return -1;
		if(i==arr.length)return sum;
		if(mem[i][sum]!=-1)return mem[i][sum];
		int ans = -1;
		for(int j : arr[i])
			ans = Math.max(ans, dp(i+1,sum+j));
		return mem[i][sum] = ans;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		mem = new int[21][300];
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			arr= new int[g][];
			for(int i =0;i<g;i++)
			{
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				arr[i] = new int[k];
				for(int j = 0;j<k;j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int i =0;i<mem.length;i++)
				Arrays.fill(mem[i], -1);
			int[][] aa = arr;
			int ans = dp(0,0);
			out.append((ans==-1)? "no solution\n":ans+"\n");
		}
		out.flush();
	}

}
