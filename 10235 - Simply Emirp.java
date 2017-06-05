import java.io.BufferedReader;
import java.io.FileReader;
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
		while(br.ready())
		{
			String num = br.readLine();
			StringBuilder s = new StringBuilder(num);
			BigInteger n = new BigInteger(num);
			if(!n.isProbablePrime(10))
			{
				out.append(n.toString()+" is not prime.\n");
				continue;
			}
			n = new BigInteger(s.reverse().toString());
			if(num.equals(s.toString()) || !n.isProbablePrime(10))
			{
				out.append(num+" is prime.\n");
			}
			else
			{
				out.append(num+" is emirp.\n");
			}
		}
		out.flush();
	}
}
