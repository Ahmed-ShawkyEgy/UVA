// Super naiive :D 
// better solutions exist

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int finalState = (1<<4)-1;
	static boolean [][][][] memo,visited;
	static boolean dp(int r1,int r2,int r3,int r4) // 4 bit masks for 4 rows
	{
		if(r1==finalState && r2 == finalState && r3 == finalState && r4 == finalState) return true;
		if(visited[r1][r2][r3][r4])return memo[r1][r2][r3][r4];
		boolean ans = false;
		
		// Size 1 pins
		for (int j = 0; j < 4; j++) 
		{
			if  ((r1&(1<<j))==0) 
					ans |= ! dp(r1|(1<<j),r2,r3,r4);
			
			if 	((r2&(1<<j))==0) 
				ans |= ! dp(r1,r2|(1<<j),r3,r4);
			
			if((r3&(1<<j))==0) 
				ans |= ! dp(r1,r2,r3|(1<<j),r4);

			if((r4&(1<<j))==0) 
				ans |= ! dp(r1,r2,r3,r4|(1<<j));
		}
		// Size 2 pins
		if((r1&(1|2))==0) 		   ans |= ! dp(r1|1|2, r2, r3, r4);
		if((r1&(4|8))==0) 		   ans |= ! dp(r1|4|8, r2, r3, r4);
		if((r1&1)==0 && (r2&1)==0) ans |= ! dp(r1|1 , r2|1 , r3 ,r4);
		if((r4&1)==0 && (r3&1)==0) ans |= ! dp(r1 , r2 , r3|1 ,r4|1);

		if((r2&(1|2))==0) 		   ans |= ! dp(r1, r2|1|2, r3, r4);
		if((r2&(4|8))==0) 		   ans |= ! dp(r1, r2|4|8, r3, r4);
		if((r1&2)==0 && (r2&2)==0) ans |= ! dp(r1|2 , r2|2 , r3 ,r4);
		if((r4&2)==0 && (r3&2)==0) ans |= ! dp(r1 , r2 , r3|2 ,r4|2);

		if((r3&(1|2))==0) 		   ans |= ! dp(r1, r2, r3|1|2, r4);
		if((r3&(4|8))==0) 		   ans |= ! dp(r1, r2, r3|4|8, r4);
		if((r1&4)==0 && (r2&4)==0) ans |= ! dp(r1|4 , r2|4 , r3 ,r4);
		if((r4&4)==0 && (r3&4)==0) ans |= ! dp(r1 , r2 , r3|4 ,r4|4);

		if((r4&(1|2))==0) 		   ans |= ! dp(r1, r2, r3, r4|1|2);
		if((r4&(4|8))==0) 		   ans |= ! dp(r1, r2, r3, r4|4|8);
		if((r1&8)==0 && (r2&8)==0) ans |= ! dp(r1|8 , r2|8 , r3 ,r4);
		if((r4&8)==0 && (r3&8)==0) ans |= ! dp(r1 , r2 , r3|8 ,r4|8);
		
		// Size 3 pins
		if((r1&(1|2|4))==0)			 		    	ans |= ! dp(r1|1|2|4, r2, r3, r4);
		if((r1&(2|4|8))==0) 		   				ans |= ! dp(r1|2|4|8, r2, r3, r4);
		if((r1&1)==0 && (r2&1)==0 && (r3&1)==0) 	ans |= ! dp(r1|1 , r2|1 , r3|1 ,r4);
		if((r4&1)==0 && (r3&1)==0 && (r2&1)==0) 	ans |= ! dp(r1 , r2|1 , r3|1 ,r4|1);

		if((r2&(1|2|4))==0)				 		    ans |= ! dp(r1, r2|1|2|4, r3, r4);
		if((r2&(2|4|8))==0) 		   			    ans |= ! dp(r1, r2|2|4|8, r3, r4);
		if((r1&2)==0 && (r2&2)==0 && (r3&2)==0) 	ans |= ! dp(r1|2 , r2|2 , r3|2 ,r4);
		if((r4&2)==0 && (r3&2)==0 && (r2&2)==0) 	ans |= ! dp(r1 , r2|2 , r3|2 ,r4|2);

		if((r3&(1|2|4))==0) 			   			ans |= ! dp(r1, r2, r3|1|2|4, r4);
		if((r3&(2|4|8))==0) 			   			ans |= ! dp(r1, r2, r3|2|4|8, r4);
		if((r1&4)==0 && (r2&4)==0 && (r3&4)==0)		ans |= ! dp(r1|4 , r2|4 , r3|4 ,r4);
		if((r4&4)==0 && (r3&4)==0 && (r2&4)==0)		ans |= ! dp(r1 , r2|4 , r3|4 ,r4|4);

		if((r4&(1|2|4))==0) 		   				ans |= ! dp(r1, r2, r3, r4|1|2|4);
		if((r4&(2|4|8))==0) 		   				ans |= ! dp(r1, r2, r3, r4|2|4|8);
		if((r1&8)==0 && (r2&8)==0 && (r3&8)==0)		ans |= ! dp(r1|8 , r2|8 , r3|8 ,r4);
		if((r4&8)==0 && (r3&8)==0 && (r2&8)==0)		ans |= ! dp(r1 , r2|8 , r3|8 ,r4|8);

		
		visited[r1][r2][r3][r4] = true;
		return memo[r1][r2][r3][r4] = ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int bnd = (1<<4);
		visited = new boolean[bnd][bnd][bnd][bnd];
		memo = new boolean[bnd][bnd][bnd][bnd];
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			String s;
			while((s=br.readLine()).isEmpty());
			char[][] arr = new char[4][4];
			arr[0] = s.toCharArray();
			for (int i = 1; i < 4; i++) 
				arr[i] = br.readLine().trim().toCharArray(); 
			int[] mask = new int[4];
			for (int i = 0; i < arr.length; i++)
				for (int j = 0; j < arr.length; j++) 
					if(arr[i][j]=='X')
						mask[i] |= (1<<j);
			
			boolean ans = dp(mask[0],mask[1],mask[2],mask[3]);
			sb.append(ans?"WINNING\n":"LOSING\n");
		}
		System.out.print(sb);
	}	
}
