import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);	
		int cases = 1;
		while(true)
		{
			int n = Integer.parseInt(br.readLine());	
			if(n<0)
				break;
			int[] arr = new int[12];
			int[] req = new int[12];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i <12; i++) 
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++)
			{
				req[i] = Integer.parseInt(st.nextToken());
			}
			int cur = n;
			out.append("Case "+cases++ +":\n");
			for (int i = 0; i < 12; i++)
			{
				if(cur<req[i])
				{
					out.append("No problem. :(\n");
				}
				else
				{
					cur-=req[i];
					out.append("No problem! :D\n");
				}
				cur+=arr[i];
			}
		}		
		out.flush();
	}
}
