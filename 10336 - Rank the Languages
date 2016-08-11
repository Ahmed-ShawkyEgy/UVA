import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class  RankTheLanguages {
	static char[][] arr;
	static int[] ii=  {1,-1,0,0};
	static int[] jj = {0,0,1,-1};
	public static void scan(int i,int j,char c)
	{
		if(i>=0 && i<arr.length && j>=0 && j<arr[0].length && arr[i][j] == c)
		{
			arr[i][j] = '.';
			for(int z =0;z<4;z++)
				scan(i+ii[z],j+jj[z],c);
		}
	}
	public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		int world = 1;
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			arr = new char[row][col];
			for(int i =0;i<row;i++)
			{
				String s = br.readLine();
				for(int j = 0;j<s.length();j++)
				{
					arr[i][j] = s.charAt(j);
				}
			}
			TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
			for(int i =0;i<row;i++)
			{
				for (int j = 0; j < col; j++) {
					char c = arr[i][j];
					if(c!='.')
					{
						scan(i,j,c);
						if(map.containsKey(c))
						{
							int val = map.get(c);
							map.put(c, val+1);
						}
						else
						{
							map.put(c, 1);
						}
					}	
				}
			}
			out.append("World #"+world++ +"\n");
			Language[] lang = new Language[map.size()];
			int i = 0;
			for( Entry<Character, Integer> e: map.entrySet())
			{
				Language l = new Language(e.getKey(), e.getValue());
				lang[i++] = l;
			}
			Arrays.sort(lang);
			for (int j = 0; j < lang.length; j++) {
				out.append(lang[j].c+":"+" "+lang[j].val+"\n");
			}
		}
		out.flush();
    }  
	static class Language implements Comparable<Language>
	{
		char c;
		int val;
		public Language(char x,int v)
		{
			c = x;
			val = v;
		}
		@Override
		public int compareTo(Language o) {
			if(o.val!=this.val)
				return o.val-this.val;			
			return this.c-o.c;
		}
		
	}
}
