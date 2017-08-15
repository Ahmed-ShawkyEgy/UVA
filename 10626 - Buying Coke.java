import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,total,ones,fives,tens , oo = (int)1e9;
	static int[][][] memo;
	static int dp(int bottles,int f,int t)
	{
		int o = total - ((5 * f) + (10*t) ) - (8 * bottles);
		if(o<0 || t<0 || f<0) return oo;
		
		if(bottles==n)return 0;
		if(memo[bottles][f][t]!=-1) return memo[bottles][f][t];
		
		int ans = oo;
		if(o>=3 && t >= 1) ans = Math.min(ans, 4 + dp(bottles+1,f+1,t-1)); // 1 ten and 3 ones (there is a change value of 5)
		if(f>=2 && o >= 3) ans = Math.min(ans, 5 + dp(bottles+1,f-1,t));   // 2 fives and 3 ones (there is a change value of 5)
		if(t>=1)		   ans = Math.min(ans, 1 + dp(bottles+1,f,t-1));   // 1 ten
		if(f>= 1 && o>=3)  ans = Math.min(ans, 4 + dp(bottles+1,f-1,t));   // 1 five and 3 ones
		if(f>=2)		   ans = Math.min(ans, 2 + dp(bottles+1,f-2,t));   // 2 fives
		if(o>=8) 		   ans = Math.min(ans, 8 + dp(bottles+1,f,t));     // 8 ones
		return memo[bottles][f][t] = ans;		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			ones = Integer.parseInt(st.nextToken());
			fives = Integer.parseInt(st.nextToken());
			tens = Integer.parseInt(st.nextToken());
			
			memo = new int[n][200][150];
			for (int i = 0; i < memo.length; i++) 
				for (int j = 0; j < memo[i].length; j++) 
					Arrays.fill(memo[i][j], -1);
			total = ones + 5 * fives + 10 * tens;
			int ans = dp(0,fives,tens);
			sb.append(((ans<oo)?ans:0) +"\n");
		}
		System.out.print(sb);
	}
	 
}
