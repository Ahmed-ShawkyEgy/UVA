import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main2 
{
	static final int oo = (int)1e9;
	static int di[] = {-2,-2,-1,-1	,-1,1,2,-2 	, 1,-1,2,-2	, 2,2,1,1};
	static int dj[] = {1,-1,2,-2	,2,2,1,1 	, -2,-2,-1,-1	,1,-1,2,-2};
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[][][][] dp = new int[8][8][8][8];
		for (int i = 0; i < dp.length; i++) 
			for (int j = 0; j < dp.length; j++) 
				for (int k = 0; k < dp.length; k++) 
					Arrays.fill(dp[i][j][k], oo);
				
		
		for (int i = 0; i < dp.length; i++) 
			for (int j = 0; j < dp.length; j++) 
				for(int d = 0 ; d<di.length;d++)
				{
					dp[i][j][i][j] = 0;
					int ii = i + di[d] , jj = j + dj[d];
					if(isValid(ii, jj))
						dp[i][j][ii][jj] = 1;
				}
		
		for (int k1 = 0; k1 < dp.length; k1++) 
			for (int k2 = 0; k2 < dp.length; k2++) 
				for (int i1 = 0; i1 < dp.length; i1++) 
					for (int j1 = 0; j1 < dp.length; j1++) 
						for (int i2 = 0; i2 < dp.length; i2++) 
							for (int j2 = 0; j2 < dp.length; j2++) 
								dp[i1][j1][i2][j2] = Math.min(dp[i1][j1][i2][j2], dp[i1][j1][k1][k2] + dp[k1][k2][i2][j2]);
							
		while(sc.ready())				
		{
			String s1 = sc.next();
			int j1 = s1.charAt(0) - 'a' , i1 = 8 - (s1.charAt(1) - '0');
			String s2 = sc.next();
			int j2 = s2.charAt(0) - 'a' , i2 = 8 - (s2.charAt(1) - '0');
			sb.append("To get from "+s1+" to "+s2+" takes "+dp[i1][j1][i2][j2]+" knight moves.\n");
		}
		System.out.print(sb);
	}
	
	static boolean isValid(int i,int j)
	{
		return i>=0 && j>=0 && i< 8 && j<8;
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}		
		public long nextLong() throws NumberFormatException, IOException {return Long.parseLong(next());}
		public Scanner(FileReader r){	br = new BufferedReader(r);}
		public Scanner(String string) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(string));
		}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public String nextLine() throws IOException {return br.readLine();}
		public boolean ready() throws IOException {return br.ready();}
	}
	
}
