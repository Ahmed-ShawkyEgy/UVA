import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		boolean first = true;
		while(t-->0)
		{
			if(first)
				first = false;
			else
				out.append("\n");
			StringTokenizer sts = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(sts.nextToken());
			String [] arr = new String[n];
			int[][] prices = new int[n][2];
			for(int i =0;i<n;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i] = st.nextToken();
				prices[i][0] = Integer.parseInt(st.nextToken());
				prices[i][1] = Integer.parseInt(st.nextToken());
			}
			int q = Integer.parseInt(br.readLine());
			while(q-->0)
			{
				int p = Integer.parseInt(br.readLine());
				int count = 0;
				String ans = "";
				for(int i = 0 ;i < n;i++)
				{
					if(p>=prices[i][0] && p<=prices[i][1])
					{
						count++;
						if(count>1)
							break;
						ans = arr[i];
					}
				}
				if(count==1)
					out.append(ans+"\n");
				else
					out.append("UNDETERMINED\n");
			}
		}
		out.flush();
    }
}
