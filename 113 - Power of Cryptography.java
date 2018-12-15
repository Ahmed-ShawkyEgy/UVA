import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static BigInteger num;
	
	static BigInteger pow (int n, int pow)
	{
		BigInteger ret = BigInteger.ONE;
		while(pow-->0)ret = ret.multiply(BigInteger.valueOf(n));
		return ret;
	}
	
	static int solve() throws Exception
	{
		int lo = 1 , hi = 1+(int)1e9;
		while(lo<=hi)
		{
			int mid = (lo+hi)>>1;
			BigInteger p = pow(mid, n);
			int compare = p.compareTo(num);
			if(compare==1)
				hi = mid-1;
			else if(compare==-1)
				lo = mid+1;
			else return mid;
		}
		throw new Exception("No answer found");
	}
	
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			n = sc.nextInt();
			num = new BigInteger(sc.nextLine());
			sb.append(solve()+"\n");
		}
		System.out.print(sb);
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		
		public Scanner(String file) throws FileNotFoundException { br = new BufferedReader(new FileReader(file));}

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
		
		public int[] nexIntArray() throws Throwable
		{
			st = new StringTokenizer(br.readLine());
			int[] a = new int[st.countTokens()];
			for(int i = 0; i < a.length;i++)a[i]=nextInt();
			return a;
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}
}
