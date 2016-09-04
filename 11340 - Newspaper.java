import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);	
		int t = Integer.parseInt(br.readLine());
		DecimalFormat f= new DecimalFormat("#0.00");
		while(t-->0)
		{
			int k  = Integer.parseInt(br.readLine());
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			while(k-->0)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				map.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
			}
			int m = Integer.parseInt(br.readLine());
			double ans =0;
			while(m-->0)
			{
				String s = br.readLine();
				for (int i = 0; i < s.length(); i++)
				{
					char x = s.charAt(i);
					if(map.containsKey(x))					
					{
						ans+=map.get(x)/100.0;
					}
				}
			}
			out.append(f.format(ans)+"$\n");
		}		
		out.flush();
	}
}
