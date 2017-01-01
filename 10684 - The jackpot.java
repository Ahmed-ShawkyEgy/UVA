import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(br.ready())
		{
			if(!st.hasMoreTokens())
			{
				String s ;
				while((s=br.readLine()).equals(""));
				st = new StringTokenizer(s);
			}
			int n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			int ans = 0;
			int cur = 0;
			for (int i = 0; i < n; i++) 
			{
				if(!st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				cur+= x;
				ans = Math.max(ans, cur);
				if(cur<0)
					cur = 0;
			}
			if(ans>0)
				out.append("The maximum winning streak is "+ans+".\n");
			else
				out.append("Losing streak.\n");
			
		}
		out.flush();
	}
	
}	
