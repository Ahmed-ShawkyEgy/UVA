import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[10];
			for (int i = 1; i <= n; i++) 
			{
				int cur = i;
				while(cur>0)
				{
					arr[cur%10]++;
					cur/=10;
				}
			}
			System.out.print(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				System.out.print(" "+arr[i]);
			}
			System.out.println();
		}
	}
}
