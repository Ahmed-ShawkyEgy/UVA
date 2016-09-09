import java.io.*;
import java.util.*;
public class Main{
	public static boolean solve(int a,int b,String s)
	{
		char x = s.charAt(a);
		for (int i = a+1; i <= b; i++) 
		{
			if(s.charAt(i)!=x)
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		boolean first = true;
		while(br.ready())
		{
			String s = br.readLine();
			int q = Integer.parseInt(br.readLine());
			out.append("Case "+cases++ +":\n");
			while(q-->0)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				boolean ans = solve(Math.min(i, j), Math.max(i, j), s);
				if(ans)
					out.append("Yes\n");
				else
					out.append("No\n");
			}
		}
		out.flush();
	}
}
