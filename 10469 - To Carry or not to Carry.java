import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] add(int[] a,int[] b)
	{
		int[] res = new int[33];
		for (int i = 0; i < b.length; i++) 
			res[i] = a[i] ^ b[i];
		
		return res;
	}
	
	
	static long toDec(int[] arr)
	{
		long res = 0;
		for(int i = arr.length-1;i>=0;--i)
			res = (res*2) + arr[i];
		
		return res;
	}
	
	
	static int[] toBinary(long n)
	{
		int[] arr = new int[33];
		for (int i = 0; i < arr.length && n>0; i++,n/=2) 
			arr[i] = (int) (n%2);
		
		return arr;
	}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
			sb.append(toDec(add(toBinary(sc.nextLong()),toBinary(sc.nextLong()) )) + "\n");
		
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
