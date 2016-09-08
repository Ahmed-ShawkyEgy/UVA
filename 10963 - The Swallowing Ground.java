import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		boolean first = true;
		while(t-->0)
		{
			br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ans = Math.abs(a-b);
			boolean found = true;
			while(n-->1)
			{
				st = new StringTokenizer(br.readLine());
				int aa = Integer.parseInt(st.nextToken());
				int bb = Integer.parseInt(st.nextToken());
				if(Math.abs(aa-bb)!=ans)
					found = false;
			}
			if(!first)
				out.append("\n");
			first = false;
			if(found)
				out.append("yes\n");
			else
				out.append("no\n");
				
		}
		out.flush();
	}
}
