import java.util.*;
import java.io.*;

public class Main {
	static int ans;
	static String list;
	static int [] arr;
	static int n;
	public static void bt(int ind,int sum,String s)
	{
		if(ind == arr.length || sum>n)
		{
			if(sum>ans && sum<=n)
			{
				ans = sum;
				list = s;
			}
			return;
		}
		//take
		bt(ind+1,sum+arr[ind],s+" "+arr[ind]);
		//leave
		bt(ind+1,sum,s);
	}
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			list = "";
			n = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			arr = new int[len];
			for (int i = 0; i < len; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			bt(0,0,"");
			out.append(list.substring(1)+" sum:"+ans+"\n");
		}
		out.flush();
    }
}
