import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[] word1,word2;
	static int[][] memo;
	static ArrayList<String> res;
	public static int dp(int i,int j)
	{
		if(i==word1.length || j==word2.length)
			return 0;
      
		if(memo[i][j]!=-1)
			return memo[i][j];
		
		int ans = dp(i+1,j); // leave
    
		for(int ind = j;ind<word2.length;ind++)
			if(word1[i].equals(word2[ind]))
			{
				ans = Math.max(ans,1 + dp(i+1,ind+1)); // take
				break;
			}
		
		return memo[i][j] = ans;
	}
	
	public static void print(int i,int j)
	{
		if(i==word1.length||j==word2.length)
			return;
      
		int ans = dp(i,j);
		if(ans==dp(i+1,j))
		{
			print(i+1, j);
			return;
		}
		
		for (int ind = 0; ind < word2.length; ind++) 
			if(word1[i].equals(word2[ind]))
				if(ans==1 + dp(i+1,ind+1))
				{
					res.add(word1[i]);
					print(i+1, ind+1);
					return;
				}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(br.ready())
		{
			ArrayList<String> list = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(true)
			{
				if(!st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				if(s.equals("#"))
					break;
				list.add(s);
			}
			word1 = new String[list.size()];
			for (int i = 0; i < word1.length; i++) 
				word1[i] = list.get(i);
			
			list = new ArrayList<String>();
			
			while(true)
			{
				if(!st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				if(s.equals("#"))
					break;
				list.add(s);
			}
			word2 = new String[list.size()];
			for (int i = 0; i < word2.length; i++) 
				word2[i] = list.get(i);
			
			memo = new int[word1.length][word2.length];
			res = new ArrayList<String>();
			for (int i = 0; i < memo.length; i++) 
				Arrays.fill(memo[i], -1);
			
			dp(0,0);
			print(0,0);
			for (int i = 0; i < res.size()-1; i++) 
				sb.append(res.get(i)+" ");
			
			sb.append(res.get(res.size()-1)+"\n");
		}
		System.out.print(sb);
	}
}
