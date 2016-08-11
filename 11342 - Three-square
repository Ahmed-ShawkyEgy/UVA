import java.io.*;
import java.io.*;

public class Threesquare {
	public static int BinSearch(int beg,int req,int sum)
	{
		int end = 224;
		while(beg<=end)
		{
			int mid = (beg+end)/2;
			int ans = mid*mid;
			if(ans+sum==req)
				return mid;
			if(ans+sum>req)
				end=mid-1;
			else
				beg = mid+1;
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			boolean found = false;
			for(int a=0;a<224;a++)
			{
				for(int b=a;b<224;b++)
				{
					int c = BinSearch(b, n, (a*a)+(b*b));
					if(c!=-1)
						{
							System.out.println(a+" "+b+" "+c);
							found = true;
							break;
						}
				}
				if(found)break;
			}

			if(!found)System.out.println(-1);
		}
	}

}
