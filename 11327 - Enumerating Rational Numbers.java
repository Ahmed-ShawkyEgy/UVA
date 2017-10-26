import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// Totient Euler
public class Main {
	
	static ArrayList<Integer> prime;
	static void sieve()
	{
		int n = 200000;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		for(int i = 2 ; i * i < isPrime.length; i++)
			if(isPrime[i])
				for(int j = i * i ; j < n; j += i)
					isPrime[j] = false;
		prime = new ArrayList<Integer>();
		for(int i = 2; i < n ; i++)
			if(isPrime[i])
				prime.add(i);
	}
	
	static int phi(int n)
	{
		int ans = n , idx = 0 , pf = prime.get(idx);
		while(pf * pf <= n)
		{
			if(n%pf == 0)
			{
				while(n%pf == 0) n /= pf;
				ans -= ans / pf;
			}
			pf = prime.get(++idx);
		}
		if(n > 1) ans -= ans / n;
		return ans;
	}
	
	static int gcd(int a , int b){return b==0?a : gcd(b,a%b);}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		sieve();
		StringBuilder sb = new StringBuilder();
		long[] prefix = new long[(int)1e5<<1|1];
		prefix[1] = 2;
		for(int i = 2 ; i < prefix.length; i++)
			prefix[i] = prefix[i-1] + phi(i);
		while(true)
		{
			long n = sc.nextLong();
			if(n==0)break;
			if(n<3)
			{
				if(n==1)sb.append("0/1\n");
				else sb.append("1/1\n");
				continue;
			}
			int d = 0 ;
			while(prefix[++d] < n);
			n = n - prefix[d-1] ;
			int num = 1;
			
			for(;num < d && n>0 ; ++num)
				if(gcd(d,num)==1)
					n--;
			
			sb.append(--num+"/"+d+"\n");
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
