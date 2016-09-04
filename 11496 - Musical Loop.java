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
			int[] arr = new int[n+2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n+1; i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			arr[0] = arr[n];
			arr[n+1] = arr[1];
			int ans = 0;
			for (int i = 1; i < arr.length-1; i++) {
				int a = arr[i-1];
				int b = arr[i];
				int c = arr[i+1];
				if((b>=a && b>=c) || (b<=a && b<=c))
					ans++;
			}
			out.append(ans+"\n");
		}		
		out.flush();
	}
}
