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
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger a = new BigInteger(st.nextToken());
			st.nextToken();
			BigInteger b = new BigInteger(st.nextToken());
			BigInteger g = a.gcd(b);
			out.append(a.divide(g).toString()+" / "+b.divide(g)+"\n");
		}
		out.flush();
	}
}
