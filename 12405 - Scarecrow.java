import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for(int cases = 1;cases<=t;cases++)
		{
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int ans = 0;
			for (int i = 0; i < s.length(); i++) 
			{
				char c = s.charAt(i);
				if(c=='.')
				{
					ans++;
					i+=2;
				}
			}
			out.append("Case "+cases+": "+ans+"\n");
		}
		out.flush();
	}
}	
