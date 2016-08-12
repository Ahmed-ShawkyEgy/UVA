import java.util.*;
import java.io.*;


public class Main{
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String s;
		PrintWriter out = new PrintWriter(System.out);
		while(!(s=br.readLine()).equals("0"))
		{
			int n = Integer.parseInt(s);
			long i = 1;
			long min = Long.MAX_VALUE;
			while(i<n)
			{
				long j = i;
				for(;j<n;j*=3);
				min = Math.min(min, j);
				i<<=1;
			}
			min = Math.min(min, i);
			out.append(min+"\n");
			
		}
			out.flush();
			br.close();
    } 
	
}
