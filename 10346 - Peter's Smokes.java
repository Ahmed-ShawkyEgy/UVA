import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==-1)
				break;
			int k = Integer.parseInt(st.nextToken());
			int ans = n;
			int buts = n;
			while(buts>=k)
			{
				ans += buts/k;
				buts = (buts/k)+(buts%k);
			}
			System.out.println(ans);
		}
	}
}
