import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int n ,m ,total , arr[];
	public static void main(String[] args) throws Throwable {
		Scanner br = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		while(br.ready())
		{
			String s = br.nextLine();
			if(s.isEmpty())continue;
			StringTokenizer st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n+m];
			total = 0;
			for (int i = 0; i < arr.length; i++) 
				total += arr[i] = br.nextInt();
			
			boolean[][] dp = new boolean[5601][n+1];
			dp[2600][0] = true;
			
			for (int i = 0; i < arr.length; i++) 
				for(int taken = n-1;taken>=0;taken--)
					for(int sum = 5201;sum>0;sum--)
						if(dp[sum][taken] && sum+arr[i]<dp.length && taken+1<n+1)
							dp[sum+arr[i]][taken+1] = true;
			
			int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
			for (int i = 0; i < dp.length; i++) 
			{
				if(dp[i][n])
				{
					int cur =(i-2600)*(total-(i-2600));
					min = Math.min(min, cur);
					max = Math.max(max, cur);
				}
			}
			sb.append(max+" "+min+"\n");
		}
		System.out.print(sb);
	}	

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		
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
