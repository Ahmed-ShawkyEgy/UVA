import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static boolean[][] chunk;
	static int[] chunkNum;
	static int[][] memo;
	static int dp(int ind,int last)
	{
		if(ind==chunk.length)
			return 0;
		if(memo[ind][last]!=-1)
			return memo[ind][last];
		int ans = (int)1e9;
		boolean hasLast = chunk[ind][last] ;
		
		for (int i = 0; i < 26; i++) 
			if(chunk[ind][i])
				ans = Math.min(ans,  chunkNum[ind] - (( (hasLast && chunkNum[ind]==1) || (hasLast && i!=last))?1:0) + dp(ind+1,i)    );
		
		return memo[ind][last] = ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			char[] arr = st.nextToken().toCharArray();
			chunk = new boolean [arr.length/k][27];
			
			for (int i = 0; i < chunk.length; i++) 
				for(int j = i*k;j<(i+1)*k;j++)
					chunk[i][arr[j]-'a'] = true; // i'th segment has the j'th character of the main string
			
			
			chunkNum = new int[chunk.length]; // Number of chunks for the i'th segment
			for (int i = 0; i < chunkNum.length; i++) {
				int c = 0;
				for(int j = 0;j<26;j++)
					if(chunk[i][j])
						c++;
				chunkNum[i] = c;
			}
			
			memo = new int[chunk.length][27];
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			
			sb.append(dp(0,26)+"\n");
		}
		System.out.print(sb);
	}
}
