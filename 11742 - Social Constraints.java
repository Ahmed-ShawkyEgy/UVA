import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
	static int[][] cons;
	public static int rec(int[] arr, int i)
	{
		if(i==arr.length)
		{
			if(isValid(arr))
				return 1;
			return 0;
		}
		int ans = 0;
		for (int j = 0; j < arr.length; j++) 
		{
			boolean valid = true;
			for (int k = 0; k < i; k++) 
			{
				if(arr[k] == j)
				{
					valid = false;
					break;
				}
			}
			if(valid)
			{
				arr[i] = j;
				ans+= rec(arr,i+1);
				arr[i] = 0;
			}
		}
		return ans;
	}
	public static boolean isValid(int[] arr)
	{
		int[] pos = new int[arr.length];
		for (int i = 0; i < pos.length; i++) 
		{
			pos[arr[i]] = i;
		}
		for (int i = 0; i < cons.length; i++) 
		{
				int a = cons[i][0];
				int b = cons[i][1];			
				int c = cons[i][2];
			if(c<0)
			{
				if(Math.abs(pos[a]-pos[b])<-c)
					return false;
			}
			else
			{
				if(Math.abs(pos[a]-pos[b])>c)
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			int[] arr = new int[n];
			cons = new int[m][3];
			for (int i = 0; i < m; i++) 
			{
				st = new StringTokenizer(br.readLine());
				cons[i][0] = Integer.parseInt(st.nextToken());
				cons[i][1] = Integer.parseInt(st.nextToken());
				cons[i][2] = Integer.parseInt(st.nextToken());				
			}
			out.append(rec(arr,0)+"\n");
		}
		out.flush();
	}
}
