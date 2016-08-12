import java.util.*;
import java.io.*;


public class Main {
	static City[] cities;
	static PrintWriter out = new PrintWriter(System.out);
	static int min;
	static String ans;
	public static void generate()
	{
		ans = "";
		for (int a = 0; a < 21; a++) {
			for (int b = a+1; b < 22; b++) {
				for (int c = b+1; c < 23; c++) {
					for (int d = c+1; d < 24; d++) {
						for (int e = d+1; e < 25; e++)
						{
							int x = countSum(a, b, c, d, e);
							if(x<min)
							{
								ans = a + " " + b + " " + c + " " + d + " " + e;
								min = x;								
							}
							
						}
					}
				}
			}
		}
		out.append(ans+"\n");
	}
	public static int countSum(int a,int b,int c,int d,int e)
	{
		int ans = 0;
		int[] arr = {a,b,c,d,e};
		for(City i: cities)
		{
			int cur = Integer.MAX_VALUE;
			for(int j = 0;j<5;j++)
			{
				int x = (( (Math.abs(i.col-arr[j]%5))+(Math.abs(i.row-arr[j]/5)) ) * i.val);
				if(x<cur)
				{
					cur = x;
				}
			}
			ans+=cur;
		}
		return ans;
	}
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int num = Integer.parseInt(br.readLine());
			cities = new City[num];
			for (int i = 0; i < num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				City x = new City(r, c, p);
				cities[i] = x;
			}
			min = Integer.MAX_VALUE;
			generate();
		}
		out.flush();
    } 
	static class City
	{
		int row,col,val;
		public City(int r, int c,int v)
		{
			row = r;
			col = c;
			val = v;
		}
	}
	
}
