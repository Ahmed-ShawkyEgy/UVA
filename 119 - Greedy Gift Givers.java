import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		boolean first = true;
		while(br.ready())
		{
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			HashMap<Integer, String> inv = new HashMap<Integer, String>();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				String s = st.nextToken();
				map.put(s, i);
				inv.put(i, s);
			}
			for (int i = 0; i < n; i++) 
			{
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int val = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				if(m!=0 && val!=0)
				{
					int give = val/m; 
					while(m-->0)
					{
						arr[map.get(st.nextToken())] += give;
						arr[map.get(s)]-=give;
					}
				}
			}
			if(!first)
				out.append("\n");
			first = false;
			for (int i = 0; i < arr.length; i++) 
			{
				out.append(inv.get(i)+" "+arr[map.get(inv.get(i))]+"\n");
			}
		}
		out.flush();
	}
}
