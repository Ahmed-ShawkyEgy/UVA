import java.util.*;
import java.io.*;

public class ExactSum {
	public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			int n = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0;i<n;i++)
			{
				int x = Integer.parseInt(st.nextToken());
				if(map.containsKey(x))
				{
					int val = map.get(x);
					map.put(x, val+1);
				}
				else
					map.put(x, 1);
			}
			int m = Integer.parseInt(br.readLine());
			int i = 0,j=0;
			int dif =Integer.MAX_VALUE;
			for(Entry<Integer, Integer> e : map.entrySet())
			{
				int key = e.getKey();
				int req = m-key;
				if(req==key)
				{
					if(e.getValue()>1)
					{
						dif = 0;
						i = key;
						j=key;
					}
				}
				else
				{
					if(map.containsKey(req))
					{
						int curDif = Math.abs(req-key);
						if(curDif<dif)
						{
							dif = curDif;
							i = Math.min(key,req);
							j = Math.max(key, req);
						}
					}
				}
			}
			out.append("Peter should buy books whose prices are "+i+" and "+j+".\n\n");
			br.readLine();
		}
		out.flush();
    }  
}
