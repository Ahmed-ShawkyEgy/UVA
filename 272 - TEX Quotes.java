import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		while(br.ready())
		{
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				char x = s.charAt(i);
				if(x=='"')
				{
					if(first)
					{
						first = false;
						out.append("``");
					}
					else
					{
						first = true;
						out.append("''");
					}
				}
				else
					out.append(x);
			}
			out.append("\n");
		}
		out.flush();
	}
}
