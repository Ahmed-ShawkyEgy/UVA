import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
	static int[] arr;
	static int req;
	static boolean pos;
	public static boolean rec(int i,int sum)
	{
		if(pos)
			return true;
		if(sum>req)
			return false;
		if(i==arr.length)
		{
			if(sum==req)
			{
				pos = true;
				return true;
			}
			return false;
		}
		boolean a = rec(i+1,sum+arr[i]);
		boolean b = rec(i+1,sum);
		return a || b || pos;		
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			req = Integer.parseInt(br.readLine());
			int p = Integer.parseInt(br.readLine());
			arr = new int[p];
			pos = false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) 
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			if(rec(0,0))
			{
				out.append("YES\n");
			}
			else
				out.append("NO\n");
		}
		out.flush();
	}
}
