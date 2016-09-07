import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{
			String s = br.readLine();
			if(s.charAt(0)=='*')
				break;
			if(s.length()==4)
				out.append("Case "+cases++ +": Hajj-e-Akbar\n");
			else
				out.append("Case "+cases++ +": Hajj-e-Asghar\n");
		}
		out.flush();
	}
}
