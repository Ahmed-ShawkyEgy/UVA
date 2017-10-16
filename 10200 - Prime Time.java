import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean isPrime(int n)
	{
		for(int i = 3; i * i <= n;i+=2)
			if(n%i==0)return false;
		return n%2!=0;
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		int[] arr = new int[10001];
		arr[0] = 1;
		for(int i = 1 ; i < arr.length ; i++)
		{
			arr[i] = arr[i-1];
			if( isPrime( i * i + i + 41 ) )
				arr[i] ++;
		}
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			int a = sc.nextInt() , b = sc.nextInt();
			double ans = 0;
			if(b<40)
				ans = 100;
			else if(a==0)
				ans = 100.0 * (arr[b] * 1.0 / ( (b+1))) ;
			else
				ans = 100 * ( (arr[b] - arr[a-1]) * 1.0  / ((b - a + 1)) ) ;
			System.out.printf("%.2f\n", ans );
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
