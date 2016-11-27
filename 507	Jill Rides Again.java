import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tt = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=tt;t++ )
		{
			int n = Integer.parseInt(br.readLine().trim());
			int beg = 1,end = 2,tmpb = 1,tmpe = 2;
			long max = 0,sum = 0;			
			for (int i = 1; i < n; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				sum+=x;
				if(sum>max)
				{
					max = sum;
					end = i+1;
					beg = tmpb;
					tmpe = i+1;
				}
				else
				{

					if(sum<0)
					{
						sum = 0;
						tmpb = i+1;
						tmpe = i+1;
					}
					else
					{
						tmpe = i+1;
						if(tmpe-tmpb>end-beg && sum==max)
						{
							beg = tmpb;
							end = tmpe;
						}
					}
				}
				
			}
			if(max==0)
			{
				System.out.println("Route "+t+" has no nice parts");
			}
			else
				System.out.println("The nicest part of route "+t+" is between stops "+beg +" and "+end);
		}
		
	}
}
