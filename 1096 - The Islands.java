import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n,b1,b2;
	static int[][] arr;
	static double[][][] memo;
	static final int oo = (int) 1e8 ;
	static final double eps = 1e-8;
	static Queue<Integer> q1,q2;
	public static double dist(int i,int j)
	{
		int res1 = arr[i][0] - arr[j][0]; res1 *= res1;
		int res2 = arr[i][1] - arr[j][1]; res2 *= res2;
		return ( Math.sqrt(res2+res1));
	}
	public static double dp(int L,int R,int state) // State = 0 :: L takes first island :: else L takes second island
	{
		int ind = Math.max(L, R) + 1;
		if(ind>n-1)
			return oo;
		if(ind==n-1)
			return (dist(L,ind)) + (dist(R,ind));
		if(memo[L][R][state]!=-1)
			return memo[L][R][state];
		double ans = oo;
		if(ind==b1)
			if(state==0)
				ans = Math.min((ans), ( (dist(L,ind)) + (dp(ind,R,state)) ));
			else
				ans = Math.min((ans), ( (dist(R, ind)) + (dp(L,ind,state))));
		else if(ind==b2)
			if(state==1)
				ans = Math.min((ans), ( (dist(L,ind)) + (dp(ind,R,state)) ));
			else
				ans = Math.min((ans), ( (dist(R, ind)) + (dp(L,ind,state))));
		else
			ans = Math.min(((dist(L,ind)) + (dp(ind,R,state)) ), ( (dist(R, ind)) + dp(L,ind,state)));
		return memo[L][R][state] = (ans);
	}
	public static void print(int L,int R,int state)
	{
		int ind = Math.max(L, R) + 1;
		if(ind>n-1)
			return;
		if(ind==n-1)
		{
			if(ind==L+1)
				q1.add(ind);
			else
				q2.add(ind);
			return;
		}	
		double res = dp(L,R,state);
		double ans = oo;
		if(ind==b1)
			if(state==0)
				if (Math.abs(( (dist(L,ind)) + (dp(ind,R,state)))-res)<=eps)
				{
					q1.add(ind);
					print(ind,R,state);
					return;
				}
			else
			{
				ans = ( (dist(R, ind)) + (dp(L,ind,state)));
				if(Math.abs(ans-res)<=eps)
				{
					q2.add(ind);
					print(L,ind,state);
					return;
				}
			}
		else if(ind==b2)
			if(state==1)
			{
				ans =  ( (dist(L,ind)) + (dp(ind,R,state)) );
				if(Math.abs(ans-res)<=eps)
				{
					q1.add(ind);
					print(ind,R,state);
					return;
				}					
			}
			else
			{
				ans = ( (dist(R, ind)) + (dp(L,ind,state)));
				if(Math.abs(ans-res)<=eps)
				{
					q2.add(ind);
					print(L,ind,state);
					return;
				}
			}
		else
		{
			double a = ((dist(L,ind)) + (dp(ind,R,state)) ) ;
			if(Math.abs(a-res)<=eps)
			{
				q1.add(ind);
				print(ind,R,state);
				return;
			}
			else
			{
				q2.add(ind);
				print(L,ind,state);
				return;
			}
		}
	}
	public static void main(String[] args) throws Throwable
	{
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		DecimalFormat f = new DecimalFormat("#0.00");
		int cases = 1;
		while(true)
		{
			n = sc.nextInt();
			b1 = sc.nextInt();
			b2 = sc.nextInt();
			if(n==0 && b1==0 && b2==0)
				break;
			arr = new int[n][2];
			for (int i = 0; i < arr.length; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			memo = new double[n][n][2];
			
			for (int i = 0; i < memo.length; i++) 
				for (int j = 0; j < memo[i].length; j++) 
						Arrays.fill(memo[i][j], -1);
			
			double ans = Math.min((dp(0,0,0)), (dp(0,0,1)));
			out.append("Case "+cases+++": "+f.format(ans)+"\n");
			
			q1 = new LinkedList<Integer>();
			q2 = new LinkedList<Integer>();
			if((dp(0,0,0))<(dp(0,0,1)))
				print(0,0,0);
			else
				print(0,0,1);
			StringBuilder sb1 = new StringBuilder("0"),sb2 = new StringBuilder("0");
			while(!q1.isEmpty())
				sb1.append(" "+q1.poll());
			while(!q2.isEmpty())
				sb2.append(" "+q2.poll());
			if(sb2.toString().compareTo(sb1.toString())<0)
			{
				StringBuilder tmp = sb1;
				sb1 = sb2;
				sb2 = tmp;
			}
			out.append(sb1+" "+reverse(sb2)+"\n");
		}
		out.flush();
	}
  
	public static StringBuilder reverse(StringBuilder sb)
	{
		Stack<String> stak = new Stack<String>();
		StringTokenizer st = new StringTokenizer(sb.toString());
		while(st.hasMoreTokens())
			stak.push(st.nextToken());
		StringBuilder tmp = new StringBuilder(stak.pop());
		while(!stak.isEmpty())
			tmp.append(" "+stak.pop());
		return tmp;
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
