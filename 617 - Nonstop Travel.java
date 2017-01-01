import java.io.*;
import java.util.*;
public class Main{
	static int [][] arr;
	static double [] pos;
	public static boolean sim(int v)
	{
		for (int i = 0; i < arr.length; i++) 
		{
			int sum = arr[i][0] + arr[i][1] + arr[i][2];
			double t = (pos[i]*3600)/v;
			double cur = t%sum;
			if(cur>(arr[i][0]+arr[i][1]))
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{
			String s;
			while((s=br.readLine()).equals(""));
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			if(n==-1)
				break;
			arr = new int[n][3];
			pos = new double[n];
			for (int i = 0; i < n; i++) 
			{
				if(!st.hasMoreTokens())
					st =  new StringTokenizer(br.readLine());
				pos[i] = Double.parseDouble(st.nextToken());
				for (int j = 0; j < 3; j++) 
				{
					if(!st.hasMoreTokens())
						st =  new StringTokenizer(br.readLine());
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean found = false;
			out.append("Case "+cases+++":");
			StringBuilder sb = new StringBuilder();
			for (int v = 30; v <= 60; v++) 
			{
				if(sim(v))
				{
					int x = v;
					found = true;
					int i ;
					for (i = v+1; i <= 60; i++) 
					{
						if(sim(i))
							x = i;
						else
							break;
					}
					if(x==v)
						sb.append(" "+v+",");
					else
						sb.append(" "+v+"-"+x+",");
					v = i;
				}
			}
			if(found)
				out.append(sb.substring(0,sb.length()-1));
			else
				out.append(" No acceptable speeds.");
			out.append("\n");
		}
		out.flush();
	}
	
}	
