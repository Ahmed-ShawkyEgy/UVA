import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		while(t-->0)
		{
			String s;
			while((s=br.readLine()).equals(""));
			n = Integer.parseInt(s.trim());
			int[][] arr = new int[n<<1][n<<1];
			for (int i = 0; i < n; i++) 
			{
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) 
					arr[i+n][j] = arr[i][j+n] = arr[i+n][j+n] = arr[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < arr.length; i++) 
				for (int j = 0; j < arr.length; j++) 
				{
					if (i > 0) arr[i][j] += arr[i - 1][j];
					if (j > 0) arr[i][j] += arr[i][j - 1];
					if (i > 0 && j > 0) arr[i][j] -= arr[i - 1][j - 1];
				}
			
			int maxSubRect = Integer.MIN_VALUE; 
			for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) 
			for (int k = i; k < n+i; k++) for (int l = j; l < n+j; l++) { 
			int subRect = arr[k][l]; 
			if (i > 0) subRect -= arr[i - 1][l];
			if (j > 0) subRect -= arr[k][j - 1]; 
			if (i > 0 && j > 0) subRect += arr[i - 1][j - 1];
			maxSubRect = Math.max(maxSubRect, subRect); }
			
			sb.append(maxSubRect+"\n");
		}
		System.out.print(sb);
	}
	 
}
