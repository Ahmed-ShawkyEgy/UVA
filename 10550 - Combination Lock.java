import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			if(a1==0 && a2==0 && a3==0 && n==0)
				break;
			int ans = 120;//for turning 2 clockwise and one anti-clockwise
			if(a1>n)			
				ans+=40-a1+n;			
			else
				ans+=n-a1;
			if(a2>a1)
				ans+=a2-a1;
			else
				ans+=40-a1+a2;
			if(a3>a2)
				ans+=40-a3+a2;
			else
				ans+=a2-a3;
			out.append(ans*9+"\n");
		}
		out.flush();
	}
}
