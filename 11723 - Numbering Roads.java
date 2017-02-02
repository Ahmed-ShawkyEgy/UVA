import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(n==0 && r==0)
				break;
			int pos = r;
			int ans = 0;
			for (int i = 0; i < 26 && pos < n; i++) 
			{
				ans++;
				pos += r;
			}
			out.append("Case "+cases+++": ");
			if(pos<n)
				out.append("impossible\n");
			else
				out.append(ans+"\n");
		}
		out.flush();
	}
}
