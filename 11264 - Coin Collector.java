import java.io.*;
import java.util.*;
public class Main{
	static int[] arr;
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) 
			{
				arr[i]=Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			long cur = 0;
			for (int i = 0; i < n; i++) 
			{
				if(cur<arr[i])
				{
					ans++;
					cur+=arr[i];
				}
				else
				{
					cur-=arr[i-1];
					cur+=arr[i];
				}
			}
			out.append(ans+"\n");
		}
		out.flush();
	}
}	
