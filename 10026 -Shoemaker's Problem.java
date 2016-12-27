import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		while(t-->0)
		{
			br.readLine();
			if(!first)
				out.append("\n");
			first =false;
			int n = Integer.parseInt(br.readLine());
			Task[] arr = new Task[n];
			for (int i = 0; i < arr.length; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				Task x = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i+1);
				arr[i] = x;
			}
			Arrays.sort(arr);
			out.append(arr[0].ind+"");
			for (int i = 1; i < arr.length; i++) 
			{
				out.append(" "+arr[i].ind);
			}
			out.append("\n");
		}
		out.flush();
	}
	static class Task implements Comparable<Task>
	{
		int time , fine,ind;
		public Task(int t,int f,int i)
		{
			time = t;
			fine = f;
			ind = i;
		}
		public int compareTo(Task o) 
		{
			int x = time*o.fine-o.time*fine;
			if(x==0)
			return this.ind-o.ind;
			return x;
		}
	}
}
