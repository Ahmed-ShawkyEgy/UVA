import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Main{
	public static void main(String[] args) throws Throwable
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(System.out);
	    String star = "";
	    for (int i = 0; i < 70; i++) 
	    {
	    	star+="*";
		}
	    star+="\n";
	    ArrayList<Integer> values = new ArrayList<Integer>();
	    boolean[] taken = new boolean[200];
	    values.add(50);
	    taken[50] = true;
	    for (int i = 0; i <= 20; i++) 
	    {
			for (int j = 1; j <= 3; j++) 
			{
				if(!taken[i*j])
				{
					taken[i*j] = true;
					values.add(i*j);
				}
			}
		}
	    Collections.sort(values);
	    while(true)
	    {
	    	int n = Integer.parseInt(br.readLine());
	    	if(n<=0)
	    		break;
	    	HashSet<String> set = new HashSet<String>();
	    	int perm = 0;
	    	for(int t1 = 0;t1<values.size();t1++)
	    	{
	    		for (int t2 = 0; t2 < values.size(); t2++) 
	    		{
	    			for (int t3 = 0; t3 < values.size(); t3++) 
	    			{
	    				int a = values.get(t1);
	    				int b = values.get(t2);
	    				int c = values.get(t3);
	    				if(n-a-b-c==0)
	    				{
	    					int[] arr = {a,b,c};
	    					Arrays.sort(arr);
	    					String s = arr[0]+""+arr[1]+""+arr[2];
	    					set.add(s);
	    					perm++;
	    				}
					}
				}
	    	}
	    	if(set.size()!=0)
	    	{
	out.append("NUMBER OF COMBINATIONS THAT SCORES "+n+" IS "+set.size()+".\n");
	out.append("NUMBER OF PERMUTATIONS THAT SCORES "+n+" IS "+perm+".\n");
	    	}
	    	else
	    		out.append("THE SCORE OF "+n+" CANNOT BE MADE WITH THREE DARTS.\n");
	    	out.append(star);
	    }
	    out.append("END OF OUTPUT\n");
	    out.flush();
	}
}
