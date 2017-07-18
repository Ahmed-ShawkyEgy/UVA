import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static char[][] arr;
	static final int oo = (int)1e8, mod = 20437;
	static int[] x = {1,-1,0,0};
	static int[] y = {0,0,1,-1};
	static Pair[] ind;
	public static Pair bfs(int ii,int jj,int curChar)
	{
		int nxtChar = curChar + 1;
		Queue<Pair> q = new LinkedList<Pair>();
		int[][] dist = new int[n][n];
		int[][] count = new int[n][n]; 
		for (int i = 0; i < dist.length; i++) 
			Arrays.fill(dist[i], oo);
		
		dist[ii][jj] = 0;
		count[ii][jj] = 1;
		q.add(new Pair(ii, jj));
		
		while(!q.isEmpty())
		{
			Pair cur = q.poll();
			int i = cur.i , j = cur.j;
			if(i==ind[nxtChar].i && j==ind[nxtChar].j)
				continue;
			for(int z = 0 ; z<x.length;z++)
			{
				int newI = i + x[z] , newj = j + y[z];
				if(isValid(newI, newj, curChar))
				{
					int newDist = dist[i][j] + 1;
					if(newDist < dist[newI][newj])
					{
						dist[newI][newj] = newDist;
						count[newI][newj] = count[i][j] % mod;
						if(arr[newI][newj] != nxtChar+'A')
						q.add(new Pair(newI, newj));
					}
					else if(newDist == dist[newI][newj])
					{
						count[newI][newj] += count[i][j] % mod;
					}
				}
			}
		}
		return new Pair(dist[ind[nxtChar].i][ind[nxtChar].j],count[ind[nxtChar].i][ind[nxtChar].j] ); // pair->i = min_dist :: pair->j = count of dist
	}
	public static boolean isValid(int i,int j,int curChar)
	{
		return i>=0 && j>=0 && i<n && j<n && arr[i][j] != '#' && !(arr[i][j]!='#' && arr[i][j]!='.' && arr[i][j]>curChar+'A'+1);
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(true)
		{
			n = Integer.parseInt(br.readLine().trim());
			if(n==0)
				break;
			arr = new char[n][n];
			ind = new Pair[26];
			int max = 0;
			for (int i = 0; i < n; i++) 
			{
				String s = br.readLine();
				for(int j = 0;j<n;j++)
				{
					char c = s.charAt(j);
					arr[i][j] = c;
					if(c!='.' && c!='#')
					{
						ind[c-'A'] = new Pair(i, j);
						max = Math.max(max, c-'A');
					}
				}
			}
			Pair res = new Pair(0, 1);
			for(int i = 0; i<max;i++)
			{
				Pair cur = bfs(ind[i].i, ind[i].j, i);
				res.i += cur.i;
				res.j = ((res.j % mod) * (cur.j % mod))% mod;
			}
			sb.append("Case "+cases++ +": ");
			if(res.i>=oo)
				sb.append("Impossible\n");
			else
				sb.append(res.i + " " + res.j%mod + "\n");
		}
		System.out.print(sb);
	}
	static class Pair
	{
		int i,j;
		public Pair(int i,int j)
		{
			this.i = i;
			this.j = j;
		}
	}
}
