import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> arr = new ArrayList<Integer>();
			while(st.hasMoreTokens())
			{
				int x = Integer.parseInt(st.nextToken());
				if(x==-999999)
					break;
				arr.add(x);
			}
			BigInteger ans = new BigInteger(Long.MIN_VALUE+"");
			for (int i = 0; i < arr.size(); i++) 
			{
				BigInteger cur = BigInteger.ONE;
				for (int j = i; j < arr.size(); j++) 
				{
					cur = cur.multiply(new BigInteger(arr.get(j)+""));
					ans = ans.max(cur);
					if(cur.toString().equals("0"))
						break;
				}
			}
			out.append(ans.toString()+"\n");
		}
		out.flush();
	}
	
}	
