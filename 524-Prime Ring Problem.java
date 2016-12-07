import java.io.*;
import java.util.StringTokenizer;


public class Main{
	static boolean[] isPrime;
	static int n;
	static PrintWriter out;
	public static void bt(int ind,int last,int mask,StringBuilder sb)
	{
		if(ind == n)
		{
			if(isPrime[last+1])
			{
				out.append(1+" "+sb.substring(1)+"\n");
			}
			return;
		}
		for (int i = 1; i <= n; i++) 
		{
			if( ((1<<i)&mask)==0 )
			{
				if(isPrime[i+last])
				{
					StringBuilder ex = new StringBuilder(sb+" "+i);
					bt(ind+1,i, (mask|(1<<i)), ex);
				}
			}
		}
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		isPrime = new boolean[100];
		populate();
		out = new PrintWriter(System.out);
		int cases = 1;
		while(br.ready())
		{
			n = Integer.parseInt(br.readLine());
			if(cases!=1)
				out.append("\n");
			out.append("Case "+cases++ + ":\n");
			bt(1,1,1<<1,new StringBuilder());
			
		}
		out.flush();
	}
	public static void populate()
	{
		for (int i = 0; i < isPrime.length; i++) 
		{
			isPrime[i] = true;
			for (int j = 2; j*j <= i; j++) 
			{
				if(i%j==0)
				{
					isPrime[i] = false;
					break;
				}
			}
		}
	}

}
