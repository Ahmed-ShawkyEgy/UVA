import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static final int oo = (int) 1e3;
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				Arrays.fill(arr[i], 1);  // Each cell will have an area of 1, unless it was part of a block
			}
			while(m-->0)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r1 = Integer.parseInt(st.nextToken());
				int c1 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				for(int i = r1-1;i<r2;i++)
				{
					for(int j = c1-1;j<c2;j++)
					{
						arr[i][j] = -oo; // Filling all blocks with small dummy values
					}
				}
			}
			int ans = 0;
			for(int L = 0;L<n;L++) // Left Column
			{
				int[] tmp = new int[n];
				for(int R =L;R<n;R++) // Right Column
				{
					for(int row = 0;row<n;row++) // Adding the current column to my temp array 
					{
						tmp[row] += arr[R][row];
					}
					int cur= 0,max = 0;
					for(int i=0;i<n;i++) // O(n) Kadane's algorithm on the temp array
					{
						cur += tmp[i];
						max = Math.max(max, cur);
						cur = Math.max(cur, 0);
					}
					ans = Math.max(ans, max);
				}
			}
			out.append(Math.max(0, ans)+"\n");			
		}
		out.flush();
	}
}
