import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;
	static int n;
	static long bs(long q,boolean f)
	{
		int lo = 0 , hi = n-1;
		long ans = -1;
		while(lo <= hi)
		{
			int mid = (lo+hi)>>1;
			if(f)
			{
				if(arr[mid] >= q) hi = mid-1;
				else
				{
					ans = arr[mid];
					lo = mid+1;
				}
			}else
			{
				if(arr[mid] <= q) lo = mid+1;
				else
				{
					ans = arr[mid];
					hi = mid-1;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		n = sc.nextInt();
		arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLong();
		}
		
		int q = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(q-->0)
		{
			long x = sc.nextLong();
			long a = bs(x,true);
			long b = bs(x,false);
			sb.append(((a!=-1)? a:"X") + " " + ((b!=-1)? b:"X") + "\n");
			
		}
		System.out.print(sb);
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(s));
		}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public String nextLine() throws IOException {return br.readLine();}		
		public long nextLong() throws IOException {return Long.parseLong(next());}		
		public double nextDouble() throws IOException {return Double.parseDouble(next());}	
		public boolean ready() throws IOException {return br.ready();}
	}

}
