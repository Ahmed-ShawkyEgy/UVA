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
	static ArrayList<Integer> prime;
	static Pair[] twin;
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		sieve();
		fill();
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			int n = sc.nextInt();
			sb.append("("+twin[n].a+", "+twin[n].b+")\n");
		}
		System.out.print(sb);
	}
	
	static class Pair
	{
		int a , b;
		public Pair(int x,int y){a = x; b = y;}
	}
	
	static void fill()
	{
		int n = 100001;
		twin = new Pair[n];
		int idx = 0;
		for (int i = 1; i < twin.length; i++)
		{
			while(prime.get(idx+1)!=prime.get(idx++)+2);
			twin[i] = new Pair(prime.get(idx-1), prime.get(idx));
		}
	}
	
	static void sieve()
	{
		int n = 20000001;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i < n; i++) 
			if(isPrime[i])
				for (int j = i*i; j < n; j+=i) 
					isPrime[j] = false;
		prime = new ArrayList<Integer>();
		for (int i = 0; i < isPrime.length; i++) 
			if(isPrime[i])
				prime.add(i);
		
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
