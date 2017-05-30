import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> prime;
	
	public static void sieve()
	{
		boolean[] isPrime = new boolean[(int)1e7];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i < isPrime.length; i++) 
		{
			if(isPrime[i])
			{
				for (long j =(long) i<<1; j < isPrime.length; j+=i) {
					isPrime[(int) j] = false;
				}
			}
		}
		prime = new ArrayList<Integer>();
		for (int i = 0; i < isPrime.length; i++) {
			if(isPrime[i])
				prime.add(i);
		}
	}
	
	public static int powerFac(int n,int p)
	{
		int res = 0;
		for (long power = p; power <= n; power=(long)power*p)
			res += n/power;
		return res;
	}

	public static ArrayList<Pair> pFactors(int n)
	{
		ArrayList<Pair> res = new ArrayList<Pair>();
		int PF_ind = 0,PF = prime.get(PF_ind);
		while(PF*PF<=n)
		{
			int ans = 0;
			while(n%PF==0){n/=PF;ans++;}
			res.add(new Pair(PF,ans));
			PF = prime.get(++PF_ind);
		}
		if(n!=1) res.add(new Pair(n,1));
		return res;
	}
	
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		sieve();
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // Factorial !!!
			int b = Integer.parseInt(st.nextToken());
			if(b==0)
			{
				out.append(b+" does not divide "+a+"!\n");
				continue;
			}
			if(b<=a)
			{
				out.append(b+" divides "+a+"!\n");
				continue;
			}
			boolean flag = true;
			ArrayList<Pair> factors = pFactors(b);
			for(Pair p : factors)
			{
				int count = powerFac(a, p.val);
				if(count<p.count)
				{
					flag = false;
					break;
				}
			}
			if(flag)
				out.append(b+" divides "+a+"!\n");
			else
				out.append(b+" does not divide "+a+"!\n");
		}
		out.flush();
	}
	
	static class Pair
	{
		int val,count;
		public Pair(int v,int c)
		{
			val = v;
			count = c;
		}
	}
}
