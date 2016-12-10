import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main{
	static HashSet<Integer> set;
	static boolean visited[][][];
	static int arr[],sign[];
	static final int offSet = 3000;
	public static void dp(int i,int open,int val)
	{
		if(visited[i][open][val+offSet])
			return;
		visited[i][open][val+offSet] = true;
		if(i==arr.length)
		{
			set.add(val);
			return;
		}
		int nval = val + arr[i] * sign[i] * ((open%2==0)? 1:-1); 
		if(sign[i]==-1)
			dp(i+1,open+1,nval);
		if(open>0)
			dp(i+1,open-1,nval);
		dp(i+1,open,nval);
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(br.ready())
		{
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			set = new HashSet<Integer>();
			arr = new int[1+((st.countTokens()-1)/2)];
			sign = new int[arr.length];
			visited = new boolean[arr.length+1][arr.length+1][6001];
			arr[0] = Integer.parseInt(st.nextToken());
			sign[0] = 1;
			int i = 1;
			while(st.hasMoreTokens())
			{
				char c = st.nextToken().charAt(0);
				if(c=='+')
					sign[i] = 1;
				else
					sign[i] = -1;
				arr[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			int[] arrr = arr;
			int[] signn = sign;
			dp(0,0,0);
			System.out.println(set.size());
		}
	}

}
