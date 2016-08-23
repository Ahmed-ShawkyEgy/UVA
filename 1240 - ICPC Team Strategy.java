import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][][] mem;
	static int[][] arr; // arr [ mate ] [ time ]
	static final int oo = (int) 1e9;
	public static int dp(int last,int remT,int mask)
	{
		if(remT<0)
			return -oo;
		if(mem[last][remT][mask]!=-1)
			return mem[last][remT][mask];
		if(mask==(1<<(n))-1)
			if(remT<0)
				return -oo;
			else
				return 0;
		int ans = 0;
		for (int i = 0; i < arr[0].length; i++)
		{
			if((mask&1<<i)==0)
			for (int j = 0; j < 3; j++)
			{
				if(j!=last)
				{
					int cur = 1<<i | mask;
					ans = Math.max(ans, 1+dp(j,remT-arr[j][i],cur));
				}
			}
		}
		return mem[last][remT][mask] = ans;
	}
	
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		mem = new int[4][281][1<<12];
		while(t-->0)
		{
			fill();
			n = Integer.parseInt(br.readLine());
			arr = new int[4][n];
			for (int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			out.append(dp(3,280,0)+"\n");
		}
		out.flush();
    }
	public static void fill()
	{
		for (int i = 0; i < mem.length; i++)
		{
			for(int j = 0;j<mem[i].length;j++)
			{
				for(int z = 0; z<mem[i][j].length;z++)
				{
					mem[i][j][z] = -1;
				}
			}
		}
	}
	
}
