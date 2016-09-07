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
			if(s.length()>3)
			{
				out.append(3+"\n");
				continue;
			}
			char a = s.charAt(0);
			char b  = s.charAt(1);
			char c = s.charAt(2);
			if( (a=='o' && (b=='n' || c=='e')) || b=='n' && (c=='e'))
				out.append(1+"\n");
			else
			{
				out.append(2+"\n");
			}
			
		}
		out.flush();
	}
}
