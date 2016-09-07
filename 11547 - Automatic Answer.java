import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t= Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			int ans = n*567;
			ans /=9;
			ans += 7492;
			ans *= 235;
			ans /= 47;
			ans -= 498;
			ans /= 10;
			out.append(Math.abs(ans%10) +"\n");
		}
		out.flush();
	}
}
