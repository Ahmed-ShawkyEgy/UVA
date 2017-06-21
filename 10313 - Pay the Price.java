import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long[][]memo = new long[301][301];
		memo[0][0] = 1;
		for(int i = 1;i<301;i++)
		{
			for (int j = 0; j < 301; j++) 
			{
				int d = j-i;
				if(d<0)
					memo[i][j] = memo[i-1][j];
				else
					memo[i][j] = (long) memo[i-1][j] + (long) memo[i][d];
			}
		}
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l1 = -1,l2 = -1;
			if(st.hasMoreTokens())
				l1 = Math.min(300, Integer.parseInt(st.nextToken()) );
			if(st.hasMoreTokens())
				l2 = Math.min(300, Integer.parseInt(st.nextToken()) );
			if(l1 ==-1)
			{
				out.append(memo[n][n]+"\n");
			}
			else
			{
				if(l2==-1)
				{
					out.append(memo[l1][n]+"\n");
				}
				else
				{
					if(l1>0)
					{
						out.append(memo[l2][n]-memo[l1-1][n]+"\n");
					}
					else
					{
						out.append(memo[l2][n]+"\n");
					}
				}
			}
		}
		out.flush();
	}
}
