import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main{
	
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat f = new DecimalFormat("#0.000");
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			double cur = 0;			
			int a = Integer.parseInt(st.nextToken());
			st.nextToken();
			st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			if(b==0)
				break;
			double cons = b;
			int last = 0, lastLeak = 0;
			double leak = 0;
			double ans = 0;
			l1 : while(true) 
			{
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				cur += (cons*(a-last)*1.0)/100;
				cur += (leak*(a-lastLeak)*1.0);
				ans = Math.max(ans, cur);
				last = a;
				lastLeak = a;
				String s = st.nextToken();
				switch(s)
				{
					case "Fuel":
					{
						st.nextToken();
						cons = Integer.parseInt(st.nextToken());
						break;
					}
					case "Leak":
					{
						leak++;
						break;
					}
					case "Gas":
					{
						st.nextToken();
						cur = 0;
						break;
					}
					case "Mechanic":
					{
						leak =0;
						break;
					}
					case "Goal":
					{
						break l1;
					}
				}
			}
			System.out.println(f.format(ans));
		}
	}

}
