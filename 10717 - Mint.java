import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int gcd(int a,int b){return b==0? a : gcd(b,a%b);}
	static int lcm(int a,int b){return a * (b/gcd(a,b));}
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int n = sc.nextInt() , t = sc.nextInt();
			if(n==0)
				break;
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			while(t-->0)
			{
				int target = sc.nextInt();
				int min = Integer.MAX_VALUE , max = 0;
				for(int i = 0; i < n ; i++)
					for (int j = i+1; j < arr.length; j++) 
						for (int z = j+1; z < arr.length; z++) 
							for (int k = z+1; k < arr.length; k++) 
							{
								int mult = lcm(arr[i],lcm(arr[j] , lcm(arr[z],arr[k])));
								int div = target / mult;
								max = Math.max(max, mult * div);
								if(mult*div == target)
									min = target;
								else min = Math.min(min, mult + mult*div);
							}
				sb.append(max+" "+min+"\n");
			}
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
