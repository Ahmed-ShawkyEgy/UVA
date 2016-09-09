import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int well = Integer.parseInt(st.nextToken());
			if(well == 0)
				break;
			double dist = Integer.parseInt(st.nextToken());
			double slide = Integer.parseInt(st.nextToken());
			double f = Integer.parseInt(st.nextToken())/100.0;
			double pos = 0;
			int ans = 0;
			f = dist*f;
			while(pos>=0 && pos<=well)
			{
				ans++;
				if(dist>=0)
					pos += dist;
				if(pos>well)
					break;
				pos -= slide;				
				dist -= f;
				if(pos<0)
					break;
			}
			if(pos>well)
				out.append("success on day "+ans+"\n");
			else
				out.append("failure on day "+ans+"\n");
		}
		out.flush();
	}
}
