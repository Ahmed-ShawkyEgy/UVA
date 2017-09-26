import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main
{
	static final int oo = (int)1e9;
	public static void main(String[] args) throws Throwable 
	{
		 Scanner sc = new Scanner(System.in);
		 StringBuilder sb = new StringBuilder();
		 while(true)
		 {
			 int n = sc.nextInt();
			 if(n==0)break;
			 int[][] dp1 = new int[26][26] , dp2 = new int[26][26];
			 for (int i = 0; i < dp1.length; i++) 
			 {
				 Arrays.fill(dp1[i], oo);
				 Arrays.fill(dp2[i], oo);
				 dp1[i][i] = 0;
				 dp2[i][i] = 0;
			 }
			 for (int i = 0; i < n; i++) 
			 {
				char in = sc.next().charAt(0);
				char type = sc.next().charAt(0);
				char x = sc.next().charAt(0),y= sc.next().charAt(0);
				
				int a = x - 'A';
				int b = y - 'A';
				int v = sc.nextInt();
				if(in=='Y')
				{
					dp1[a][b] =  Math.min(dp1[a][b], v);
					if(type=='B')
						dp1[b][a] = Math.min(dp1[b][a], v);
				}
				else
				{
					dp2[a][b] =  Math.min(dp2[a][b], v);
					if(type=='B')
						dp2[b][a] =  Math.min(dp2[b][a], v);
				}
			 }
			 
			 floyd(dp1);
			 floyd(dp2);
			 
			 int p1 = sc.next().charAt(0)-'A' , p2 = sc.next().charAt(0)-'A';
			 ArrayList<Character> arr = new ArrayList<Character>();
			 int min = oo - 1000;
			 for (int i = 0; i < 26; i++) 
			 {
				 int cur = dp1[p1][i] + dp2[p2][i];
				 if(cur==min)
					 arr.add((char) (i+'A'));
				 else if(cur<min)
				 {
					 arr = new ArrayList<Character>();
					 min = cur;
					 arr.add((char) (i+'A'));
				 }
			 }
			 Collections.sort(arr);
			 if(arr.size()==0)
				 sb.append("You will never meet.");
			 else
			 {
				 sb.append(min);
				 for(char c : arr)
					 sb.append(" "+c);
				 
			 }
			 sb.append("\n");
		 }
		 System.out.print(sb);
	}
	
	
	static void floyd(int[][] dp)
	{
		for (int k = 0; k < dp.length; k++) 
			for (int i = 0; i < dp.length; i++) 
				for (int j = 0; j < dp.length; j++) 
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);	
	}
	
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}		
		public long nextLong() throws NumberFormatException, IOException {return Long.parseLong(next());}
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
