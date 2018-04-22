import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> prime;
	
	static void seive()
	{
		int n = (int) 1e4;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		prime = new ArrayList<Integer>();
		for(int i = 2; i<n;i++)
			if(isPrime[i])
				for(int j=i*i;j<n;j+=i)
					isPrime[j] = false;
				
		for (int i = n-1; i >1; i--) 
			if(isPrime[i])
				prime.add(i);
	}
	
	static String f(int n)
	{
		StringBuilder sb = new StringBuilder();
		for(int i:prime)
		{
			if(n%i==0)
			{
				sb.append(i+" ");
				int pow = 0;
				while(n%i==0)
				{
					++pow;
					n/=i;
				}
				sb.append(pow+" ");
			}
		}
		if(n>1)
			sb = new StringBuilder(n+" 1 "+sb);
		
		return sb.toString().trim();
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		seive();
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			StringTokenizer st = new StringTokenizer(sc.nextLine().trim());
			if(st.countTokens()==1)break;
			int cur =1;
			while(st.hasMoreTokens())
			{
				int b = Integer.parseInt(st.nextToken()),pow = Integer.parseInt(st.nextToken());
				int p = b;
				while(--pow>0)p*=b;
				cur*=p;
			}
			sb.append(f(cur-1)+"\n");
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
