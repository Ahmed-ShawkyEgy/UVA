import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);	
		while(true)
		{
			int n = Integer.parseInt(br.readLine());	
			if(n==0)
				break;
			boolean flag = true;
			int[] arr = new int[n];
			Arrays.fill(arr, -1);
			for (int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(b+i<0 || b+i>=n || arr[i+b]!=-1)
				{
					flag = false;
					continue;
				}
				arr[i+b] = a;
			}
			if(!flag)
				out.append(-1+"\n");
			else
			{
				out.append(arr[0]+"");
				for (int i = 1; i < arr.length; i++) {
					out.append(" "+arr[i]);
				}
				out.append("\n");
			}
		}		
		out.flush();
	}
}
