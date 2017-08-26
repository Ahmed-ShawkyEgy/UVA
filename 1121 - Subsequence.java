import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,s;
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			n = sc.nextInt();
			s = sc.nextInt();
			
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) 
				arr[i] = sc.nextInt();
			
			int left = 0 , right = 0 , curSum = 0 , min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) 
			{
				curSum += arr[right++];
				while(left<right)
				{
					if(curSum-arr[left]<s)break;
					curSum -= arr[left++];
				}
				if(curSum>=s)min = Math.min(min, right-left);
			}
			sb.append((min==Integer.MAX_VALUE?0:min)+"\n");
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
		
		public boolean ready() throws IOException {return br.ready();}

	}

}
