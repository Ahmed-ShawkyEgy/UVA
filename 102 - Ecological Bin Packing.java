import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.*;

public class Main{
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	PrintWriter out = new PrintWriter(System.out);
    	while(br.ready())
    	{
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int b1 = Integer.parseInt(st.nextToken());
    		int g1 = Integer.parseInt(st.nextToken());
    		int c1 = Integer.parseInt(st.nextToken());
    		int b2 = Integer.parseInt(st.nextToken());
    		int g2 = Integer.parseInt(st.nextToken());
    		int c2 = Integer.parseInt(st.nextToken());
    		int b3 = Integer.parseInt(st.nextToken());
    		int g3 = Integer.parseInt(st.nextToken());
    		int c3 = Integer.parseInt(st.nextToken());
    		int bcg = g1 + c1 + b2 + g2 + b3 + c3;
    		int bgc = g1 + c1 + b2 + c2 + b3 + g3;
    		
    		int cbg = g1 + b1 + c2 + g2 + c3 + b3;
    		int cgb = g1 + b1 + c2 + b2 + c3 + g3;
    		
    		int gbc = b1 + c1 + g2 + c2 + g3 + b3;
    		int gcb = b1 + c1 + g2 + b2 + g3 + c3;
    		
    		int max = Math.min(bcg, bgc);
    		int max2 = Math.min(cbg, cgb);
    		int max3 = Math.min(gbc, gcb);
    		int ans = Math.min(max, Math.min(max2, max3));
    		String s = "";
    		if(ans==bcg)
    		{
    			s = "BCG";
    		}
    		else
    		{
    			if(ans==bgc)
    				s = "BGC";
    			else
    			{
    				if(ans == cbg)
    					s = "CBG";
    				else
    				{
    					if(ans == cgb)
    						s = "CGB";
    					else
    					{
    						if(ans == gbc)
    							s = "GBC";
    						else
    						{
    							if(ans == gcb)
    								s = "GCB";
    						}
    					}
    				}
    			}
    		}
    	out.append(s+" "+ans+"\n");		
    }
    	out.flush();
   }
}
