import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		boolean first = true;
		while(t-->0)
		{
			br.readLine();
			int m = Integer.parseInt(br.readLine().trim());
			ArrayList<Interval> arr = new ArrayList<Interval>();
			if(!first)
				out.append("\n");
			first = false;
			while(true)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(x==0 && y==0)
					break;
				if(y>=0)
				arr.add(new Interval(x,y));
			}
			Collections.sort(arr);
			int ans = 0;
			ArrayList<Interval> res = new ArrayList<Interval>();
			int lastEnd = 0;
			boolean flag = true;
			for(int i =0 ;flag && lastEnd<m;)
			{
				flag = false;
				int tmp = lastEnd,tmpbeg = 0;
				for(;i<arr.size() && arr.get(i).beg<=lastEnd;i++)
				{
					flag = true;
					if(arr.get(i).end>tmp)
					{
						tmp = arr.get(i).end;
						tmpbeg = arr.get(i).beg;
					}
				}
				if(tmp!=lastEnd)
				{
					ans++;
					res.add(new Interval(tmpbeg,tmp));
				}
				lastEnd = tmp;
			}
			if(lastEnd<m)
			{
				out.append(0+"\n");
				continue;
			}
			Collections.sort(res);
			out.append(ans+"\n");
			for (int i = 0; i < res.size(); i++) 
			{
				out.append(res.get(i)+"\n");
			}
		}
		out.flush();
	}
	static class Interval implements Comparable<Interval>
	{
		int beg,end;
		public Interval(int x,int y)
		{
			this.beg = x;
			this.end = y;
		}
		public int compareTo(Interval o) 
		{
			if(beg!=o.beg)
				return this.beg-o.beg;
			return o.end-this.end;
		}
		public String toString()
		{
			return beg+" "+end;
		}
	}
}	
