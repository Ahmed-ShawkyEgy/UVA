import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		out.append("Lumberjacks:\n");
		while(t-->0)
		{
			boolean as = true, des = true;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int last = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 9; i++)
			{
				int x = Integer.parseInt(st.nextToken());
				if(x>last)
					des = false;
				if(x<last)
					as = false;
				last = x;
			}
			out.append((as || des)? "Ordered\n":"Unordered\n" );
		}
		out.flush();
	}
}
