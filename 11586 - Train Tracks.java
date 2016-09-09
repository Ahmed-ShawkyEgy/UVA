import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = 0;
			int f = 0;
			while(st.hasMoreTokens())
			{
				String s = st.nextToken();
				char a = s.charAt(0);
				char b = s.charAt(1);
				if(a=='F')
				{
					f++;
				}
				else
				{
					m++;
				}
				if(b=='F')
				{
					f++;
				}
				else
				{
					m++;
				}
			}
			if(m==f && m%2==0)
				out.append("LOOP\n");
			else
				out.append("NO LOOP\n");
		}
		out.flush();
	}
}
