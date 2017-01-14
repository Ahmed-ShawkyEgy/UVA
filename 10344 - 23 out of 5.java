import java.io.*;
import java.util.*;
public class Main{
	static boolean found;
	static int[] arr;
	static boolean [] taken;
    public static int get(int a,int b,int op)
    {
    	switch (op)
    	{
			case 0:return a+b;
			case 1:return a-b;
			case 2:return a*b;
		default: return 0;
		}
    }
    public static void bt(int ind,int sum)
    {
    	if(found)
    		return ;
    	if(ind==5)
    	{
    		if(sum==23)
    			found = true;
    		return;
    	}
    	for(int i = 0;i<5;i++)
    	{
    		if(!taken[i])
    		{
    			taken[i] = true;
    			if(ind!=0)
		    	for (int j = 0; j < 3; j++) 
		    	{
		    		bt(ind+1, get(sum,arr[i],j) );
				}
    			else
    				bt(ind+1,arr[i]);
		    	taken[i] = false;
    		}
    	}
    }
	public static void main(String[] args) throws Throwable
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(System.out);
	    while(true)
	    {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	arr = new int[5];
	    	for (int i = 0; i < arr.length; i++) 
	    	{
	    		arr[i] = Integer.parseInt(st.nextToken());
			}
	    	if(arr[0]==0)
	    		break;
	    	Arrays.sort(arr);
	    	found = false;
	    	taken = new boolean[5];
	    	bt(0,0);
	    	out.append(found?"Possible\n":"Impossible\n");
	    }
	    out.flush();
	}
}
