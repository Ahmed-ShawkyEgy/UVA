import java.io.*;
import java.util.*;

public class Main {
	static long mem [][];
	static int n,k;
	public static long dp(int i,int sum)
	{
		if(i>=k || sum>n)
		{
			return 0;
		}
		if(sum==n)
		{
			return 1;
		}
		if(mem[i][sum]!=-1)
		{
			return mem[i][sum];
		}
		return mem[i][sum] =(dp(i+1,sum) + dp(i,sum+1))%1000000;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(!(s = br.readLine()).equals("0 0"))
		{
			StringTokenizer st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			mem = new long[k+1][n+1];
			for(int i =0;i<k+1;i++)
			Arrays.fill(mem[i], -1);
			
			System.out.println(dp(0,0)%1000000);
		}
		
	}

}
