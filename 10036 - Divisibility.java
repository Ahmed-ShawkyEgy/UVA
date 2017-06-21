import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static boolean [][][] memo;
	static boolean [][][] vis;
	static int[] arr;
	public static boolean dp(int ind,int cur,int sign)
	{
		if(ind == n)
		{
			if(Math.abs(cur)%k==0)
				return true;
			else
				return false;
		}
		if(cur>=0)
		{
			cur %= k;
		}
		else
		{
			cur = -(Math.abs(cur)%k);
		}
		if(cur<0)
		{
			cur = -cur;
			sign = 0;
		}
		if(vis[ind][cur][sign])
			return memo[ind][cur][sign];
		boolean add ;
		boolean sub ;
		if(sign==0)
		{
			add = dp(ind+1,cur+arr[ind],sign);
			sub = dp(ind+1,cur-arr[ind],sign);
		}
		else
		{
			add = dp(ind+1,-cur+arr[ind],sign);
			sub = dp(ind+1,-cur+arr[ind],sign);
		}
		vis[ind][cur][sign] = true;
		return memo[ind][cur][sign] = add || sub;
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			memo = new boolean[n][101][2];
			vis = new boolean [n][101][2];
			boolean ans = dp(1,arr[0],arr[0]>=0?0:1);
			if(ans)
			{
				out.append("Divisible\n");
			}
			else
			{
				out.append("Not divisible\n");
			}
		}
		out.flush();
	}
}
