import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static double[][] memo;
	static int[][] pos;
	static int[][] res;
	
	static double dist(int i,int j)
	{
		int x = pos[i][0]-pos[j][0];
		int y = pos[i][1]-pos[j][1];
		x*=x;
		y*=y;
		return Math.sqrt(x+y);
	}
	static double dp(int i,int mask)
	{
		if(mask==(1<<pos.length)-1)
			return 0;
		if(memo[i][mask]!=-1)
			return memo[i][mask];
		
		double ans = (int)1e9;
		for(int j = 0;j<pos.length;j++)
			if((mask&(1<<j))==0)
				ans = Math.min(ans, dist(i,j) + 16 + dp(j,mask|(1<<j)));
		
		return memo[i][mask] = ans;
	}
	static void print(int i,int mask,int ind)
	{
		if(mask==(1<<pos.length)-1)
			return ;
		double ans = dp(i,mask);
		
		for(int j = 0;j<pos.length;j++)
			if((mask&(1<<j))==0)
			{
				double cur = dist(i,j) + 16 + dp(j,mask|(1<<j));
				if(ans==cur)
				{
					res[ind][0] = i;
					res[ind][1] = j;
					print(j,mask|(1<<j),ind+1);
					return;
				}
			}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = 1;
		StringBuilder sb = new StringBuilder();
		DecimalFormat f = new DecimalFormat("0.00");
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			pos = new int[n][2];
			for (int i = 0; i < pos.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			memo = new double[n][(1<<n)+1];
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			
			int start = 0;
			double ans = Integer.MAX_VALUE;
			for(int i = 0;i<n;i++)
			{
				double cur = dp(i,1<<i);
				if(cur<ans)
				{
					start = i;
					ans = cur;
				}
			}
			
			sb.append("**********************************************************\n");
			sb.append("Network #"+cases+++"\n");
			
			res = new int[n-1][2];
			print(start,(1<<start),0);
			
			for (int i = 0; i < res.length; i++) {
				int ind = res[i][0];
				int nxt = res[i][1];
				sb.append("Cable requirement to connect ("+pos[ind][0]+","+pos[ind][1]+") to ("+pos[nxt][0]+","+pos[nxt][1]+") is "+f.format(16+dist(ind,nxt))+" feet.\n");
			}
			sb.append("Number of feet of cable required is "+f.format(ans)+".\n");
			
		}
		System.out.print(sb);
	}
}
