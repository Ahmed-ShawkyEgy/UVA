import java.io.*;
import java.util.*;

public class Main
{
	static int n,k;
	static TreeSet<String> set;
	static char[] arr = {'A','C','G','T'};
	static String s;
	public static void bt(int ind,int cur,String last)
	{
		if(ind==n)
		{
			if(!set.contains(last))
				set.add(last);
			return;
		}
		if(cur>0)
		{
			for (int i = 0; i < arr.length; i++) 
			{
				bt(ind+1,cur-1,last+arr[i]);
			}
		}
		bt(ind+1,cur,last+s.charAt(ind));
	}
	public static void main(String[] args) throws Throwable 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(System.out);
	    int t = Integer.parseInt(br.readLine());
	    while(t-->0)
	    {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	n = Integer.parseInt(st.nextToken());
	    	k = Integer.parseInt(st.nextToken());
	    	s = br.readLine();
	    	set = new TreeSet<String>();
	    	bt(0,k,"");
	    	out.append(set.size()+"\n");
	    	for(String i: set)
	    	{
	    		out.append(i+"\n");
	    	}
	    }
	    out.flush();
	}
}
