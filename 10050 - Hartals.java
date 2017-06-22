import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2{
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			int p = Integer.parseInt(br.readLine());
			int[] arr = new int[p];
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(br.readLine());
			int ans = 0;
			for(int i = 1;i<=n;i++)
			{
				if((i+1)%7==0 || (i)%7==0) // friday or Sat
					continue;
				for(int j = 0;j<p;j++)
					if(i%arr[j]==0)
					{
						ans++;
						break;
					}
			}
			out.append(ans+"\n");
		}
		out.flush();
	}
}
