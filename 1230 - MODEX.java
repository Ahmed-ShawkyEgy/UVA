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
			String a = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			BigInteger res = (new BigInteger(a)).modPow(new BigInteger(b+""), new BigInteger(c));
			out.append(res+"\n");
		}
		out.flush();
	}
}
