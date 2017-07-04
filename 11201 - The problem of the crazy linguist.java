import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer, Double> map;
	static HashSet<Integer> set;
	static int n,count;
	static double eps = 1e-8;
	public static double SBC(String s)
	{
		double res = 0;
		for (int i = 0; i < s.length(); i++) 
			res +=(i+1) * map.get(s.charAt(i)-'a');
		return res;
	}
	public static double solve(String s,int ind)
	{
		if(ind==n)
		{
			count++;
			return SBC(s);
		}
		double res = 0;
		for (int i = 0; i < 26; i++) 
		{
			char cur = (char)(i+'a');
			if(ind%2==1)
			{
				if(set.contains(i))
				{
					int num = num(s,cur);
					if(num<2)
						res += solve(s+cur,ind+1);
				}
			}
			else
			{
				if(!set.contains(i))
				{
					int num = num(s,cur);
					if(num<2)
						res += solve(s+cur,ind+1);
				}
			}
		}
		return res;
	}
	public static int num(String s,char c) 
	{
		int ans = 0;
		for (int i = 0; i < s.length();i++)
			if(s.charAt(i)==c)
				ans++;
		return ans;
	}
	public static void main(String[] args) throws Throwable
	{		
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		make();
		double[][] memo = new double[8][26];
		for (int i = 1; i < 8; i++) 
		{
			n = i;
			for (int j = 0; j < 26; j++) 
			{
				char c = (char) (j+'a');
				if(!set.contains(j))
				{
					count = 0;
					double cur = solve(c+"", 1);
					memo[i][j] = cur/count;
				}
			}
		}
		int t = sc.nextInt();
		while(t-->0)
		{
			String s = sc.nextLine();
			count = 0;
			n = s.length();
			double res = memo[s.length()][s.charAt(0)-'a'];
			double cur = SBC(s);
			if(cur<res && Math.abs(cur-res)>eps)
				out.append("below\n");
			else
				out.append("above or equal\n");
		}
		out.flush();
	}
	public static void make()
	{
		map = new HashMap<Integer, Double>();
		set = new HashSet<Integer>();
		for (int i = 0; i < 26; i++) 
		{
			char c = (char) (i+'a');
			if(c=='a')map.put(i, 12.53);
			if(c=='b')map.put(i, 1.42);
			if(c=='c')map.put(i, 4.68);
			if(c=='d')map.put(i, 5.86);
			if(c=='e')map.put(i, 13.68);
			if(c=='f')map.put(i, 0.69);
			if(c=='g')map.put(i, 1.01);
			if(c=='h')map.put(i,0.70 );
			if(c=='i')map.put(i,6.25 );
			if(c=='j')map.put(i,0.44 );
			if(c=='k')map.put(i, 0.00);
			if(c=='l')map.put(i, 4.97);
			if(c=='m')map.put(i,3.15 );
			if(c=='n')map.put(i, 6.71);
			if(c=='o')map.put(i, 8.68);
			if(c=='p')map.put(i, 2.51);
			if(c=='q')map.put(i,0.88 );
			if(c=='r')map.put(i,6.87 );
			if(c=='s')map.put(i,7.98 );
			if(c=='t')map.put(i,4.63 );
			if(c=='u')map.put(i,3.93 );
			if(c=='v')map.put(i,0.90 );
			if(c=='w')map.put(i,0.02 );
			if(c=='x')map.put(i, 0.22);
			if(c=='y')map.put(i,0.90 );
			if(c=='z')map.put(i, 0.52);
		}
		set.add(0);
		set.add('e'-'a');
		set.add('i'-'a');
		set.add('o'-'a');
		set.add('u'-'a');
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

		public boolean ready() throws IOException 
		{return br.ready();}
	}
}
