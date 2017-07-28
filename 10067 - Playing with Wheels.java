import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][][][] wrong;
	static int[] start;
	static long[][][][] dist;
	static final long oo = (long) 1e11;
	static class Quad
	{
		int a,b,c,d;
		public Quad(int a,int b,int c,int d)
		{
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}
	public static void bfs()
	{
		Queue<Quad> q = new LinkedList<Quad>();
		dist = new long[10][10][10][10];
		for (int i = 0; i < dist.length; i++) 
			for (int j = 0; j < dist.length; j++) 
				for (int j2 = 0; j2 < dist.length; j2++) 
					Arrays.fill(dist[i][j][j2], oo);

		dist[start[0]][start[1]][start[2]][start[3]] = 0;
		q.add(new Quad(start[0], start[1], start[2], start[3]));
		
		while(!q.isEmpty())
		{
			Quad cur = q.poll();
			long curDist = getDist(cur);
			int [] arr = {cur.a,cur.b,cur.c,cur.d};
			
			for (int i = 0; i < arr.length; i++) 
			{
				int tmp = arr[i];
				
				arr[i]++;
				arr[i]%=10;
				
				Quad quad = getQuad(arr);
				if(isValid(quad) && curDist+1<getDist(quad))
				{
					dist[quad.a][quad.b][quad.c][quad.d] = curDist+1;
					q.add(quad);
				}
				
				arr[i]= tmp-1;
				if(arr[i]==-1)arr[i] = 9;
				
				quad = getQuad(arr);
				if(isValid(quad) && curDist+1<getDist(quad))
				{
					dist[quad.a][quad.b][quad.c][quad.d] = curDist+1;
					q.add(quad);
				}
				
				arr[i] = tmp;
			}
		}		
	}
	public static Quad getQuad(int []arr)
	{
		return new Quad(arr[0], arr[1], arr[2], arr[3]);
	}
	public static boolean isValid(Quad quad)
	{
		return !wrong[quad.a][quad.b][quad.c][quad.d];
	}
	public static long getDist(Quad quad)
	{
		return dist[quad.a][quad.b][quad.c][quad.d];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while(t-->0)
		{
			String s;
			while((s=br.readLine()).equals(""));
			StringTokenizer st = new StringTokenizer(s);
			start = new int[4];
			for (int i = 0; i < start.length; i++) 
				start[i] = Integer.parseInt(st.nextToken());
			
			int[]req = new int[4];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < req.length; i++) 
				req[i] = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(br.readLine().trim());
			wrong = new boolean[10][10][10][10];
			while(n-->0)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				wrong[a][b][c][d] = true;
			}
			
			bfs();
			
			long res = getDist(getQuad(req));
			
			if(res>=oo)
				sb.append(-1);
			else
				sb.append(res);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
