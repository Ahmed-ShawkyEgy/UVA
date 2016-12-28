import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);	
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{		
			int n = Integer.parseInt(br.readLine())-1;
			int max = Integer.parseInt(br.readLine());
			int ans = 0;
			boolean flag = false;
			while(n-->0)
			{
				int cur = Integer.parseInt(br.readLine());
				if(max-cur>=ans)
				{
					flag = true;
					ans = max-cur;
				}
				max = Math.max(max, cur);
			}
			if(!flag)
				out.append(-1+"\n");
			else
				out.append(ans+"\n");
		}
		out.flush();
	}
	
}	
