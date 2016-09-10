import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		int cases = 1;
		while(t-->0)
		{
			String s = br.readLine();
			int[] arr = new int[100];
			int pointer = 0;
			for (int i = 0; i < s.length(); i++)
			{
				char c = s.charAt(i);
				switch (c) 
				{
					case '>':
					{
						pointer++;
						if(pointer>99)
							pointer=0;
					}
					break;
					case '<':
					{
						pointer--;
						if(pointer<0)
							pointer = 99;
					}
					break;
					case '+':
					{
						arr[pointer]++;
						if(arr[pointer]>255)
							arr[pointer]=0;
					}
					break;
					case '-':
					{
						arr[pointer]--;
						if(arr[pointer]<0)
							arr[pointer]=255;
					}
					break;
				}
			}
			out.append("Case "+cases++ +": "+getVal(arr[0]));
			for (int i = 1; i < arr.length; i++) {
				out.append(" "+getVal(arr[i]));
			}
			out.append("\n");
		}
		out.flush();
	}
	public static String getVal(int n)
	{
		String s = Integer.toHexString(n).toUpperCase();
		if(s.length()==1)
		{
			s = "0"+s;
		}
		return s;
	}
}
