import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==-1)
				break;
			int ans1 ,ans2;
			if(a>=b)
			{
				ans1 = a-b;
				ans2 = b+100-a;
			}
			else
			{
				ans1 = b-a;
				ans2 = a+100-b;
			}
			out.append(Math.min(ans2, ans1)+"\n");
		}
		out.flush();
	}
}
