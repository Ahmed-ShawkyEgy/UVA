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
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ans = 0;
			for (int i = 0; i < arr.length; i++) 
			{
				int x = Integer.parseInt(st.nextToken());
				arr[i] = x;
				for (int j = 0; j < i; j++) 
				{
					if(arr[j] <= x)
						ans++;
				}
			}
			out.append(ans+"\n");
		}
		out.flush();
	}
	
}	
