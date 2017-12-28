import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n , m;
	static char[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static char water;
	static int dfs(int x,int y)
	{
		
		if(y<0) y = m-1;
		if(y>=m) y = 0;
		
		if(!(x >=0 && x< n) || arr[x][y]==water)
			return 0;
		
		int ans = 1;
		arr[x][y] = water;
		
		for (int i = 0; i < dx.length; i++) 
			ans += dfs(x+dx[i], y+dy[i]);
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();

		while(true)
		{
			
			try{
			n = sc.nextInt();
			}catch(Exception e)
			{
				break;
			}
			m = sc.nextInt();
			arr = new char[n][m];
			for (int i = 0; i < arr.length; i++) 
				arr[i] = sc.nextLine().toLowerCase().toCharArray();
			
			int xi = sc.nextInt() , yi = sc.nextInt();
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++) 
					if(arr[i][j] != arr[xi][yi])
						water = arr[i][j];
				
			
			dfs(xi,yi);
			
			int ans = 0;
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++) 
					ans = Math.max(ans, dfs(i,j));
			sb.append(ans+"\n");
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
