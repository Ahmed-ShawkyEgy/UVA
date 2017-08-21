import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n,arr[][];
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner((System.in));
		ArrayList<Pair> list = new ArrayList<Pair>();
		while(sc.ready())
			list.add(new Pair(sc.nextInt(), sc.nextInt()));
		
		Collections.sort(list);
		n = list.size();
		arr = new int[n][2];
		for(int i = 0; i<list.size();i++)
		{
			arr[i][0] = list.get(i).w;
			arr[i][1] = list.get(i).s;
		}
		int[] dp = new int[n+1];
		Arrays.fill(dp, (int)1e9);
		dp[0] = 0;
		for (int i = 0; i < n; i++) 
			for(int j = n;j>=0;j--)
				if(dp[j]+arr[i][0]<=arr[i][1])
					dp[j+1] = Math.min(dp[j+1], arr[i][0] + dp[j]); 
		
		int max = 0;
		for (int i = 0; i < dp.length; i++) 
			if(dp[i]<(int)1e9)
				max = i;
		
		System.out.println(max);
	}	
	static class Pair implements Comparable<Pair>
	{
		int w , s;
		public Pair(int w,int s)
		{
			this.w = w;
			this.s = s;
		}
		public int compareTo(Pair o) {
			return (s!=o.s)? s-o.s : w-o.w;
		}
	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		
		public Scanner(FileReader r){	br = new BufferedReader(r);}
		
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
