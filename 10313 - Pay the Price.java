import java.util.*;
import java.io.*;

public class Main{
	public static void generate(long[][] arr)
	{
		for (int i = 1; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++) 
			{
				long dif = j-i;
				if(dif<0)
					dif = arr[i-1][j];
				else
					dif = arr[i][(int)dif]+arr[i-1][j];
				arr[i][j] = dif;
				
			}
		}
	}
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long[][] arr = new long[301][301];
		arr[0][0] = 1;	
		generate(arr);
		while(br.ready())
		{	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l1 = -1, l2 = -1;
			if(st.hasMoreTokens()) l1 = Integer.parseInt(st.nextToken());
			if(st.hasMoreTokens()) l2 = Integer.parseInt(st.nextToken());
			if(l1>300)
				l1 = 300;
			if(l2>300)
				l2 = 300;
			if(l1!=-1)
			{
				if((l2!=-1))
				{		
					if(l1!=0)				
						out.append((arr[l2][n]-arr[l1-1][n])+"\n");
					else
						out.append((arr[l2][n])+"\n");
				}
				else
				{
					out.append(arr[l1][n]+"\n");
				}
			}
			else
			{
				out.append(arr[n][n]+"\n");
			}
		}		
		out.flush();
    }	
}
