import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String s = "Happy birthday to you Happy birthday to you Happy birthday to Rujia Happy birthday to you";
		String[] arr = new String[n];
		boolean all = false;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}
		int i = 0;
		while(!all)
		{
			StringTokenizer st = new StringTokenizer(s);
			while(st.hasMoreTokens())
			{
				out.append(arr[i]+": "+st.nextToken()+"\n");
				i++;
				if(i==n)
					all = true;
				i%=n;
			}
		}
		out.flush();
	}
}
