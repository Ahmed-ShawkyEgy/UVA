import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k==0)
				break;
			int m = Integer.parseInt(st.nextToken());
			HashSet<String> set = new HashSet<String>();
			for (int i = 0; i < k; i++) {
				if(!st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				set.add(st.nextToken());
			}
			boolean pass = true;
			for (int i = 0; i < m; i++) 
			{
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int req = Integer.parseInt(st.nextToken());
				int count = 0;
				while(n-->0)
				{
					if(set.contains(st.nextToken()))
					{
						count++;
					}
				}
				if(count<req)
					pass = false;
			}
			if(pass)
				out.append("yes\n");
			else 
				out.append("no\n");
		}
		out.flush();
	}
}
