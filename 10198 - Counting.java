import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
	static BigInteger memo[][];
	static BigInteger dummy = new BigInteger("-1");
	static int n;
	public static BigInteger dp(int sum,int ones)
	{
		if(sum==0)
			return BigInteger.ONE;
		if(!memo[sum][ones].equals(dummy))
			return memo[sum][ones];
		BigInteger ans = BigInteger.ZERO;
		if(sum-2>=0)
			ans = ans.add(dp(sum-2,ones));
		if(sum-3>=0)
			ans = ans.add(dp(sum-3,ones));
		if(sum-1>=0)
			ans = ans.add(dp(sum-1,ones+1).add(dp(sum-1,ones)));
		return memo[sum][ones] = ans;
	}	
	public static void main(String[] args) throws IOException
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		memo = new BigInteger[1001][1001];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], dummy);	
		}
		
		while(br.ready())
		{
			n = Integer.parseInt(br.readLine().trim());
			BigInteger ans = dp(n,0);
			out.append(ans.toString()+"\n");
		}
		out.flush();
	}
}
