import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) 
			{
				st = new StringTokenizer(br.readLine());
				arr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			out.append("Case "+cases++ +":\n");
			while(m-->0)
			{
				int ans =0;
				int min = Integer.MAX_VALUE;
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				for (int i = 0; i < arr.length; i++) 
				{
					for (int j = i+1; j < arr.length; j++) 
					{
						int x = Math.abs(arr[i]+arr[j]-c);
						if(x<min)
						{
							min = x;
							ans = arr[i]+arr[j];
						}
					}
				}
				out.append("Closest sum to "+c+" is "+ans+".\n");
			}
		}
		out.flush();
	}
}
