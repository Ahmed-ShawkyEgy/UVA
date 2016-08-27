import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class Main {
	static double[] mem;	
	static int[][] arr;
	static int n; // Assume n = n<<1
	static int count = 1;
	public static double dp(int mask)
	{
		if(mem[mask]!=-1)
			return mem[mask];
		if(mask==(1<<n)-1)
			return 0;
		double ans = (int) 1e9;
		for(int i =0;i<arr.length;i++)
		{			
			if(!isOne(i, mask))
			{
				int cur = put(i,mask);
				for(int j = 0;j<arr.length;j++)
				{
					if(!isOne(j, cur))
					{
						int x = put(j,cur);
						double tmp = Math.abs(arr[i][0]-arr[j][0]);
						tmp *=tmp;
						int tmp2=Math.abs(arr[i][1]-arr[j][1]);
						tmp2 *=tmp2;
						tmp+=tmp2;
						tmp = Math.sqrt(tmp);
						ans = Math.min(ans, tmp + dp(x));
					}
				}
			}
		}
		return mem[mask] = ans;
	}
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		mem = new double[1<<18];
		int cases = 1;
		DecimalFormat f = new DecimalFormat("#0.00");
		while(true)
		{
			n = Integer.parseInt(br.readLine());
			if(n==0)break;
			Arrays.fill(mem, -1);
			n<<=1;
			arr = new int[n][2];
			for(int i =0;i<n;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[i][0] = x;  arr[i][1] = y;
			}
			out.append("Case "+cases++ +": ");
			double ans = dp(0);
			out.append(f.format(ans)+"\n");
		}
		out.flush();
    }
	public static boolean isOne(int ind,int mask)
	{
		return ((1<<ind)&mask) !=0;
	}
	public static int take(int ind,int mask)
	{
		return mask^(1<<ind);
	}
	public static int put(int ind,int mask)
	{
		return mask | (1<<ind);
	}
}
