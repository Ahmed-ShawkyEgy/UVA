// The Problem statement is not correct; there is a blank line before each case  
import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);	
		int t = Integer.parseInt(br.readLine());
		int cases = 1;
		while(t-->0)
		{
			br.readLine();
			HashSet<Integer> set1 = new HashSet<Integer>();
			HashSet<Integer> set2 = new HashSet<Integer>();
			HashSet<Integer> set3 = new HashSet<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n1; i++)
			{
				set1.add(Integer.parseInt(st.nextToken()));
			}
			 st = new StringTokenizer(br.readLine());
			int n2 = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n2; i++)
			{
				set2.add(Integer.parseInt(st.nextToken()));
			}
			 st = new StringTokenizer(br.readLine());
			int n3 = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n3; i++)
			{
				set3.add(Integer.parseInt(st.nextToken()));
			}
			PriorityQueue<Integer>[] arr = new PriorityQueue[3];
			arr[0] = new PriorityQueue<Integer>();arr[1] = new PriorityQueue<Integer>();arr[2] = new PriorityQueue<Integer>();
			int max = 0;
			for (Integer i : set1)
			{
				if(!set2.contains(i) && !set3.contains(i))
				{
					arr[0].add(i);
				}				
			}
			max = Math.max(max, arr[0].size());
			for (Integer i : set2)
			{
				if(!set1.contains(i) && !set3.contains(i))
				{
					arr[1].add(i);
				}				
			}
			max = Math.max(max, arr[1].size());
			for (Integer i : set3)
			{
				if(!set2.contains(i) && !set1.contains(i))
				{
					arr[2].add(i);
				}				
			}
			max = Math.max(max, arr[2].size());
			out.append("Case #"+cases++ +":\n");
			for (int i = 0; i < arr.length; i++) 
			{
				if(arr[i].size()==max)
				{
					out.append((i+1)+" "+arr[i].size());
					while(!arr[i].isEmpty())
					{
						out.append(" "+arr[i].poll());
					}
					out.append("\n");
				}
			}
		}		
		out.flush();
	}
}
