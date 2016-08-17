import java.io.*;
import java.util.*;

public class Main {
	static int[] arr = {1,5,10,25,50};
	static long[][] mem;
	static int n;
	static final int oo= (int)-1e5;
	public static long dp(int ind,int sum)
	{
		if(sum==0)return 1;
		if(ind==5 || sum < 0)
		{
			return 0;
		}
		if(mem[ind][sum]!=-1)
			return mem[ind][sum];
		long ans = 0;
		ans+= dp(ind,sum-arr[ind]);
		ans+= dp(ind+1,sum);
		return mem[ind][sum] = ans;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		mem = new long[5][1<<20];
		for(int i = 0 ; i<mem.length;i++)
		{
			for(int j = 0; j<mem[i].length;j++)
				mem[i][j] = -1;
		}
		for (int i = 1000; i < 30000; i+=1000) {
			dp(0,i);
		}
		while(br.ready())
		{
			n = Integer.parseInt(br.readLine());
			long ans = dp(0,n);
			if(ans>1)
				out.append("There are "+ans+" ways to produce "+n+" cents change.\n");
			else
				out.append("There is only 1 way to produce "+n+" cents change.\n");
		}
		out.flush();
	}
}
