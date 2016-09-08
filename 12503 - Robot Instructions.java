import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int p = 0;
			for (int i = 0; i < n; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				if(s.charAt(0)=='R')
				{
					arr[i] = 1;
					p++;
				}
				else
				{
					if(s.charAt(0)=='L')
					{
						arr[i] = -1;
						p--;
					}
					else
					{
						st.nextToken();
						int x = Integer.parseInt(st.nextToken());
						p+=arr[x-1];
						arr[i] = arr[x-1];
					}	
				}
			}
			out.append(p+"\n");
		}
		out.flush();
	}
}
