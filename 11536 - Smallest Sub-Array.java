import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int m,n,k;
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner((System.in));
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(t-->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			
			int[] arr = new int[n];
			for (int i = 0; i < 3; i++) 
				arr[i] = i+1;
			for (int i = 3; i < arr.length; i++) 
				arr[i] = 1 + ((arr[i-1]%m+arr[i-2]%m+arr[i-3]%m)%m);
			int[] taken = new int[2000];
			
			int left = 0,right=0,min = Integer.MAX_VALUE,count = 0;
			for (int i = 0; i < n; i++) 
			{
				taken[arr[i]]++;
				if(arr[i]<=k && taken[arr[i]]==1)count++;
				right++;
				while(left<right)
				{
					if(arr[left]<=k && taken[arr[left]]==1)break;
					taken[arr[left++]]--;
				}
				if(count==k)
					min = Math.min(min, right-left);
			}
			sb.append("Case "+cases+++": "+((min==Integer.MAX_VALUE)?"sequence nai":min)+"\n");
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
		
		public long nextLong() throws IOException {return Long.parseLong(next());}
		
		public boolean ready() throws IOException {return br.ready();}

	}

}
