import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,s;
	static long [][][] memo;
	public static long dp(int ind,int sec,int lst) // lst = 0 -> locked :: 1 -> not locked
	{
		if(sec<0)
			return 0;
		if(ind==n)
		{
			if(sec==0)
				return 1;
			else
				return 0;
		}
		if(memo[ind][sec][lst]!=-1)
			return memo[ind][sec][lst];
		long ans = 0;
		if(lst==0) // last is locked
		{
			ans += (long) dp(ind+1,sec-1,0);
			ans += (long) dp(ind+1,sec,1);
		}
		else // last is unlocked
		{
			ans += (long) dp(ind+1,sec,0);
			ans += (long) dp(ind+1,sec,1);
		}
		return memo[ind][sec][lst] = ans;
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n<0)
				break;
			s = Integer.parseInt(st.nextToken());
			memo = new long[n+1][s+1][2];
			for (int i = 0; i < memo.length; i++) {
				for (int j = 0; j < memo[i].length; j++) {
					Arrays.fill(memo[i][j], -1);
				}
			}
			out.append(dp(0,s,0)+"\n");
		}
		out.flush();
	}
}
