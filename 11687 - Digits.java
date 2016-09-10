import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main {
	public static int solve(int counter,String cur,String last)
	{
		if(cur.equals(last))
			return counter;
		last = cur;
		cur = last.length()+"";
		return solve(++counter, cur, last);
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String s = br.readLine();
			if(s.charAt(0)=='E')
				break;
			out.append(solve(1,s.length()+"",s)+"\n");
		}
		out.flush();
	}
}
