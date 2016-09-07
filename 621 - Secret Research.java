import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String s = br.readLine();
			if(s.equals("1") || s.equals("4") || s.equals("78"))
			{
				out.append("+\n");
				continue;
			}
			if(s.charAt(0)=='9' && s.charAt(s.length()-1)=='4')
			{
				out.append("*\n");
				continue;
			}
			if(s.substring(s.length()-2).equals("35"))
			{
				out.append("-\n");
				continue;
			}
			out.append("?\n");
		}
		out.flush();
	}
}
