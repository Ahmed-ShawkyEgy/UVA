import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			st = new StringTokenizer(br.readLine());
			
			int pos = 0,neg = 0;
			for (int i = 0; i < n; i++)
			{
				int x = Integer.parseInt(st.nextToken());
				if(x==0)
					neg++;
				else
					pos++;
			}
			int ans = pos-neg;
			out.append("Case "+cases++ +": "+ans+"\n");
		}
		out.flush();
	}
}
