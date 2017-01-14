import java.io.*;
import java.util.*;
public class Main{
	static int n,m;
	static char[][] arr;
	static StringBuilder sb;
	static int targetI,targetJ;
	static HashMap<Character, Integer> map;
	public static boolean bt(int i,int j,char action)
	{
		HashMap<Character, Integer> mapp=map;
		if(!isValid(i, j))
			return false;
		if(i==targetI && j==targetJ )
		{
			sb.append(getVal(action));
			return true;
		}
		if(!map.containsKey(arr[i][j]))
			return false;
		if(isValid(i-1, j))
		{
			char c = arr[i-1][j];
			if(map.containsKey(arr[i-1][j]) && map.get(arr[i][j])==map.get(arr[i-1][j])-1)
			{
				if(bt(i-1, j,'f'))
				{
					sb.append(getVal(action));
					return true;
				}
			}
		}
		if(isValid(i, j+1))
		{
			if(map.containsKey(arr[i][j+1]) && map.get(arr[i][j])==map.get(arr[i][j+1])-1)
			{
				if(bt(i, j+1,'r'))
				{
					sb.append(getVal(action));
					return true;
				}
			}
		}
		if(isValid(i, j-1))
		{
			if(map.containsKey(arr[i][j-1]) && map.get(arr[i][j])==map.get(arr[i][j-1])-1)
			{
				if(bt(i, j-1,'l'))
				{
					sb.append(getVal(action));
					return true;
				}
			}
		}
		return false;
	}
	public static boolean isValid(int i,int j)
	{
		return (i<n && j<m && i>=0 && j>=0);
	}
	public static String getVal(char c)
	{
		switch (c) {
		case 'f':
			return "forth ";
		case 'r':
			return "right ";
		case 'l':
			return "left ";
			default: return "";
		}
	}
	public static void main(String[] args) throws Throwable
	{	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(System.out);
	    int t = Integer.parseInt(br.readLine());
	    map = new HashMap<Character, Integer>();
	    String ss = "IEHOVA";
	    map.put('@', 0);
	    for (int i = 0; i < ss.length(); i++) 
	    {
	    	map.put(ss.charAt(i), i+1);
		}
	    map.put('#', ss.length()+1);
	    while(t-->0)
	    {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	n = Integer.parseInt(st.nextToken());
	    	m = Integer.parseInt(st.nextToken());
	    	arr  = new char[n][m];
	    	int startI=0,startJ=0;
	    	for (int i = 0; i < n; i++) 
	    	{
	    		arr[i] = br.readLine().toCharArray();
			}
	    	for (int i = 0; i < arr.length; i++) 
	    	{
	    		for (int j = 0; j < arr[i].length; j++) 
	    		{
	    			if(arr[i][j]=='@')
	    			{
	    				startI = i;
	    				startJ = j;
	    			}
	    			else
	    				if(arr[i][j]=='#')
	    				{
	    					targetI = i;
	    					targetJ = j;
	    				}
				}
			}
	    	sb = new StringBuilder();
	    	bt(startI,startJ,' ');
	    	StringTokenizer tk = new StringTokenizer(sb.toString());
	    	ArrayList<String> ans = new ArrayList<String>();
	    	while(tk.hasMoreTokens())
	    	{
	    		ans.add(tk.nextToken());
	    	}
	    	sb = new StringBuilder();
	    	sb.append(ans.get(ans.size()-1));
	    	for (int i = ans.size()-2; i >=0; i--) 
	    	{
	    		sb.append(" "+ans.get(i));
			}
	    	out.append(sb+"\n");
	    }
	    out.flush();
	}
}
