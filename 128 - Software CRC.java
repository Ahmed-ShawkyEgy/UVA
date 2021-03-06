import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int mod = 34943;
		while(true)
		{
			char[] a = sc.nextLine().toCharArray();
			if(a.length==1 && a[0]=='#')break;
			
			int x = 0;
			for(int i = 0 ; i < a.length;i++)
			{
				x = (x%mod * (16*16)%mod)%mod;
				x = (x%mod + (int)a[i]%mod)%mod;
			}
			x = (x%mod * 16%mod)%mod;
			x = (x%mod * 16%mod)%mod;
			x = (x%mod * 16%mod)%mod;
			x = (x%mod * 16%mod)%mod;
			int ans = mod - x;
			ans %= mod;
			String hex = Integer.toHexString(ans).toUpperCase();
			
			while(hex.length()<4)
				hex = 0 + hex;
			sb.append(hex.substring(0, 2)+" "+hex.substring(2)+"\n");
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
