import java.io.*;
import java.util.*;
public class Main{
	static ArrayList<Building> arr ;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new ArrayList<Building>();
		int bound = 0;
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken())-1;
			arr.add(new Building(b, h, e));
			bound = Math.max(bound, e);
		}
		int cur_pos = arr.get(0).beg;
		int cur_height = 0;
		int j = 0;
		ArrayList<Building> arrr = arr;
		while(cur_pos<=bound+1)
		{
			int max = 0;
			for (int i = j; i < arr.size(); i++) 
			{
				Building cur = arr.get(i);
				if(cur.beg>cur_pos)
					break;
				if(cur.beg<=cur_pos && cur.end>=cur_pos)
				{
					max = Math.max(max, cur.height);
				}
			}
			if(max != cur_height)
			{
				cur_height = max;
				sb.append(" "+cur_pos+" "+cur_height);
			}
			cur_pos ++;
		}
		System.out.println(sb.substring(1));
	}
	static class Building
	{
		int beg,height,end;
		public Building(int b,int h,int e)
		{
			beg = b;
			height = h;
			end = e;
		}
		public String toString()
		{
			return beg+" "+height+" "+end;
		}
	}
	
}	
