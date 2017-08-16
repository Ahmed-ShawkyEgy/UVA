import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main
{
	static int n,m,mod = 1000000007;
	static int[][][] memo;
	static int dp(int ind,int cur,int mask)
	{
		if(cur<0 || cur>n || mask>1<<n) return 0;
		int status = mask==(1<<n)-1?1:0;
		if(ind<=0)return status;
		if(memo[ind][cur][mask]!=-1) return memo[ind][cur][mask];
		
		int ans = status + (dp(ind-1,cur+1,mask|(1<<(cur+1)))%mod) 
				+ ( (cur-1>=0)?(dp(ind-1,cur-1,mask|1<<(cur-1))%mod):0 );
				
		return memo[ind][cur][mask] = ans % mod;
	}
    public static void main(String[]args) throws IOException 
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine().trim());
    	while(t-->0)
    	{
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());
    		memo = new int[m+1][n+1][1+(1<<n)];
        	for (int i = 0; i < memo.length; i++)
        		for (int j = 0; j < memo[i].length; j++) 
    			Arrays.fill(memo[i][j], -1);
        	long ans = 0;
        	for (int i = 1; i < n; i++)
				ans += 1l * dp(m-1,i,1<<i)%mod;
			System.out.println(ans%mod);
    	}
    }
}

