import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			while(n-->0)	
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(a==x || b==y)
				{
					out.append("divisa\n");
					continue;
				}
				if(a>x)
				{
					if(b>y)
						out.append("NE\n");
					else
						out.append("SE\n");
				}
				else
				{
					if(b>y)
						out.append("NO\n");
					else
						out.append("SO\n");
				}
			}
		}
		out.flush();
	}
}
