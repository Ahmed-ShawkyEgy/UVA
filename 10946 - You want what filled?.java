import java.util.*;
import java.util.Map.Entry;
import java.io.*;


public class YouWantWhatFilled {
	static char[][] arr;
	static int[] ii=  {1,-1,0,0};
	static int[] jj = {0,0,1,-1};
	static int count;
	public static void scan(int i,int j,char c)
	{
		if(isValid(i, j,c))
		{		
			arr[i][j] ='.';
			count++;
			for(int z =0;z<4;z++){
				scan(i+ii[z],j+jj[z],c);
			}
		}
	}
	public static boolean isValid(int i, int j,char c)
	{
		return i>=0 && i<arr.length && j>=0 && j<arr[i].length && arr[i][j]==c; 
	}
	public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(System.out);
		String s;
		int cases = 1;
		while(!(s=br.readLine()).equals("0 0"))
		{
			StringTokenizer st = new StringTokenizer(s);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr = new char[x][y];
			for (int i = 0; i <x; i++) {
				s = br.readLine();
				for (int j = 0; j < y; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			ArrayList<Hole> list = new ArrayList<Hole>();
			count = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < y; j++) {
					
					if(arr[i][j]!='.')
					{
						char c = arr[i][j];
						scan(i,j,c);
						Hole h = new Hole(c, count);
						list.add(h);
						count = 0;
					}
				}
			}
			Collections.sort(list);
			out.append("Problem "+cases+++":\n");
			for (int i = 0; i < list.size(); i++) {
				out.append(list.get(i).c +" "+list.get(i).size+"\n");
			}
		}
		out.flush();
    } 
	static class Hole implements Comparable<Hole>
	{
		char c;
		int size;
		public Hole(char x,int n)
		{
			c =x;
			size = n;
		}
		@Override
		public int compareTo(Hole o) {
			if(this.size!=o.size)
				return o.size-this.size;
			return this.c-o.c;
		}
		
	}
}
