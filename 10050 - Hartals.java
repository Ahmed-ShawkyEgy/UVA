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
			int n = Integer.parseInt(br.readLine());
			int p = Integer.parseInt(br.readLine());
			int ans = 0;
			boolean[] taken = new boolean[n+1];
			for (int i = 0; i < p; i++)
			{
				int h = Integer.parseInt(br.readLine());
				int counter = 0;
				int day =-1;
				int ind=-1;
				for (int j = 0; j < n; j++)
				{
					day++;day%=7;
					counter++;
					ind++;
					if(counter==h)
					{
						counter=0;
						if(day!=5 && day!=6)
						{
							taken[ind] = true;
						}
					}
				}
			}
			for (int j =1 ; j < taken.length; j++) {
				if(taken[j])
					ans++;
			}
			System.out.println(ans);
			
		}		
		out.flush();
	}
}
