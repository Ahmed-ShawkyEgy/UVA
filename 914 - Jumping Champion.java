import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> prime;
	static void sieve()
	{
		int size = 1000000 | 1;
		prime = new ArrayList<Integer>();
		boolean[] isPrime = new boolean[size];
		Arrays.fill(isPrime, true);
		for(int i = 2;i*i<size;i++)
		{
			if(isPrime[i])
			{
				prime.add(i);
				for(int j = i*i;j<size;j+=i)
					isPrime[j] = false;
			}
		}
		
		for (int i = 0; i < isPrime.length; i++) 
			if(isPrime[i])prime.add(i);
		
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		sieve();
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			int l = sc.nextInt() , r = sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 1; i < prime.size() ; i++) 
			{
				int cur = prime.get(i) , last = prime.get(i-1);
				if(cur < l || last < l)continue;
				if(cur > r || last > r)break;
				int dif = cur - last;
				if(!map.containsKey(dif))
					map.put(dif, 1);
				else
					map.put(dif, map.get(dif)+1);
			}
			int max = 0 , val = 0;
			boolean repeat = true;
			for(Entry<Integer, Integer> e : map.entrySet())
			{
				int v = e.getKey() , cnt = e.getValue();
				if(cnt > max)
				{
					repeat = false;
					max = cnt;
					val = v;
				}
				else if ( cnt == max)
					repeat = true;
			}
			if(repeat)
				sb.append("No jumping champion\n");
			else
				sb.append("The jumping champion is "+val+"\n");
			
			
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
