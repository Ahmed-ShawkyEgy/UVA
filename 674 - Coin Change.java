import java.io.*;
import java.util.*;

public class Main {
	static int[] arr = {1,5,10,25,50};
	static int[][] mem;
	public static int dp(int i , int s)
	{
		if(s==0){
			return 1;
		}
		if(s<0 || i>4)return 0;
		if(mem[i][s]!=-1)
		{
			return mem[i][s];
		}
		return mem[i][s] = dp(i,s-arr[i]) + dp(i+1,s);
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		mem = new int[5][8000];
		for(int i =0;i<5;i++)
			Arrays.fill(mem[i], -1);
		while(br.ready())
		{
			int n = Integer.parseInt(br.readLine());
			out.append(dp(0,n)+"\n");
		}
		out.flush();
	}
}

