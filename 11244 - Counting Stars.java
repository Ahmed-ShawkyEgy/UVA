import java.util.*;
import java.io.*;


public class  CountingStars {
	static char[][] arr;
	static int[] ii=  {1,-1,0,0,1,-1,1,-1};
	static int[] jj = {0,0,1,-1,1,1,-1,-1};
	static int count;
	public static boolean isStar(int i,int j)
	{
		for (int z = 0; z <8; z++) {
			if(isValid(i+ii[z], j+jj[z]))
			{
				if(arr[i+ii[z]][j+jj[z]]=='*')
					return false;
			}
		}
		return true;
	}
	public static boolean isValid(int i, int j)
	{
		return i>=0 && i<arr.length && j>=0 && j<arr[i].length ; 
	}
	public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(System.out);
		String s;
		while(!(s=br.readLine()).equals("0 0"))
		{
			StringTokenizer st = new StringTokenizer(s);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr = new char[x][y];
			for (int i = 0; i < x; i++) {
				s = br.readLine();
				for (int j = 0; j < y; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			int ans = 0;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if(arr[i][j]=='*' && isStar(i, j))
						ans++;
				}
			}
			out.append(ans+"\n");
		}
		out.flush();
    } 
	
}
