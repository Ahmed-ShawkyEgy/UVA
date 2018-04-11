import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static String[] memo;
	static ArrayList<Pair> factors;
	static class Pair
	{
		long base,pow;
		public Pair(long a,long b) {base = a;pow = b;}
	}
	
	
	static boolean isPrime(int n)
	{
		for (int i = 2; i < n; i++) 
			if(n%i==0)return false;
		return true;
	}
	
	static String solve(int n)
	{
		long N = (1l<<(n-1l))*((1l<<n)-1l) , tmp = N;
		if(!memo[n].equals("-1"))return memo[n];
		String ret = "";
		boolean isPrime = isPrime(n) , isPerfect = false;
		factors = new ArrayList<Pair>();
		int ind = 0;
		for(int i = 2;1l*i*i<=N;i++)
		{
			if(N%i==0)
			{
				factors.add(new Pair(i, 0));
				while(N%i==0)
				{
					N/=i;
					++factors.get(ind).pow;
				}
				++ind;
			}
		}
		if(N>1)factors.add(new Pair(N, 1));
		long sum = getSum(0)>>1;
		if(sum == tmp)
			isPerfect = true;
		
		if(isPerfect)
			ret = "Perfect: "+tmp+"!";
		else if(isPrime)
			ret = "Given number is prime. But, NO perfect number is available.";
		else
			ret = "Given number is NOT prime! NO perfect number is available.";
		
		return memo[n] = ret;
	}
	
	static long getSum(int ind)
	{
		if(ind==factors.size())return 1;
		long sum = 0;
		int cur = 1;
		for(int i = 0;i<=factors.get(ind).pow;i++)
		{
			sum += 1l*cur*getSum(ind+1);
			cur *=	factors.get(ind).base;
		}
		return sum;
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		memo = new String[32];
		Arrays.fill(memo, "-1");
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int n = sc.nextInt();
			if(n==0)break;
			sb.append(solve(n)+"\n");
		}
		System.out.print(sb);
	}
	

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String s) throws FileNotFoundException {br = new BufferedReader(new FileReader(s));}
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
		public char nextChar() throws IOException{return next().charAt(0);}
		public boolean ready() throws IOException {return br.ready();}
		public int[] nextIntArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			int[] res = new int[st.countTokens()];
			for (int i = 0; i < res.length; i++)
				res[i] = nextInt();
			return res;
		}
		public char[] nextCharArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			char[] res = new char[st.countTokens()];
			for (int i = 0; i < res.length; i++) 
				res[i] = nextChar();
			return res;
		}
	}

}
