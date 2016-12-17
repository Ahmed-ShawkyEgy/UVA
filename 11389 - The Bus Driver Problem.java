import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(n==0 && d==0 && r==0)
				break;
			int[] day = new int[n],night = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) 
			{
				day[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) 
			{
				night[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(day);
			Arrays.sort(night);
			long ans = 0;
			for (int i = 0; i < n; i++) 
			{
				long total = day[i]+night[n-1-i];
				if(total>d)
				{
					ans += r*(total-d);
				}
			}
			out.append(ans+"\n");
		}
		out.flush();
	}
}	
