import java.io.*;
import java.util.*;
public class Main{
	static int bound ;
	public static int binarySearch(int n,int balls)
	{
		if(n>=bound)
			return n;
		int left = (n<<1), right = left+1;
		if(balls%2==0)return binarySearch(right, balls/2);
		return binarySearch(left, balls/2+1);
	}
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);	
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			if(d==-1)
				break;
			int ball = Integer.parseInt(st.nextToken());
			bound = 1<<(d-1);
			out.append(binarySearch(1, ball)+"\n");
		}
		out.flush();
	}
	
}	
