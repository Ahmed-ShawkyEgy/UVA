import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static String s;
	static long[][] memo;
	static final long max =  Integer.MAX_VALUE, oo = (long) 1e12;
	static long dp(int lo,int hi)
	{
		long cur = Long.parseLong(s.substring(lo, hi));
		if(cur>max)
			return -oo;
		if(hi==s.length())
			return cur;
		if(memo[lo][hi]!=-1)
			return memo[lo][hi];
		long leave = dp(lo,hi+1);
		long take = 1l * cur + dp(hi,hi+1);
		return memo[lo][hi] = Math.max(take, leave);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			s = br.readLine().trim();
			memo = new long[s.length()][s.length()];
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			System.out.println(dp(0,1));
		}
	}
}
