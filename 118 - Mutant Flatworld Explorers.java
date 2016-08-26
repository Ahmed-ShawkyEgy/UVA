import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.*;

public class Main {
	static int[] moves = {0,1,2,3};
	static char[] ori = {'N','E','S','W'};
	static boolean [][] scent = new boolean[51][51];
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int xMax = Integer.parseInt(st.nextToken());
		int yMax = Integer.parseInt(st.nextToken());
		
		while(br.ready())
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char o = st.nextToken().charAt(0);
			int orient = (o=='N')? 0:(o=='E')? 1:(o=='S')? 2:3;
			String s = br.readLine();
			boolean lost = false;
			for (int i = 0; i < s.length(); i++) 
			{
				char move = s.charAt(i);
				int xx=x,yy=y;
				if(move=='R')
				{
					orient ++;
					orient %= 4;
				}
				else
				{
					if(move=='L')
					{
						orient--;
						if(orient==-1)
							orient=3;
					}
					else
					{
						switch (orient) {
						case 0:
							yy++;
							break;
						case 1:
							xx++;
							break;
						case 2:
							yy--;
							break;
						case 3:
							xx--;
							break;
						default:
							break;
						}
						if(xx<0 || yy<0 || xx>xMax || yy>yMax)
						{
							if(!scent[x][y])
							{
								scent[x][y]=true;
								lost = true;
								break;
							}
						}
						else
						{
							x = xx;
							y  = yy;					
						}
					}
				}
				
			}
			out.append(x+" "+y+" "+ori[orient]);
			if(lost)
				out.append(" LOST");
			out.append("\n");
		}
		out.flush();
    }
}
