import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
	public static int gauss(int n)
	{
		return (++n*(n-1)) >> 1;
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int oo = (int) 1e9;
		int N = 11,M = 101;
		int[][][] memo = new int[N][M][M];
		
		for(int i = 0;i<M;i++)	// Filling Base case the way mentioned in the problem description
		{
			int base = gauss(i);
			for(int j = i;j<M;j++)
				memo[1][i][j] = gauss(j) - base;
		}
		
		for(int i = 2;i<N;i++)			
			for(int hi = 0 ;hi < M;hi++)
					for(int lo = 0;lo+hi < M;lo++)
				{
					int ans = hi==0?0:oo;
					for(int x = lo+1;x<=hi+lo;x++)
					{
						int a = memo[i-1][lo][x-1] , b = memo[i][x][hi+lo];
						int max = Math.max(a , b);
						ans = Math.min(ans, x + max);
					}
					memo[i][lo][hi+lo] = ans;
				}
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			sb.append(memo[n][0][m]+"\n");
		}
		System.out.print(sb);
	}
}
