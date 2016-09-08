import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m == 0)
				break;
			int[] arr = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < m; i++) 
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b =Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				arr[a] -= val;
				arr[b] += val;
			}
			boolean ans = true;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]<0)
					ans = false;
			}
			out.append(ans? "S\n":"N\n");
		}
		out.flush();
	}
}
