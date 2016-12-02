import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
	public static boolean isValid(String a,String b)
	{
		if(a.length()>5 || b.length()>5)
			return false;
		boolean [] arr = new boolean[10];
		int count = 0;
		for (int i = 0; i < a.length(); i++) 
		{
			char x = (char) (a.charAt(i)-48);
			if(arr[x])
				return false;
			arr[x] = true;
			count++;
		}
		for (int i = 0; i < b.length(); i++) 
		{
			char x = (char) (b.charAt(i)-48);
			if(arr[x])
				return false;
			arr[x] = true;
			count++;
		}
		if(count!=10)
			return false;
		return true;
	}
	public static String addZeros(String s)
	{
		String res = "";
		while(res.length()+s.length()<5)
		{
			res+="0";
		}
		return res+s;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			if(!first)
				out.append("\n");
			first = false;
			boolean found = false;
			for (int a = 0; a <=9; a++) 
			{
				for (int b = 0; b <=9; b++) 
				{
					if(b==a)
						continue;
					for (int c = 0; c <=9; c++) 
					{
						if(c==a || c==b)
							continue;
						for (int d = 0; d <=9; d++) 
						{
							if(d==a || d==b || d==c)
								continue;
							for (int e = 0; e <=9; e++) 
							{
								if(e==a || e==b || e==c || e==d)
									continue;
								String yy = a+""+b+""+c+""+d+""+e;
								int y = Integer.parseInt(yy);
								int x = y*n;
								String xx = x+"";
								xx = addZeros(xx);
								yy = addZeros(yy);
								if(isValid(xx+"", yy+""))
								{
									found = true;
									out.append(xx+" / "+yy+" = "+n+"\n");
								}
							}
						}
					}
				}
			}
			if(!found)
				out.append("There are no solutions for "+n+".\n");
		}
		out.flush();
	}
}
