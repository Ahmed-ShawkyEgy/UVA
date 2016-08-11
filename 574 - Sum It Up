import java.util.*;
import java.io.*;

public class  Sum_It_Up {
	static boolean found;
	static PrintWriter out = new PrintWriter(System.out);
	static boolean[] taken;
	static ArrayList<String> last;
	public static void dfs(int index, int target,int sum,int[] arr)
	{
		if(sum==target)
		{
			found = true;
			boolean first = true;
			StringBuilder sb = new StringBuilder();
			for(int i =0;i<taken.length;i++)
			{
				if(taken[i])
				{
					if(first)
					{
						first = false;
						sb.append(arr[i]+"");
					}
					else
						sb.append("+"+arr[i]);
				}
			}
			if(isValid(sb))
				{
					last.add(sb.toString());
					out.append(sb.toString()+"\n");
				}
			
			
		}
		if(sum<target)
		{
			for(int i =index;i<arr.length;i++)
			{
				if(!taken[i] && sum+arr[i]<=target)
				{
					taken[i] = true;
					dfs(i,target,sum+arr[i],arr);
					taken[i] = false;
				}
			}
		}
	}
	public static boolean isValid(StringBuilder sb)
	{
		for (int i = 0; i < last.size(); i++) {
			if(sb.toString().equals(last.get(i)))
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String s ;
		while(!(s=br.readLine()).equals("0 0"))
		{
			StringTokenizer st = new StringTokenizer(s);
			int t = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for(int i =0;i<arr.length;i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			found = false;
			taken = new boolean[n];
			last = new ArrayList<String>();
			out.append("Sums of "+t+":\n");
			dfs(0, t, 0, arr);
			if(!found)
				out.append("NONE\n");
		}
		out.flush();
    }  
}
