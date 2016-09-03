import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);		
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			String [] arr = new String[n];
			int ind = -1;
			for (int i = 0; i < n; i++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				String card = st.nextToken();
				int len = st.nextToken().length();
				while(len>0)
				{
					ind++;ind%=n;
					while(arr[ind]!=null)
						{
							ind++;ind%=n;
						}
					ind%=n;
					len--;
				}
				arr[ind] = card;
			}
			out.append(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				out.append(" "+arr[i]);
			}
			out.append("\n");
		}		
		out.flush();
	}
}
