import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Throwable {
  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		DecimalFormat f = new DecimalFormat("0.00000");
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()); // Cows
			int w = Integer.parseInt(st.nextToken()); // Wining states
			int s = Integer.parseInt(st.nextToken()); // Show
			
			int den = w + c - s - 1;
			double ans = 1.0 / (c+w);
			ans *= (1.0 * w/den * c) + (1.0 * (w-1) / den * w);
      
			sb.append(f.format(ans)+"\n");
		}
		System.out.print(sb);
	}

}
