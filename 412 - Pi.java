import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static int gcd(int a,int b){return b==0?a:gcd(b,a%b);}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			int n = sc.nextInt();
			if(n==0)break;
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) 
				arr[i] = sc.nextInt();
			
			int total = 0 , cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = i+1; j < arr.length; j++) 
				{
					total++;
					if(gcd(arr[i], arr[j])==1)
						cnt++;
				}
			}
			if(cnt==0)
				out.println("No estimate for this data set.");
			else
			{
				double res = Math.sqrt(6.0*total/cnt);
				out.printf("%6f\n",res);
			}
			
		}
		out.flush();
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
