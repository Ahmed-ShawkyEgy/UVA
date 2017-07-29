import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[][] beep;
	static int[][][] memo;
	static int x,y;
	static int n,m;
	static int dist(int i,int j,int i1,int j1)
	{
		return Math.abs(i-i1) + Math.abs(j-j1);
	}
	public static int dp(int i,int j,int mask) // There exists a better solution
	{
		if(mask==(1<<beep.length)-1)
			return dist(i,j,x,y);
		if(memo[i][j][mask]!=-1)
			return memo[i][j][mask];
		int ans = (int) 1e9;
		
		for (int k = 0; k < beep.length; k++) 
			if((mask&(1<<k))==0)
				ans = Math.min(ans, dist(i,j,beep[k][0],beep[k][1]) + dp(beep[k][0],beep[k][1],mask | (1<<k))); 

		return memo[i][j][mask] = ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			
			int k = Integer.parseInt(br.readLine().trim());
			beep = new int[k][2];
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				beep[i][0] = Integer.parseInt(st.nextToken())-1;
				beep[i][1] = Integer.parseInt(st.nextToken())-1;
			}
			
			memo = new int[n][m][(1<<k) + 1];
			for (int i = 0; i < memo.length; i++) 
				for (int j = 0; j < memo[i].length; j++) 
					Arrays.fill(memo[i][j], -1);
			
			sb.append("The shortest path has length "+dp(x,y,0)+"\n");
		}
		System.out.print(sb);
	}
}
