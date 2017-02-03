import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int theta = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			if(a==0 && b==0 && v==0 && theta==0 && time==0)
				break;
			double distance =(double) ((1.0)*v/2)*time;
			double x =(double) (((1.0)*distance)*Math.cos(theta*Math.PI/180));
			double y =(double) (((1.0)*distance)*Math.sin(theta*Math.PI/180));
			int ans1 = (int) ((x+(a/2))/a);
			int ans2 = (int) ((y+(b/2))/b);
			System.out.println(ans1+" "+ans2);
		}
		out.flush();
		
	}
}
