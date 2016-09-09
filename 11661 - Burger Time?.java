import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			String s = br.readLine();
			int min = Integer.MAX_VALUE;
			int lastR = -1,lastD = -1;
			for (int i = 0; i < s.length(); i++) 
			{
				char c = s.charAt(i);
				switch (c) {
				case 'Z':
					min = 0;
					break;
				case 'R':
					if(lastD!=-1)
						min = Math.min(min, i-lastD);
						lastR = i;
					break;
				case 'D':
					if(lastR!=-1)
						min = Math.min(min, i-lastR);
					lastD = i;
					break;
				}
			}
			out.append(min+"\n");
		}
		out.flush();
	}
}
