import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static long memo[][];
	static ArrayList<Integer> scores;
	public static long dp(int ind,int s)
	{
		if(s<0)
			return 0;
		if(ind==3)
			return s==0? 1:0;
		if(memo[ind][s]!=-1)
			return memo[ind][s];
		long ans = 0;
		for(int i = 0;i<scores.size() && s-scores.get(i)>=0;i++)
		{
			ans += (long) dp(ind+1,s-scores.get(i));
		}
		return memo[ind][s] = ans;
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		scores = new ArrayList<Integer>(60);
		scores.add(0);
		boolean [] found = new boolean [61];
		for(int i = 1;i<=20;i++)
		{
			scores.add(i);
			found[i] = true;
		}
		int count = 1;
		for(int i = 21;i<=40;i++)
		{
			int x = (count++) * 2 ;
			if(!found[x])
				scores.add( x );
			found[x] = true;
		}
		count = 1;
		for(int i = 41;i<=60;i++)
		{
			int x = (count++) * 3 ;
			if(!found[x])
				scores.add( x );
			found[x] = true;
		}
		found[50] = true;
		scores.add(50);
		Collections.sort(scores);
		StringBuilder sb = new StringBuilder(70);
		for (int i = 0; i < 70; i++) {
			sb.append('*');
		}
		int bound = scores.get(scores.size()-1)+1;
		int[][][] taken = new int[bound][bound][bound];		
		int cases = 0;
		memo  = new long[3][1001];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			cases ++;
			n = Integer.parseInt(st.nextToken());
			if(n<=0)
				break;
			int comb = 0;
			for(int i = 0;i<scores.size();i++)
			{
				for(int j = 0;j<scores.size();j++)
				{
					int a = scores.get(i),b = scores.get(j);
					int c = n-(a+b);
					try{
						if(found[c])
						{
							if(taken[a][b][c]<cases && taken[a][c][b]<cases && taken[b][a][c]<cases && taken[b][c][a]<cases && taken[c][a][b]<cases && taken[c][b][a]<cases)
							{
								taken[a][b][c] = cases;
								comb++;
							}
						}
					}
					catch(Exception e)
					{						
					}
				}
			}
			if(comb>0)
			{
				out.append("NUMBER OF COMBINATIONS THAT SCORES "+n+" IS "+comb+".\n");
				out.append("NUMBER OF PERMUTATIONS THAT SCORES "+n+" IS "+dp(0,n)+".\n");
			}
			else
			{
				out.append("THE SCORE OF "+n+" CANNOT BE MADE WITH THREE DARTS.\n");
			}
			out.append(sb+"\n");
		}
		out.append("END OF OUTPUT\n");
		out.flush();
	}
}
