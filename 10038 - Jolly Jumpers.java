import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			boolean[] sol = new boolean[n];
			int last = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n-1; i++)
			{
				int x = Integer.parseInt(st.nextToken());
				int z = Math.abs(x-last);
				if(z<n)		
					sol[z]=true;
				last = x;
			}
			boolean flag = true;
			for (int i = 1; i < sol.length; i++) {
				if(!sol[i])
				{
					flag = false;
					break;
				}
			}
			if(flag)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
		}		
		out.flush();
	}
}
