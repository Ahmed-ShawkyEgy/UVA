import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			if(h==0)
				break;
			int l = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int ans = 0 , last = h;
			for (int i = 0; i < l; i++)
			{
				int x = Integer.parseInt(st.nextToken());
				if(x<last)
					ans += (h - x) - (h - last);
				last = x;				
			}
			out.append(ans+"\n");
		}
		out.flush();
	}
}
