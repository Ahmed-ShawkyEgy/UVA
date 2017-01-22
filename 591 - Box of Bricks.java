import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));	    
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			int num = sum/n;
			int cur = 0;
			Arrays.sort(arr);
			int res = 0;
			for (int i = n-1; i >=0; i--)
			{
				if(arr[i]>=num)
				{
					cur += arr[i]-num;
					res += arr[i]-num;
				}
				else
				{
					cur -= num-arr[i];
				}
			}
			out.append("Set #"+cases+++"\n");
			out.append("The minimum number of moves is "+res+".\n\n");
		}
		out.flush();
	}
}
