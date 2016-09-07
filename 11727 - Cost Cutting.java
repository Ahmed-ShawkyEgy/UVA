import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t= Integer.parseInt(br.readLine());
		int cases = 1;
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] arr = new int[3];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			out.append("Case "+cases++ +": "+arr[1]+"\n");
		}
		out.flush();
	}
}
