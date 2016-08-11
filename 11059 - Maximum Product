import java.io.*;
import java.util.*;
public class MaximumProduct {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = 1;
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			long ans = 0;
			int[] arr = new int[n];
			for(int i =0;i<n;i++)
			{
				int x = Integer.parseInt(st.nextToken());
				arr[i] = x;
			}
			for (int i = 0; i < n; i++) {
				long curr = 0;
					for(int j = i;j<n;j++)
					{
						ans = Math.max(ans, curr);
						if(curr==0)
							curr++;
						curr*=arr[j];
						ans = Math.max(ans, curr);
					}
				
			}
			out.append("Case #"+cases++ +": The maximum product is ");
			out.append(ans+".");
			out.append("\n\n");
			br.readLine();
		}
		out.flush();
	}

}
