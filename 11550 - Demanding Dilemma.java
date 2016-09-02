import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[n][m];
			for (int i = 0; i < n; i++) 
			{
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) 
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean flag = true;
			for (int i = 0; i < m; i++)
			{
				int count = 0;
				for (int j = 0; j < n; j++) 
				{
					if(matrix[j][i]==1)
						count++;
					if(count>2)
					{
						flag = false;
						break;
					}
				}
				if(!flag)
					break;
				if(count!=2)
				{
					flag = false;
					break;
				}
				for(int x = 0;x<i;x++)
				{
					boolean diff = false;
					for(int y = 0;y<n;y++)
					{
						if(matrix[y][x] != matrix[y][i])
						{
							diff = true;
							break;
						}
					}
					if(!diff)
					{
						flag = false;
						break;
					}
				}
				if(!flag)
				{
					break;
				}
			}
			if(flag)
				out.append("Yes\n");
			else
				out.append("No\n");
		}
		out.flush();
	}
}
