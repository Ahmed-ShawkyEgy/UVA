import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n,k,oo = (int)1e8;
	static String[] a;
	static int[][][] memo;
	
	static int dp(int i,int l,int r)
	{
		int matched = i - r;
		int j = n - 1 -l - matched;
		if(l+r>k)return oo; 
		if(i>=j)return 0;
		if(memo[i][l][r]!=-1)return memo[i][l][r];
		
		int ans;
		
		if(a[i].equals(a[j]))
			ans = dp(i+1,l,r);
		else
		{
			ans = 1 + dp(i+1,l,r+1);
			ans = Math.min(ans,1+ dp(i,l+1,r));
		}
		return memo[i][l][r] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int cases = 1; cases <= t; cases++) 
		{
			n = sc.nextInt(); k = sc.nextInt();
			a = sc.nextLine().trim().split(" ");
			memo = new int[n][k+1][k+1];
			for (int i = 0; i < memo.length; i++) 
				for (int j = 0; j < memo[i].length; j++) 
					Arrays.fill(memo[i][j], -1);
				
			
			int ans = dp(0,0,0);
			if(ans==0)
				System.out.println("Case "+cases+": Too easy");
			else if(ans>k)
				System.out.println("Case "+cases+": Too difficult");
			else
				System.out.println("Case "+cases+": "+ans);
		}
		
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
