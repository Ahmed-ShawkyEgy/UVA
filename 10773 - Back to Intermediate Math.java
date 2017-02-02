import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter out = new PrintWriter(System.out);
		DecimalFormat f = new DecimalFormat("0.000");
		for(int i = 1;i<=t;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			boolean flag = true;
			double d1 = (double)(1.0)*d/u;
			double d2 = 2;
			try
			{
				d2 = Math.sqrt(u*u - v*v);
				d2 = d / d2;
				if(Double.isNaN(d2) || Double.isInfinite(d2) || v==0)
					throw new Exception();
			}
			catch(Exception e)
			{
				flag = false;
			}
			out.append("Case "+i+": ");
			if(flag)
				out.append(f.format(Math.abs(d1-d2))+"\n");
			else
				out.append("can't determine\n");
		}
		out.flush();
	}
}
