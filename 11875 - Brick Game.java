import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for(int cases = 1; cases<=t;cases++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int ans = arr[n/2];
			out.append("Case "+cases+": "+ans+"\n");
		}
		out.flush();
	}
}
