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
			int l = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			if(l==0 && g==0 )
				break;
			Interval [] arr = new Interval[g];
			for (int i = 0; i < g; i++) 
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				arr[i] = new Interval(x-r, x+r);
			}
			Arrays.sort(arr);
			int ans = 0;
			int lastEnd = 0;
			boolean found = true;
			for(int i =0 ; found && lastEnd<l;)
			{
				found = false;
				int tmpEnd = lastEnd;
				for(;i<g && arr[i].beg<=lastEnd ;i++)
				{
					found = true;
					tmpEnd = Math.max(tmpEnd, arr[i].end);
				}
				if(tmpEnd!=lastEnd)
					ans++;
				lastEnd = tmpEnd;
			}
			if(!found)
				out.append(-1+"\n");
			else
				out.append((g-ans)+"\n");
		}
		out.flush();
	}
	static class Interval implements Comparable<Interval>
	{
		int beg,end;
		public Interval(int b,int e)
		{
			beg = b;
			end = e;
		}
		public int compareTo(Interval o) 
		{
			if(beg!=o.beg)
				return beg-o.beg;
			return o.end-end;
		}
	}
}	
