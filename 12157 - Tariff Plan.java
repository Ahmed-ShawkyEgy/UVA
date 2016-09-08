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
			int mile = 0,juc = 0;
			while(n-->0)
			{
				int x = Integer.parseInt(st.nextToken());
				mile += ((x/30)+1) *10;
				juc += ((x/60)+1) *15;
			}
			out.append("Case "+cases++ +": ");
			if(mile<juc)
				out.append("Mile "+mile+"\n");
			else
			{
				if(juc<mile)
					out.append("Juice "+juc+"\n");
				else
					out.append("Mile Juice "+juc+"\n");
			}
		}
		out.flush();
	}
}
