import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
			{
				break;
			}
			BigInteger sum = BigInteger.ZERO;
			for (int i = 0; i < n; i++) 
			{
				BigInteger x = new BigInteger(br.readLine());
				sum = sum.add(x);
			}
			BigInteger res = sum.divide(new BigInteger(m+""));
			out.append("Bill #"+cases+++" costs "+sum.toString()+": each friend should pay "+res.toString()+"\n\n");
		}
		out.flush();
	}
}
