import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main
{
	static final int oo = (int)1e9;
	static int[][] path;
	static Queue<Integer> q;
	public static void main(String[] args) throws Throwable 
	{
		 Scanner sc = new Scanner(System.in);
		 int t = sc.nextInt();
		 StringBuilder sb = new StringBuilder();
		 while(t-->0)
		 {
			 int n = sc.nextInt();
			 int[][] dp = new int[n][n];
			 path = new int[n][n];
			 HashMap<String, Integer> nameToInd = new HashMap<String, Integer>();
			 HashMap<Integer, String> indToName = new HashMap<Integer, String>();
			 for (int i = 0; i < path.length; i++) 
			 {
				String s = sc.next();
				nameToInd.put(s, i);
				indToName.put(i, s);
			 }
			 for (int i = 0; i < n; i++) 
			 {
				 for (int j = 0; j < n; j++) 
				 {
					 dp[i][j] = sc.nextInt();
					 if(dp[i][j]==-1)dp[i][j] = oo;
					 path[i][j] = i;
				 }
			 }
			 
			 for(int k = 0;k<n;k++)
				 for (int i = 0; i < n; i++) 
					 for (int j = 0; j < n; j++) 
					 {
						 if(dp[i][k] + dp[k][j] < dp[i][j])
						 {
							 dp[i][j] = dp[i][k] + dp[k][j];
							 path[i][j] = path[k][j];
						 }
					 }
			 int p = sc.nextInt();
			 while(p-->0)
			 {
				 String s = sc.next();
				 String d1 = sc.next() , d2 = sc.next();
				 int a = nameToInd.get(d1);
				 int b = nameToInd.get(d2);
				 if(dp[a][b]==oo)
				 {
					 sb.append("Sorry Mr "+s+" you can not go from "+d1+" to "+d2+"\n");
				 }
				 else
				 {
					 sb.append("Mr "+s+" to go from "+d1+" to "+d2+", you will receive "+dp[a][b]+" euros\nPath:");
					 if(a==b)
					 {
						 sb.append(d1+" "+d1+"\n");
						 continue;
					 }
					 q = new LinkedList<Integer>();
					 getPath(a, b);
					 sb.append(indToName.get(q.poll()));
					 while(!q.isEmpty())
					 {
						 sb.append(" "+indToName.get(q.poll()));
					 }
					 sb.append("\n");
				 }
			 }
		 }
		 System.out.print(sb);
	}
	
	static void getPath(int a,int b)
	{
		if(a!=b)getPath(a, path[a][b]);
		q.add(b);
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
