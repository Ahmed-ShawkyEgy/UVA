import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			int n = Integer.parseInt(br.readLine().trim());
			if(n<0)
				break;
			int ans = 0;
			for(int p = 1;p*p<=n+100;p++)
			{
				int cur = n;
				boolean flag = true;
				for (int i = 0; i < p; i++) 
				{
					if(cur%p!=1)
					{
						flag = false;
						break;
					}
					cur -= (cur)/p;
					cur--;
				}
				if(flag && cur%p==0)
					ans = p;
			}
			out.append(n+" coconuts,");
			if(ans==0)
				out.append(" no solution\n");
			else
				out.append(" "+ans+" people and 1 monkey\n");
		}
		out.flush();
		
	}
}
