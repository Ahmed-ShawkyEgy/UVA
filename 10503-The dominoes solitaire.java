import java.io.*;
import java.util.StringTokenizer;


public class Main{
	static int[][] arr;
	static int n,first,last;	
	static boolean found;
	public static void bt(int ind,int mask,int prev)
	{
		int[][] arrr = arr;;
		if(found)
			return;
		if(ind==n)
		{
			if(prev==last)
				found = true;
			return;
		}
		for (int i = 0; i < arr.length; i++) 
		{
			if(((1<<i)&mask)==0)
			{
				if(arr[i][0]==prev)
					bt(ind+1,(mask|(1<<i)),arr[i][1]);
				else if(arr[i][1]==prev)
					bt(ind+1,(mask|(1<<i)),arr[i][0]);
			}
		}
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			int m = Integer.parseInt(br.readLine());
			arr = new int[m][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			first = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			last = Integer.parseInt(st.nextToken());
			for(int i = 0;i<m;i++)
			{
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			found = false;
			bt(0,0,first);
			if(found)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
