import java.util.*;
import java.io.*;


public class Main{
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		String s;
		boolean first = true;
		while(!(s=br.readLine()).equals("0"))
		{
			StringTokenizer st = new StringTokenizer(s);
			if(!first)
				System.out.println();
			else
				first = false;
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int a=0;a<n-5;a++)
			{
				for(int b = a+1;b<n-4;b++)
				{
					for(int c = b+1;c<n-3;c++)
					{
						for(int d = c+1;d<n-2;d++)
						{
							for(int e = d+1;e<n-1;e++)
							{
								for(int f = e+1;f<n;f++)
								{
									System.out.println(arr[a]+" "+arr[b]+" "+arr[c]+" "+arr[d]+" "+arr[e]+" "+arr[f]);
								}
							}
						}
					}
				}
			}
		}
    } 
	
}
