import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static TreeSet<Integer> prime;
	static Stack<Integer> stak;
	static void bt(int n,int lvl)
	{
		if(lvl==0 )
		{
			if(prime.contains(n))stak.push(n);
		}
		else
		{
			int curPrime = prime.floor(n-2*lvl);
			stak.add(curPrime);
			bt(n-curPrime,lvl-1);
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		sieve();
		stak = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			int n = sc.nextInt();
			if(n>=8)
				bt(n,3);
			if(stak.size()<4)
			{
				stak.clear();
				sb.append("Impossible.");
			}
			else
			{
				sb.append(stak.pop());
				while(!stak.isEmpty())
					sb.append(" "+stak.pop());
				
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
	
	
	
	static void sieve()
	{
		int n = 10000001;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i*i <= isPrime.length; i++) 
			if(isPrime[i])
				for (int j = i*i; j < isPrime.length; j+=i) 
					isPrime[j] = false;
		
		prime = new TreeSet<Integer>();
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
