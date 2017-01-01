import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> arr = new ArrayList<Integer>(Integer.parseInt(st.nextToken()));
			while(st.hasMoreTokens())
				arr.add(Integer.parseInt(st.nextToken()));
			Collections.sort(arr);
			int x = arr.get((arr.size()-1 )>>1);
			int ans = 0;
			for (int i = 0; i < arr.size(); i++) 
			{
				ans += Math.abs(arr.get(i)-x);
			}
			out.append(ans+"\n");
		}
		out.flush();
	}
	
}	
