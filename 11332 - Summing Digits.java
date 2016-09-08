import java.io.*;
import java.util.*;
public class Main{
	public static int solve(String s)
	{
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum+=Integer.parseInt(s.charAt(i)+"");			
		}
		if(sum<10)
			return (int)sum;
		return solve(sum+"");
	}	
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		while(true)
		{
			String s = br.readLine();
			if(s.equals("0"))
				break;
			out.append(solve(s)+"\n");
		}
		out.flush();
	}
}
