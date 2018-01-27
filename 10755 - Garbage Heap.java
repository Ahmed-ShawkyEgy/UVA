import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		boolean first = true;
		while(t-->0)
		{
			if(!first)System.out.println();
			first = false;
			int a = sc.nextInt() , b = sc.nextInt() , c = sc.nextInt();
			long[][][] arr = new long[a][b][c];
			for (int i = 0; i < a; i++) 
			{
				for (int j = 0; j < b; j++) 
				{
					for (int k = 0; k < c; k++) 
					{
						arr[i][j][k] = sc.nextLong();
						
						if(i>0)arr[i][j][k] += arr[i-1][j][k];
						if(j>0)arr[i][j][k] += arr[i][j-1][k];
						if(k>0)arr[i][j][k] += arr[i][j][k-1];
						
						if(i>0 && j>0) arr[i][j][k] -= arr[i-1][j-1][k];
						if(i>0 && k>0) arr[i][j][k] -= arr[i-1][j][k-1];
						if(j>0 && k>0) arr[i][j][k] -= arr[i][j-1][k-1];
						
						if(i>0 && j>0 && k>0) arr[i][j][k] += arr[i-1][j-1][k-1];
					}
				}
			}
			
			long ans = Long.MIN_VALUE;
			for (int i1 = 0; i1 < a; i1++) 
			{
				for (int i2 = i1; i2 < a; i2++) 
				{
					for (int j1 = 0; j1 < b; j1++) 
					{
						for (int j2 = j1; j2 < b; j2++) 
						{
							long cur = 0;
							for(int k = 0;k<c;++k)
							{
								cur += arr[i2][j2][k];
								
								if(i1>0)cur -= arr[i1-1][j2][k];
								if(j1>0)cur -= arr[i2][j1-1][k];
								if(k>0)cur -= arr[i2][j2][k-1]; 
								
								if(i1>0 && j1>0) cur += arr[i1-1][j1-1][k];
								if(i1>0 && k>0) cur += arr[i1-1][j2][k-1];
								if(j1>0 && k>0) cur += arr[i2][j1-1][k-1];
								
								if(i1>0 && j1>0 && k>0) cur -= arr[i1-1][j1-1][k-1];
								
								ans = Math.max(ans, cur);
								if(cur<0) cur = 0;
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
		
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
		public int[] nextIntArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			int[] res = new int[st.countTokens()];
			for (int i = 0; i < res.length; i++) {
				res[i] = Integer.parseInt(st.nextToken());
			}
			return res;
		}
		public char[] nextCharArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			char[] res = new char[st.countTokens()];
			for (int i = 0; i < res.length; i++) {
				res[i] = st.nextToken().charAt(0);
			}
			return res;
		}
	}	
}
