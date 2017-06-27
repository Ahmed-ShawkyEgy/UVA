import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable
	{
		Scanner sc = new Scanner(System.in);
		while(sc.ready())
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] rev = new int[n];
			// My algorithm in a nutshell
			// Two LIS one on arr and the other on rev
			// rev is = to arr but reversed
			// That way a LIS on rev is the same as LDS on arr
			
			for(int i = 0;i<n;i++)
			{
				arr[i] = sc.nextInt();
				rev[i] = arr[i];
			}
			reverse(rev);
			
			// Holds the the maximum possible subsequences at index i for all i<n i>=0 
			// The second dimension is the same but for the reversed array
			int[][] res = new int[n][2];
			
			int[] tmp = new int[n];
			int ind = 0;
			tmp[ind++] = arr[0];
			
			// Fill the res array with base cases
			for (int i = 0; i < res.length; i++) {
				res[i][0] = res[i][1] = 1;
			}
			
			// Begin LIS on arr
			for(int i = 1;i<n;i++)
			{
				if(arr[i]>tmp[ind-1])
				{
					tmp[ind++] = arr[i];
					res[i][0] = ind; // ind could also be seen as the LIS seen so far at index i
					continue;
				}
				int lo = 0, hi = ind-1;
				int j = ind; // j holds the index of the smallest int >= arr[i]
				while(lo<=hi)
				{
					int mid = (lo+hi)/2;
					if(tmp[mid]<arr[i])
						lo = mid+1;
					else
					{
						hi = mid-1;
						j = mid;
					}
				}
				tmp[j] = arr[i];
				res[i][0] = ind;
			}
			// End of LIS on arr
			// -----------------------------------------------
			// Begin LIS on rev ie: LDS on arr
			tmp = new int[n];
			ind = 1; tmp[0] = rev[0];
			for(int i = 1;i<n;i++)
			{
				if(rev[i]>tmp[ind-1])
				{
					tmp[ind++] = rev[i];
					res[n-i-1][1] = ind;
					continue;
				}
				int lo = 0, hi = ind-1,j = ind;
				while(lo<=hi)
				{
					int mid = (lo+hi)/2;
					if(tmp[mid]<rev[i])
						lo = mid+1;
					else
					{
						j = mid;
						hi = mid-1;
					}
				}
				tmp[j] = rev[i];
				res[n-i-1][1] = ind;
			}
			
			int ans = 0;
			// Computing result
			for(int i = n-1;i>=0;i--)
			{
				if(res[i][0] == res[i][1])
				{
					ans = res[i][0] + res[i][1] - 1;
					break;
				}
			}
			System.out.println(ans);
		}
	}
	public static void reverse(int[] arr)
	{
		for (int i = 0; i < arr.length/2; i++) {
			int j = arr.length-1-i;
			arr[i] ^= arr[j];
			arr[j] ^= arr[i];
			arr[i] ^= arr[j];
		}
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

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}


	}
}
