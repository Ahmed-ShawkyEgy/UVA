import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int ans = Integer.MAX_VALUE;
			while(h-->0)
			{
				int price = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());
				int z = w;
				while(z-->0)
				{
					int x = Integer.parseInt(st.nextToken());
					if(x>=n)
					{
						if(n*price<=money)
						{
							ans = Math.min(ans, n*price);
						}
					}
				}
			}
				if(ans==Integer.MAX_VALUE)
					out.append("stay home\n");
				else
					out.append(ans+"\n");
		}
		out.flush();
	}
}
