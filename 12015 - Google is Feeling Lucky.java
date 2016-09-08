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
			String [] site = new String[10];
			int[] rate = new int[10];
			int max = 0;
			for (int i = 0; i < rate.length; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				site[i] = st.nextToken();
				rate[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, rate[i]);
			}
			out.append("Case #"+cases++ +":\n");
			for (int i = 0; i < rate.length; i++) {
				if(rate[i] == max)
					out.append(site[i]+"\n");
			}
		}
		out.flush();
	}
}
