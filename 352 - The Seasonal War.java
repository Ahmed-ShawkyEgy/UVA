import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[] dx = {0,1,1,1,0  ,-1 ,-1 ,-1};
	static int[] dy = {1,1,0,-1,-1,-1 ,0 ,1};
	static char[][] arr;
	
	static void floodFill(int x,int y)
	{
		if(arr[x][y]=='0')return;
		arr[x][y] = '0';
		for(int z = 0 ; z < dx.length ; z++)
		{
			int nx = x + dx[z] , ny = y + dy[z];
			if(isValid(nx, ny))
				floodFill(nx, ny);
		}
	}
	
	static boolean isValid(int x,int y)
	{
		return x >= 0 && y>=0 && x < n && y<n;
	}
	
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(sc.ready())
		{
			n = sc.nextInt(); 
			arr = new char[n][n];
			
			for (int i = 0; i < n; i++) 
				arr[i] = sc.nextLine().toCharArray();
			
			int ans = 0;
			for(int i = 0 ; i < n;i++)
			{
				for (int j = 0; j < n; j++) 
				{
					if(arr[i][j] == '1')
					{
						ans++;
						floodFill(i, j);
					}
				}
			}
			sb.append("Image number "+cases+++" contains "+ans+" war eagles.\n");
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
