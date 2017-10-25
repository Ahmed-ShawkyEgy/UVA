import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		
		while(sc.ready())
		{
			int n = sc.nextInt();
			int tmp = n;
			BigInteger cur = new BigInteger(1+"");
			while(n>0)
				cur = cur.multiply(new BigInteger("" + n--));
			char last = '0';
			char[] arr = cur.toString().toCharArray();
			for (int i = 0; i < arr.length; i++) 
				if(arr[i] != '0')last = arr[i];
			
			System.out.printf("%5d -> %c\n",tmp,last);
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
	}
}
