import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			String pos = "+x";
			st = new StringTokenizer(br.readLine());
			while(n-->1)
			{
				String s = st.nextToken();
				switch(pos)
				{
					case "+x":
					{
						switch(s)
						{
							case "+y":
							{
								pos = "+y";
							}break;
							case "-y":
							{
								pos = "-y";
							}break;
							case "+z":
							{
								pos = "+z";
							}break;
							case "-z":
							{
								pos = "-z";
							}break;
						}
					}
					break;
					case "-x":
					{
						switch(s)
						{
							case "+y":
							{
								pos = "-y";
							}break;
							case "-y":
							{
								pos = "+y";
							}break;
							case "+z":
							{
								pos = "-z";
							}break;
							case "-z":
							{
								pos = "+z";
							}break;
						}
					}
					break;
					case "+y":
					{
						switch(s)
						{
							case "+y":
							{
								pos = "-x";
							}break;
							case "-y":
							{
								pos = "+x";
							}break;
							case "+z":
							{
								pos = "+y";
							}break;
							case "-z":
							{
								pos = "+y";
							}break;
						}
					}
					break;
					case "-y":
					{
						switch(s)
						{
							case "+y":
							{
								pos = "+x";
							}break;
							case "-y":
							{
								pos = "-x";
							}break;
							case "+z":
							{
								pos = "-y";
							}break;
							case "-z":
							{
								pos = "-y";
							}break;
						}
					}
					break;
					case "+z":
					{
						switch(s)
						{
							case "+y":
							{
								pos = "+z";
							}break;
							case "-y":
							{
								pos = "+z";
							}break;
							case "+z":
							{
								pos = "-x";
							}break;
							case "-z":
							{
								pos = "+x";
							}break;
						}
					}
					break;
					case "-z":
					{
						switch(s)
						{
							case "+y":
							{
								pos = "-z";
							}break;
							case "-y":
							{
								pos = "-z";
							}break;
							case "+z":
							{
								pos = "+x";
							}break;
							case "-z":
							{
								pos = "-x";
							}break;
						}
					}
					break;
				}
			}
				out.append(pos+"\n");
		}
		out.flush();
	}
}
