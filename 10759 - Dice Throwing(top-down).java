import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n , m , offset = 6 * 25;
	static long memo[][];
	static long dp(int idx,int sum)
	{
		if(idx == 0)return sum <= offset ? 1 : 0;
		if(memo[idx][sum]!=-1)return memo[idx][sum];
		long ans = 0;
		for (int i = 1; i <= 6; i++) 
			ans += dp(idx-1 , sum - i);
		return memo[idx][sum] = ans;
	}
	
	static long gcd(long a,long b){return b==0 ? a : gcd(b,a%b);}
	static long pow(int a,int b){
		long ans = 1;
		while(b-->0)
			ans *= 1l * a;
		return ans;
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		memo = new long[25][(6*25) << 1];
		for (int i = 0; i < memo.length; i++) 
			Arrays.fill(memo[i], -1);
		
		while(true)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			if(n == 0 && m == 0)break;
			long total = pow (6 , n);
			long ans = dp(n,m + offset);
			if(ans==0)
			{
				sb.append("0\n");
				continue;
			}
			if(ans == total)
			{
				sb.append("1\n");
				continue;
			}
			long gcd = gcd(ans, total);
			ans /= gcd; total /= gcd;
			sb.append(ans+"/"+total+"\n");
			
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
