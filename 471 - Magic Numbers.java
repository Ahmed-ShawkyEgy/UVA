import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main{
	public static boolean isValid(long n)
	{
		boolean[] taken = new boolean[10];
		while(n>0)
		{
			int x = (int) (n%10);
			if(taken[x])
				return false;
			taken[x] =true;
			n/=10;
		}
		return true;
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		boolean first = true;
		while(t-->0)
		{
			if(!first)
				out.append("\n");
			first = false;
			br.readLine();
			long n = Long.parseLong(br.readLine().trim());
			for (int i = 1; i < 1000000; i++) 
			{
				if(isValid(i))
				{
					long s2 =(long) n*i;
					if(isValid(s2))
					{
						out.append(s2+" / "+i+" = "+n+"\n");
					}
				}
			}
		}
		out.flush();
	}
	
}	
