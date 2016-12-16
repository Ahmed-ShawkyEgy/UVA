import java.io.*;
import java.util.*;
public class Main{

	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			int[] dragon = new int[n];
			int[] knight = new int[m];
			for (int i = 0; i < n; i++)
				{
				st = new StringTokenizer(br.readLine());
					dragon[i] = Integer.parseInt(st.nextToken());
				}
			for (int i = 0; i < m; i++) 
				{
					st = new StringTokenizer(br.readLine());
					knight[i] = Integer.parseInt(st.nextToken());
				}
			Arrays.sort(dragon);
			Arrays.sort(knight);
			int ans = 0;
			int i = 0,j=0;
			boolean found = false;
			while(i<n)
			{
				found = false;
				for(;j<m && !found;j++)
				{
					if(knight[j]>=dragon[i])
						{
							found = true;
							ans+=knight[j];
						}
				}
				if(!found)
					break;
				i++;
			}
			if(!found)
				out.append("Loowater is doomed!\n");
			else
				out.append(ans+"\n");
		}
		out.flush();
	}
}	
