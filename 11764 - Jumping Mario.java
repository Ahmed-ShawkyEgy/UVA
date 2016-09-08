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
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int last = Integer.parseInt(st.nextToken());
			int big =0,small = 0;
			while(n-->1)
			{
				int x = Integer.parseInt(st.nextToken());
				if(x>last)
					big++;
				if(x<last)
					small++;
				last = x;
			}
			out.append("Case "+cases++ +": "+big+" "+small+"\n");
		}
		out.flush();
	}
}
