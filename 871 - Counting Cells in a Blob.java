import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	static int[][] arr;
	static int[] ii=  {1,-1,0,0,1,1,-1,-1};
	static int[] jj = {0,0,1,-1,1,-1,1,-1};
	static int max;
	static int count;
	public static void scan(int i,int j)
	{
		if(i>=0 && i<arr.length && j>=0 && j<arr[0].length && arr[i][j] == 1)
		{		
			count++;
			arr[i][j] = 0;
			for(int z =0;z<8;z++){
				scan(i+ii[z],j+jj[z]);
			}
		}
		max = Math.max(max, count);
	}
	public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		br.readLine();
		boolean first = true;
		while(t-->0)
		{
			ArrayList<String> grid = new ArrayList<String>();
			max = 0;			
			String s;
			int index = 0;
			while( br.ready() && !(s=br.readLine()).equals(""))
			{
				grid.add(s);
				index++;
			}
			int len = grid.get(0).length();
			arr = new int[index][len];
			for (int i = 0; i < index; i++) {
				for (int j = 0; j < len; j++) {
					arr[i][j] =Integer.parseInt( grid.get(i).charAt(j)  +"" );
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < len; j++) {
					if(arr[i][j] == 1)
					{
						count = 0;
						scan(i,j);
					}
				}
			}
			if(first){
				first = false;
				out.append(max+"\n");
			}
			else
			{
				out.append("\n"+max+"\n");
			}
		}
		out.flush();
    } 
}
