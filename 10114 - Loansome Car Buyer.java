import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int duration = Integer.parseInt(st.nextToken());
			if(duration<0)
				break;
			double pay = Double.parseDouble(st.nextToken());
			double loan = Double.parseDouble(st.nextToken());
			double car = loan+pay;
			int m = Integer.parseInt(st.nextToken());
			double[] arr = new double[101];
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				String s = "0"+st.nextToken();
				double d = Double.parseDouble(s);
				arr[i] = d;
			}
			double dif = arr[0];
			car -= (car*dif);
			int ans = 0;
			int month =0;
			pay = loan/duration;
			while(loan>=car)
			{		
				month++;
				ans++;		
				if(arr[month]!=0)
					dif = arr[month];
				loan-= pay;
				car-= (car*dif);
			}
			if(ans>1)
				out.print(ans+" months\n");
			else
				if(ans==1)
				out.print("1 month\n");
				else
					out.print("0 months\n");
		}
		out.flush();
	}
}
