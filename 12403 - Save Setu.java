import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		int ans = 0;
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("donate"))
			{
				int x = Integer.parseInt(st.nextToken());
				ans+=x;				
			}
			else
			{
				out.append(ans+"\n");
			}
		}
		out.flush();
	}
}
