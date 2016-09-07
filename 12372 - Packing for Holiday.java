import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		int cases = 1;
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			if(a<=20 && b<=20 && c<=20)
			{
				out.append("Case "+cases++ + ": "+"good\n");
			}
			else
				out.append("Case "+cases++ + ": "+"bad\n");
		}
		out.flush();
	}
}
