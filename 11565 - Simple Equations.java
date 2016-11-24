import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

public class Main{
	static int a,b,c;
	public static boolean isValid(int x,int y,int z)
	{
		return x+y+z==a && x*y*z==b && ((x*x)+(y*y)+(z*z))==c;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			boolean found = false;
			for (int x = -101; x < 101; x++) 
			{
				boolean flag = false;
				for (int y = x+1; y < 101; y++) 
				{
					boolean flag2 = false;
					for (int z = y+1; z < 101; z++) 
					{
						if(isValid(x, y, z))
						{
							flag2 = true;
							flag = true;
							found = true;
							System.out.println(x+" "+y+" "+z);
							break;
						}
					}
					if(flag2)
						break;
				}
				if(flag)
					break;
			}
			if(!found)
				System.out.println("No solution.");
				
		}
	}
}
