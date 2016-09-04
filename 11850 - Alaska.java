import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);	
		while(true)
		{
			int n = Integer.parseInt(br.readLine());	
			if(n==0)
				break;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			int last = 0;
			boolean flag = true;
			Arrays.sort(arr);
			if(Math.abs(arr[n-1]-1422)<<1>200)
				flag = false;
			if(flag)
			for (int i = 0; i < n; i++) 
			{
				if(Math.abs(arr[i]-last)<=200)
				{
					last = arr[i];
				}
				else
				{
					flag = false;
					break;
				}
			}
			out.append((flag)? "POSSIBLE\n":"IMPOSSIBLE\n");
		}		
		out.flush();
	}
}
