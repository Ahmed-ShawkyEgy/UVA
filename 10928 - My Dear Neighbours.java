import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		boolean first = true;
		while(t-->0)
		{
			if(!first)
				br.readLine();
			first = false;
			int p = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE;
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < p; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int count = 0;
				while(st.hasMoreTokens())
				{
					st.nextToken();
					count++;
				}
				if(count<min)
				{
					q.clear();
					min = count;
					q.offer(i+1);
				}
				else
				{
					if(count==min)
					{
						q.offer(i+1);
					}
				}
			}
			out.append(q.poll()+"");			
			while(!q.isEmpty())
			{
				out.append(" "+q.poll());
			}
			out.append("\n");
		}
		out.flush();
	}
}
