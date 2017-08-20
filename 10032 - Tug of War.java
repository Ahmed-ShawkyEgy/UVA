// Disclaimer: I learned the solution for this problem form this link:
//  https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v100/TugOfWar_UVa10032.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n ,total , arr[];
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		boolean first = true;
		while(t-->0)
		{
			if(!first)sb.append("\n");
			first = false;
			n = sc.nextInt();
			arr = new int[n];
			total = 0;
			int max = 0;
			for (int i = 0; i < arr.length; i++) 
			{
				total += arr[i] = sc.nextInt();
				max = Math.max(max, arr[i]);
			}
			// Maximum/Minimum size for one group
			int maxSize = (n%2==0)? n>>1 : (n>>1)+1;
		    int minSize =  n>>1;
		    // Maximum Weight possible
			int bound = 1+(max*50);
			/*
			 * DP is an array of bitMasks
			 * For each i (sum of weights) in this array there is a bit mask 
			 * representing the number of people who could make up this sum. 
			 * 
			 */
			long [] dp = new long[bound];
			dp[0] = 1;
			for (int i = 0; i < n; i++) 
					for (int sum = bound-1; sum >= 0; sum--) 
						if(sum+arr[i]<bound)dp[sum+arr[i]] |= dp[sum]<<1;
			
			
			int min = Integer.MAX_VALUE , a = -1 , b = -1;
			for(int i = minSize ; i<=maxSize;i++)
			{
				for(int sum = 0;sum<bound;sum++)
				{
					int other = total - sum;
					if(((dp[sum])&(1l<<i))!=0 && Math.abs(sum-other)<min)
					{
						min = Math.abs(sum-other);
						a = Math.min(other, sum);
						b = Math.max(other, sum);
					}
				}
			}
			sb.append(a+" "+b+"\n");
		}
		System.out.print(sb);
	}	

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		
		public Scanner(FileReader r){	br = new BufferedReader(r);}
		
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public boolean ready() throws IOException {return br.ready();}

	}

}
