import java.util.*;
import java.io.*;

public class  MazeExploration {
	static char[][] arr;
	static int[] ii=  {1,-1,0,0};
	static int[] jj = {0,0,1,-1};
	public static void paint(int i,int j)
	{
		if(isValid(i, j))
		{		
			arr[i][j] ='#';
			for(int z =0;z<4;z++){
				paint(i+ii[z],j+jj[z]);
			}
		}
	}
	public static boolean isValid(int i, int j)
	{
		return i>=0 && i<arr.length && j>=0 && j<arr[i].length && (arr[i][j] ==' ' || arr[i][j]=='*') ; 
	}
	public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			ArrayList<String> grid = new ArrayList<String>();
			String s ;
			do
			{
				s = br.readLine();
				grid.add(s);
			}while(s.charAt(0)!='_');
			
			int posi =-1,posj = -1;
			arr = new char[grid.size()][];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = new char[grid.get(i).length()];
				for (int j = 0; j < grid.get(i).length(); j++) {
					arr[i][j] = grid.get(i).charAt(j);
					if(arr[i][j] == '*')
					{
						posi = i;
						posj = j;
					}
				}
			}
			paint(posi, posj);
			for (int i = 0; i < arr.length-1; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					out.append(arr[i][j]+"");
				}
				out.append("\n");
			}
			out.append(s+"\n");
		}
		out.flush();
    } 
}
